package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseProcessor;
import org.instantlogic.engine.manager.EngineProcessor;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.engine.message.ChangeMessage;
import org.instantlogic.engine.message.EnterMessage;
import org.instantlogic.engine.message.Message;
import org.instantlogic.engine.message.PresenceMessage;
import org.instantlogic.engine.message.SubmitMessage;
import org.instantlogic.interaction.util.TravelerInfo;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * A traveler usually has one open parked request. When another comes in, the first one is released.
 */
public class NettyTraveler implements TravelerProxy {
	
	enum State {ACTIVE, MAY_BE_OBANDONED, REMOVED}
	
	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);

	private static final Map<String, NettyTraveler> nettyTravelers = new ConcurrentHashMap<String, NettyTraveler>();
	private static Gson gson = new Gson();

	public static void broadcast(Update message) {
		logger.info("broadcasting to all {} travelers", nettyTravelers.size());
		for (NettyTraveler nettyTraveler : nettyTravelers.values()) {
			nettyTraveler.sendMessage(message);
		}
	}
	
	public static NettyTraveler getOrCreate(String travelerId, String applicationName, String caseId) {
		NettyTraveler result = nettyTravelers.get(travelerId);
		if (result==null) {
			logger.info("Registering new traveler {}", travelerId);
			CaseProcessor caseProcessor = EngineProcessor.getCaseProcessor(applicationName, caseId);
			result = new NettyTraveler(travelerId, caseProcessor);
			nettyTravelers.put(travelerId, result);
		}
		return result;
	}
	
	public static void sweep() {
		for(NettyTraveler nettyTraveler : nettyTravelers.values()) {
			nettyTraveler.check();
		}
	}
	
	private final TravelerInfo travelerInfo;
	private final CaseProcessor caseProcessor;
	
	private List<MessageEvent> parkedRequests = new ArrayList<MessageEvent>();
	private List<Update> updatesWaiting = new ArrayList<Update>();
	private State state = State.ACTIVE;

	private ChannelFutureListener channelClosed = new ChannelFutureListener() {
		@Override
		public void operationComplete(ChannelFuture future) throws Exception {
			removeParkedRequestForChannel(future.getChannel());
		}
	};
	
	private NettyTraveler(String travelerId, CaseProcessor caseProcessor) {
		travelerInfo = new TravelerInfo(travelerId);
		this.caseProcessor = caseProcessor;
	}

	/**
	 * Sends a message to this traveler
	 * @param update the message to send
	 */
	public synchronized void sendMessage(Update update) {
		updatesWaiting.add(update);
		deliverMessagesIfPossible();
	}
	
	public synchronized void check() {
		if (state==State.MAY_BE_OBANDONED) {
			state = State.REMOVED;
			logger.info("Removing traveler {}", travelerInfo.getTravelerId());
			nettyTravelers.remove(travelerInfo.getTravelerId());
			this.caseProcessor.processMessagesAndSendUpdates(this, Collections.singletonList((Message)new EnterMessage(null)));
		}
		if (state==State.ACTIVE && parkedRequests.size()==0) {
			state = State.MAY_BE_OBANDONED;
		}
	}
	
	public synchronized void handleIncomingMessages(String messagesText) {
		JsonArray jsonMessages = (JsonArray) new JsonParser().parse(messagesText);
		List<Message> messages = new ArrayList<Message>(jsonMessages.size());
		for (JsonElement message : jsonMessages) {
			String messageName = message.getAsJsonObject().get("message").getAsString();
			logger.debug("Handling {} message from traveler {}", messageName, travelerInfo.getTravelerId());
			if ("change".equals(messageName)) {
				String placeElementId = message.getAsJsonObject().get("id").getAsString();
				Object value = null;
				if (message.getAsJsonObject().has("value")) {
					value = getPrimitiveValue(message.getAsJsonObject().get("value").getAsJsonPrimitive());
				}
				messages.add(new ChangeMessage(placeElementId, value));
			} else if ("submit".equals(messageName)) {
				String placeElementId = message.getAsJsonObject().get("id").getAsString();
				messages.add(new SubmitMessage(placeElementId));
			} else if ("enter".equals(messageName)) {
				JsonElement locationElement = message.getAsJsonObject().get("location");
				String newLocation = locationElement==null?null:locationElement.getAsString();
				messages.add(new EnterMessage(newLocation));
			} else if ("presence".equals(messageName)) {
				String command = message.getAsJsonObject().get("command").getAsString();
				Object data = null;
				if (message.getAsJsonObject().has("value")) {
					data = getPrimitiveValue(message.getAsJsonObject().get("data").getAsJsonPrimitive());
				}
				messages.add(new PresenceMessage(command, data));
			}
		}
		this.caseProcessor.processMessagesAndSendUpdates(this, messages); // Will also queue updates
	}

	private Object getPrimitiveValue(JsonPrimitive jsonPrimitive) {
		if (jsonPrimitive.isBoolean()) {
			return jsonPrimitive.getAsBoolean();
		}
		if (jsonPrimitive.isNumber()) {
			return jsonPrimitive.getAsNumber();
		}
		return jsonPrimitive.getAsString();
	}

	public synchronized void parkRequest(MessageEvent e) {
		if (state==State.REMOVED) {
			logger.error("Rare race condition");
			throw new RuntimeException("This traveler was removed");
		}
		state = State.ACTIVE;
		e.getChannel().getCloseFuture().addListener(channelClosed);
		parkedRequests.add(e);
		if (parkedRequests.size()>1 || updatesWaiting.size()>0) {
			sendResponseMessages(parkedRequests.remove(0));
		}
	}

	private void deliverMessagesIfPossible() {
		if (parkedRequests.size()>0) {
			sendResponseMessages(parkedRequests.remove(0));
		}
	}
	
	/**
	 * The parked request is returned carrying the messages waiting.
	 * @param event
	 */
	private void sendResponseMessages(MessageEvent event) {
		HttpRequest request = (HttpRequest) event.getMessage();
		
		boolean keepAlive = isKeepAlive(request);
 
        // Build the response object.
        HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
        logger.debug("Sending {} messages to traveler {}", updatesWaiting.size(), travelerInfo.getTravelerId());
    	response.setContent(ChannelBuffers.copiedBuffer(gson.toJson(updatesWaiting), CharsetUtil.UTF_8)); // gson.toJsonTree(update)
    	updatesWaiting = new ArrayList<Update>();

    	response.setHeader(CONTENT_TYPE, "text/plain; charset=UTF-8");
 
        if (keepAlive) {
            // Add 'Content-Length' header only for a keep-alive connection.
            response.setHeader(CONTENT_LENGTH, response.getContent().readableBytes());
        }
 
        // Write the response.
        ChannelFuture future = event.getChannel().write(response);
 
        // Close the non-keep-alive connection after the write operation is done.
        if (!keepAlive) {
            future.addListener(ChannelFutureListener.CLOSE);
        }		
	}

	synchronized void removeParkedRequestForChannel(Channel channel) {
		for (int i=0;i<parkedRequests.size();i++) {
			if (parkedRequests.get(i).getChannel()==channel) {
				parkedRequests.remove(i);
				logger.debug("A channel for traveler {} was closed by the client", travelerInfo.getTravelerId());
				return;
			}
		}
	}
	
	@Override
	public String toString() {
		return "Traveler "+travelerInfo.getTravelerId();
	}

	@Override
	public TravelerInfo getTravelerInfo() {
		return travelerInfo;
	}

	@Override
	public synchronized void sendUpdates(List<Update> newUpdates) {
		// Remove old updates with the same name
		Iterator<Update> updatesWaitingIterator = updatesWaiting.iterator();
		while (updatesWaitingIterator.hasNext()) {
			Update update = updatesWaitingIterator.next();
			for (Update newUpdate: newUpdates) {
				if (update.getName().equals(newUpdate.getName())) {
					updatesWaitingIterator.remove();
				}
			}
		}
		for (Update update: newUpdates) {
			this.updatesWaiting.add(update);
		}
		deliverMessagesIfPossible();
	}
}

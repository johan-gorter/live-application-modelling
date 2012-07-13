package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.manager.PlaceManager.RenderedPage;
import org.instantlogic.fabric.util.AbstractTransactionListener;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.util.ChangeContext.FieldChange;
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
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * A traveler usually has one open parked request. When another comes in, the first one is released.
 */
public class Traveler {
	
	enum State {ACTIVE, MAY_BE_OBANDONED, REMOVED}
	
	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);

	private static final Map<String, Traveler> travelers = new ConcurrentHashMap<String, Traveler>();
	private static Gson gson = new Gson();

	public static void broadcast(JsonObject message) {
		logger.info("broadcasting to all {} travelers", travelers.size());
		for (Traveler traveler : travelers.values()) {
			traveler.sendMessage(message);
		}
	}
	
	public static Traveler getOrCreate(String travelerId, String applicationName) {
		Traveler result = travelers.get(travelerId);
		if (result==null) {
			logger.info("Registering new traveler {}", travelerId);
			ApplicationManager application = ApplicationManager.getManager(applicationName);
			result = new Traveler(travelerId, application);
			travelers.put(travelerId, result);
		}
		return result;
	}
	
	public static void sweep() {
		for(Traveler traveler : travelers.values()) {
			traveler.check();
		}
	}
	
	private final TravelerInfo travelerInfo;
	private List<MessageEvent> parkedRequests = new ArrayList<MessageEvent>();
	private JsonArray messagesWaiting = new JsonArray();
	private ApplicationManager applicationManager;
	private boolean sendPlace;
	private String caseId;
	private String location;
	private CaseManager caseManager;
	private State state = State.ACTIVE;
	private ObservationsOutdatedObserver placeOutdatedObserver;
	private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			event.getOperation().addTransactionListener(placeOutdatedTransactionListener);
		}
	}; 
	private final AbstractTransactionListener placeOutdatedTransactionListener = new AbstractTransactionListener() {
		@Override
		public void transactionCompleted(CaseAdministration instanceAdministration, boolean committed) {
			sendPlace = true;
			deliverMessagesIfPossible();
		}
	};

	private ChannelFutureListener channelClosed = new ChannelFutureListener() {
		@Override
		public void operationComplete(ChannelFuture future) throws Exception {
			removeParkedRequestForChannel(future.getChannel());
		}
	};
	
	private Traveler(String travelerId, ApplicationManager application) {
		travelerInfo = new TravelerInfo();
		travelerInfo.setTravelerId(travelerId);
		this.applicationManager = application;
	}

	/**
	 * Sends a message to this traveler
	 * @param message the message to send
	 */
	public synchronized void sendMessage(JsonObject message) {
		messagesWaiting.add(message);
		deliverMessagesIfPossible();
	}
	
	public synchronized void check() {
		if (state==State.MAY_BE_OBANDONED) {
			state = State.REMOVED;
			logger.info("Removing traveler {}", travelerInfo.getTravelerId());
			this.placeOutdatedObserver = null;
			travelers.remove(travelerInfo.getTravelerId());
			this.caseManager.leave(this.location, travelerInfo);
		}
		if (state==State.ACTIVE && parkedRequests.size()==0) {
			state = State.MAY_BE_OBANDONED;
		}
	}
	
	public synchronized void handleIncomingMessages(String messagesText) {
		JsonArray messages = (JsonArray) new JsonParser().parse(messagesText);
		for (JsonElement message : messages) {
			String messageName = message.getAsJsonObject().get("message").getAsString();
			logger.debug("Handling {} message from traveler {}", messageName, travelerInfo.getTravelerId());
			if ("change".equals(messageName)) {
				// TODO: handle change
				sendPlace = true;
				throw new RuntimeException("TODO");
			} else if ("event".equals(messageName)) {
				String id = message.getAsJsonObject().get("id").getAsString();
				this.location = this.caseManager.submit(travelerInfo, this.location, new FieldChange[0], id);
				sendPlace = true;
			} else if ("enter".equals(messageName)) {
				String newLocation = message.getAsJsonObject().get("location").getAsString();
				this.caseManager.enter(travelerInfo, this.location, newLocation);
				this.location = newLocation;
				sendPlace = true;
			}
		}
	}

	public synchronized void parkRequest(MessageEvent e) {
		if (state==State.REMOVED) {
			logger.info("Rare race condition");
			travelers.put(travelerInfo.getTravelerId(), this);
			this.caseManager.enter(travelerInfo, null, this.location);
		}
		state = State.ACTIVE;
		e.getChannel().getCloseFuture().addListener(channelClosed);
		parkedRequests.add(e);
		if (parkedRequests.size()>1 || sendPlace || messagesWaiting.size()>0) {
			deliverMessages();
		}
	}

	private void deliverMessagesIfPossible() {
		if (parkedRequests.size()>0) {
			deliverMessages();
		}
	}
	
	private void deliverMessages() {
		if (sendPlace) {
			RenderedPage renderedPage = caseManager.renderAndObserve(travelerInfo, this.location, placeOutdatedObserver, placeOutdatedValueChangeObserver);
			placeOutdatedObserver = renderedPage.placeOutdatedObserver;
			JsonElement rootFragment = gson.toJsonTree(renderedPage.content);
			JsonObject placeMessage = new JsonObject();
			placeMessage.addProperty("message", "place");
			placeMessage.addProperty("location", location);
			placeMessage.add("rootFragment", rootFragment);
			messagesWaiting.add(placeMessage);
			sendPlace = false;
		}
		sendResponseMessages(parkedRequests.remove(0));
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
        logger.debug("Sending {} messages to traveler {}", messagesWaiting.size(), travelerInfo.getTravelerId());
    	response.setContent(ChannelBuffers.copiedBuffer(gson.toJson(messagesWaiting), CharsetUtil.UTF_8));
    	messagesWaiting = new JsonArray();

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

	public void setCaseId(String caseId) {
		this.caseId = caseId;
		this.caseManager = this.applicationManager.getOrCreateCase(caseId);
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
}

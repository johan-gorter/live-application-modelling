package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static org.jboss.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static org.jboss.netty.handler.codec.http.HttpResponseStatus.OK;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.netty.manager.ApplicationManager;
import org.instantlogic.netty.manager.CaseManager;
import org.jboss.netty.buffer.ChannelBuffers;
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
	
	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);

	public static final Map<String, Traveler> travelers = new HashMap<String, Traveler>();
	private static Gson gson = new Gson();

	public static void broadcast(JsonObject message) {
		logger.info("broadcasting to every traveler");
		for (Traveler session : Traveler.travelers.values()) {
			session.sendMessage(message);
		}
	}
	
//	public static JsonObject placeJson = new JsonObject();
//	static {
//		placeJson.addProperty("widget", "Question");
//		placeJson.addProperty("answerWidget", "Slider");
//		placeJson.addProperty("value", 42);
//		placeJson.addProperty("min", 10);
//		placeJson.addProperty("max", 110);
//		placeJson.addProperty("length", "500px");
//		placeJson.addProperty("question", "The answer to everything?");
//	}
	
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
	
	private String id;
	private List<MessageEvent> parkedRequests = new ArrayList<MessageEvent>();
	private long lastSentPlaceVersion = -1;
	private JsonArray messagesWaiting = new JsonArray();
	private ApplicationManager applicationManager;
	private boolean sendPlace;
	private String caseId;
	private String location;
	private CaseManager caseManager;
	
	public Traveler(String travelerId, ApplicationManager application) {
		this.id = travelerId;
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
	
	public void handleIncomingMessages(String messagesText) {
		JsonArray messages = (JsonArray) new JsonParser().parse(messagesText);
		for (JsonElement message : messages) {
			String messageName = message.getAsJsonObject().get("message").getAsString();
			logger.debug("Handling {} message from traveler {}", messageName, id);
			if ("update".equals(messageName)) {
				// TODO: handle update
			} else if ("enter".equals(messageName)) {
				String newLocation = message.getAsJsonObject().get("location").getAsString();
				this.caseManager.enter(this, this.location, newLocation);
				this.location = newLocation;
				sendPlace = true;
			}
		}
	}

	public void parkRequest(MessageEvent e) {
		parkedRequests.add(e);
		if (parkedRequests.size()>1 || sendPlace || messagesWaiting.size()>0) {
			deliverMessages();
		}
	}

	private void deliverMessagesIfPossible() {
		if (parkedRequests.size()>1) {
			deliverMessages();
		}
	}
	
	private void deliverMessages() {
		if (sendPlace) {
			JsonElement rootFragment = gson.toJsonTree(caseManager.render(this, this.location));
			JsonObject placeMessage = new JsonObject();
			placeMessage.addProperty("message", "place");
			placeMessage.add("rootFragment", rootFragment);
			messagesWaiting.add(placeMessage);
		}
		sendResponseMessages(parkedRequests.remove(0));
	}

	/**
	 * The parked request is returned carrying the messages waiting.
	 * @param event
	 */
	private synchronized void sendResponseMessages(MessageEvent event) {
		HttpRequest request = (HttpRequest) event.getMessage();
		
		boolean keepAlive = isKeepAlive(request);
 
         // Build the response object.
         HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
         logger.debug("Sending {} messages to traveler {}", messagesWaiting.size(), id);
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
}

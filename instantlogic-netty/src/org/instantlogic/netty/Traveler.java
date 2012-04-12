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

import org.instantlogic.netty.place.PlaceFragmentModel;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.util.CharsetUtil;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * A traveler usually has one open parked request. When another comes in, the first one is released.
 */
public class Traveler {

	public static final Map<String, Traveler> travelers = new HashMap<String, Traveler>();
	private static Gson gson = new Gson();
	
	public static void broadcast(JsonObject message) {
		for (Traveler session : Traveler.travelers.values()) {
			session.sendMessage(message);
		}
	}

	
	public static long placeVersion;
	public static PlaceFragmentModel thePlace = new PlaceFragmentModel();
	static {
		PlaceFragmentModel field = new PlaceFragmentModel();
		field.id="1-1";
		field.role="attribute";
		field.question="The answer to everything";
		field.value= "42";
		thePlace.content = 
			new PlaceFragmentModel[]
				{
					field
				};
		thePlace.id="1";
	}
	public static JsonObject placeJson = new JsonObject();
	static {
		placeJson.addProperty("widget", "Question");
		placeJson.addProperty("answerWidget", "Slider");
		placeJson.addProperty("value", 42);
		placeJson.addProperty("min", 10);
		placeJson.addProperty("max", 110);
		placeJson.addProperty("length", "500px");
		placeJson.addProperty("question", "The answer to everything?");
	}
	
	public static Traveler getOrCreate(String sessionId) {
		Traveler result = travelers.get(sessionId);
		if (result==null) {
			result = new Traveler();
			travelers.put(sessionId, result);
		}
		return result;
	}
	
	private List<MessageEvent> parkedRequests = new ArrayList<MessageEvent>();
	private long lastSentPlaceVersion = -1;
	private JsonArray messagesWaiting = new JsonArray();
	
	public synchronized void sendMessage(JsonObject message) {
		messagesWaiting.add(message);
		sendMessages();
	}
	
	private synchronized void sendMessages() {
		if (parkedRequests.size()>0) {
			sendResponses(parkedRequests.remove(0), thePlace);
		}
	}

	public synchronized void handleIncomingMessage(String message) {
		thePlace.content[0].value = message;
		placeVersion ++;
		sendMessages();
	}

	public synchronized void parkRequest(MessageEvent e) {
		parkedRequests.add(e);
		if (parkedRequests.size()>1 || messagesWaiting.size()>0 || lastSentPlaceVersion<placeVersion) {
			sendResponses(parkedRequests.remove(0), thePlace);
		}
	}

	private synchronized void sendResponses(MessageEvent event, PlaceFragmentModel place) {
		HttpRequest request = (HttpRequest) event.getMessage();
		
		boolean keepAlive = isKeepAlive(request);
 
         // Build the response object.
         HttpResponse response = new DefaultHttpResponse(HTTP_1_1, OK);
         if (lastSentPlaceVersion<placeVersion) {
        	 JsonObject placeMessage = new JsonObject();
        	 placeMessage.addProperty("message", "place");
        	 placeMessage.add("rootFragment", placeJson);
        	 messagesWaiting.add(placeMessage);
         }
    	 response.setContent(ChannelBuffers.copiedBuffer(gson.toJson(messagesWaiting), CharsetUtil.UTF_8));
    	 lastSentPlaceVersion = placeVersion;

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

	public synchronized void pushNewPlaceValue(String command) {
		handleIncomingMessage(command);
	}
}

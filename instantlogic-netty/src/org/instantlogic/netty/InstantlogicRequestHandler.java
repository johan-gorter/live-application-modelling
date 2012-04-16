package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.List;
import java.util.Map;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.DefaultHttpResponse;
import org.jboss.netty.handler.codec.http.HttpHeaders;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.jboss.netty.handler.codec.http.HttpResponse;
import org.jboss.netty.handler.codec.http.QueryStringDecoder;
import org.jboss.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InstantlogicRequestHandler extends HttpStaticFileServerHandler implements ChannelHandler {

	private static final Logger logger = LoggerFactory.getLogger(InstantlogicRequestHandler.class);
	
	@Override
	protected void handlePost(ChannelHandlerContext ctx, MessageEvent e, HttpRequest request) throws Exception {
		if (HttpHeaders.is100ContinueExpected(request)) {
			send100Continue(e);
		}
		
		QueryStringDecoder queryStringDecoder = new QueryStringDecoder(request.getUri());
		Map<String, List<String>> params = queryStringDecoder.getParameters();
		
		List<String> travelerIds = params.get("travelerId");
		if (travelerIds==null || travelerIds.size()!=1) {
			throw new Exception("No travelerId queryString parameter");
		}
		
		String travelerId = travelerIds.get(0);
		logger.debug("Incoming request from traveler {}", travelerId);
		Traveler traveler = Traveler.getOrCreate(travelerId);
		
		ChannelBuffer content = request.getContent();
		if (content.readable()) {
			traveler.handleIncomingMessages(content.toString(CharsetUtil.UTF_8));
		}
		
		traveler.parkRequest(e);
	}

	private void send100Continue(MessageEvent e) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
		e.getChannel().write(response);
	}
}

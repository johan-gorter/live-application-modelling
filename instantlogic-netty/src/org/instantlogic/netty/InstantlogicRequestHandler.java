package org.instantlogic.netty;

import static org.jboss.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static org.jboss.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelHandler;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.Cookie;
import org.jboss.netty.handler.codec.http.CookieDecoder;
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
		
		List<String> applications = params.get("application");
		if (applications==null || applications.size()!=1) {
			throw new Exception("No application queryString parameter");
		}
		String applicationName = applications.get(0);

		List<String> cases = params.get("case");
		if (cases==null || cases.size()!=1) {
			throw new Exception("No case queryString parameter");
		}
		String caseId = cases.get(0);
		
		logger.debug("Incoming request from traveler {} for application {}, case {}", new Object[]{ travelerId, applicationName, caseId});
		NettyTraveler nettyTraveler = NettyTraveler.getOrCreate(travelerId, applicationName, caseId);
		
		String value = request.getHeader("Cookie");
		if (value!=null) {
			Set<Cookie> cookies = new CookieDecoder().decode(value);
			handleAuthentication(cookies, nettyTraveler);
		}
		
		ChannelBuffer content = request.getContent();
		if (content.readable()) {
			nettyTraveler.handleIncomingMessages(content.toString(CharsetUtil.UTF_8));
		}
		
		nettyTraveler.parkRequest(e);
	}

	private void handleAuthentication(Set<Cookie> cookies, NettyTraveler nettyTraveler) {
		for (Cookie cookie:cookies) {
			if ("who-am-i".equals(cookie.getName())) {
				String username = cookie.getValue();
				if (nettyTraveler.getTravelerInfo().getAuthenticatedUsername()==null) {
					nettyTraveler.getTravelerInfo().setAuthenticatedUsername(username);
				} else if (username.equals(nettyTraveler.getTravelerInfo().getAuthenticatedUsername())) {
					return;
				} else {
					throw new RuntimeException("Traveler switched authenticatedUsername");
				}
			}
		}
		if (nettyTraveler.getTravelerInfo().getAuthenticatedUsername()!=null) {
			throw new RuntimeException("AuthenticatedUsername disappeared");
		}
	}

	private void send100Continue(MessageEvent e) {
		HttpResponse response = new DefaultHttpResponse(HTTP_1_1, CONTINUE);
		e.getChannel().write(response);
	}
}

package org.instantlogic.netty;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.engine.manager.ApplicationManager;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

public class NettyServer {

	private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

	private static final boolean WATCH_FILES = true;
	
	private static final JsonObject FILES_UPDATED = new JsonObject();
	static {
		FILES_UPDATED.addProperty("message", "filesUpdated");
	}

	private static Runnable fileWatcher = new Runnable() {

		@Override
		public void run() {
			try {
				WatchService watcher = FileSystems.getDefault().newWatchService();
				Path dir = new File("public").toPath();
				WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);				
				while (true) {
					try {
						key = watcher.take();
						logger.warn("Filesystem update detected");
					} catch (InterruptedException x) {
						return;
					}
					key.pollEvents();
					Traveler.broadcast(FILES_UPDATED);
					if (!key.reset()) break;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	};

	private static Runnable sweeper = new Runnable() {
		@Override
		public void run() {
			Traveler.sweep();
		}
	};

	private static Runnable filesUpdatedBroadcaster = new Runnable() {
		@Override
		public void run() {
			Traveler.broadcast(FILES_UPDATED);
		}
	};

	public static void main(String[] args) throws IOException {
		// TODO: Discover which applications should be loaded
		ApplicationManager.registerApplication(DesignerApplication.INSTANCE);
		
		ExecutorService executor = Executors.newCachedThreadPool();
		ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newSingleThreadExecutor(), executor));

		// Set up the event pipeline factory.
		bootstrap.setPipelineFactory(new InstantlogicPipelineFactory());

		if (WATCH_FILES) {
			executor.execute(fileWatcher);
		}
		
		bootstrap.bind(new InetSocketAddress(8080));
		logger.info("Server started");
		
		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
		scheduler.scheduleWithFixedDelay(sweeper, 10, 10, TimeUnit.SECONDS); // This may be a bit short for mobile devices on the road

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter a command");
			final String command = in.readLine();
			if ("quit".equalsIgnoreCase(command)) {
				break;
			} else if ("sweep".equalsIgnoreCase(command)){
				Traveler.sweep();
			} else {
				executor.execute(filesUpdatedBroadcaster);
			}
		}
		scheduler.shutdown();
		executor.shutdown();
	}
}

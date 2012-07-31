package org.instantlogic.engine.manager;

import java.util.ArrayList;
import java.util.List;

import org.instantlogic.engine.Client;
import org.instantlogic.engine.message.Message;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.interaction.util.TravelerInfo;

/**
 *	This class makes sure the CaseManager is only accessed by one thread at a time. 
 */
public class CaseProcessor {

	public static class QueueEntry {
		public final Client client; 
		public final List<Message> messages;
		public final QueueEntry previousEntry;
		
		public QueueEntry(Client client, List<Message> messages, QueueEntry previousEntry) {
			this.client = client;
			this.messages = messages;
			this.previousEntry = previousEntry;
		}
	}
	
	private volatile QueueEntry queueHead;
	private volatile boolean queueBeingProcessed;
	private final Object queueLock = new Object();
	
	private final CaseManager caseManager;
	
	public CaseProcessor(ApplicationManager applicationManager, String caseId) {
		this.caseManager = new CaseManager(applicationManager,caseId);
	}

	public void processMessages(Client client, List<Message> messages) {
		List<QueueEntry> processEntries;
		synchronized (queueLock) {
			if (queueBeingProcessed) {
				queueHead = new QueueEntry(client, messages, queueHead);
				return; // Another thread is doing the processing
			} else {
				processEntries = new ArrayList<QueueEntry>();
				processEntries.add(new QueueEntry(client, messages, queueHead));
				QueueEntry entry = queueHead;
				while (entry!=null) {
					processEntries.add(entry);
					entry = entry.previousEntry;
				}
				queueBeingProcessed = true;
				queueHead = null;
			}
		}
		do {
			do {
				for (int i=processEntries.size()-1;i>=0;i--) {
					QueueEntry entry = processEntries.get(i);
					for (Message message: entry.messages) {
						caseManager.processMessage(entry.client, message);
					}
				}
				processEntries.clear();
				synchronized (queueLock) {
					// Pick up new messages that arrived during the processing of previous messages.
					QueueEntry entry = queueHead;
					while (entry!=null) {
						processEntries.add(entry);
						entry = entry.previousEntry;
					}
				}
			} while (processEntries.size()>0);
			caseManager.sendUpdates();
			synchronized (queueLock) {
				if (queueHead==null) {
					// We are done
					queueBeingProcessed = false;
				} else {
					// Pick up new messages that arrived during the sending of updates.
					QueueEntry entry = queueHead;
					while (entry!=null) {
						processEntries.add(entry);
						entry = entry.previousEntry;
					}
				}
			}
		} while (processEntries.size()>0);
	}
}

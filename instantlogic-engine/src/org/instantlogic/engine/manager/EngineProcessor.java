package org.instantlogic.engine.manager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.instantlogic.engine.Client;
import org.instantlogic.engine.message.Message;
import org.instantlogic.interaction.util.TravelerInfo;

public class EngineProcessor {

	private Map<String, CaseProcessor> caseProcessors = new ConcurrentHashMap<String, CaseProcessor>();
	
	public synchronized CaseProcessor getCaseProcessor(String application, String caseId) {
		String key = application+":"+caseId;
		CaseProcessor result = caseProcessors.get(key);
		if (result==null) {
			ApplicationManager applicationManager = ApplicationManager.getManager(application);
			result = new CaseProcessor(applicationManager, caseId);
			caseProcessors.put(key, result);
		}
		return result;
	}
	
	public void process(String application, String caseId, Client client, List<Message> messages) {
		CaseProcessor caseProcessor = getCaseProcessor(application, caseId);
		caseProcessor.processMessages(client, messages);
	}
}

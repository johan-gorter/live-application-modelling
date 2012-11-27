package org.instantlogic.engine.izzy;

import static org.junit.Assert.assertEquals;

import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.message.StartMessage;
import org.instantlogic.engine.util.TravelerProxyStub;
import org.instantlogic.example.izzy.IzzyApplication;
import org.instantlogic.example.izzy.Project;
import org.junit.Before;
import org.junit.Test;

public class CompleteScenario {

	@Before
	public void setUp() {
		ApplicationManager.registerApplication(IzzyApplication.INSTANCE);
		tim = new TravelerProxyStub("Tim1", "Tim");
		bill = new TravelerProxyStub("Bill1", "Bill");
	}
	
	private TravelerProxyStub tim;
	private TravelerProxyStub bill;
	
	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(IzzyApplication.INSTANCE);
		CaseManager petstoreManager = designerApplicationManager.getOrCreateCase("petstore");
		Project petstore = (Project)petstoreManager.getCase();

		petstoreManager.processMessages(tim, new StartMessage());
		assertEquals(1, petstore.getUsers().size());
		petstoreManager.sendUpdates();
	}

}

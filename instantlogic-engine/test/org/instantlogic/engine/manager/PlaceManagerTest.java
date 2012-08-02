package org.instantlogic.engine.manager;

import java.util.List;

import junit.framework.Assert;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.message.EnterMessage;
import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.IzzyApplication;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlaceManagerTest {

	protected ValueChangeEvent lastEvent;
	
	private ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			lastEvent = event;
		}
	};


	@Before
	public void setUp() {
		ApplicationManager.registerApplication(IzzyApplication.INSTANCE);
		travelerInfo = new TravelerInfo("traveler1");
		travelerInfo.setAuthenticatedUsername("user1");
		lastUpdates = null;
	}
	
	@After
	public void tearDown() {
		lastEvent = null;
	}
	
	private TravelerProxy proxy = new TravelerProxy() {
		
		@Override
		public void sendUpdates(List<Update> messages) {
		}
		
		@Override
		public TravelerInfo getTravelerInfo() {
			return travelerInfo;
		}
	};
	
	protected TravelerInfo travelerInfo;
	
	protected List<Update> lastUpdates;
	
	@Test
	public void test() {
		ApplicationManager applicationManager = ApplicationManager.getManager("izzy");
		CaseManager case1 = applicationManager.getOrCreateCase("project1");
		case1.processMessage(proxy, new EnterMessage("dashboard"));
		case1.sendUpdates();
		Assert.assertEquals(1, lastUpdates.size());
		lastUpdates = null;
		((Project)case1.getCase()).addToIssues(new Issue());
		case1.sendUpdates();
		Assert.assertEquals(1, lastUpdates.size());
	}

}

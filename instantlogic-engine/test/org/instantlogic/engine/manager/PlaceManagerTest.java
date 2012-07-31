package org.instantlogic.engine.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.instantlogic.engine.manager.CaseManager.RenderedPage;
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
	}
	
	@After
	public void tearDown() {
		lastEvent = null;
	}
	
	
	@Test
	public void test() {
		ApplicationManager applicationManager = ApplicationManager.getManager("izzy");
		CaseManager case1 = applicationManager.getOrCreateCase("project1");
		TravelerInfo traveler1 = new TravelerInfo("traveler1");
		traveler1.setAuthenticatedUsername("user1");
		case1.goTo(traveler1, "dashboard");
		RenderedPage page = case1.renderAndObserve(traveler1, null, placeOutdatedValueChangeObserver);
		assertNull(lastEvent);
		((Project)case1.getCase()).addToIssues(new Issue());
		assertNotNull(lastEvent);
	}

}

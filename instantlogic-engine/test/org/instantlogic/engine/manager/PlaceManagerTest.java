package org.instantlogic.engine.manager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.instantlogic.engine.EngineTestApplication;
import org.instantlogic.engine.EngineTestApplication.Case;
import org.instantlogic.engine.EngineTestApplication.Item;
import org.instantlogic.engine.manager.PlaceManager.RenderedPage;
import org.instantlogic.fabric.Instance;
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
		ApplicationManager.registerApplication(EngineTestApplication.INSTANCE);
	}
	
	@After
	public void tearDown() {
		lastEvent = null;
	}
	
	
	@Test
	public void test() {
		ApplicationManager applicationManager = ApplicationManager.getManager("EngineTest");
		CaseManager case1 = applicationManager.getOrCreateCase("case1");
		TravelerInfo traveler1 = new TravelerInfo("traveler1");
		case1.enter(traveler1, null, "Home");
		RenderedPage page = case1.renderAndObserve(traveler1, "Home", null, placeOutdatedValueChangeObserver);
		assertNull(lastEvent);
		((Case)case1.getCase()).addToItems(new Item());
		assertNotNull(lastEvent);
	}

}

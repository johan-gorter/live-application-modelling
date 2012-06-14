package org.instantlogic.netty;

import junit.framework.Assert;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

import com.google.gson.Gson;

public class EnteringDesignerTest {

	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(DesignerApplication.INSTANCE);
		CaseManager testCase = designerApplicationManager.getOrCreateCase("testCase");
		TravelerInfo traveler = new TravelerInfo();
		traveler.setTravelerId("testTraveler");
		
		testCase.enter(traveler, null, "Welcome");
		Object page = testCase.render(traveler, "Welcome");

		Assert.assertNotNull(page);
		
		System.out.println(new Gson().toJson(page));
	}
	
}

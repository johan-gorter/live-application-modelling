package org.instantlogic.netty;

import junit.framework.Assert;

import org.instantlogic.netty.manager.ApplicationManager;
import org.instantlogic.netty.manager.CaseManager;
import org.junit.Test;

import com.google.gson.Gson;

public class EnteringDesignerTest {

	@Test
	public void test() {
		ApplicationManager designerApplicationManager = ApplicationManager.applications[0];
		CaseManager testCase = designerApplicationManager.getOrCreateCase("testCase");
		Traveler traveler = new Traveler("testTraveler", designerApplicationManager);
		traveler.setCaseId("testCase");
		
		Object page = testCase.enter(traveler, null, "Main/Welcome");

		Assert.assertNotNull(page);
		
		System.out.println(new Gson().toJson(page));
	}
	
}

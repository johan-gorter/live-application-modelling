package org.instantlogic.designer.flow;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.engine.manager.ApplicationManager;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.persistence.json.CasePersister;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

public class MainFlowTest {

	@Test
	public void test() {
		ApplicationManager designerApplicationManager = new ApplicationManager(DesignerApplication.INSTANCE);
		CaseManager testCase = designerApplicationManager.getOrCreateCase("mini");
		TravelerInfo traveler = new TravelerInfo();
		traveler.setTravelerId("testTraveler");
		String path = "Welcome";
		
		testCase.enter(traveler, null, path);
		Map<String, Object> page = testCase.render(traveler, path);

		System.out.println(CasePersister.gson.toJson(page));
		
		Map<String, Object> link = findOnly(page, "text", "MiniThing");
		
		path = testCase.submit(traveler, path, new FieldChange[0], (String) link.get("id"));
		
		assertEquals("Entity/E1/EntityDetails", path);
	}

	private Map<String, Object> findOnly(Map<String, Object> node, String key, Object value) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		findAll(node, key, value, results);
		if (results.size()==1) {
			return results.get(0);
		}
		if (results.size()==0) {
			throw new RuntimeException("No node was found");
		}
		throw new RuntimeException("More than one node was found");
	}

	private void findAll(Map<String, Object> node, String key, Object value, List<Map<String, Object>> results) {
		for(Entry<String, Object> entry : node.entrySet()) {
			if (entry.getKey().equals(key) && entry.getValue().equals(value)) {
				results.add(node);
			}
			else if (entry.getValue() instanceof List<?>) {
				for(Object item : ((List<?>)entry.getValue())) {
					if (item instanceof Map<?,?>) {
						findAll((Map<String, Object>) item, key, value, results);
					}
				}
			}
		}
	}
}

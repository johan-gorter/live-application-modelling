package org.instantlogic.designer.flow.main;

import java.util.Map;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.flow.MainFlow;
import org.instantlogic.engine.persistence.json.CasePersister;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;
import org.junit.Test;

public class WelcomePlaceTemplateTest {

	@Test
	public void test() {
		
		ApplicationDesign mini = new ApplicationDesign();
		EntityDesign entity1 = new EntityDesign();
		entity1.setName("Entity1");
		mini.addToEntities(entity1);
		
		
		TravelerInfo travelerInfo = new TravelerInfo();
		travelerInfo.setTravelerId("travelerId");
		RenderContext renderContext = RenderContext.create(MainFlow.INSTANCE, "Welcome", mini, "Mini", travelerInfo);
		Map<String, Object> result = WelcomePlaceTemplate.INSTANCE.render(renderContext);
		System.out.println(CasePersister.gson.toJson(result));
	}

}

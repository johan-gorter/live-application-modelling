package lbe.engine.codegenerator;

import lbe.designerbootstrap.CarinsuranceBootstrapper;

import org.junit.Test;

import app.designer.FlowDesign;
import custom.designer.ApplicationDesignCustomization;

public class AbstractGeneratorTest {

	@Test
	public void test() {
		ApplicationDesignCustomization application = CarinsuranceBootstrapper.createCarinsurance();
		application.name.set("GeneratorTest");
		application.afterLoading();
		application.getApplicationGenerator().setMustRegenerate();
		application.afterSubmit();
		FlowDesign insureFlow = application.flows.get().get(0);
		insureFlow.name.set("InsureX");
		application.afterSubmit();
	}
}

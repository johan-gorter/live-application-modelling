package lbe.engine.codegenerator;

import static org.junit.Assert.*;
import lbe.designerbootstrap.CarinsuranceBootstrapper;

import org.junit.Test;

import app.designer.data.instance.FlowInstance;

import custom.designer.ApplicationInstanceCustomization;

public class AbstractGeneratorTest {

	@Test
	public void test() {
		ApplicationInstanceCustomization application = CarinsuranceBootstrapper.createCarinsurance();
		application.name.set("GeneratorTest");
		application.afterLoading();
		application.getApplicationGenerator().setMustRegenerate();
		application.afterSubmit();
		FlowInstance insureFlow = application.flows.get().get(0);
		insureFlow.name.set("InsureX");
		application.afterSubmit();
	}
}

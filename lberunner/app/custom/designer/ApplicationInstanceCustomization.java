package custom.designer;

import lbe.engine.codegenerator.AbstractGenerator;
import lbe.engine.codegenerator.ApplicationGenerator;
import lbe.instance.CaseInstance;
import play.Play;
import play.classloading.HotswapAgent;
import app.designer.data.entity.ApplicationEntity;
import app.designer.data.instance.ApplicationInstance;

public class ApplicationInstanceCustomization extends ApplicationInstance {

	static {
		HotswapAgent.enabled = false;
	}

	private ApplicationGenerator applicationGenerator;
	
	@Override
	public void afterLoading() {
		applicationGenerator = new ApplicationGenerator(this);
		applicationGenerator.dryRun();
	}
	
	
	@Override
	public void afterSubmit() {
		synchronized (Play.class) {
			applicationGenerator.afterSubmit();
			if (Play.started)
			{
				Play.detectChanges();					
			}
		}
	}


	public ApplicationGenerator getApplicationGenerator() {
		return applicationGenerator;
	}
}

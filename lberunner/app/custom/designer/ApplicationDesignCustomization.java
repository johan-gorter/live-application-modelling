package custom.designer;

import app.designer.ApplicationDesign;
import lbe.engine.codegenerator.ApplicationGenerator;
import lbe.instance.impl.SimpleCaseInstance;
import play.Play;
import play.classloading.HotswapAgent;

public class ApplicationDesignCustomization extends ApplicationDesign {

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

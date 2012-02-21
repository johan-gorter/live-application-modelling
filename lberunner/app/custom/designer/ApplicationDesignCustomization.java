package custom.designer;

import lbe.engine.codegenerator.ApplicationGenerator;
import play.Play;
import play.classloading.HotswapAgent;
import app.designer.ApplicationDesign;

public class ApplicationDesignCustomization extends ApplicationDesign {

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

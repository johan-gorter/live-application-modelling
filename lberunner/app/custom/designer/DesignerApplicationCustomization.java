package custom.designer;

import play.Play;
import play.classloading.HotswapAgent;
import lbe.engine.codegenerator.ApplicationGenerator;
import lbe.engine.codegenerator.CodeGenerator;
import lbe.instance.CaseInstance;
import app.designer.DesignerApplication;
import app.designer.data.instance.ApplicationInstance;

public class DesignerApplicationCustomization extends DesignerApplication {
	
	private ApplicationGenerator codeGenerator;

	static {
		HotswapAgent.enabled = false;
	}
	
	public DesignerApplicationCustomization() {
	}
	
	@Override
	public void afterSubmit(CaseInstance caseInstance) {
		synchronized (Play.class) {
			new ApplicationGenerator((ApplicationInstance) caseInstance).generate();
			Play.detectChanges();
		}
	}
}

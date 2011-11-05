package custom.designer;

import play.Play;
import play.classloading.HotswapAgent;
import lbe.engine.codegenerator.CodeGenerator;
import lbe.instance.CaseInstance;
import app.designer.DesignerApplication;
import app.designer.data.instance.ApplicationInstance;

public class DesignerApplicationCustomization extends DesignerApplication {

	static {
		HotswapAgent.enabled = false;
	}
	
	public DesignerApplicationCustomization() {
	}
	
	@Override
	public void afterSubmit(CaseInstance caseInstance) {
		synchronized (Play.class) {
			CodeGenerator.generateApplication((ApplicationInstance) caseInstance);
			Play.detectChanges();
		}
	}
}

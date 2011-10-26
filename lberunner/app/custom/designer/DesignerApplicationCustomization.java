package custom.designer;

import play.Play;
import lbe.engine.codegenerator.CodeGenerator;
import lbe.instance.CaseInstance;
import app.designer.DesignerApplication;
import app.designer.data.instance.ApplicationInstance;

public class DesignerApplicationCustomization extends DesignerApplication {

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

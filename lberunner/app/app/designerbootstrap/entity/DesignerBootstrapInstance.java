package app.designerbootstrap.entity;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Entity;

public class DesignerBootstrapInstance extends CaseInstance {

	@Override
	public Entity getModel() {
		return DesignerBootstrapCaseEntity.INSTANCE;
	}

}

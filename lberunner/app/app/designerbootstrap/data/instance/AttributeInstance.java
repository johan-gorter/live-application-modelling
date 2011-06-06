package app.designerbootstrap.data.instance;

import app.designerbootstrap.data.entity.AttributeEntity;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.impl.SimpleInstance;
import lbe.model.Entity;

public class AttributeInstance extends ConceptInstance {

	public AttributeInstance(CaseInstance caseInstance) {
		super(caseInstance, AttributeEntity.INSTANCE);
	}

}

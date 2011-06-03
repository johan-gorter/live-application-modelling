package app.designerbootstrap.entity;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

public class DesignerBootstrapCaseEntity extends Entity{

	public static final DesignerBootstrapCaseEntity INSTANCE = new DesignerBootstrapCaseEntity();

	private static final Attribute[] ATTRIBUTES = new Attribute[]{};
	private static final Relation[] RELATIONS = new Relation[]{};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{};
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getReverseRelations() {
		return REVERSE_RELATIONS;
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new DesignerBootstrapInstance();
	}

	@Override
	public String getName() {
		return "DesignerBootstrapCase";
	}

}

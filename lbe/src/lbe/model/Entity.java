package lbe.model;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;

public abstract class Entity extends Model {

	public abstract Attribute<? extends Instance, Object>[] getAttributes();
	
	public abstract Relation<? extends Instance, ? extends Instance>[] getRelations();

	public abstract Relation<? extends Instance, ? extends Instance>[] getReverseRelations();

	public abstract Instance createInstance(CaseInstance caseInstance);

}

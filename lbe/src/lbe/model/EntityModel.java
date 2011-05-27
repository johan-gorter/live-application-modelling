package lbe.model;

import lbe.instance.Instance;

public abstract class EntityModel extends ModelBase {

	public abstract AttributeModel<? extends Instance, Object>[] getAttributes();
	
	public abstract RelationModel<? extends Instance, ? extends Instance>[] getRelations();

	public abstract RelationModel<? extends Instance, ? extends Instance>[] getReverseRelations();

}

package lbe.model;

public abstract class EntityModel extends ModelBase {

	public abstract AttributeModel[] getAttributes();
	
	public abstract RelationModel[] getRelations();

	public abstract RelationModel[] getReverseRelations();

}

package lbe.model;

import lbe.instance.Instance;
import lbe.page.RenderContext;

public abstract class RelationModel<V extends Instance> extends AttributeModel<V> {
	
	public abstract EntityModel getTo();
	
	public abstract boolean isOwner();
	
	public abstract boolean isMultivalue();
	
	public abstract boolean isReverseMultivalue();

	public abstract Instance createTo(Instance from);
	
	@Override
	public String getDatatype() {
		return DATATYPE_ENTITY;
	}

	@Override
	public String getQuestion(RenderContext context) {
		return null;
	}

}

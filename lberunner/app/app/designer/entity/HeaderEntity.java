package app.designer.entity;

import java.util.List;

import app.designer.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class HeaderEntity extends SimpleEntity {

	public static final HeaderEntity INSTANCE = new HeaderEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<Header, TextDesign, TextDesign> text
		= new SimpleRelation<Header, TextDesign, TextDesign>(
			"text", INSTANCE, TextDesignEntity.INSTANCE, TextDesign.class, TextDesignEntity.textOnHeader
		) {
	
			@Override
			public ReadOnlyRelationValue<Header, TextDesign> get(
					Header instance) {
				return instance.text;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isAutoCreate() {
				return true;
			}
		};
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		text,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private HeaderEntity() {
		super("Header");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Header(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return CompositePageFragmentDesignEntity.INSTANCE;
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}

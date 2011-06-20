package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ConstantTextEntity extends SimpleEntity {

	public static final ConstantTextEntity INSTANCE = new ConstantTextEntity();
	
	// Attributes
	
	public static final Attribute<ConstantTextInstance, java.lang.String, java.lang.String> untranslated 
		= new SimpleAttribute<ConstantTextInstance, java.lang.String, java.lang.String>(
			"untranslated", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ConstantTextInstance, java.lang.String> get(ConstantTextInstance instance) {
				return instance.untranslated;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		untranslated,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConstantTextEntity() {
		super("ConstantText");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new ConstantTextInstance(caseInstance);
	}
	
	@Override
	public Entity extendsEntity() {
		return TextEntity.INSTANCE;
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

package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class ConstantStringEntity extends SimpleEntity {

	public static final ConstantStringEntity INSTANCE = new ConstantStringEntity();
	
	// Attributes
	
	public static final Attribute<ConstantStringInstance, java.lang.String, java.lang.String> constant 
		= new SimpleAttribute<ConstantStringInstance, java.lang.String, java.lang.String>(
			"constant", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<ConstantStringInstance, java.lang.String> get(ConstantStringInstance instance) {
				return instance.constant;
			}
		};
	
	// Relations
	
	// Reverse relations

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		constant,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
	};

	private ConstantStringEntity() {
		super("ConstantString");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new ConstantStringInstance(caseInstance, id);
	}
	
	@Override
	public Entity extendsEntity() {
		return StringProducerEntity.INSTANCE;
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

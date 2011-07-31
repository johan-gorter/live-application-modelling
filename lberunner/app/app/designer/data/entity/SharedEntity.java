package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class SharedEntity extends SimpleEntity {

	public static final SharedEntity INSTANCE = new SharedEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<SharedInstance, List<PageFragmentHolderInstance>, PageFragmentHolderInstance> pageFragments
		= new SimpleRelation<SharedInstance, List<PageFragmentHolderInstance>, PageFragmentHolderInstance>(
			"pageFragments", INSTANCE, PageFragmentHolderEntity.INSTANCE, PageFragmentHolderInstance.class, PageFragmentHolderEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValues<SharedInstance, PageFragmentHolderInstance> get(
					SharedInstance instance) {
				return instance.pageFragments;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<SharedInstance, List<TextHolderInstance>, TextHolderInstance> texts
		= new SimpleRelation<SharedInstance, List<TextHolderInstance>, TextHolderInstance>(
			"texts", INSTANCE, TextHolderEntity.INSTANCE, TextHolderInstance.class, TextHolderEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValues<SharedInstance, TextHolderInstance> get(
					SharedInstance instance) {
				return instance.texts;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<SharedInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<SharedInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, SharedEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValue<SharedInstance, ApplicationInstance> get(
					SharedInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		pageFragments,
		texts,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
	};

	private SharedEntity() {
		super("Shared");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new SharedInstance(caseInstance, id);
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

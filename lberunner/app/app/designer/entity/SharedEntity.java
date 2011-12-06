package app.designer.entity;

import java.util.List;

import app.designer.*;
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
	
	public static final Relation<Shared, List<PageFragmentHolder>, PageFragmentHolder> pageFragments
		= new SimpleRelation<Shared, List<PageFragmentHolder>, PageFragmentHolder>(
			"pageFragments", INSTANCE, PageFragmentHolderEntity.INSTANCE, PageFragmentHolder.class, PageFragmentHolderEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValues<Shared, PageFragmentHolder> get(
					Shared instance) {
				return instance.pageFragments;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	// Reverse relations
	
	public static final Relation<Shared, ApplicationDesign, ApplicationDesign> application
		= new SimpleRelation<Shared, ApplicationDesign, ApplicationDesign>(
			"application", INSTANCE, SharedEntity.INSTANCE, ApplicationDesign.class, ApplicationDesignEntity.shared
		) {
	
			@Override
			public ReadOnlyRelationValue<Shared, ApplicationDesign> get(
					Shared instance) {
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
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
	};

	private SharedEntity() {
		super("Shared");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Shared(caseInstance, id);
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

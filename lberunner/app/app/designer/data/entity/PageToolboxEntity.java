package app.designer.data.entity;

import java.util.List;

import app.designer.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class PageToolboxEntity extends SimpleEntity {

	public static final PageToolboxEntity INSTANCE = new PageToolboxEntity();
	
	// Attributes
	
	// Relations
	
	public static final Relation<PageToolboxInstance, List<ButtonInstance>, ButtonInstance> buttons
		= new SimpleRelation<PageToolboxInstance, List<ButtonInstance>, ButtonInstance>(
			"buttons", INSTANCE, ButtonEntity.INSTANCE, ButtonInstance.class, ButtonEntity.pageToolbox
		) {
	
			@Override
			public ReadOnlyRelationValues<PageToolboxInstance, ButtonInstance> get(
					PageToolboxInstance instance) {
				return instance.buttons;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<PageToolboxInstance, List<ContainerInstance>, ContainerInstance> containers
		= new SimpleRelation<PageToolboxInstance, List<ContainerInstance>, ContainerInstance>(
			"containers", INSTANCE, ContainerEntity.INSTANCE, ContainerInstance.class, ContainerEntity.pageToolbox
		) {
	
			@Override
			public ReadOnlyRelationValues<PageToolboxInstance, ContainerInstance> get(
					PageToolboxInstance instance) {
				return instance.containers;
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
		};
	
	public static final Relation<PageToolboxInstance, List<TextInstance>, TextInstance> texts
		= new SimpleRelation<PageToolboxInstance, List<TextInstance>, TextInstance>(
			"texts", INSTANCE, TextEntity.INSTANCE, TextInstance.class, TextEntity.pageToolbox
		) {
	
			@Override
			public ReadOnlyRelationValues<PageToolboxInstance, TextInstance> get(
					PageToolboxInstance instance) {
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
	
	public static final Relation<PageToolboxInstance, ApplicationInstance, ApplicationInstance> application
		= new SimpleRelation<PageToolboxInstance, ApplicationInstance, ApplicationInstance>(
			"application", INSTANCE, PageToolboxEntity.INSTANCE, ApplicationInstance.class, ApplicationEntity.pageToolbox
		) {
	
			@Override
			public ReadOnlyRelationValue<PageToolboxInstance, ApplicationInstance> get(
					PageToolboxInstance instance) {
				return instance.application;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
	};
	private static final Relation[] RELATIONS = new Relation[]{
		buttons,
		containers,
		texts,
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		application,
	};

	private PageToolboxEntity() {
		super("PageToolbox");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new PageToolboxInstance(caseInstance);
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

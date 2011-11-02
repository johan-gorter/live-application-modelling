package app.designer;

import java.util.*;

import app.designer.data.entity.*;
import app.designer.data.instance.*;
import app.designer.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class DesignerApplication extends Application {

	public static final custom.designer.DesignerApplicationCustomization INSTANCE = new custom.designer.DesignerApplicationCustomization();
	
	protected DesignerApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return ApplicationEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		MainFlow.INSTANCE,
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	private static final Entity[] entities = new Entity[] {
		ApplicationEntity.INSTANCE,
		ConceptEntity.INSTANCE,
		EntityEntity.INSTANCE,
		AttributeBaseEntity.INSTANCE,
		AttributeEntity.INSTANCE,
		DomainEntryEntity.INSTANCE,
		RelationEntity.INSTANCE,
		SharedEntity.INSTANCE,
		TextHolderEntity.INSTANCE,
		PageFragmentHolderEntity.INSTANCE,
		PageFragmentEntity.INSTANCE,
		CompositePageFragmentEntity.INSTANCE,
		SelectEntity.INSTANCE,
		HeaderEntity.INSTANCE,
		SharedFragmentEntity.INSTANCE,
		FieldEntity.INSTANCE,
		ButtonEntity.INSTANCE,
		PageCompositionEntity.INSTANCE,
		TextEntity.INSTANCE,
		ConstantTextEntity.INSTANCE,
		SharedTextEntity.INSTANCE,
		FlowEdgeEntity.INSTANCE,
		FlowNodeBaseEntity.INSTANCE,
		FlowSourceEntity.INSTANCE,
		FlowSinkEntity.INSTANCE,
		PageEntity.INSTANCE,
		SubFlowEntity.INSTANCE,
		FlowEntity.INSTANCE,
	};
	private static final SortedMap<String, Entity> entityMap = new TreeMap<String, Entity>();
	static {
		for (Entity entity:entities) {
			entityMap.put(entity.getName(), entity);
		}
	}
	@Override
	public SortedMap<String, Entity> getEntities() {
		return entityMap;
	}
	
	
	@Override
	public Class<? extends CaseInstance> getCaseInstanceClass() {
		return ApplicationInstance.class;
	}

	@Override
	public String getName() {
		return "Designer";
	}
}

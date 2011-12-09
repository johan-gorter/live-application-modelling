package app.designer;

import java.util.*;

import app.designer.entity.*;
import app.designer.*;
import app.designer.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public class DesignerApplication extends Application {

	public static final DesignerApplication INSTANCE = new DesignerApplication();
	
	protected DesignerApplication() {
	}
	
	@Override
	public Entity getCaseModel() {
		return ApplicationDesignEntity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
		MainFlow.INSTANCE,
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	private static final Entity[] entities = new Entity[] {
		ApplicationDesignEntity.INSTANCE,
		DesignEntity.INSTANCE,
		EntityDesignEntity.INSTANCE,
		AttributeDesignEntity.INSTANCE,
		DomainEntryDesignEntity.INSTANCE,
		RelationDesignEntity.INSTANCE,
		DeductionSchemeDesignEntity.INSTANCE,
		DeductionDesignEntity.INSTANCE,
		SelectedInstanceDeductionDesignEntity.INSTANCE,
		AttributeDeductionDesignEntity.INSTANCE,
		PageFragmentHolderDesignEntity.INSTANCE,
		PageFragmentDesignEntity.INSTANCE,
		CompositePageFragmentDesignEntity.INSTANCE,
		SelectDesignEntity.INSTANCE,
		HeaderDesignEntity.INSTANCE,
		SharedFragmentDesignEntity.INSTANCE,
		FieldDesignEntity.INSTANCE,
		LinkDesignEntity.INSTANCE,
		ButtonDesignEntity.INSTANCE,
		PageCompositionDesignEntity.INSTANCE,
		TextDesignEntity.INSTANCE,
		ConstantTextDesignEntity.INSTANCE,
		TemplatedTextDesignEntity.INSTANCE,
		StringProducerDesignEntity.INSTANCE,
		ConstantStringDesignEntity.INSTANCE,
		FormattedValueDesignEntity.INSTANCE,
		SharedTextDesignEntity.INSTANCE,
		EventDesignEntity.INSTANCE,
		FlowEdgeDesignEntity.INSTANCE,
		FlowNodeBaseDesignEntity.INSTANCE,
		FlowSourceDesignEntity.INSTANCE,
		PageDesignEntity.INSTANCE,
		SubFlowDesignEntity.INSTANCE,
		FlowDesignEntity.INSTANCE,
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
		return custom.designer.ApplicationDesignCustomization.class;
	}

	@Override
	public String getName() {
		return "Designer";
	}
}

package app.designer;

import java.util.SortedMap;
import java.util.TreeMap;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.model.Entity;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;

import app.designer.entity.ApplicationDesignEntity;
import app.designer.entity.AttributeDeductionDesignEntity;
import app.designer.entity.AttributeDesignEntity;
import app.designer.entity.ButtonDesignEntity;
import app.designer.entity.CastInstanceDeductionDesignEntity;
import app.designer.entity.CompositePageFragmentDesignEntity;
import app.designer.entity.ConstantStringDesignEntity;
import app.designer.entity.ConstantTextDesignEntity;
import app.designer.entity.DeductionDesignEntity;
import app.designer.entity.DeductionSchemeDesignEntity;
import app.designer.entity.DesignEntity;
import app.designer.entity.DomainEntryDesignEntity;
import app.designer.entity.EntityDesignEntity;
import app.designer.entity.EventDesignEntity;
import app.designer.entity.FieldDesignEntity;
import app.designer.entity.FlowDesignEntity;
import app.designer.entity.FlowEdgeDesignEntity;
import app.designer.entity.FlowNodeBaseDesignEntity;
import app.designer.entity.FlowSourceDesignEntity;
import app.designer.entity.FormattedValueDesignEntity;
import app.designer.entity.HeaderDesignEntity;
import app.designer.entity.LinkDesignEntity;
import app.designer.entity.PageCompositionDesignEntity;
import app.designer.entity.PageDesignEntity;
import app.designer.entity.PageFragmentDesignEntity;
import app.designer.entity.PageFragmentHolderDesignEntity;
import app.designer.entity.RelationDesignEntity;
import app.designer.entity.SelectDesignEntity;
import app.designer.entity.SelectedInstanceDeductionDesignEntity;
import app.designer.entity.SharedFragmentDesignEntity;
import app.designer.entity.SharedTextDesignEntity;
import app.designer.entity.StringProducerDesignEntity;
import app.designer.entity.SubFlowDesignEntity;
import app.designer.entity.TemplatedTextDesignEntity;
import app.designer.entity.TextDesignEntity;
import app.designer.flow.MainFlow;

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
		CastInstanceDeductionDesignEntity.INSTANCE,
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

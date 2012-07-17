package org.instantlogic.engine;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.fabric.model.impl.SimpleRelation;
import org.instantlogic.fabric.value.Multi;
import org.instantlogic.fabric.value.ReadOnlyRelationValue;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.Flow;
import org.instantlogic.interaction.flow.FlowEdge;
import org.instantlogic.interaction.flow.FlowNodeBase;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.page.SelectionElement;

public class EngineTestApplication extends Application {

	public static class CaseEntity extends Entity<Case> {

		public static CaseEntity INSTANCE = new CaseEntity();
		
		private CaseEntity() {}
		
		public static final Relation<Case, Multi<Item>, Item> items
			= new SimpleRelation<Case, Multi<Item>, Item>("items", INSTANCE, ItemEntity.INSTANCE, Item.class, ItemEntity.itemIn
		) {
	
			@Override
			public org.instantlogic.fabric.value.ReadOnlyRelationValues<Case, Item> get(Case instance) {
				return instance.getItemsRelationValue();
			}
	
			public boolean isOwner() {
				return true;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
		};
		
		
		private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		};
		private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		};
		private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		};

		@Override
		public Attribute<Case, ? extends Object, ? extends Object>[] getLocalAttributes() {
			return ATTRIBUTES;
		}

		@Override
		public Relation<Case, ? extends Object, ? extends Instance>[] getLocalRelations() {
			return RELATIONS;
		}

		@Override
		public Relation<? extends Instance, ? extends Object, Case>[] getLocalReverseRelations() {
			return REVERSE_RELATIONS;
		}

		@Override
		public Case createInstance() {
			return new Case();
		}

		@Override
		public Class<Case> getInstanceClass() {
			return Case.class;
		}

		@Override
		public String getName() {
			return "Case";
		}
	}
	
	public static class Case extends Instance {

		@Override
		public Entity<?> getInstanceEntity() {
			return CaseEntity.INSTANCE;
		}
		
		private final org.instantlogic.fabric.value.RelationValues<Case, Item> items
			= createRelationValues(CaseEntity.items);
		
		public org.instantlogic.fabric.value.RelationValues<Case, Item> getItemsRelationValue() {
			return items;
		}

		public org.instantlogic.fabric.value.Multi<Item> getItems() {
			return items.getValue();
		}
	
		public Case addToItems(Item item) {
			items.addValue(item);
			return (Case)this;
		}
	}
	
	public static class ItemEntity extends Entity<Item> {

		public static ItemEntity INSTANCE = new ItemEntity();
		
		private ItemEntity() {}

		public static final Relation<Item, Case, Case> itemIn
			= new SimpleRelation<Item, Case, Case>(
			"itemIn", INSTANCE, CaseEntity.INSTANCE, Case.class, CaseEntity.items
		) {
	
			@Override
			public ReadOnlyRelationValue<Item, Case> get(Item instance) {
				return instance.getItemInRelationValue();
			}
	
			public boolean isReverse() {
				return true;
			}
		};
		
		private static final org.instantlogic.fabric.model.Attribute[] ATTRIBUTES = new org.instantlogic.fabric.model.Attribute[]{
		};
		private static final org.instantlogic.fabric.model.Relation[] RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		};
		private static final org.instantlogic.fabric.model.Relation[] REVERSE_RELATIONS = new org.instantlogic.fabric.model.Relation[]{
		};
		
		@Override
		public Attribute<Item, ? extends Object, ? extends Object>[] getLocalAttributes() {
			return ATTRIBUTES;
		}

		@Override
		public Relation<Item, ? extends Object, ? extends Instance>[] getLocalRelations() {
			return RELATIONS;
		}

		@Override
		public Relation<? extends Instance, ? extends Object, Item>[] getLocalReverseRelations() {
			return REVERSE_RELATIONS;
		}

		@Override
		public Item createInstance() {
			return new Item();
		}

		@Override
		public Class<Item> getInstanceClass() {
			return Item.class;
		}

		@Override
		public String getName() {
			return null;
		}
	}
	
	public static class Item extends Instance {

		@Override
		public Entity<?> getInstanceEntity() {
			return ItemEntity.INSTANCE;
		}
		
		private final org.instantlogic.fabric.value.ReadOnlyRelationValue<Item, Case> itemIn
			= createReverseRelationValue(ItemEntity.itemIn);

		public org.instantlogic.fabric.value.ReadOnlyRelationValue<Item, Case> getItemInRelationValue() {
			return itemIn;
		}
	
		public Case getItemIn() {
			return itemIn.getValue();
		}
	}
	
	public static class HomePlaceTemplate extends org.instantlogic.interaction.flow.PlaceTemplate {

		public static final HomePlaceTemplate INSTANCE = new HomePlaceTemplate();

		private Deduction<Multi<Item>> createDeduction0() {
		  	Deduction<Case> d0 = SelectedInstanceDeduction.create(CaseEntity.INSTANCE);
		  	Deduction<Multi<Item>> d1 = AttributeDeduction.create(CaseEntity.items, d0);
			return d1;
		}
		
		private FragmentTemplate CONTENT = 
		        new FragmentTemplate("F7P3F1", "Page")      
		        	.putChildren("mainContent",
		                new FragmentTemplate("F7P3F1P1F1", "Table")      
		                	.putChildren("columns",
		                        new FragmentTemplate("F7P3F1P1F1P1F1", "Column")      
		                        	.putText("header", new org.instantlogic.fabric.text.ConstantText("Column1"))
		                	)
		                	.putChildren("rows",
		                        new SelectionElement(createDeduction0(),
		                        	new org.instantlogic.interaction.page.FragmentTemplate("F7P3F1P1F1P2S1F2", "Row")      
		                                .putChildren("cells",
		                                    new org.instantlogic.interaction.page.FragmentTemplate("F7P3F1P1F1P2S1F2P1F1", "Cell")      
//		                                        .putChildren("content",
//		                                                new org.instantlogic.interaction.page.FragmentTemplate("F7P3F1P1F1P2S1F2P1F1P1F1", "Link")
//		                                        			.setEvent(org.instantlogic.example.izzy.event.IssueDetailsEvent.INSTANCE)
//		                                        			.putText("text", new org.instantlogic.fabric.text.TemplatedText().add(createDeduction1()))
//		                                        )
		                                )
		                        )
		                	)
		        	); 
		
		@Override
		public FragmentTemplate getRootContainer() {
			return CONTENT;
		}

		@Override
		public String getName() {
			return "Home";
		}
	}
	
	public static class MainFlow extends org.instantlogic.interaction.flow.Flow {

		public static final MainFlow INSTANCE = new MainFlow();
		
		private static final org.instantlogic.interaction.flow.FlowNodeBase[] NODES = new org.instantlogic.interaction.flow.FlowNodeBase[]{
			HomePlaceTemplate.INSTANCE,
		};
		
		private static final org.instantlogic.interaction.flow.FlowEdge[] EDGES = new org.instantlogic.interaction.flow.FlowEdge[]{
		};
		
		private static final org.instantlogic.fabric.model.Entity[] PARAMETERS = new org.instantlogic.fabric.model.Entity[]{
		};

		@Override
		public FlowNodeBase[] getNodes() {
			return NODES;
		}

		@Override
		public FlowEdge[] getEdges() {
			return EDGES;
		}

		@Override
		public Entity<? extends Instance>[] getParameters() {
			return PARAMETERS;
		}

		@Override
		public String getName() {
			return "Main";
		}
	}

	public static EngineTestApplication INSTANCE = new EngineTestApplication();
	
	private EngineTestApplication() {};
	
	@Override
	public Entity<? extends Instance> getCaseEntity() {
		return CaseEntity.INSTANCE;
	}
	
	@Override
	public Flow getMainFlow() {
		return MainFlow.INSTANCE;
	}

	@Override
	public String getName() {
		return "EngineTest";
	}
}

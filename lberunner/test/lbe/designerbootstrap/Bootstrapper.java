package lbe.designerbootstrap;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.RelationInstance;

public class Bootstrapper {

	public enum RelationType {OneToOne, OneToOneAggregation, OneToMany, OneToManyAggregation, ManyToOne, ManyToMany}
	
	private static ApplicationInstance applicationInstance;
	
	public static void main(String[] args) {

		// Case
		applicationInstance = new ApplicationInstance();
		applicationInstance.name.set("Designer");
		
		// Entities
		
		// Application
		EntityInstance application = createEntity("Application", null);
		createAttribute(application, "name", String.class);
		applicationInstance.caseEntity.set(application);
		
		// Concept
		EntityInstance concept = createEntity("Concept", null);
		createAttribute(concept, "name", String.class);
		
		// Entity
		EntityInstance entity = createEntity("Entity", concept);

		// AttributeBase
		EntityInstance attributeBase = createEntity("AttributeBase", concept);
		createAttribute(attributeBase, "readonly", Boolean.class);
		createAttribute(attributeBase, "multivalue", Boolean.class);
		
		// Attribute
		EntityInstance attribute = createEntity("Attribute", attributeBase);
		createAttribute(attribute, "className", String.class);
		
		// Relation
		EntityInstance relation = createEntity("Relation", attributeBase);
		createAttribute(relation, "owner", Boolean.class);
		createAttribute(relation, "reverseMultivalue", Boolean.class);
		createAttribute(relation, "reverseName", String.class);
		
		// Flow nodes & Flow
		EntityInstance flowEdge = createEntity("FlowEdge", null);
		EntityInstance flowNodeBase = createEntity("FlowNodeBase", concept);
		EntityInstance flowSource = createEntity("FlowSource", flowNodeBase);
		EntityInstance flowSink = createEntity("FlowSink", flowNodeBase);
		EntityInstance page = createEntity("Page", flowNodeBase);
		EntityInstance subFlow = createEntity("SubFlow", flowNodeBase);
		EntityInstance flow = createEntity("Flow", concept);
		
		// Relations
		
		createRelation("entities", application, RelationType.OneToManyAggregation, entity, "application");
		createRelation("caseEntity", application, RelationType.OneToOne, entity, "caseEntityInApplication");
		createRelation("flows", application, RelationType.OneToManyAggregation, flow, "application");
		createRelation("exposedFlows", application, RelationType.OneToMany, flow, "exposedFlowInApplication");

		createRelation("extendsFrom", entity, RelationType.ManyToOne, entity, "extensions");
		createRelation("attributes", entity, RelationType.OneToManyAggregation, attribute, "entity");
		createRelation("relations", entity, RelationType.OneToManyAggregation, relation, "entity");

		createRelation("to", relation, RelationType.ManyToOne, entity, "reverseRelations");

		createRelation("sources", flow, RelationType.OneToManyAggregation, flowSource, "flow");
		createRelation("sinks", flow, RelationType.OneToManyAggregation, flowSink, "flow");
		createRelation("nodes", flow, RelationType.OneToManyAggregation, flowNodeBase, "flow");
		createRelation("edges", flow, RelationType.OneToManyAggregation, flowEdge, "flow");
		createRelation("from", flowEdge, RelationType.ManyToOne, flowNodeBase, "outgoingEdges");
		createRelation("to", flowEdge, RelationType.ManyToOne, flowNodeBase, "incomingEdges");
		
		// Finish up

//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateApplication(applicationInstance);
	}

	private static EntityInstance createEntity(String name, EntityInstance extendsFrom) {
		EntityInstance result = new EntityInstance(applicationInstance);
		result.name.set(name);
		result.extendsFrom.set(extendsFrom);
		applicationInstance.entities.add(result);
		return result;
	}

	private static void createAttribute(EntityInstance entity, String name, Class<?> className) {
		AttributeInstance attribute = new AttributeInstance(applicationInstance);
		attribute.name.set(name);
		attribute.className.set(className.getName());
		entity.attributes.add(attribute);
	}

	private static void createRelation(String name, EntityInstance from, RelationType relationType, EntityInstance to, String reverseName) {
		RelationInstance relation = new RelationInstance(applicationInstance);
		from.relations.add(relation);
		relation.to.set(to);
		relation.name.set(name);
		relation.reverseName.set(reverseName);
		relation.owner.set(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToOneAggregation);
		relation.multivalue.set(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.reverseMultivalue.set(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToOne);
	}
}

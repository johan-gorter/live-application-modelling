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
		
		// Flow
		EntityInstance flow = createEntity("Flow", concept);
		
		// Relations
		
		// Entity.extendsFrom
		RelationInstance extendsFrom = new RelationInstance(applicationInstance);
		entity.relations.add(extendsFrom);
		extendsFrom.to.set(entity);
		extendsFrom.name.set("extendsFrom");
		extendsFrom.reverseName.set("extensions");
		extendsFrom.reverseMultivalue.set(true);
		
		// Application.entities
		createRelation("entities", application, RelationType.OneToManyAggregation, entity, "application");
		// Application.caseEntity
		RelationInstance caseEntity = new RelationInstance(applicationInstance);
		application.relations.add(caseEntity);
		caseEntity.name.set("caseEntity");
		caseEntity.reverseName.set("caseEntityInApplication");
		caseEntity.to.set(entity);

		// Entity.attributes
		createRelation("attributes", entity, RelationType.OneToManyAggregation, attribute, "entity");
		RelationInstance entityAttributes = new RelationInstance(applicationInstance);
		entity.relations.add(entityAttributes);
		entityAttributes.name.set("attributes");
		entityAttributes.reverseName.set("entity");
		entityAttributes.reverseMultivalue.set(false);
		entityAttributes.to.set(attribute);
		entityAttributes.multivalue.set(true);
		entityAttributes.owner.set(true);
		// Entity.relations
		RelationInstance entityRelations = new RelationInstance(applicationInstance);
		entity.relations.add(entityRelations);
		entityRelations.name.set("relations");
		entityRelations.reverseName.set("entity");
		entityRelations.reverseMultivalue.set(false);
		entityRelations.to.set(relation);
		entityRelations.multivalue.set(true);
		entityRelations.owner.set(true);
		// Relation.to
		RelationInstance relationTo = new RelationInstance(applicationInstance);
		relation.relations.add(relationTo);
		relationTo.name.set("to");
		relationTo.reverseName.set("reverseRelations");
		relationTo.reverseMultivalue.set(true);
		relationTo.to.set(entity);
		
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

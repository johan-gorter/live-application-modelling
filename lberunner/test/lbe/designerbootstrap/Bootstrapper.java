package lbe.designerbootstrap;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
import app.designerbootstrap.data.instance.ApplicationInstance;
import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;

public class Bootstrapper {
	
	public static void main(String[] args) {

		// Case
		ApplicationInstance applicationInstance = new ApplicationInstance();
		
		// Entities
		EntityInstance application = new EntityInstance(applicationInstance);
		application.name.set("Application");

		EntityInstance concept = new EntityInstance(applicationInstance);
		concept.name.set("Concept");

		EntityInstance entity = new EntityInstance(applicationInstance);
		entity.name.set("Entity");
		entity.extendsFrom.set(concept);

		EntityInstance attribute = new EntityInstance(applicationInstance);
		attribute.name.set("Attribute");
		attribute.extendsFrom.set(concept);
		
		EntityInstance relation = new EntityInstance(applicationInstance);
		relation.name.set("Relation");
		relation.extendsFrom.set(attribute);

		// Relations
		RelationInstance extendsFrom = new RelationInstance(applicationInstance);
		entity.relations.add(extendsFrom);
		extendsFrom.to.set(entity);
		extendsFrom.name.set("extendsFrom");
		extendsFrom.reverseName.set("extensions");
		extendsFrom.reverseMultivalue.set(true);
		
		RelationInstance entities = new RelationInstance(applicationInstance);
		application.relations.add(entities);
		entities.name.set("entities");
		entities.reverseName.set("application");
		entities.reverseMultivalue.set(false);
		entities.to.set(entity);
		entities.multivalue.set(true);
		entities.owner.set(true);

		RelationInstance caseEntity = new RelationInstance(applicationInstance);
		application.relations.add(caseEntity);
		caseEntity.name.set("caseEntity");
		caseEntity.reverseName.set("caseEntityInApplication");
		caseEntity.to.set(entity);

		RelationInstance entityAttributes = new RelationInstance(applicationInstance);
		entity.relations.add(entityAttributes);
		entityAttributes.name.set("attributes");
		entityAttributes.reverseName.set("entity");
		entityAttributes.reverseMultivalue.set(false);
		entityAttributes.to.set(attribute);
		entityAttributes.multivalue.set(true);
		entityAttributes.owner.set(true);

		RelationInstance entityRelations = new RelationInstance(applicationInstance);
		entity.relations.add(entityRelations);
		entityRelations.name.set("relations");
		entityRelations.reverseName.set("entity");
		entityRelations.reverseMultivalue.set(false);
		entityRelations.to.set(relation);
		entityRelations.multivalue.set(true);
		entityRelations.owner.set(true);

		RelationInstance relationTo = new RelationInstance(applicationInstance);
		relation.relations.add(relationTo);
		relationTo.name.set("to");
		relationTo.reverseName.set("reverseRelations");
		relationTo.reverseMultivalue.set(true);
		relationTo.to.set(entity);
		
		// Attributes
		AttributeInstance conceptName = new AttributeInstance(applicationInstance);
		conceptName.name.set("name");
		conceptName.className.set("java.lang.String");
		concept.attributes.add(conceptName);
		
		AttributeInstance attributeReadonly = new AttributeInstance(applicationInstance);
		attributeReadonly.name.set("readonly");
		attributeReadonly.className.set("java.lang.Boolean");
		attribute.attributes.add(attributeReadonly);

		AttributeInstance attributeMultivalue = new AttributeInstance(applicationInstance);
		attributeMultivalue.name.set("multivalue");
		attributeMultivalue.className.set("java.lang.Boolean");
		attribute.attributes.add(attributeMultivalue);
		
		AttributeInstance attributeClassName = new AttributeInstance(applicationInstance);
		attributeClassName.name.set("className");
		attributeClassName.className.set("java.lang.String");
		attribute.attributes.add(attributeClassName);
		
		AttributeInstance relationOwner = new AttributeInstance(applicationInstance);
		relationOwner.name.set("owner");
		relationOwner.className.set("java.lang.Boolean");
		relation.attributes.add(relationOwner);
		
		AttributeInstance relationReverseMultivalue = new AttributeInstance(applicationInstance);
		relationReverseMultivalue.name.set("reverseMultivalue");
		relationReverseMultivalue.className.set("java.lang.Boolean");
		relation.attributes.add(relationReverseMultivalue);
		
		AttributeInstance relationReverseName = new AttributeInstance(applicationInstance);
		relationReverseName.name.set("reverseName");
		relationReverseName.className.set("java.lang.String");
		relation.attributes.add(relationReverseName);
		
		// Finish up
		applicationInstance.caseEntity.set(application);
		applicationInstance.entities.add(application);
		applicationInstance.entities.add(concept);
		applicationInstance.entities.add(entity);
		applicationInstance.entities.add(attribute);
		applicationInstance.entities.add(relation);
		
//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateEntity(relation, "designerbootstrap");
		
	}
}

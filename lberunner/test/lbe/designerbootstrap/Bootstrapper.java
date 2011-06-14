package lbe.designerbootstrap;

import lbe.engine.CasePersister;
import lbe.engine.codegenerator.CodeGenerator;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.RelationInstance;

public class Bootstrapper {
	
	public static void main(String[] args) {

		// Case
		ApplicationInstance applicationInstance = new ApplicationInstance();
		applicationInstance.name.set("Designer");
		
		// Entities
		EntityInstance application = new EntityInstance(applicationInstance);
		application.name.set("Application");

		EntityInstance concept = new EntityInstance(applicationInstance);
		concept.name.set("Concept");

		EntityInstance entity = new EntityInstance(applicationInstance);
		entity.name.set("Entity");
		entity.extendsFrom.set(concept);

		EntityInstance attributeBase = new EntityInstance(applicationInstance);
		attributeBase.name.set("AttributeBase");
		attributeBase.extendsFrom.set(concept);

		EntityInstance attribute = new EntityInstance(applicationInstance);
		attribute.name.set("Attribute");
		attribute.extendsFrom.set(attributeBase);
		
		EntityInstance relation = new EntityInstance(applicationInstance);
		relation.name.set("Relation");
		relation.extendsFrom.set(attributeBase);

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
		AttributeInstance applicationName = new AttributeInstance(applicationInstance);
		applicationName.name.set("name");
		applicationName.className.set("java.lang.String");
		application.attributes.add(applicationName);

		AttributeInstance conceptName = new AttributeInstance(applicationInstance);
		conceptName.name.set("name");
		conceptName.className.set("java.lang.String");
		concept.attributes.add(conceptName);
		
		AttributeInstance attributeBaseReadonly = new AttributeInstance(applicationInstance);
		attributeBaseReadonly.name.set("readonly");
		attributeBaseReadonly.className.set("java.lang.Boolean");
		attributeBase.attributes.add(attributeBaseReadonly);

		AttributeInstance attributeBaseMultivalue = new AttributeInstance(applicationInstance);
		attributeBaseMultivalue.name.set("multivalue");
		attributeBaseMultivalue.className.set("java.lang.Boolean");
		attributeBase.attributes.add(attributeBaseMultivalue);
		
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
		applicationInstance.entities.add(attributeBase);
		applicationInstance.entities.add(attribute);
		applicationInstance.entities.add(relation);
		
//		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateApplication(applicationInstance);
	}
}

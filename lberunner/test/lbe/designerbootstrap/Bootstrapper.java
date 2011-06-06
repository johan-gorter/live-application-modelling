package lbe.designerbootstrap;

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

		EntityInstance relation = new EntityInstance(applicationInstance);
		relation.name.set("Relation");

		EntityInstance attribute = new EntityInstance(applicationInstance);
		attribute.name.set("Attribute");
		
		// Relations
		RelationInstance entities = new RelationInstance(applicationInstance);
		entities.name.set("entities");
		entities.from.set(application);
		entities.to.set(entity);
		entities.multivalue.set(true);
		entities.owner.set(true);

		RelationInstance caseEntity = new RelationInstance(applicationInstance);
		caseEntity.name.set("caseEntity");
		caseEntity.from.set(application);
		caseEntity.to.set(entity);

		RelationInstance entityExtends = new RelationInstance(applicationInstance);
		entityExtends.name.set("entityExtends");
		entityExtends.from.set(entity);
		entityExtends.to.set(entity);
		
		RelationInstance entityAttributes = new RelationInstance(applicationInstance);
		entityAttributes.name.set("entityAttributes");
		entityAttributes.from.set(entity);
		entityAttributes.to.set(attribute);
		entityAttributes.multivalue.set(true);
		entityAttributes.owner.set(true);

		RelationInstance entityRelations = new RelationInstance(applicationInstance);
		entityRelations.name.set("entityAttributes");
		entityRelations.from.set(entity);
		entityRelations.to.set(relation);
		entityRelations.multivalue.set(true);
		entityRelations.owner.set(true);
		
		// Extends relations
		RelationInstance entityExtendsFrom = new RelationInstance(applicationInstance);
		entityExtendsFrom.name.set("entityExtendsFrom");
		entityExtendsFrom.from.set(entity);
		entityExtendsFrom.to.set(concept);

		RelationInstance attributeExtendsFrom = new RelationInstance(applicationInstance);
		attributeExtendsFrom.name.set("attributeExtendsFrom");
		attributeExtendsFrom.from.set(attribute);
		attributeExtendsFrom.to.set(concept);
		
		RelationInstance relationExtendsFrom = new RelationInstance(applicationInstance);
		relationExtendsFrom.name.set("relationExtendsFrom");
		relationExtendsFrom.from.set(relation);
		relationExtendsFrom.to.set(attribute);
		
		// Finish up
		applicationInstance.caseEntity.set(application);
		applicationInstance.entities.add(application);
		applicationInstance.entities.add(concept);
		applicationInstance.entities.add(entity);
		applicationInstance.entities.add(attribute);
		applicationInstance.entities.add(relation);
		
		CodeGenerator.generateEntity(concept);
		
	}
}

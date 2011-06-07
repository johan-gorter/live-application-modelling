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
		RelationInstance entities = new RelationInstance(applicationInstance);
		application.relations.add(entities);
		entities.name.set("entities");
		entities.to.set(entity);
		entities.multivalue.set(true);
		entities.owner.set(true);

		RelationInstance caseEntity = new RelationInstance(applicationInstance);
		application.relations.add(caseEntity);
		caseEntity.name.set("caseEntity");
		caseEntity.to.set(entity);

		RelationInstance entityExtends = new RelationInstance(applicationInstance);
		entity.relations.add(entityExtends);
		entityExtends.name.set("entityExtends");
		entityExtends.to.set(entity);
		
		RelationInstance entityAttributes = new RelationInstance(applicationInstance);
		entity.relations.add(entityAttributes);
		entityAttributes.name.set("entityAttributes");
		entityAttributes.to.set(attribute);
		entityAttributes.multivalue.set(true);
		entityAttributes.owner.set(true);

		RelationInstance entityRelations = new RelationInstance(applicationInstance);
		entity.relations.add(entityRelations);
		entityRelations.name.set("entityAttributes");
		entityRelations.to.set(relation);
		entityRelations.multivalue.set(true);
		entityRelations.owner.set(true);
		
		// Finish up
		applicationInstance.caseEntity.set(application);
		applicationInstance.entities.add(application);
		applicationInstance.entities.add(concept);
		applicationInstance.entities.add(entity);
		applicationInstance.entities.add(attribute);
		applicationInstance.entities.add(relation);
		
		System.out.println(CasePersister.gson.toJson(applicationInstance));
		
		CodeGenerator.generateEntity(concept);
		
	}
}

package lbe.engine.codegenerator;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import lbe.engine.codegenerator.EntityClassModel.Attribute;
import lbe.engine.codegenerator.EntityClassModel.Relation;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import app.designerbootstrap.data.entity.EntityEntity;
import app.designerbootstrap.data.instance.AttributeInstance;
import app.designerbootstrap.data.instance.EntityInstance;
import app.designerbootstrap.data.instance.RelationInstance;

public class CodeGenerator {

	private static Configuration freemarkerConfig;
	
	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(CodeGenerator.class, "template/");
		freemarkerConfig.setObjectWrapper(new DefaultObjectWrapper());
	}
	
	public static void generateEntity(EntityInstance entity, String appname) {
		
		try {
			Template entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			System.out.println("Name: "+entity.name.get());
			Writer out = new OutputStreamWriter(System.out);
			entityTemplate.process(createEntityClassModel(entity, appname), out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static EntityClassModel createEntityClassModel(EntityInstance entity, String appname) {
		EntityClassModel result = new EntityClassModel();
		result.appname=appname;
		result.name=entity.name.get();
		for (AttributeInstance attributeInstance: entity.attributes.get()) {
			Attribute attribute = new Attribute();
			attribute.name = attributeInstance.name.get();
			attribute.className = attributeInstance.className.get();
			attribute.multivalue = (attributeInstance.multivalue.get()==Boolean.TRUE);
			
			result.attributes.add(attribute);
		}
		for (RelationInstance relationInstance: entity.relations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.name.get();
			relation.multivalue = (relationInstance.multivalue.get()==Boolean.TRUE);
			relation.owner = (relationInstance.owner.get()==Boolean.TRUE);
			relation.item = relationInstance.to.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item;
			relation.reverseName=relation.reverseName;
			result.relations.add(relation);
		}
		for (EntityInstance otherEntity : entity.application.get().entities.get()) {
			for (RelationInstance relationInstance: entity.relations.get()) {
				if (relationInstance.to.get()==entity) {
					Relation relation = new Relation();
					relation.name = relationInstance.reverseName.get();
					relation.multivalue = relationInstance.reverseMultivalue.get();
					relation.reverseName = relationInstance.name.get();
					relation.item = otherEntity.name.get();
					relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item;
					result.reverseRelations.add(relation);
				}
			}
		}
		return result;
	}
}

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
			Template instanceTemplate = freemarkerConfig.getTemplate("Instance.java.ftl");
			Writer out = new OutputStreamWriter(System.out);
			EntityClassModel entityClassModel = createEntityClassModel(entity, appname);
			//entityTemplate.process(entityClassModel, out);
			instanceTemplate.process(entityClassModel, out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static EntityClassModel createEntityClassModel(EntityInstance entity, String appname) {
		EntityClassModel result = new EntityClassModel();
		result.appname=appname;
		result.name=entity.name.get();
		result.caseEntity = (entity.caseEntityInApplication.get()!=null);
		if (entity.extendsFrom.get()!=null) {
			result.extendsFrom = entity.extendsFrom.get().name.get();
		}
		for (AttributeInstance attributeInstance: entity.attributes.get()) {
			Attribute attribute = new Attribute();
			attribute.name = attributeInstance.name.get();
			attribute.className = attributeInstance.className.get();
			attribute.multivalue = (attributeInstance.multivalue.get()==Boolean.TRUE);
			attribute.readonly = (attributeInstance.readonly.get()==Boolean.TRUE);
			result.attributes.add(attribute);
		}
		for (RelationInstance relationInstance: entity.relations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.name.get();
			relation.multivalue = (relationInstance.multivalue.get()==Boolean.TRUE);
			relation.readonly = (relationInstance.readonly.get()==Boolean.TRUE);
			relation.owner = (relationInstance.owner.get()==Boolean.TRUE);
			relation.item = relationInstance.to.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item+"Instance";
			relation.reverseName=relationInstance.reverseName.get();
			result.relations.add(relation);
		}
		for (RelationInstance relationInstance: entity.reverseRelations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.reverseName.get();
			relation.multivalue = (relationInstance.reverseMultivalue.get()==Boolean.TRUE);
			relation.reverseName = relationInstance.name.get();
			relation.item = relationInstance.entity.get().name.get();
			relation.to = relation.multivalue?"List<"+relation.item+"Instance>":relation.item+"Instance";
			result.reverseRelations.add(relation);
		}
		return result;
	}
}

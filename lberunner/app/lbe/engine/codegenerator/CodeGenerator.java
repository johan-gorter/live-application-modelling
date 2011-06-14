package lbe.engine.codegenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.CharsetEncoder;

import play.Play;

import lbe.engine.codegenerator.EntityClassModel.Attribute;
import lbe.engine.codegenerator.EntityClassModel.Relation;
import lbe.instance.CaseInstance;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import app.designer.data.entity.EntityEntity;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.RelationInstance;

public class CodeGenerator {

	private static Configuration freemarkerConfig;
	private static Template entityTemplate;
	private static Template instanceTemplate;
	private static Template applicationTemplate;
	private static File applicationsRoot = new File(Play.applicationPath, "app/app");
	
	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(CodeGenerator.class, "template/");
		freemarkerConfig.setObjectWrapper(new DefaultObjectWrapper());
		try {
			entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			instanceTemplate = freemarkerConfig.getTemplate("Instance.java.ftl");
			applicationTemplate = freemarkerConfig.getTemplate("Application.java.ftl");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
	
	public static void generateEntity(EntityInstance entity, String appname, File applicationRoot) {
		Writer entityWriter = null;
		Writer instanceWriter = null;
		try {
			File entityFile = new File(new File(applicationRoot, "data/entity"), entity.name.get()+"Entity.java");
			entityFile.getParentFile().mkdirs();
			entityWriter = new OutputStreamWriter(new FileOutputStream(entityFile), "UTF-8");
	
			File instanceFile = new File(new File(applicationRoot, "data/instance"), entity.name.get()+"Instance.java");
			instanceFile.getParentFile().mkdirs();
			instanceWriter = new OutputStreamWriter(new FileOutputStream(instanceFile), "UTF-8");
			
			EntityClassModel entityClassModel = createEntityClassModel(entity, appname);
			entityTemplate.process(entityClassModel, entityWriter);
			instanceTemplate.process(entityClassModel, instanceWriter);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (entityWriter!=null) {
					entityWriter.close();
				}
				if (instanceWriter!=null) {
					instanceWriter.close();
				}
			} catch (IOException e) {
			}
		}
	}

	public static void generateApplication(ApplicationInstance application, String appname, File applicationRoot) {
		Writer applicationWriter = null;
		try {
			File entityFile = new File(applicationRoot, application.name.get()+"Application.java");
			entityFile.getParentFile().mkdirs();
			applicationWriter = new OutputStreamWriter(new FileOutputStream(entityFile), "UTF-8");
	
			ApplicationClassModel applicationClassModel = createApplicationClassModel(application, appname);
			applicationTemplate.process(applicationClassModel, applicationWriter);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (applicationWriter!=null) {
					applicationWriter.close();
				}
			} catch (IOException e) {
			}
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

	private static ApplicationClassModel createApplicationClassModel(ApplicationInstance application, String appname) {
		ApplicationClassModel result = new ApplicationClassModel();
		result.appname = appname;
		result.name = application.name.get();
		result.caseEntity = application.caseEntity.get().name.get();
		return result;
	}
	
	public static void generateApplication(ApplicationInstance applicationInstance) {
		String appname = applicationInstance.name.get().toLowerCase();
		File applicationRoot = new File(applicationsRoot, appname);
		
		generateApplication(applicationInstance, appname, applicationRoot);
		for (EntityInstance entity: applicationInstance.entities.get()) {
			generateEntity(entity, appname, applicationRoot);
		}
		
		new File(applicationRoot, "flow").mkdirs();
	}
}

package lbe.engine.codegenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import play.Play;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import lbe.instance.Observations;

import app.designer.data.instance.ConceptInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.TextInstance;

public abstract class AbstractGenerator {

	public String appname;
	public String name;
	public String customization;
	
	protected Observations observations;
	static Configuration freemarkerConfig;
	public static File applicationsRoot = new File(Play.applicationPath, "app/app");
	public static Template subFlowTemplate;
	public static Template pageTemplate;
	public static Template eventTemplate;
	public static Template flowTemplate;
	public static Template applicationTemplate;
	public static Template instanceTemplate;
	public static Template entityTemplate;

	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(AbstractGenerator.class, "template/");
		freemarkerConfig.setObjectWrapper(new DefaultObjectWrapper());
		try {
			entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			instanceTemplate = freemarkerConfig.getTemplate("Instance.java.ftl");
			applicationTemplate = freemarkerConfig.getTemplate("Application.java.ftl");
			eventTemplate = freemarkerConfig.getTemplate("Event.java.ftl");
			flowTemplate = freemarkerConfig.getTemplate("Flow.java.ftl");
			pageTemplate = freemarkerConfig.getTemplate("Page.java.ftl");
			subFlowTemplate = freemarkerConfig.getTemplate("SubFlow.java.ftl");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getAppname() {
		return appname;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCustomization() {
		return customization;
	}
	
	public abstract void update(File applicationRoot);
	
	public abstract void delete(File applicationRoot);
	
	protected <G extends AbstractGenerator> List<ConceptInstance> updateGenerators(Map<String, G> generators, List<? extends ConceptInstance> from, File applicationRoot) {
		List<ConceptInstance> newConcepts = new ArrayList<ConceptInstance>();
		for(ConceptInstance instance: from) {
			AbstractGenerator generator = generators.get(instance.getName());
			if (generator!=null) {
				generator.update(applicationRoot);
			} else {
				newConcepts.add(instance);
			}
		}
		Iterator<Map.Entry<String, G>> i = generators.entrySet().iterator();
		nextEntry: while (i.hasNext()) {
			Entry<String, G> entry = i.next();
			for (ConceptInstance instance : from) {
				if (entry.getKey().equals(instance.getName())) {
					break nextEntry;
				}
			}
			entry.getValue().delete(applicationRoot);
			i.remove();
		}
		return newConcepts;
	}
	
	protected TextClassModel generateText(TextInstance text) {
		if (text instanceof ConstantTextInstance) {
			ConstantTextInstance constantText = (ConstantTextInstance) text;
			return new TextClassModel(constantText.untranslated.get());
		}
		throw new RuntimeException("Unsupported subclass of TextInstance: "+text.getClass());
	}

	static void generateFile(Template template, Object rootMap, String subDirectory, String name, String postfix, String appname, File root) {
		if (root==null) return;//Dry run
		Writer writer = null;
		try {
			if (subDirectory!=null) {
				root = new File(root, subDirectory);
				root.mkdirs();
			}
			File output = new File(root, name+postfix+".java");
			writer = new OutputStreamWriter(new FileOutputStream(output), "UTF-8");
			template.process(rootMap, writer);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (writer!=null) {
				try {
					writer.close();
				} catch (IOException e) {
				}
			}
		}
	}

	static void deleteFile(String subDirectory, String name, String postfix, String appname, File root) {
		new File(new File(root, subDirectory), name+postfix+".java").delete();
	}
	
	protected void purge(File dir) {
		if (dir==null) return;
		for( File file : dir.listFiles()) {
			if (file.isDirectory()) {
				purge(file);
			}
			if (!file.delete()) throw new RuntimeException("Could not delete "+file.getAbsolutePath());
		}
	}

	protected void updateAll(Collection<? extends AbstractGenerator> generators, File applicationRoot) {
		for (AbstractGenerator generator: generators) {
			generator.update(applicationRoot);
		}
	}
}

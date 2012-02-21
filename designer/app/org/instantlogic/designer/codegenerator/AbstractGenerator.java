package org.instantlogic.codegenerator;

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

import org.instantlogic.fabric.util.Observations;

import play.Play;
import app.designer.DeductionSchemeDesign;
import app.designer.Design;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public abstract class AbstractGenerator {

	public String rootPackageName;
	public String name;
	public String customization;
	
	private List<DeductionSchemeGenerator> deductionSchemes = new ArrayList<DeductionSchemeGenerator>();
	
	protected Observations observations;
	static Configuration freemarkerConfig;
	public static File applicationsRoot = new File(Play.applicationPath, "app/app");
	public static Template subFlowTemplate;
	public static Template pageTemplate;
	public static Template eventTemplate;
	public static Template pageFragmentTemplate;
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
			pageFragmentTemplate = freemarkerConfig.getTemplate("PageFragment.java.ftl");
			flowTemplate = freemarkerConfig.getTemplate("Flow.java.ftl");
			pageTemplate = freemarkerConfig.getTemplate("Page.java.ftl");
			subFlowTemplate = freemarkerConfig.getTemplate("SubFlow.java.ftl");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getRootPackageName() {
		return rootPackageName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCustomization() {
		return customization;
	}
	
	protected void clearDeductionSchemes() {
		deductionSchemes.clear();
	}
	
	public abstract void update(File applicationRoot);
	
	public abstract void delete(File applicationRoot);
	
	protected <G extends AbstractGenerator> List<Design> updateGenerators(Map<String, G> generators, List<? extends Design> from, File applicationRoot) {
		List<Design> newConcepts = new ArrayList<Design>();
		for(Design instance: from) {
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
			for (Design instance : from) {
				if (entry.getKey().equals(instance.getName())) {
					break nextEntry;
				}
			}
			entry.getValue().delete(applicationRoot);
			i.remove();
		}
		return newConcepts;
	}
	
	static void generateFile(Template template, Object rootMap, String subDirectory, String name, String postfix, String appname, File root, boolean isCustomized) {
		if (root==null) return;//Dry run
		Writer writer = null;
		try {
			if (subDirectory!=null) {
				root = new File(root, subDirectory);
				root.mkdirs();
			}
			String prefix = isCustomized?"Abstract":"";
			File output = new File(root, prefix+name+postfix+".java");
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
	
	public List<DeductionSchemeGenerator> getDeductionSchemes() {
		return deductionSchemes;
	}
	
	public int addDeductionScheme(DeductionSchemeDesign scheme) {
		int deductionIndex = deductionSchemes.size();
		deductionSchemes.add(new DeductionSchemeGenerator(scheme, deductionIndex));
		return deductionIndex;
	}

	protected String javaSafeName(String name) {
		if ("package".equals(name) || "default".equals(name)) {
			return "_"+name;
		}
		return name;
	}
	
	
}

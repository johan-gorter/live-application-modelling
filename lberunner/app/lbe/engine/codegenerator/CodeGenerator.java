package lbe.engine.codegenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import lbe.engine.codegenerator.EntityClassModel.Attribute;
import lbe.engine.codegenerator.EntityClassModel.Attribute.DomainEntry;
import lbe.engine.codegenerator.EntityClassModel.Relation;
import lbe.engine.codegenerator.FlowClassModel.FlowEdge;
import lbe.engine.codegenerator.FlowClassModel.FlowNode;
import play.Play;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.ButtonInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.DomainEntryInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FieldInstance;
import app.designer.data.instance.FlowEdgeInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowNodeBaseInstance;
import app.designer.data.instance.FlowSinkInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.HeaderInstance;
import app.designer.data.instance.PageCompositionInstance;
import app.designer.data.instance.PageFragmentHolderInstance;
import app.designer.data.instance.PageFragmentInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;
import app.designer.data.instance.SubFlowInstance;
import app.designer.data.instance.TextInstance;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class CodeGenerator {

	private static Configuration freemarkerConfig;
	private static Template entityTemplate;
	private static Template instanceTemplate;
	private static Template applicationTemplate;
	private static Template flowTemplate;
	private static Template pageTemplate;
	private static Template subFlowTemplate;
	private static File applicationsRoot = new File(Play.applicationPath, "app/app");
	
	static {
		freemarkerConfig = new Configuration();
		freemarkerConfig.setClassForTemplateLoading(CodeGenerator.class, "template/");
		freemarkerConfig.setObjectWrapper(new DefaultObjectWrapper());
		try {
			entityTemplate = freemarkerConfig.getTemplate("Entity.java.ftl");
			instanceTemplate = freemarkerConfig.getTemplate("Instance.java.ftl");
			applicationTemplate = freemarkerConfig.getTemplate("Application.java.ftl");
			flowTemplate = freemarkerConfig.getTemplate("Flow.java.ftl");
			pageTemplate = freemarkerConfig.getTemplate("Page.java.ftl");
			subFlowTemplate = freemarkerConfig.getTemplate("SubFlow.java.ftl");
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
		ApplicationClassModel applicationClassModel = createApplicationClassModel(application, appname);
		applicationRoot.mkdirs();
		generateFile(applicationTemplate, applicationClassModel, null, application.name.get(), "Application", appname, applicationRoot);
	}

	private static void generateFlow(FlowInstance flow, String appname, File applicationRoot) {
		FlowClassModel flowClassModel = createFlowClassModel(flow, appname);
		generateFile(flowTemplate, flowClassModel, "flow", flow.name.get(), "Flow", appname, applicationRoot);
		String flowName = flow.name.get();
		for (FlowNodeBaseInstance node: flow.nodes.get()) {
			if (node instanceof PageInstance) {
				PageInstance page = (PageInstance)node;
				PageClassModel pageClassModel = createPageClassModel(page, appname, flowName);
				generateFile(pageTemplate, pageClassModel, "flow/"+flowName.toLowerCase(), page.name.get(), "Page", appname, applicationRoot);
			} else if (node instanceof SubFlowInstance) {
				SubFlowInstance subFlow = (SubFlowInstance)node;
				SubFlowClassModel subFlowClassModel = createSubFlowClassModel(subFlow, appname, flowName);
				generateFile(subFlowTemplate, subFlowClassModel, "flow/"+flowName.toLowerCase(), subFlow.name.get(), "SubFlow", appname, applicationRoot);
			}
		}
	}
	
	private static SubFlowClassModel createSubFlowClassModel(
			SubFlowInstance subFlow, String appname, String flowName) {
		SubFlowClassModel result = new SubFlowClassModel();
		result.appname = appname;
		result.name = subFlow.name.get();
		result.flowname = flowName;
		result.subFlowName = subFlow.flow.get().name.get();
		return result;
	}

	private static PageClassModel createPageClassModel(PageInstance page, String appname, String flowName) {
		PageClassModel result = new PageClassModel();
		result.appname = appname;
		result.flowname = flowName;
		result.name = page.name.get();
		result.customization = page.customization.get();
		result.content = createContentClassModel(page.content.get());
		return result;
	}

	private static ContentClassModel createContentClassModel(PageFragmentInstance fragment) {
		ContentClassModel result = new ContentClassModel();
		result.type=fragment.getModel().getName();
		if (fragment instanceof FieldInstance) {
			FieldInstance field = (FieldInstance) fragment;
			result.required = (field.required.get()== Boolean.TRUE);
			result.entity = field.attribute.get().entity.get().name.get();
			result.attribute = field.attribute.get().name.get();
			result.readOnly = (field.readOnly.get()==Boolean.TRUE);
		} else if (fragment instanceof ConstantTextInstance) {
			result.text = generateText((ConstantTextInstance)fragment);
		} else if (fragment instanceof ButtonInstance) {
			result.text = generateText(((ButtonInstance)fragment).caption.get());
			result.trigger = ((ButtonInstance)fragment).trigger.get();
		} else if (fragment instanceof CompositePageFragmentInstance) {
			for (PageCompositionInstance composition : ((CompositePageFragmentInstance)fragment).items.get()) {
				result.children.add(createContentClassModel(composition.pageFragment.get()));
			}
			if (fragment instanceof HeaderInstance) {
				result.text = generateText(((HeaderInstance)fragment).text.get());
			}
			if (fragment instanceof SelectInstance) {
				SelectInstance selectFragment = (SelectInstance)fragment;
				result.relationEntity = selectFragment.relation.get().entity.get().name.get();
				result.relationName = selectFragment.relation.get().name.get();
			}
		}
		return result;
	}

	private static FlowClassModel createFlowClassModel(FlowInstance flow, String appname) {
		FlowClassModel result = new FlowClassModel();
		result.customization = flow.customization.get();
		result.appname = appname;
		result.name = flow.name.get();
		for (FlowNodeBaseInstance source: flow.sources.get()) {
			result.sources.add(source.name.get());
		}
		for (FlowNodeBaseInstance sink: flow.sinks.get()) {
			result.sinks.add(sink.name.get());
		}
		for (FlowNodeBaseInstance nodeInstance: flow.nodes.get()) {
			FlowNode node = new FlowNode();
			node.name = nodeInstance.name.get();
			node.type = nodeInstance.getModel().getName();
			result.nodes.add(node);
		}
		for (FlowEdgeInstance edgeInstance: flow.edges.get()) {
			FlowEdge edge = new FlowEdge();
			edge.from = edgePoint(edgeInstance.from.get());
			edge.entryName = edgeInstance.entryName.get();
			edge.to = edgePoint(edgeInstance.to.get());
			edge.exitName = edgeInstance.exitName.get();
			result.edges.add(edge);
		}
		for (EntityInstance selectInstance: flow.parameters.get()) {
			result.parameters.add(selectInstance.name.get());
		}
		return result;
	}

	private static String edgePoint(FlowNodeBaseInstance flowNodeBaseInstance) {
		String name = flowNodeBaseInstance.name.get();
		if (flowNodeBaseInstance instanceof FlowSourceInstance || flowNodeBaseInstance instanceof FlowSinkInstance) {
			return name.toUpperCase();
		}
		String typeName = flowNodeBaseInstance.getModel().getName();
		return name+typeName+".INSTANCE";
	}

	private static EntityClassModel createEntityClassModel(EntityInstance entity, String appname) {
		EntityClassModel result = new EntityClassModel();
		result.appname=appname;
		result.name=entity.name.get();
		result.caseEntity = (entity.caseEntityInApplication.get()!=null);
		result.applicationName = entity.application.get().name.get();
		if (entity.extendsFrom.get()!=null) {
			result.extendsFrom = entity.extendsFrom.get().name.get();
		}
		for (AttributeInstance attributeInstance: entity.attributes.get()) {
			Attribute attribute = new Attribute();
			attribute.name = attributeInstance.name.get();
			attribute.itemClassName = attributeInstance.className.get();
			attribute.multivalue = (attributeInstance.multivalue.get()==Boolean.TRUE);
			if (attribute.multivalue) {
				attribute.className="List<"+attribute.itemClassName+">";
			} else {
				attribute.className=attribute.itemClassName;
			}
			attribute.readonly = (attributeInstance.readOnly.get()==Boolean.TRUE);
			TextInstance question = attributeInstance.question.get();
			if (question!=null) {
				attribute.question = generateText(question);
			}
			TextInstance explanation = attributeInstance.explanation.get();
			if (explanation!=null) {
				attribute.explanation = generateText(explanation);
			}
			List<DomainEntryInstance> domain = attributeInstance.domain.get();
			if (domain.size()>0) {
				attribute.domain = generateDomain(domain);
			}
			result.attributes.add(attribute);
		}
		for (RelationInstance relationInstance: entity.relations.get()) {
			Relation relation = new Relation();
			relation.name = relationInstance.name.get();
			relation.multivalue = (relationInstance.multivalue.get()==Boolean.TRUE);
			relation.readonly = (relationInstance.readOnly.get()==Boolean.TRUE);
			relation.owner = (relationInstance.owner.get()==Boolean.TRUE);
			relation.autoCreate = (relationInstance.autoCreate.get()==Boolean.TRUE);
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

	private static List<DomainEntry> generateDomain(List<DomainEntryInstance> domain) {
		List<DomainEntry> result = new ArrayList<DomainEntry>();
		for (DomainEntryInstance entry: domain) {
			DomainEntry resultEntry = new DomainEntry();
			resultEntry.name = entry.name.get();
			resultEntry.display = generateText(entry.display.get());
			result.add(resultEntry);
		}
		return result;
	}

	private static TextClassModel generateText(TextInstance text) {
		if (text instanceof ConstantTextInstance) {
			ConstantTextInstance constantText = (ConstantTextInstance) text;
			return new TextClassModel(constantText.untranslated.get());
		}
		throw new RuntimeException("Unsupported subclass of TextInstance: "+text.getClass());
	}

	private static ApplicationClassModel createApplicationClassModel(ApplicationInstance application, String appname) {
		ApplicationClassModel result = new ApplicationClassModel();
		for (EntityInstance entity: application.entities.get()) {
			result.entities.add(entity.name.get());
		}
		result.appname = appname;
		result.name = application.name.get();
		result.customization = application.customization.get();
		result.caseEntity = application.caseEntity.get().name.get();
		for (FlowInstance exposed: application.exposedFlows.get()) {
			result.exposedFlows.add(exposed.name.get());
		}
		return result;
	}
	
	public static void generateApplication(ApplicationInstance applicationInstance) {
		String appname = applicationInstance.name.get().toLowerCase();
		File applicationRoot = new File(applicationsRoot, appname);
		
		generateApplication(applicationInstance, appname, applicationRoot);
		for (EntityInstance entity: applicationInstance.entities.get()) {
			generateEntity(entity, appname, applicationRoot);
		}
		for (PageFragmentHolderInstance pageFragment: applicationInstance.shared.get().pageFragments.get()) {
//TODO:			generatePageFragment(pageFragment, appname, applicationRoot);
		}
		// TODO: textHolder
		for (FlowInstance flow: applicationInstance.flows.get()) {
			generateFlow(flow, appname, applicationRoot);
		}
		
		new File(applicationRoot, "flow").mkdirs();
	}

	private static void generateFile(Template template, Object rootMap, String subDirectory, 
			String name, String postfix, String appname, File root) {
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
}

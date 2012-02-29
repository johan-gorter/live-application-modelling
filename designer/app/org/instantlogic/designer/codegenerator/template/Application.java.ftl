package ${rootPackageName};

import java.util.*;

import ${rootPackageName}.entity.*;
import ${rootPackageName}.*;
import ${rootPackageName}.flow.*;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.Entity;
import lbe.model.flow.Flow;

public<#if isCustomized> abstract</#if> class <#if isCustomized>Abstract</#if>${name}Application extends Application {

	public static final ${name}Application INSTANCE = new ${name}Application();
	
	protected ${name}Application() {
	}
	
	@Override
	public Entity getCaseModel() {
		return ${caseEntity}Entity.INSTANCE;
	}
	
	private static final Flow[] exposedFlows = new Flow[] {
	<#list exposedFlows as exposedFlow>
		${exposedFlow}Flow.INSTANCE,
	</#list>
	};

	@Override
	public Flow[] getExposedFlows() {
		return exposedFlows;
	}
	
	private static final Entity[] entities = new Entity[] {
	<#list entities as entity>
		${entity}Entity.INSTANCE,
	</#list>
	};
	private static final SortedMap<String, Entity> entityMap = new TreeMap<String, Entity>();
	static {
		for (Entity entity:entities) {
			entityMap.put(entity.getName(), entity);
		}
	}
	@Override
	public SortedMap<String, Entity> getEntities() {
		return entityMap;
	}
	
	
	@Override
	public Class<? extends CaseInstance> getCaseInstanceClass() {
		<#if caseInstanceCustomization??>
		return ${caseInstanceCustomization}.class;
		<#else>
		return ${caseEntity}.class;
		</#if>
	}

	@Override
	public String getName() {
		return "${name}";
	}
}
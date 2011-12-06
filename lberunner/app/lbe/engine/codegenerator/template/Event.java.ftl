package app.${appname}.event;

import app.${appname}.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import lbe.model.Entity;
import lbe.model.impl.SimpleFlowEvent;

public class ${name}Event extends SimpleFlowEvent {

	public static final ${name}Event INSTANCE = new <#if customization??>${customization}<#else>${name}Event</#if>();

	public ${name}Event() {
		super("${name}", new Entity[]{
<#list parameters as parameter>
			${parameter}Entity.INSTANCE,
</#list>
		});
	}
}
package org.instantlogic.interaction.page;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.DomainEntry;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.page.PageElement.Domain;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.FlowEventOccurrence;
import org.instantlogic.interaction.util.RenderContext;

public abstract class Field extends PlaceFragmentTemplate {
	
	public Field() {}
	
	@Override
	public String getName() {
		return getAttribute().getName()+":"+this.datatypeToString(getAttribute().getDatatype());
	}
	
//	@Override
//	public String getElementType() {
//		return "field";
//	}
//	
//	@Override
//	public PageElement render(RenderContext context) {
//		PageElement result = super.render(context);
//		Attribute attribute = getAttribute();
//		Object value = context.getValue(getEntity(), attribute);
//		if (attribute.isMultivalue() && value==null) {
//			value = new String[0];
//		}
//		result.datatype = datatypeToString(attribute.getDatatype());
//		result.id = result.id;
//		result.value = value;
//		result.required = isRequired();
//		result.refresh = true;
//		Text question = getQuestion();
//		if (question!=null) {
//			result.question = question.renderText(context);
//		}
//		Text explain = getExplain();
//		if (explain!=null) {
//			result.explain = explain.renderText(context);
//		}
//		result.multivalue = attribute.isMultivalue()?Boolean.TRUE:null;
//		DomainEntry[] domain = attribute.getDomain();
//		if (domain!=null) {
//			result.domain = convertDomain(domain, context);
//		}
//		return result;
//	}
	
	private Domain[] convertDomain(DomainEntry[] domain, RenderContext context) {
		Domain[] result = new Domain[domain.length];
		for (int i=0;i<domain.length;i++) {
			result[i]=new Domain(domain[i].getValue(), domain[i].getDisplay().renderText(context));
		}
		return result;
	}

	private String datatypeToString(Class datatype) {
		if (datatype==String.class) {
			return "text";
		}
		if (datatype==Double.class) {
			return "number";
		}
		if (Instance.class.isAssignableFrom(datatype)) {
			return "entity";
		}
		return datatype.getSimpleName().toLowerCase();
	}

	@Override
	public FlowEventOccurrence submit(ChangeContext changeContext) {
		String id = getName()+"@"+changeContext.nextId();
		
		for (ChangeContext.FieldChange fieldChange: changeContext.getFieldChanges()) {
			if (fieldChange.getPageElementId().equals(id))
			changeContext.setValue(getEntity(), getAttribute(), fieldChange.getValue());
		}
		return null;
	}

	/**
	 * @return the entity that contains the attribute from getAttribute() or one of its subclasses.
	 */
	public abstract Entity getEntity();
	
	public abstract Attribute getAttribute();
	
	public abstract boolean isRequired();

	public abstract boolean isReadOnly();
	
	private Text getExplain() {
		return getAttribute().getExplain();
	}

	protected Text getQuestion() {
		return getAttribute().getQuestion();
	}
}

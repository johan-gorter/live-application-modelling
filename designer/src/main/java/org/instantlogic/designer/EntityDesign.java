package org.instantlogic.designer;

import java.util.Iterator;



public class EntityDesign extends AbstractEntityDesign { 

	public enum RelationType {
		OneToZeroOrOne, 
		OneToZeroOrOneAggregation, 
		OneToOneAggregation, 
		OneToMany, 
		OneToManyAggregation, 
		ManyToZeroOrOne, 
		ManyToMany
	}
	
	public EntityDesign() {}
	
	public EntityDesign(String name) {
		setName(name);
	}
	
	protected static AttributeDesign addAttribute(EntityDesign from, String name, Class<?> type) {
		return from.addAttribute(name,  type);
	}

	protected static AttributeDesign addAttribute(EntityDesign from, String name, DataCategoryDesign dataCategory) {
		return from.addAttribute(name, dataCategory);
	}
	
	protected static AttributeDesign addAttribute(EntityDesign from, String name, String className) {
		return from.addAttribute(name, className);
	}
	
	protected static RelationDesign addRelation(EntityDesign from, String name, RelationType relationType, EntityDesign to) {
		return from.addRelation(name, relationType, to);
	}

	public AttributeDesign addAttribute(String name, Class<?> type) {
		return addAttribute(name, type.getName());
	}

	public AttributeDesign addAttribute(String name, String className) {
		AttributeDesign result = new AttributeDesign();
		result.setName(name);
		result.getDataType().setJavaClassName(className);
		addToAttributes(result);
		return result;
	}

	public AttributeDesign addAttribute(String name, DataCategoryDesign dataCategory) {
		AttributeDesign result = new AttributeDesign();
		result.setName(name);
		result.getDataType().setDataCategory(dataCategory);
		addToAttributes(result);
		return result;
	}
	
	public RelationDesign addRelation(String name, RelationType relationType, EntityDesign to) {
		RelationDesign relation = new RelationDesign();
		addToRelations(relation);
		relation.setTo(to);
		relation.setName(name);
		relation.setOwner(relationType==RelationType.OneToManyAggregation || relationType==RelationType.OneToZeroOrOneAggregation || relationType==RelationType.OneToOneAggregation);
		relation.setAutoCreate(relationType==RelationType.OneToOneAggregation);
		relation.getDataType().setMultivalue(relationType==RelationType.OneToMany || relationType==RelationType.OneToManyAggregation || relationType==RelationType.ManyToMany);
		relation.setReverseMultivalue(relationType==RelationType.ManyToMany || relationType==RelationType.ManyToZeroOrOne);
		return relation;
	}
	
	public DeductionSchemeDesign newValidation(String uniqueId, String message, AttributeDesign... displayWith) {
		ValidationDesign validation = new ValidationDesign();
		validation.getMetadata().initUniqueId(uniqueId);
		addToValidations(validation);
		validation.setMessage(createConstantText(message));
		for (AttributeDesign attribute : displayWith) {
			validation.addToDisplayWith(attribute);
		}
		return validation.newRule();
	}
	
	public ValidationDesign newValidation(String uniqueId, AttributeDesign... displayWith) {
		ValidationDesign validation = new ValidationDesign();
		validation.getMetadata().initUniqueId(uniqueId);
		addToValidations(validation);
		for (AttributeDesign attribute : displayWith) {
			validation.addToDisplayWith(attribute);
		}
		return validation;
	}
	
	public Iterable<AttributeDesign> getAttributesAndRelations() {
		return new Iterable<AttributeDesign>() {
			
			@Override
			public Iterator<AttributeDesign> iterator() {
				return new Iterator<AttributeDesign>() {
					
					final Iterator<AttributeDesign> attributes = getAttributes().iterator();
					final Iterator<RelationDesign> relations = getRelations().iterator();

					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
					
					@Override
					public AttributeDesign next() {
						if(attributes.hasNext()) {
							return attributes.next();
						}
						return relations.next();
					}
					
					@Override
					public boolean hasNext() {
						return attributes.hasNext()||relations.hasNext();
					}
				};
			}
		};
	}
	
	public void registerApplication(ApplicationDesign application) {
		if (application.getEntities().contains(this)) return;
		application.addToEntities(this);
		if (this.getExtendsFrom()!=null) {
			this.getExtendsFrom().registerApplication(application);
		}
		for(EntityDesign entity: this.getExtensions()) {
			entity.registerApplication(application);
		}
		for (RelationDesign relation: getRelations()) {
			relation.getTo().registerApplication(application);
		}
	}
	
	/**
	 * Will be called once for every entity from ApplicationDesign.init
	 */
	public void init() {
	}
}

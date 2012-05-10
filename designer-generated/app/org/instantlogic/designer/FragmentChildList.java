package org.instantlogic.designer;


public class FragmentChildList extends Design { 

	@Override
	public org.instantlogic.fabric.model.Entity getInstanceEntity() {
		return org.instantlogic.designer.entity.FragmentChildListEntity.INSTANCE;
	}

	// Attributes
	
	// Relations
	
	private final org.instantlogic.fabric.value.RelationValues<FragmentChildList, FragmentTemplateDesign> children
		= createRelationValues(org.instantlogic.designer.entity.FragmentChildListEntity.children);
		
	public org.instantlogic.fabric.value.RelationValues<FragmentChildList, FragmentTemplateDesign> getChildrenRelationValue() {
		return children;
	}

	public org.instantlogic.fabric.value.Multi<org.instantlogic.designer.FragmentTemplateDesign> getChildren() {
		return children.getValue();
	}
	
	public FragmentChildList addToChildren(FragmentTemplateDesign item) {
		children.addValue(item);
		return (FragmentChildList)this;
	}
	
	public FragmentChildList addToChildren(FragmentTemplateDesign item, int index) {
		children.insertValue(item, index);
		return (FragmentChildList)this;
	}
	
	public FragmentChildList removeFromChildren(FragmentTemplateDesign item) {
		children.removeValue(item);
		return (FragmentChildList)this;
	}
	
	public FragmentChildList removeFromChildren(int index) {
		children.removeValue(index);
		return (FragmentChildList)this;
	}
	

	// Reverse relations
	
	private final org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentChildList, FragmentTemplateDesign> fragment
		= createReverseRelationValue(org.instantlogic.designer.entity.FragmentChildListEntity.fragment);

	public org.instantlogic.fabric.value.ReadOnlyRelationValue<FragmentChildList, FragmentTemplateDesign> getFragmentRelationValue() {
		return fragment;
	}

	public org.instantlogic.designer.FragmentTemplateDesign getFragment() {
		return fragment.getValue();
	}


}

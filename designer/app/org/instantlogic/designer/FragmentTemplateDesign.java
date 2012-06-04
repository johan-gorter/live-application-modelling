package org.instantlogic.designer;

public class FragmentTemplateDesign extends AbstractFragmentTemplateDesign {

	public FragmentTemplateDesign() {
	}

	public FragmentTemplateDesign(String fragmentTypeName) {
		setFragmentTypeName(fragmentTypeName);
	}
	
	
	public FragmentTemplateDesign setText(String propertyName, TextDesign text) {
		FragmentText fragmentText = new FragmentText();
		fragmentText.setName(propertyName);
		fragmentText.setText(text);
		addToTexts(fragmentText);
		return this;
	}
	
	public FragmentTemplateDesign setChildren(String propertyName, FragmentTemplateDesign... children) {
		FragmentChildList childList= new FragmentChildList();
		childList.setName(propertyName);
		for (FragmentTemplateDesign child: children) {
			childList.addToChildren(child);
		}
		addToChildLists(childList);
		return this;
	}
	
	public FragmentTemplateDesign setValue(String propertyName, DeductionSchemeDesign value) {
		FragmentValue fragmentValue = new FragmentValue();
		fragmentValue.setName(propertyName);
		fragmentValue.setDeduction(value);
		addToValues(fragmentValue);
		return this;
	}
}

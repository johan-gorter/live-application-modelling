package org.instantlogic.designer.deduction;

import java.math.BigDecimal;
import java.util.Date;

import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.entity.AttributeDesignEntity;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class AttributeJavaClassNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		AttributeDesign attribute = context.getSelectedInstance(AttributeDesignEntity.INSTANCE);
		Class<?> result = determineJavaClass(attribute);
		if (result==null) return ValueAndLevel.inconclusive();
		return ValueAndLevel.deduced(result.getName());
	}

	private Class<?> determineJavaClass(AttributeDesign attribute) {
		DataCategoryDesign dataCategory = attribute.getDataCategory();
		if (dataCategory == DataCategoryDesignEntity.INSTANCE._boolean) {
			return Boolean.class;
		}
		if (dataCategory == DataCategoryDesignEntity.INSTANCE.dateTime) {
			return Date.class;
		}
		if (dataCategory == DataCategoryDesignEntity.INSTANCE.text) {
			return String.class;
		}
		if (dataCategory == DataCategoryDesignEntity.INSTANCE.number) {
			if (attribute.getWholeNumber()==Boolean.TRUE) return Integer.class;
			if (attribute.getExactRounding()==Boolean.TRUE) return BigDecimal.class;
			return Double.class;
		}
		return null;
	}
	
}

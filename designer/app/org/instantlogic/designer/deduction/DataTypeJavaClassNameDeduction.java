package org.instantlogic.designer.deduction;

import java.math.BigDecimal;
import java.util.Date;

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeJavaClassNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		Class<?> result = determinePrimitiveJavaClass(dataType);
		if (result!=null) {
			return ValueAndLevel.deduced(result.getName());
		}
		if (dataType.getDataCategory() == DataCategoryDesignEntity.INSTANCE.entity) {
			return ValueAndLevel.deduced(dataType.getEntity().getApplication().getRootPackageName()+"."+dataType.getEntity().getTechnicalNameCapitalized());
		}
		return ValueAndLevel.inconclusive();
	}

	private Class<?> determinePrimitiveJavaClass(DataTypeDesign type) {
		DataCategoryDesign dataCategory = type.getDataCategory();
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
			if (type.getWholeNumber()==Boolean.TRUE) return Integer.class;
			if (type.getExactRounding()==Boolean.TRUE) return BigDecimal.class;
			return Double.class;
		}
		return null;
	}
	
}

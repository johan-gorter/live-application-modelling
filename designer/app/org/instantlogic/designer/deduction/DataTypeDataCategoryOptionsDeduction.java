package org.instantlogic.designer.deduction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.instantlogic.designer.DataCategoryDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataCategoryDesignEntity;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;
import org.instantlogic.fabric.value.Multi;

public class DataTypeDataCategoryOptionsDeduction extends Deduction<Multi<DataCategoryDesign>>{

	private static final List<DataCategoryDesign> ATTRIBUTE_OPTIONS = Arrays.asList(new DataCategoryDesign[]{
		DataCategoryDesignEntity.INSTANCE.text, DataCategoryDesignEntity.INSTANCE.number, DataCategoryDesignEntity.INSTANCE.dateTime, 
		DataCategoryDesignEntity.INSTANCE._boolean, DataCategoryDesignEntity.INSTANCE.custom}); 
	
	@Override
	public ValueAndLevel<Multi<DataCategoryDesign>> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.deduced(new Multi<DataCategoryDesign>(Collections.singletonList(DataCategoryDesignEntity.INSTANCE.entity)));
		}
		return ValueAndLevel.deduced(new Multi<DataCategoryDesign>(ATTRIBUTE_OPTIONS));
	}
}

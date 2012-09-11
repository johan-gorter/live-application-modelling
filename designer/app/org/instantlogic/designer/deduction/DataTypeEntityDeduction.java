package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeEntityDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		// TODO: Get attribute, instanceof Relation ...
		return ValueAndLevel.missing();
	}

}

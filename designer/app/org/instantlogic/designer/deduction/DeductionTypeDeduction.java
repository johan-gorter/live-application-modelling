package org.instantlogic.designer.deduction;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.entity.DeductionDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DeductionTypeDeduction extends Deduction<DataTypeDesign> {

	@Override
	public ValueAndLevel<DataTypeDesign> deduct(DeductionContext context) {
		DeductionDesign deductionDesign = context.getSelectedInstance(DeductionDesignEntity.INSTANCE);
		if (deductionDesign instanceof AttributeDeductionDesign) {
			return ValueAndLevel.deduced(((AttributeDeductionDesign)deductionDesign).getAttribute().getDataType());
		}
		return ValueAndLevel.inconclusive();
	}
}

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.DataTypeDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.entity.DataTypeDesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class DataTypeEntityDeduction extends Deduction<EntityDesign> {

	@Override
	public ValueAndLevel<EntityDesign> deduct(DeductionContext context) {
		DataTypeDesign dataType = context.getSelectedInstance(DataTypeDesignEntity.INSTANCE);
		if (dataType.getAttribute()!=null && dataType.getAttribute() instanceof RelationDesign) {
			return ValueAndLevel.deduced(((RelationDesign)dataType.getAttribute()).getTo());
		}
		if (dataType.getReverseRelation()!=null) {
			return ValueAndLevel.deduced(dataType.getReverseRelation().getFrom());
		}
		if (dataType.getForEntity()!=null) {
			return ValueAndLevel.deduced(dataType.getForEntity());
		}
		if (dataType.getConstantDeductionDesign()!=null) {
			Object value = dataType.getConstantDeductionDesign().getValue();
			if (value instanceof EntityDesign) {
				return ValueAndLevel.deduced((EntityDesign)value);
			}
		}
		return ValueAndLevel.missing();
	}

}

package org.instantlogic.designer.deduction;

import org.instantlogic.designer.Design;
import org.instantlogic.designer.entity.DesignEntity;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.DeductionContext;
import org.instantlogic.fabric.util.ValueAndLevel;

public class TechnicalNameDeduction extends Deduction<String> {

	@Override
	public ValueAndLevel<String> deduct(DeductionContext context) {
		Design design = context.getSelectedInstance(DesignEntity.INSTANCE);
		StringBuilder sb = new StringBuilder(design.getName());
		if (sb.length()==0) {
			return ValueAndLevel.deduced("_");
		}
		boolean nextLetterToUppercase = false;
		for (int i=0;i<sb.length();) {
			char ch = sb.charAt(i);
			if (!Character.isLetterOrDigit(ch) && ch!='_') {
				sb.delete(i, i);
				nextLetterToUppercase = true;
				continue;
			}
			if (nextLetterToUppercase && Character.isLetter(ch)) {
				nextLetterToUppercase = false;
				sb.setCharAt(i, Character.toUpperCase(ch));
			}
			if (i==0 && Character.isDigit(ch)) {
				sb.insert(0, '_');
				i++;
			}
			i++;
		}
		return ValueAndLevel.deduced(sb.toString());
	}

}

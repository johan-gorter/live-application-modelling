package org.instantlogic.designer.codegenerator.generator;


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;
import org.instantlogic.designer.codegenerator.classmodel.DeductionModel;
import org.instantlogic.designer.codegenerator.classmodel.DeductionSchemeModel;

public class DeductionSchemeGenerator {
	
	public static DeductionSchemeModel generate(String rootPackageName, DeductionSchemeDesign deductionSchemeDesign) {
		List<DeductionDesign> deductionDesigns = new ArrayList<DeductionDesign>();
		fillDeductions(deductionSchemeDesign.getOutput(), deductionDesigns);
		int deductionIndex = 0;
		DeductionSchemeModel model = new DeductionSchemeModel();
		for (DeductionDesign deduction : deductionDesigns) {
			DeductionModel classModel = new DeductionModel();
			classModel.index = deductionIndex++;
			classModel.type = deduction.getInstanceEntity().getName();
			classModel.type = "org.instantlogic.fabric.deduction."+classModel.type.substring(0, classModel.type.length()-6); // leave Design suffix off
			classModel.customization = deduction.getCustomization();
			if (deduction.getClassName()==null) {
				throw new RuntimeException("Resulting classname was not specified for deduction "+deduction);
			}
			classModel.resultType = deduction.getClassName();
			if (deduction instanceof SelectedInstanceDeductionDesign) {
				String name = ((SelectedInstanceDeductionDesign)deduction).getOfEntity().getName();
				classModel.parameters.add(rootPackageName+".entity."+name+"Entity.INSTANCE");
			} else if (deduction instanceof AttributeDeductionDesign) {
				AttributeDesign attribute = ((AttributeDeductionDesign)deduction).getAttribute(); 
				String name = attribute.getName();
				String entityName = (attribute instanceof RelationDesign)?((RelationDesign)attribute).getFrom().getName():attribute.getBelongsToEntity().getName();
				classModel.parameters.add(rootPackageName+".entity."+entityName+"Entity."+name);
			} else if (deduction instanceof ReverseRelationDeductionDesign) {
				RelationDesign relation = ((ReverseRelationDeductionDesign)deduction).getRelation(); 
				String name = relation.getName();
				String entityName = relation.getFrom().getName();
				classModel.parameters.add(rootPackageName+".entity."+entityName+"Entity."+name);
			} else if (deduction instanceof CastInstanceDeductionDesign) {
				String name = ((CastInstanceDeductionDesign)deduction).getToEntity().getName();
				classModel.parameters.add(rootPackageName+".entity."+name+"Entity.INSTANCE");
			}
			for (DeductionDesign input : deduction.getInputs()) {
				classModel.parameters.add("d"+deductionDesigns.indexOf(input));
			}
			model.deductions.add(classModel);
		}
		return model;
	}

	private static void fillDeductions(DeductionDesign fromOutput, List<DeductionDesign> deductionDesigns) {
		if (deductionDesigns.contains(fromOutput)) return;
		for (DeductionDesign input: fromOutput.getInputs()) {
			fillDeductions(input, deductionDesigns);
		}
		if (deductionDesigns.contains(fromOutput)) return;
		deductionDesigns.add(fromOutput);
	}
}

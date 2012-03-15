package org.instantlogic.designer.codegenerator;


import java.util.ArrayList;
import java.util.List;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDeductionDesign;
import org.instantlogic.designer.ReverseRelationDeductionDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CastInstanceDeductionDesign;
import org.instantlogic.designer.DeductionDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectedInstanceDeductionDesign;

public class DeductionSchemeGenerator {
	
	public static class DeductionClassModel {
		public int index;
		public String type;
		public String resultType;
		public String customization;
		public List<String> parameters = new ArrayList<String>();
		
		public int getIndex() {
			return index;
		}
		public String getType() {
			return type;
		}
		public String getResultType() {
			return resultType;
		}
		public List<String> getParameters() {
			return parameters;
		}
		public String getCustomization() {
			return customization;
		}
	}
	
	private int index;
	
	private List<DeductionDesign> deductionDesigns = new ArrayList<DeductionDesign>();
	private List<DeductionClassModel> deductions = new ArrayList<DeductionClassModel>();
	
	public DeductionSchemeGenerator(String rootPackageName, DeductionSchemeDesign deductionSchemeDesign, int index) {
		fillDeductions(deductionSchemeDesign.getOutput());
		int deductionIndex = 0;
		for (DeductionDesign deduction : deductionDesigns) {
			DeductionClassModel classModel = new DeductionClassModel();
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
			deductions.add(classModel);
		}
		this.index = index;
	}

	private void fillDeductions(DeductionDesign fromOutput) {
		if (deductionDesigns.contains(fromOutput)) return;
		for (DeductionDesign input: fromOutput.getInputs()) {
			fillDeductions(input);
		}
		if (deductionDesigns.contains(fromOutput)) return;
		deductionDesigns.add(fromOutput);
	}

	public int getIndex() {
		return index;
	}

	public List<DeductionClassModel> getDeductions() {
		return deductions;
	}
	
	public int getLastDeductionIndex() {
		return deductions.size()-1;
	}

	public String getLastResultType() {
		return deductions.get(deductions.size()-1).resultType;
	}

}

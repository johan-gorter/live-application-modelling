package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.AttributeDeductionDesign;
import app.designer.AttributeDesign;
import app.designer.CastInstanceDeductionDesign;
import app.designer.DeductionDesign;
import app.designer.DeductionSchemeDesign;
import app.designer.RelationDesign;
import app.designer.SelectedInstanceDeductionDesign;

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
	
	public DeductionSchemeGenerator(DeductionSchemeDesign deductionSchemeDesign, int index) {
		fillDeductions(deductionSchemeDesign.getOutput());
		int deductionIndex = 0;
		for (DeductionDesign design : deductionDesigns) {
			DeductionClassModel classModel = new DeductionClassModel();
			classModel.index = deductionIndex++;
			classModel.type = design.getModel().getName();
			classModel.type = classModel.type.substring(0, classModel.type.length()-6);
			classModel.customization = design.getCustomization();
			classModel.resultType = design.getClassName();
			if (design instanceof SelectedInstanceDeductionDesign) {
				String name = ((SelectedInstanceDeductionDesign)design).getInstanceEntity().getName();
				classModel.parameters.add(name+"Entity.INSTANCE");
			} else if (design instanceof AttributeDeductionDesign) {
				AttributeDesign attribute = ((AttributeDeductionDesign)design).getAttribute(); 
				String name = attribute.getName();
				String entityName = (attribute instanceof RelationDesign)?((RelationDesign)attribute).getFrom().getName():attribute.getInstanceEntity().getName();
				classModel.parameters.add(entityName+"Entity."+name);
			} else if (design instanceof CastInstanceDeductionDesign) {
				String name = ((CastInstanceDeductionDesign)design).getInstanceEntity().getName();
				classModel.parameters.add(name+"Entity.INSTANCE");
			}
			for (DeductionDesign input : design.getInputs()) {
				classModel.parameters.add("d"+deductionDesigns.indexOf(input));
			}
			deductions.add(classModel);
		}
		this.index = index;
	}

	private void fillDeductions(DeductionDesign fromOutput) {
		if (deductionDesigns.contains(fromOutput)) return;
		for (DeductionDesign input: fromOutput.inputs.get()) {
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

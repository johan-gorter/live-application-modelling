package org.instantlogic.designer.codegenerator.generator;


import org.instantlogic.designer.ConstantStringDesign;
import org.instantlogic.designer.ConstantTextDesign;
import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.FormattedValueDesign;
import org.instantlogic.designer.StringProducerDesign;
import org.instantlogic.designer.TemplatedTextDesign;
import org.instantlogic.designer.TextDesign;
import org.instantlogic.designer.codegenerator.classmodel.AbstractClassModel;
import org.instantlogic.designer.codegenerator.classmodel.TextModel;
import org.instantlogic.fabric.value.Multi;

public abstract class TextGenerator extends AbstractGenerator {

	public static TextModel generate(TextDesign text, AbstractClassModel deductionSchemeHolder) {
		TextModel model = new TextModel();
		if (text instanceof ConstantTextDesign) {
			model.type="constant";
			ConstantTextDesign constantText = (ConstantTextDesign) text;
			model.untranslatedConstant = constantText.getUntranslated();
		} else if (text instanceof TemplatedTextDesign) {
			model.type="templated";
			TemplatedTextDesign templatedText = (TemplatedTextDesign) text;
			Multi<StringProducerDesign> list = templatedText.getUntranslated();
			for (StringProducerDesign spInstance : list) {
				TextModel.StringProducer result = new TextModel.StringProducer();
				if (spInstance instanceof ConstantStringDesign) {
					result.type = "constant";
					result.constant = ((ConstantStringDesign)spInstance).getConstant();
				} else if (spInstance instanceof FormattedValueDesign) {
					result.type = "formattedValue";
					FormattedValueDesign fvInstance = (FormattedValueDesign)spInstance;
					DeductionSchemeDesign scheme = fvInstance.getDeduction();
					result.deductionIndex = deductionSchemeHolder.addDeductionScheme(DeductionSchemeGenerator.generate(deductionSchemeHolder.rootPackageName, scheme));
				}
				model.stringProducers.add(result);
			}
		} else throw new RuntimeException("Unsupported subclass of TextDesign: "+text.getClass());
		return model;
	}
}
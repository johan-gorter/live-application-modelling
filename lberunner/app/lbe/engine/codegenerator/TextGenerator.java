package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.AttributeDesign;
import app.designer.ConstantStringDesign;
import app.designer.ConstantTextDesign;
import app.designer.DeductionDesign;
import app.designer.DeductionSchemeDesign;
import app.designer.FormattedValueDesign;
import app.designer.StringProducerDesign;
import app.designer.TemplatedTextDesign;
import app.designer.TextDesign;

public class TextGenerator {

	public class StringProducer
	{
		public String type;
		public String constant;
		public int deductionIndex;
		
		public String getType() {
			return type;
		}
		public String getConstant() {
			return constant;
		}
		public int getDeductionIndex() {
			return deductionIndex;
		}
	}
	
	private AbstractGenerator deductionSchemeHolder;
	
	public String type;
	
	public String untranslatedConstant;
	
	public List<StringProducer> stringProducers = new ArrayList<StringProducer>();

	public TextGenerator(TextDesign text, AbstractGenerator deductionSchemeHolder)
	{
		this.deductionSchemeHolder = deductionSchemeHolder;
		if (text instanceof ConstantTextDesign) {
			type="constant";
			ConstantTextDesign constantText = (ConstantTextDesign) text;
			this.untranslatedConstant = constantText.untranslated.get();
		} else if (text instanceof TemplatedTextDesign) {
			type="templated";
			TemplatedTextDesign templatedText = (TemplatedTextDesign) text;
			List<StringProducerDesign> list = templatedText.untranslated.get();
			for (StringProducerDesign spInstance : list) {
				StringProducer result = new StringProducer();
				if (spInstance instanceof ConstantStringDesign) {
					result.type = "constant";
					result.constant = ((ConstantStringDesign)spInstance).getConstant();
				} else if (spInstance instanceof FormattedValueDesign) {
					result.type = "formattedValue";
					FormattedValueDesign fvInstance = (FormattedValueDesign)spInstance;
					DeductionSchemeDesign scheme = fvInstance.getDeduction();
					result.deductionIndex = deductionSchemeHolder.addDeductionScheme(scheme);
				}
				stringProducers.add(result);
			}
		} else throw new RuntimeException("Unsupported subclass of TextDesign: "+text.getClass());
	}

	public String getUntranslatedConstant() {
		return untranslatedConstant;
	}

	public String getType() {
		return type;
	}

	public List<StringProducer> getStringProducers() {
		return stringProducers;
	}
}

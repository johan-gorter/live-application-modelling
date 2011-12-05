package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.AttributeDesign;
import app.designer.ConstantStringDesign;
import app.designer.ConstantTextDesign;
import app.designer.FormattedValueDesign;
import app.designer.StringProducerDesign;
import app.designer.TemplatedTextDesign;
import app.designer.TextDesign;

public class TextGenerator {

	public class StringProducer
	{
		public String type;
		public String constant;
		public String entity;
		public String attribute;
		
		public String getType() {
			return type;
		}
		public String getConstant() {
			return constant;
		}
		public String getEntity() {
			return entity;
		}
		public String getAttribute() {
			return attribute;
		}
	}
	
	public String type;
	
	public String untranslatedConstant;
	
	public List<StringProducer> stringProducers = new ArrayList<StringProducer>();

	public TextGenerator(TextDesign text)
	{
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
					// Other types of deduction are not yet supported
					AttributeDesign attributeInstance = (AttributeDesign)fvInstance.value.get();
					result.entity = attributeInstance.entity.get().name.get();
					result.attribute = attributeInstance.name.get();
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

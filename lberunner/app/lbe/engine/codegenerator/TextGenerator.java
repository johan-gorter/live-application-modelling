package lbe.engine.codegenerator;

import java.util.ArrayList;
import java.util.List;

import app.designer.data.instance.AttributeBaseInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.ConstantStringInstance;
import app.designer.data.instance.ConstantTextInstance;
import app.designer.data.instance.FormattedValueInstance;
import app.designer.data.instance.StringProducerInstance;
import app.designer.data.instance.TemplatedTextInstance;
import app.designer.data.instance.TextInstance;

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

	public TextGenerator(TextInstance text)
	{
		if (text instanceof ConstantTextInstance) {
			type="constant";
			ConstantTextInstance constantText = (ConstantTextInstance) text;
			this.untranslatedConstant = constantText.untranslated.get();
		} else if (text instanceof TemplatedTextInstance) {
			type="templated";
			TemplatedTextInstance templatedText = (TemplatedTextInstance) text;
			List<StringProducerInstance> list = templatedText.untranslated.get();
			for (StringProducerInstance spInstance : list) {
				StringProducer result = new StringProducer();
				if (spInstance instanceof ConstantStringInstance) {
					result.type = "constant";
					result.constant = ((ConstantStringInstance)spInstance).getConstant();
				} else if (spInstance instanceof FormattedValueInstance) {
					result.type = "formattedValue";
					FormattedValueInstance fvInstance = (FormattedValueInstance)spInstance;
					// Other types of deduction are not yet supported
					AttributeInstance attributeInstance = (AttributeInstance)fvInstance.value.get();
					result.entity = attributeInstance.entity.get().name.get();
					result.attribute = attributeInstance.name.get();
				}
				stringProducers.add(result);
			}
		} else throw new RuntimeException("Unsupported subclass of TextInstance: "+text.getClass());
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

package org.instantlogic.designer.codegenerator.classmodel;

import java.util.ArrayList;
import java.util.List;

public class TextModel {

	public static class StringProducer
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
	
	public String type;
	
	public String untranslatedConstant;
	
	public final List<StringProducer> stringProducers = new ArrayList<StringProducer>();
	
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

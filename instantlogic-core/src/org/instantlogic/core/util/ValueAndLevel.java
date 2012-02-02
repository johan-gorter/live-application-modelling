package org.instantlogic.core.util;

public class ValueAndLevel<V extends Object> {
	
	private V value;
	private ValueLevel valueLevel;
	
	public static <V> ValueAndLevel<V> inconclusive() {
		return new ValueAndLevel<V>(null, ValueLevel.INCONCLUSIVE);
	}
	
	public static <V> ValueAndLevel<V> missing() {
		return new ValueAndLevel<V>(null, ValueLevel.MISSING);
	}
	
	public static <V> ValueAndLevel<V> irrelevant() {
		return new ValueAndLevel<V>(null, ValueLevel.IRRELEVANT);
	}
	
	public static <V> ValueAndLevel<V> deduced(V value) {
		if (value==null) throw new IllegalArgumentException("value");
		return new ValueAndLevel<V>(value, ValueLevel.DEDUCED);
	}
	
	public static <V> ValueAndLevel<V> stored(V value) {
		if (value==null) throw new IllegalArgumentException("value");
		return new ValueAndLevel<V>(value, ValueLevel.STORED);
	}
	
	private ValueAndLevel(V value, ValueLevel valueLevel) {
		this.value = value;
		this.valueLevel = valueLevel;
	}

	public V getValue() {
		return value;
	}

	public ValueLevel getValueLevel() {
		return valueLevel;
	}
	
	public boolean isConclusive() {
		return valueLevel!=ValueLevel.INCONCLUSIVE;
	}

	public boolean hasValue() {
		return value!=null;
	}
}

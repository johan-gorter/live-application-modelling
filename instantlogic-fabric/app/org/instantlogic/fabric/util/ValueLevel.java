package org.instantlogic.fabric.util;

/**
 * Provides meta-information about the value of an AttributeValue
 */
public enum ValueLevel {

	/**
	 * The value is null. The FirstDeduction will try the next deduction to deduce a value.
	 */
	INCONCLUSIVE,
	/**
	 * The value is null. FirstDeduction will not try the next deduction.
	 */
	MISSING,
	/**
	 * The value is null. This gives a hint to the user interface that this field should be hidden. FirstDeduction will not try the next deduction.
	 */
	IRRELEVANT,
	/**
	 * The value is not null. The value is the same as the value stored at this attribute.
	 */
	STORED,
	/**
	 * The value is not null. The value is determined by a deduction (business rule or default).
	 */
	DEDUCED
	
}

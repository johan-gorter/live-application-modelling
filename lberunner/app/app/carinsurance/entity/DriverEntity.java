package app.carinsurance.entity;

import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.DomainEntry;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleAttribute;
import org.instantlogic.core.model.impl.SimpleEntity;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.text.ConstantText;
import org.instantlogic.core.text.Text;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyAttributeValues;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.carinsurance.CarinsuranceCase;
import app.carinsurance.Driver;

public class DriverEntity extends SimpleEntity {

	public static final DriverEntity INSTANCE = new DriverEntity();
	
	// Attributes
	
	public static final Attribute<Driver, java.util.Date, java.util.Date> dateOfBirth 
		= new SimpleAttribute<Driver, java.util.Date, java.util.Date>(
			"dateOfBirth", INSTANCE, java.util.Date.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.util.Date> get(Driver instance) {
				return instance.dateOfBirth;
			}
			
			private final Text question = new ConstantText("Date of birth");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<Driver, List<java.lang.String>, java.lang.String> carUse 
		= new SimpleAttribute<Driver, List<java.lang.String>, java.lang.String>(
			"carUse", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValues<Driver, java.lang.String> get(Driver instance) {
				return instance.carUse;
			}
	
			public boolean isMultivalue() {
				return true;
			}
			
			private final Text question = new ConstantText("How will the car be used?");
			@Override
			public Text getQuestion() {
				return question;
			}
			
			private final DomainEntry[] domain = new DomainEntry[] {
				new DomainEntry("private", new ConstantText("Private")),
				new DomainEntry("business", new ConstantText("Business")),
			};
			@Override
			public DomainEntry[] getDomain() {
				return domain;
			};
		};
	
	public static final Attribute<Driver, java.lang.Boolean, java.lang.Boolean> disqualified 
		= new SimpleAttribute<Driver, java.lang.Boolean, java.lang.Boolean>(
			"disqualified", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.Boolean> get(Driver instance) {
				return instance.disqualified;
			}
			
			private final Text question = new ConstantText("Have you been disqualified in the last 5 years?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<Driver, java.lang.String, java.lang.String> zipCode 
		= new SimpleAttribute<Driver, java.lang.String, java.lang.String>(
			"zipCode", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.String> get(Driver instance) {
				return instance.zipCode;
			}
			
			private final Text question = new ConstantText("ZIP code");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<Driver, java.lang.Integer, java.lang.Integer> yearsDriverslicense 
		= new SimpleAttribute<Driver, java.lang.Integer, java.lang.Integer>(
			"yearsDriverslicense", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.Integer> get(Driver instance) {
				return instance.yearsDriverslicense;
			}
			
			private final Text question = new ConstantText("How many years have you held your drivers licence?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<Driver, java.lang.Integer, java.lang.Integer> yearsInsured 
		= new SimpleAttribute<Driver, java.lang.Integer, java.lang.Integer>(
			"yearsInsured", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.Integer> get(Driver instance) {
				return instance.yearsInsured;
			}
			
			private final Text question = new ConstantText("How many years have you been insured?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<Driver, java.lang.String, java.lang.String> mileage 
		= new SimpleAttribute<Driver, java.lang.String, java.lang.String>(
			"mileage", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.String> get(Driver instance) {
				return instance.mileage;
			}
			
			private final Text question = new ConstantText("Annual mileage");
			@Override
			public Text getQuestion() {
				return question;
			}
			
			private final DomainEntry[] domain = new DomainEntry[] {
				new DomainEntry("k1", new ConstantText("< 7.500 km")),
				new DomainEntry("k2", new ConstantText("7.500 km - 12.000 km")),
				new DomainEntry("k1", new ConstantText("> 12.000 km")),
			};
			@Override
			public DomainEntry[] getDomain() {
				return domain;
			};
		};
	
	public static final Attribute<Driver, java.lang.Integer, java.lang.Integer> noClaimsDiscount 
		= new SimpleAttribute<Driver, java.lang.Integer, java.lang.Integer>(
			"noClaimsDiscount", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<Driver, java.lang.Integer> get(Driver instance) {
				return instance.noClaimsDiscount;
			}
			
			private final Text question = new ConstantText("Number of years 'no claims discount' entitlement?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	// Relations
	
	// Reverse relations
	
	public static final Relation<Driver, CarinsuranceCase, CarinsuranceCase> carinsuranceCase
		= new SimpleRelation<Driver, CarinsuranceCase, CarinsuranceCase>(
			"carinsuranceCase", INSTANCE, DriverEntity.INSTANCE, CarinsuranceCase.class, CarinsuranceCaseEntity.driver
		) {
	
			@Override
			public ReadOnlyRelationValue<Driver, CarinsuranceCase> get(
					Driver instance) {
				return instance.carinsuranceCase;
			}
	
			public boolean isReverse() {
				return true;
			}
		};

	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		dateOfBirth,
		carUse,
		disqualified,
		zipCode,
		yearsDriverslicense,
		yearsInsured,
		mileage,
		noClaimsDiscount,
	};
	private static final Relation[] RELATIONS = new Relation[]{
	};
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		carinsuranceCase,
	};

	private DriverEntity() {
		super("Driver");
	}
	
	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		return new Driver(caseInstance, id);
	}
	
	@Override
	public Attribute<? extends Instance, ? extends Object, ? extends Object>[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation<? extends Instance, ? extends Object, ? extends Instance>[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}
}

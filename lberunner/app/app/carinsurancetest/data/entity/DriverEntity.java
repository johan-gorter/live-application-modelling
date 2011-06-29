package app.carinsurancetest.data.entity;

import java.util.List;

import app.carinsurancetest.data.instance.*;
import lbe.instance.*;
import lbe.instance.value.*;
import lbe.model.*;
import lbe.model.impl.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DriverEntity extends SimpleEntity {

	public static final DriverEntity INSTANCE = new DriverEntity();
	
	// Attributes
	
	public static final Attribute<DriverInstance, java.util.Date, java.util.Date> dateOfBirth 
		= new SimpleAttribute<DriverInstance, java.util.Date, java.util.Date>(
			"dateOfBirth", INSTANCE, java.util.Date.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.util.Date> get(DriverInstance instance) {
				return instance.dateOfBirth;
			}
			
			private final Text question = new ConstantText("Date of birth");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<DriverInstance, List<java.lang.String>, java.lang.String> carUse 
		= new SimpleAttribute<DriverInstance, List<java.lang.String>, java.lang.String>(
			"carUse", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValues<DriverInstance, java.lang.String> get(DriverInstance instance) {
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
	
	public static final Attribute<DriverInstance, java.lang.Boolean, java.lang.Boolean> disqualified 
		= new SimpleAttribute<DriverInstance, java.lang.Boolean, java.lang.Boolean>(
			"disqualified", INSTANCE, java.lang.Boolean.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.Boolean> get(DriverInstance instance) {
				return instance.disqualified;
			}
			
			private final Text question = new ConstantText("Have you been disqualified in the last 5 years?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<DriverInstance, java.lang.String, java.lang.String> zipCode 
		= new SimpleAttribute<DriverInstance, java.lang.String, java.lang.String>(
			"zipCode", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.String> get(DriverInstance instance) {
				return instance.zipCode;
			}
			
			private final Text question = new ConstantText("Zip code");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<DriverInstance, java.lang.Integer, java.lang.Integer> yearsDriverslicense 
		= new SimpleAttribute<DriverInstance, java.lang.Integer, java.lang.Integer>(
			"yearsDriverslicense", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.Integer> get(DriverInstance instance) {
				return instance.yearsDriverslicense;
			}
			
			private final Text question = new ConstantText("How many years have you held your drivers licence?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<DriverInstance, java.lang.Integer, java.lang.Integer> yearsInsured 
		= new SimpleAttribute<DriverInstance, java.lang.Integer, java.lang.Integer>(
			"yearsInsured", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.Integer> get(DriverInstance instance) {
				return instance.yearsInsured;
			}
			
			private final Text question = new ConstantText("How many years have you been insured?");
			@Override
			public Text getQuestion() {
				return question;
			}
		};
	
	public static final Attribute<DriverInstance, java.lang.String, java.lang.String> mileage 
		= new SimpleAttribute<DriverInstance, java.lang.String, java.lang.String>(
			"mileage", INSTANCE, java.lang.String.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.String> get(DriverInstance instance) {
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
	
	public static final Attribute<DriverInstance, java.lang.Integer, java.lang.Integer> noClaimsDiscount 
		= new SimpleAttribute<DriverInstance, java.lang.Integer, java.lang.Integer>(
			"noClaimsDiscount", INSTANCE, java.lang.Integer.class
		) {
	
			@Override
			public ReadOnlyAttributeValue<DriverInstance, java.lang.Integer> get(DriverInstance instance) {
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
	
	public static final Relation<DriverInstance, CarinsuranceCaseInstance, CarinsuranceCaseInstance> carinsuranceCase
		= new SimpleRelation<DriverInstance, CarinsuranceCaseInstance, CarinsuranceCaseInstance>(
			"carinsuranceCase", INSTANCE, DriverEntity.INSTANCE, CarinsuranceCaseInstance.class, CarinsuranceCaseEntity.driver
		) {
	
			@Override
			public ReadOnlyRelationValue<DriverInstance, CarinsuranceCaseInstance> get(
					DriverInstance instance) {
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
	public Instance createInstance(CaseInstance caseInstance) {
		return new DriverInstance(caseInstance);
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

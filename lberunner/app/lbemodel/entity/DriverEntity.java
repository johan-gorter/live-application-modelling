package lbemodel.entity;

import java.util.Date;
import java.util.GregorianCalendar;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.model.Attribute;
import lbe.model.DomainEntry;
import lbe.model.Entity;
import lbe.model.Relation;
import lbe.model.deduction.ConstantDeduction;
import lbe.model.deduction.Deduction;
import lbe.model.impl.SimpleAttribute;
import lbe.model.impl.SimpleRelation;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;


public class DriverEntity extends Entity {

	public static final DriverEntity INSTANCE = new DriverEntity();
	
	public static final Attribute<DriverInstance, Date> dateOfBirth = new SimpleAttribute<DriverInstance, Date>("dateOfBirth", INSTANCE, Date.class) {
		
		@Override
		public AttributeValueImpl<DriverInstance, Date> get(DriverInstance instance) {
			return instance.dateOfBirth;
		}
		
		private final Text question = new ConstantText("Date of birth"); 
		@Override
		public Text getQuestion() {
			return question;
		};
		
		private final Deduction<Date> deduction = new ConstantDeduction<Date>(new GregorianCalendar(1980,0,1).getTime());
		@Override
		public Deduction<Date> getDeduction() {
			return deduction;
		};
		
	};
	
	public static final Attribute<DriverInstance, Integer> yearsInsured = new SimpleAttribute<DriverInstance, Integer>("yearsInsured", INSTANCE, Integer.class) {

		@Override
		public AttributeValueImpl<DriverInstance, Integer> get(
				DriverInstance instance) {
			return instance.yearsInsured;
		}

		private final Text question = new ConstantText("How many years have you been insured?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};
	
	public static final Attribute<DriverInstance, Integer> yearsDriverslicense = new SimpleAttribute<DriverInstance, Integer>("yearsDriverslicense", INSTANCE, Integer.class) {

		@Override
		public AttributeValueImpl<DriverInstance, Integer> get(
				DriverInstance instance) {
			return instance.yearsDriverslicense;
		}
		
		private final Text question = new ConstantText("How many years have you held your drivers licence?"); 
		@Override
		public Text getQuestion() {
			return question;
		};

		private final Text explain = new ConstantText("Round the number of months down to entire years. e.g. if you own a drivers licence for 3 months round down to 0 years."); 
		@Override
		public Text getExplain() {
			return explain;
		};
	};
	
	public static final Attribute<DriverInstance, Integer> noClaimsDiscount = new SimpleAttribute<DriverInstance, Integer>("noClaimsDiscount", INSTANCE, Integer.class) {

		@Override
		public AttributeValueImpl<DriverInstance, Integer> get(
				DriverInstance instance) {
			return instance.noClaimsDiscount;
		}
		
		private final Text question = new ConstantText("Number of years no claims discount entitlement?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};

	public static final Attribute<DriverInstance, Boolean> disqualified = new SimpleAttribute<DriverInstance, Boolean>("disqualified", INSTANCE, Boolean.class) {

		@Override
		public AttributeValueImpl<DriverInstance, Boolean> get(
				DriverInstance instance) {
			return instance.disqualified;
		}
		
		private final Text question = new ConstantText("Have you been disqualified in the last 5 years?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
		
	};
	
	public static final Attribute<DriverInstance, String> carUse = new SimpleAttribute<DriverInstance, String>("carUse", INSTANCE, String.class) {

		@Override
		public AttributeValueImpl<DriverInstance, String> get(
				DriverInstance instance) {
			return instance.carUse;
		};
		
		private final DomainEntry[] domain = new DomainEntry[] {
				new DomainEntry("private",new ConstantText("Private")),
				new DomainEntry("business",new ConstantText("Business"))
		};
		public DomainEntry[] getDomain() {
			return domain;
		};
		
		
		public boolean isMultivalue() {
			return true;
		}

	};
	
	public static final Attribute<DriverInstance, String> mileage = new SimpleAttribute<DriverInstance, String>("mileage", INSTANCE, String.class) {

		@Override
		public AttributeValueImpl<DriverInstance, String> get(
				DriverInstance instance) {
			return instance.mileage;
		}
		
		private final DomainEntry[] domain = new DomainEntry[] {
				new DomainEntry("k1", new ConstantText("< 7.500 km")),	
				new DomainEntry("k2",new ConstantText("7.500 km - 12.000 km")),	
				new DomainEntry("k3",new ConstantText("> 12.000 km"))
		};
		public DomainEntry[] getDomain() {
			return domain;
		};

		private final Text question = new ConstantText("Annual mileage"); 
		@Override
		public Text getQuestion() {
			return question;
		};

	};
	
	public static final Attribute<DriverInstance, String> zipCode 
		= new SimpleAttribute<DriverInstance, String>("zipCode", INSTANCE, String.class) {

		@Override
		public AttributeValueImpl<DriverInstance, String> get(
				DriverInstance instance) {
			return instance.zipCode;
		}
		
		private final Text question = new ConstantText("ZIP code"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};
	
	public static final Relation<DriverInstance, CarinsuranceCaseInstance> carinsuranceCase 
		= new SimpleRelation<DriverInstance, CarinsuranceCaseInstance>("carinsuranceCase", INSTANCE, CarinsuranceCaseEntity.INSTANCE, 
				CarinsuranceCaseInstance.class, CarinsuranceCaseEntity.driver) {

			@Override
			public AttributeValueImpl<DriverInstance, CarinsuranceCaseInstance> get(
					DriverInstance instance) {
				return instance.carinsuranceCase;
			}
		
	};
	
	private static final Attribute[] ATTRIBUTES = new Attribute[]{
		dateOfBirth,
		yearsInsured,
		yearsDriverslicense,
		noClaimsDiscount,
		disqualified,
		carUse,
		mileage,
		zipCode
	};
	
	private static final Relation[] RELATIONS = new Relation[]{
		
	};
	
	private static final Relation[] REVERSE_RELATIONS = new Relation[]{
		carinsuranceCase
	};


	@Override
	public String getName() {
		return "Driver";
	}

	@Override
	public Attribute[] getAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation[] getRelations() {
		return RELATIONS;
	}

	@Override
	public Relation[] getReverseRelations() {
		return REVERSE_RELATIONS;
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new DriverInstance(caseInstance);
	}
}

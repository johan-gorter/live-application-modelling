package app.oldcarinsurance.entity;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.instantlogic.core.CaseInstance;
import org.instantlogic.core.Instance;
import org.instantlogic.core.deduction.AttributeDeduction;
import org.instantlogic.core.deduction.ConstantDeduction;
import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.deduction.FirstDeduction;
import org.instantlogic.core.deduction.SelectedInstanceDeduction;
import org.instantlogic.core.model.Attribute;
import org.instantlogic.core.model.DomainEntry;
import org.instantlogic.core.model.Entity;
import org.instantlogic.core.model.Relation;
import org.instantlogic.core.model.impl.SimpleAttribute;
import org.instantlogic.core.model.impl.SimpleRelation;
import org.instantlogic.core.text.ConstantText;
import org.instantlogic.core.text.Text;
import org.instantlogic.core.value.AttributeValue;
import org.instantlogic.core.value.ReadOnlyAttributeValue;
import org.instantlogic.core.value.ReadOnlyRelationValue;

import app.oldcarinsurance.CarinsuranceCase;
import app.oldcarinsurance.Driver;



public class DriverEntity extends Entity {

	public static final DriverEntity INSTANCE = new DriverEntity();
	
	public static final Attribute<Driver, Date, Date> dateOfBirth 
		= new SimpleAttribute<Driver, Date, Date>("dateOfBirth", INSTANCE, Date.class) {
		
		@Override
		public AttributeValue<Driver, Date> get(Driver instance) {
			return instance.dateOfBirth;
		}
		
		private final Text question = new ConstantText("Date of birth"); 
		@Override
		public Text getQuestion() {
			return question;
		};
		
		private final Deduction<Date> deduction = new ConstantDeduction<Date>(new GregorianCalendar(1980,0,1).getTime());
		@Override
		public Deduction<Date> getDefault() {
			return deduction;
		};
		
	};
	
	public static final Attribute<Driver, Integer, Integer> yearsInsured 
		= new SimpleAttribute<Driver, Integer, Integer>("yearsInsured", INSTANCE, Integer.class) {

		@Override
		public AttributeValue<Driver, Integer> get(
				Driver instance) {
			return instance.yearsInsured;
		}

		private final Text question = new ConstantText("How many years have you been insured?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};
	
	public static final Attribute<Driver, Integer, Integer> yearsDriverslicense 
		= new SimpleAttribute<Driver, Integer, Integer>("yearsDriverslicense", INSTANCE, Integer.class) {

		@Override
		public AttributeValue<Driver, Integer> get(
				Driver instance) {
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
	
	public static final Attribute<Driver, Integer, Integer> noClaimsDiscount 
		= new SimpleAttribute<Driver, Integer, Integer>("noClaimsDiscount", INSTANCE, Integer.class) {

		@Override
		public AttributeValue<Driver, Integer> get(
				Driver instance) {
			return instance.noClaimsDiscount;
		}
		
		private final Text question = new ConstantText("Number of years no claims discount entitlement?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};

	public static final Attribute<Driver, Boolean, Boolean> disqualified 
		= new SimpleAttribute<Driver, Boolean, Boolean>("disqualified", INSTANCE, Boolean.class) {

		@Override
		public AttributeValue<Driver, Boolean> get(
				Driver instance) {
			return instance.disqualified;
		}
		
		private final Text question = new ConstantText("Have you been disqualified in the last 5 years?"); 
		@Override
		public Text getQuestion() {
			return question;
		};
		
	};
	
	public static final Attribute<Driver, List<String>, String> carUse 
		= new SimpleAttribute<Driver, List<String>, String>("carUse", INSTANCE, String.class) {

		@Override
		public AttributeValue<Driver, List<String>> get(
				Driver instance) {
			return instance.carUse;
		};
		
		private final DomainEntry[] domain = new DomainEntry[] {
				new DomainEntry("private",new ConstantText("Private")),
				new DomainEntry("business",new ConstantText("Business"))
		};
		@Override
		public DomainEntry[] getDomain() {
			return domain;
		};
		
		
		public boolean isMultivalue() {
			return true;
		}

	};
	
	public static final Attribute<Driver, String, String> mileage 
		= new SimpleAttribute<Driver, String, String>("mileage", INSTANCE, String.class) {

		@Override
		public AttributeValue<Driver, String> get(
				Driver instance) {
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
	
	public static final Attribute<Driver, String, String> zipCode 
		= new SimpleAttribute<Driver, String, String>("zipCode", INSTANCE, String.class) {

		@Override
		public AttributeValue<Driver, String> get(
				Driver instance) {
			return instance.zipCode;
		}
		
		private final Text question = new ConstantText("ZIP code"); 
		@Override
		public Text getQuestion() {
			return question;
		};
	};

	public static final Attribute<Driver, Integer, Integer> penalty 
		= new SimpleAttribute<Driver, Integer, Integer>("penalty", INSTANCE, Integer.class) {

		protected final Deduction<Integer> DEDUCTION = createDeduction();
		private Deduction<Integer> createDeduction() {
			Deduction<Driver> d9 = new SelectedInstanceDeduction<Driver>(DriverEntity.INSTANCE);
			Deduction<Integer> d8 = new AttributeDeduction<Integer, Driver>(DriverEntity.yearsInsured, d9);
			ConstantDeduction<Integer> d7 = new ConstantDeduction<Integer>(100);
			FirstDeduction<Integer> d0 = new FirstDeduction<Integer>(d8, d7);
			return d0;
		}
		
		@Override
		public ReadOnlyAttributeValue<Driver, Integer> get(
				Driver instance) {
			return instance.penalty;
		}
		

		public boolean isReadOnly() {
			return true;
		};
		
		public Deduction<Integer> getDefault() {
			return DEDUCTION;
		};
		
	};
	
	public static final Relation<Driver, CarinsuranceCase, CarinsuranceCase> carinsuranceCase 
		= new SimpleRelation<Driver, CarinsuranceCase, CarinsuranceCase>("carinsuranceCase", INSTANCE, 
				CarinsuranceCaseEntity.INSTANCE, 
				CarinsuranceCase.class, CarinsuranceCaseEntity.driver) {

			@Override
			public ReadOnlyRelationValue<Driver, CarinsuranceCase> get(
					Driver instance) {
				return instance.carinsuranceCase;
			}
			
			public boolean isReverse() {
				return true;
			};
		
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
	public Attribute[] getLocalAttributes() {
		return ATTRIBUTES;
	}

	@Override
	public Relation[] getLocalRelations() {
		return RELATIONS;
	}

	@Override
	public Relation[] getLocalReverseRelations() {
		return REVERSE_RELATIONS;
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance) {
		return new Driver(caseInstance);
	}

	@Override
	public Entity extendsEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instance createInstance(CaseInstance caseInstance, long id) {
		// TODO Auto-generated method stub
		return null;
	}
}

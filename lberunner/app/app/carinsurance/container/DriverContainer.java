package app.carinsurance.container;

import lbe.model.Attribute;
import lbe.model.Relation;
import lbe.model.pageelement.Container;
import lbe.model.pageelement.Field;
import lbe.model.pageelement.PageElementBase;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;
import app.carinsurancetest.data.entity.CarinsuranceCaseEntity;
import app.carinsurancetest.data.entity.DriverEntity;

public class DriverContainer extends Container{

	public static DriverContainer INSTANCE = new DriverContainer();
	
	private static final Text DISPLAY = new ConstantText("Driver details");

	private DriverContainer() {}
	
	private static final PageElementBase[] CHILDREN = new PageElementBase[] {

//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.dateOfBirth;
//			}
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.yearsInsured;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		new Field() {
//
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.yearsDriverslicense;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//			
//		},
//		new Field() {
//
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.noClaimsDiscount;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		
//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.disqualified;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		
//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.carUse;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		
//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.mileage;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		},
//		
//		new Field() {
//			@Override
//			public Attribute getAttribute() {
//				return DriverEntity.zipCode;
//			}
//
//			@Override
//			public boolean isRequired() {
//				return true;
//			}
//		}

	};

	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public Text getDisplay() {
		return DISPLAY;
	}
	
	@Override
	public PageElementBase[] getChildren() {
		return CHILDREN;
	}

	@Override
	public Relation getRelation() {
		return CarinsuranceCaseEntity.driver;
	}
}

package app.oldcarinsurance.container;

import lbe.engine.RenderContext;
import lbe.model.deduction.Deduction;
import lbe.model.pageelement.CompositePageFragment;
import lbe.model.pageelement.PageFragment;
import lbe.model.pageelement.Text;
import lbe.model.pageelement.impl.ConstantText;
import app.oldcarinsurance.entity.CarinsuranceCaseEntity;

public class DriverContainer extends CompositePageFragment{

	public static DriverContainer INSTANCE = new DriverContainer();
	
	private static final Text DISPLAY = new ConstantText("Driver details");

	private DriverContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {

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
	public PageFragment[] getChildren(RenderContext context) {
		return CHILDREN;
	}
	
	@Override
	public Deduction<? extends Object> getSelect() {
		return CarinsuranceCaseEntity.driver;
	}
}

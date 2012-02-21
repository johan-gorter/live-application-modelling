 package app.oldcarinsurance.sharedPageFragment;


import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.fabric.text.Text;
import org.instantlogic.interaction.page.CompositePageFragment;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.util.RenderContext;

import app.oldcarinsurance.CarinsuranceCase;
import app.oldcarinsurance.Driver;
import app.oldcarinsurance.entity.CarinsuranceCaseEntity;

public class DriverContainer extends CompositePageFragment {

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
	
	private Deduction<Driver> select = 
		new AttributeDeduction<Driver, CarinsuranceCase>(CarinsuranceCaseEntity.driver, new SelectedInstanceDeduction<CarinsuranceCase>(CarinsuranceCaseEntity.INSTANCE));
	
	@Override
	public Deduction<? extends Object> getSelect() {
		return select;
	}
}

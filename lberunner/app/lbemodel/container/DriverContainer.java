package lbemodel.container;

import lbe.instance.Instance;
import lbe.model.AttributeModel;
import lbe.model.ContainerModel;
import lbe.model.FieldModel;
import lbe.model.PageElementModelBase;
import lbe.model.RelationModel;
import lbe.page.RenderContext;
import lbemodel.entity.DriverEntity;
import lbemodel.entity.carinsurancecase.DriverRelation;
import lbemodel.entity.driver.CarUseAttribute;
import lbemodel.entity.driver.DateOfBirthAttribute;
import lbemodel.entity.driver.DisqualifiedAttribute;
import lbemodel.entity.driver.MileageAttribute;
import lbemodel.entity.driver.NoClaimsDiscountAttribute;
import lbemodel.entity.driver.YearsDriverslicenseAttribute;
import lbemodel.entity.driver.YearsInsuredAttribute;
import lbemodel.entity.driver.ZipCodeAttribute;

public class DriverContainer extends ContainerModel{

	public static DriverContainer INSTANCE = new DriverContainer();
	
	private DriverContainer() {}
	
	private static final PageElementModelBase[] CHILDREN = new PageElementModelBase[] {

		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return DateOfBirthAttribute.INSTANCE;
			}
			@Override
			public boolean isRequired() {
				return true;
			}
		},
		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return YearsInsuredAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		},
		new FieldModel() {

			@Override
			public AttributeModel getAttribute() {
				return YearsDriverslicenseAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
			
		},
		new FieldModel() {

			@Override
			public AttributeModel getAttribute() {
				return NoClaimsDiscountAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		},
		
		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return DisqualifiedAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		},
		
		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return CarUseAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		},
		
		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return MileageAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		},
		
		new FieldModel() {
			@Override
			public AttributeModel getAttribute() {
				return ZipCodeAttribute.INSTANCE;
			}

			@Override
			public boolean isRequired() {
				return true;
			}
		}

	};

	@Override
	public String getName() {
		return "Driver";
	}
	
	@Override
	public String getDisplay(RenderContext context) {
		return "Driver details";
	}
	
	@Override
	public PageElementModelBase[] getChildren() {
		return CHILDREN;
	}

	@Override
	public RelationModel getRelation() {
		return DriverRelation.INSTANCE;
	}
}

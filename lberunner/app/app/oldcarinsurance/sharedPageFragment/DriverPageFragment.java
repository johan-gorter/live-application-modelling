package app.oldcarinsurance.sharedPageFragment;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleCompositePageFragment;
import org.instantlogic.interaction.page.impl.SimpleField;
import org.instantlogic.interaction.page.impl.SimpleSharedPageFragment;

import app.carinsurance.CarinsuranceCase;
import app.carinsurance.Driver;
import app.carinsurance.entity.CarinsuranceCaseEntity;
import app.carinsurance.entity.DriverEntity;

public class DriverPageFragment extends SimpleSharedPageFragment {
	
	public static DriverPageFragment INSTANCE = new DriverPageFragment();
	
	protected DriverPageFragment() {
	}
	
	private static Deduction<?> createDeduction0() {
		Deduction<CarinsuranceCase> d0 = SelectedInstanceDeduction.create(CarinsuranceCaseEntity.INSTANCE);
		Deduction<Driver> d1 = AttributeDeduction.create(CarinsuranceCaseEntity.driver, d0);
		return d1;
	}

	public static final PageFragment SHARED_INSTANCE = 
        new SimpleCompositePageFragment(createDeduction0(), new PageFragment[]{
            new SimpleCompositePageFragment(new ConstantText("Driver"), new PageFragment[]{
                new SimpleCompositePageFragment(new PageFragment[]{
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.dateOfBirth).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsInsured).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsDriverslicense).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.noClaimsDiscount).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.disqualified).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.carUse).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.mileage).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.zipCode).setRequired(),
                })
            })
        });

	@Override
	protected PageFragment getDelegate() {
		return SHARED_INSTANCE;
	}
}

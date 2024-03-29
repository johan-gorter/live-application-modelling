package app.carinsurance.flow.insure;

import org.instantlogic.fabric.deduction.AttributeDeduction;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.deduction.SelectedInstanceDeduction;
import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.SimpleButton;
import org.instantlogic.interaction.page.impl.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.impl.SimpleField;

import app.carinsurance.CarinsuranceCase;
import app.carinsurance.Driver;
import app.carinsurance.entity.CarinsuranceCaseEntity;
import app.carinsurance.entity.DriverEntity;
import app.carinsurance.event.NextEvent;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();


	private static Deduction<?> createDeduction0() {
		Deduction<CarinsuranceCase> d0 = SelectedInstanceDeduction.create(CarinsuranceCaseEntity.INSTANCE);
		Deduction<Driver> d1 = AttributeDeduction.create(CarinsuranceCaseEntity.driver, d0);
		return d1;
	}

	
	private static CompositeFragmentTemplate CONTENT = 
        new CompositeFragmentTemplate(createDeduction0(), new PageFragment[]{
            new CompositeFragmentTemplate(new ConstantText("Driver"), new PageFragment[]{
                new CompositeFragmentTemplate(new PageFragment[]{
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.dateOfBirth).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsInsured).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsDriverslicense).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.noClaimsDiscount).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.disqualified).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.carUse).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.mileage).setRequired(),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.zipCode).setRequired()
                })
            }),
            new SimpleButton(NextEvent.INSTANCE, new ConstantText("Next"))
        }); 
	
	@Override
	public CompositeFragmentTemplate getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
}

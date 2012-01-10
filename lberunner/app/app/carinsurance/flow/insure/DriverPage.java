package app.carinsurance.flow.insure;

import app.carinsurance.*;
import app.carinsurance.event.*;
import app.carinsurance.flow.*;
import app.carinsurance.entity.*;
import app.carinsurance.sharedpagefragment.*;
import lbe.instance.*;
import lbe.model.flow.*;
import lbe.model.deduction.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();


	private static Deduction<?> createDeduction0() {
		Deduction<CarinsuranceCase> d0 = SelectedInstanceDeduction.create(CarinsuranceCaseEntity.INSTANCE);
		Deduction<Driver> d1 = AttributeDeduction.create(CarinsuranceCaseEntity.driver, d0);
		return d1;
	}

	
	private static CompositePageFragment CONTENT = 
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
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.zipCode).setRequired()
                })
            }),
            new SimpleButton(NextEvent.INSTANCE, new ConstantText("Next"))
        }); 
	
	@Override
	public CompositePageFragment getRootContainer() {
		return CONTENT;
	}; 
	
	@Override
	public String getName() {
		return "Driver";
	}
	
}

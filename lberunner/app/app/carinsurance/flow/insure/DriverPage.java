package app.carinsurance.flow.insure;

import app.carinsurance.event.*;
import app.carinsurance.flow.*;
import app.carinsurance.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(CarinsuranceCaseEntity.driver, new PageFragment[]{
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
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.Test),
                    new SimpleField(DriverEntity.INSTANCE, DriverEntity.NewAttribute1323119309)
                })
            })
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

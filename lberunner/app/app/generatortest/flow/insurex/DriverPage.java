package app.generatortest.flow.insurex;

import app.generatortest.event.*;
import app.generatortest.flow.*;
import app.generatortest.data.entity.*;
import lbe.model.flow.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	
	private static CompositePageFragment CONTENT = 
        new SimpleCompositePageFragment(CarinsuranceCaseEntity.driver.toDeduction(), new PageFragment[]{
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

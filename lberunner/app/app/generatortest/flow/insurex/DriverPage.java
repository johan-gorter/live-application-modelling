package app.generatortest.flow.insurex;

import org.instantlogic.fabric.text.ConstantText;
import org.instantlogic.interaction.flow.Page;
import org.instantlogic.interaction.page.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.PageFragment;
import org.instantlogic.interaction.page.impl.CompositeFragmentTemplate;
import org.instantlogic.interaction.page.impl.SimpleField;

import app.generatortest.data.entity.CarinsuranceCaseEntity;
import app.generatortest.data.entity.DriverEntity;

public class DriverPage extends Page {

	public static final DriverPage INSTANCE = new DriverPage();
	
	
	private static CompositeFragmentTemplate CONTENT = 
        new CompositeFragmentTemplate(CarinsuranceCaseEntity.driver.toDeduction(), new PageFragment[]{
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
            })
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

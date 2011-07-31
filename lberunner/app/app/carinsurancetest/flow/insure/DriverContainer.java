package app.carinsurancetest.flow.insure;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.carinsurancetest.data.entity.*;

public class DriverContainer extends CompositePageFragment {

	public static DriverContainer INSTANCE = new DriverContainer();
	
	private DriverContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
		new SimpleField(DriverEntity.dateOfBirth).setRequired(),
		new SimpleField(DriverEntity.yearsInsured).setRequired(),
		new SimpleField(DriverEntity.yearsDriverslicense).setRequired(),
		new SimpleField(DriverEntity.noClaimsDiscount).setRequired(),
		new SimpleField(DriverEntity.disqualified).setRequired(),
		new SimpleField(DriverEntity.carUse).setRequired(),
		new SimpleField(DriverEntity.mileage).setRequired(),
		new SimpleField(DriverEntity.zipCode).setRequired(),
	};

	@Override
	public String getName() {
		return "Driver";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}

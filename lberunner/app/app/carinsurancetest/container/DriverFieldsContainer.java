package app.carinsurancetest.container;

import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.carinsurancetest.data.entity.*;

public class DriverFieldsContainer extends CompositePageFragment {

	public static DriverFieldsContainer INSTANCE = new DriverFieldsContainer();
	
	private DriverFieldsContainer() {}
	
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
		return "DriverFields";
	}

	@Override
	public PageFragment[] getChildren() {
		return CHILDREN;
	}
}

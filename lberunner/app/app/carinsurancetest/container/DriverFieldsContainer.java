package app.carinsurancetest.container;

import lbe.engine.RenderContext;
import lbe.model.*;
import lbe.model.pageelement.*;
import lbe.model.pageelement.impl.*;
import app.carinsurancetest.data.entity.*;

public class DriverFieldsContainer extends CompositePageFragment {

	public static DriverFieldsContainer INSTANCE = new DriverFieldsContainer();
	
	private DriverFieldsContainer() {}
	
	private static final PageFragment[] CHILDREN = new PageFragment[] {
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.dateOfBirth).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsInsured).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.yearsDriverslicense).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.noClaimsDiscount).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.disqualified).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.carUse).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.mileage).setRequired(),
		new SimpleField(DriverEntity.INSTANCE, DriverEntity.zipCode).setRequired(),
	};

	@Override
	public String getName() {
		return "DriverFields";
	}

	@Override
	public PageFragment[] getChildren(RenderContext context) {
		return CHILDREN;
	}
}

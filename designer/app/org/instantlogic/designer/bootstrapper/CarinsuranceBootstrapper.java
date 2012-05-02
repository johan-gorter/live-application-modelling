package org.instantlogic.designer.bootstrapper;

import java.util.Date;

import org.instantlogic.designer.ApplicationDesign;
import org.instantlogic.designer.AttributeDesign;
import org.instantlogic.designer.CompositeTemplateDesign;
import org.instantlogic.designer.EntityDesign;
import org.instantlogic.designer.EntityDesign.RelationType;
import org.instantlogic.designer.EventDesign;
import org.instantlogic.designer.FlowDesign;
import org.instantlogic.designer.FlowSourceDesign;
import org.instantlogic.designer.HeaderDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.RelationDesign;
import org.instantlogic.designer.SelectDesign;

public class CarinsuranceBootstrapper extends BootstrapperUtil {

	public static ApplicationDesign createCarinsurance() {

		// Case
		applicationDesign = new ApplicationDesign();
		applicationDesign.setName("CarInsurance");
		
		// Data
		EntityDesign carinsuranceCase = createEntity("CarinsuranceCase", null);
		applicationDesign.setCaseEntity(carinsuranceCase);
		EntityDesign driver = createEntity("Driver", null);
		AttributeDesign dateOfBirth = createAttribute(driver, "dateOfBirth", Date.class);
		dateOfBirth.setQuestion(createConstantText("Date of birth"));
		AttributeDesign carUse = createAttribute(driver, "carUse", String.class);
		carUse.setMultivalue(true);
		carUse.addToDomain(createDomainEntry("private", "Private"));
		carUse.addToDomain(createDomainEntry("business", "Business"));
		carUse.setQuestion(createConstantText("How will the car be used?"));
		AttributeDesign disqualified = createAttribute(driver, "disqualified", Boolean.class);
		disqualified.setQuestion(createConstantText("Have you been disqualified in the last 5 years?"));
		AttributeDesign zipCode = createAttribute(driver, "zipCode", String.class);
		zipCode.setQuestion(createConstantText("ZIP code"));
		AttributeDesign yearsDriverslicense = createAttribute(driver, "yearsDriverslicense", Integer.class);
		yearsDriverslicense.setQuestion(createConstantText("How many years have you held your drivers licence?"));
		AttributeDesign yearsInsured = createAttribute(driver, "yearsInsured", Integer.class);
		yearsInsured.setQuestion(createConstantText("How many years have you been insured?"));
		AttributeDesign mileage = createAttribute(driver, "mileage", String.class);
		mileage.setQuestion(createConstantText("Annual mileage"));
		mileage.addToDomain(createDomainEntry("k1", "< 7.500 km"));	
		mileage.addToDomain(createDomainEntry("k2", "7.500 km - 12.000 km"));	
		mileage.addToDomain(createDomainEntry("k1", "> 12.000 km"));	
		AttributeDesign noClaimsDiscount = createAttribute(driver, "noClaimsDiscount", Integer.class);
		noClaimsDiscount.setQuestion(createConstantText("Number of years 'no claims discount' entitlement?"));
		RelationDesign driverRelation = createRelation(carinsuranceCase, "driver", RelationType.OneToOneAggregation, "carinsuranceCase", driver);

		// Events
		EventDesign next = createEvent("Next");
		
		// PageFragments
		SelectDesign selectDriver = createSelect(createDeduction(driverRelation));
		HeaderDesign driverHeader = createHeader(createConstantText("Driver"));
		addContent(selectDriver, driverHeader);
		CompositeTemplateDesign driverFields = createCompositeFragmentTemplate();
		addContent(driverHeader, driverFields);
		createField(driverFields, dateOfBirth, true);
		createField(driverFields, yearsInsured, true);
		createField(driverFields, yearsDriverslicense, true);
		createField(driverFields, noClaimsDiscount, true);
		createField(driverFields, disqualified, true);
		createField(driverFields, carUse, true);
		createField(driverFields, mileage, true);
		createField(driverFields, zipCode, true);
		addContent(selectDriver, createButton(next, createConstantText("Next")));
		
		// Flows
		FlowDesign insureFlow = createFlow("Insure");
		PlaceTemplateDesign insureDriverPage = createPage(insureFlow, "Driver");
		FlowSourceDesign insureStartSource = createSource(insureFlow, null, insureDriverPage, null);
		insureDriverPage.setContent(selectDriver);
		applicationDesign.addToExposedFlows(insureFlow);
		
		// Finish up
		
		return applicationDesign;
	}
}

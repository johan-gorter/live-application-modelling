package lbe.designerbootstrap;

import java.util.Date;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import app.designer.AttributeDesign;
import app.designer.CompositePageFragmentDesign;
import app.designer.DeductionDesign;
import app.designer.EntityDesign;
import app.designer.EventDesign;
import app.designer.FlowDesign;
import app.designer.FlowSourceDesign;
import app.designer.HeaderDesign;
import app.designer.PageDesign;
import app.designer.RelationDesign;
import app.designer.SelectDesign;
import custom.designer.ApplicationDesignCustomization;

public class CarinsuranceBootstrapper extends BootstrapperUtil {

	public static ApplicationDesignCustomization createCarinsurance() {

		// Case
		applicationDesign = new ApplicationDesignCustomization();
		applicationDesign.name.set("CarInsurance");
		
		// Data
		EntityDesign carinsuranceCase = createEntity("CarinsuranceCase", null);
		applicationDesign.caseEntity.set(carinsuranceCase);
		EntityDesign driver = createEntity("Driver", null);
		AttributeDesign dateOfBirth = createAttribute(driver, "dateOfBirth", Date.class);
		dateOfBirth.question.set(createConstantText("Date of birth"));
		AttributeDesign carUse = createAttribute(driver, "carUse", String.class);
		carUse.multivalue.set(true);
		carUse.domain.add(createDomainEntry("private", "Private"));
		carUse.domain.add(createDomainEntry("business", "Business"));
		carUse.question.set(createConstantText("How will the car be used?"));
		AttributeDesign disqualified = createAttribute(driver, "disqualified", Boolean.class);
		disqualified.question.set(createConstantText("Have you been disqualified in the last 5 years?"));
		AttributeDesign zipCode = createAttribute(driver, "zipCode", String.class);
		zipCode.question.set(createConstantText("ZIP code"));
		AttributeDesign yearsDriverslicense = createAttribute(driver, "yearsDriverslicense", Integer.class);
		yearsDriverslicense.question.set(createConstantText("How many years have you held your drivers licence?"));
		AttributeDesign yearsInsured = createAttribute(driver, "yearsInsured", Integer.class);
		yearsInsured.question.set(createConstantText("How many years have you been insured?"));
		AttributeDesign mileage = createAttribute(driver, "mileage", String.class);
		mileage.question.set(createConstantText("Annual mileage"));
		mileage.domain.add(createDomainEntry("k1", "< 7.500 km"));	
		mileage.domain.add(createDomainEntry("k2", "7.500 km - 12.000 km"));	
		mileage.domain.add(createDomainEntry("k1", "> 12.000 km"));	
		AttributeDesign noClaimsDiscount = createAttribute(driver, "noClaimsDiscount", Integer.class);
		noClaimsDiscount.question.set(createConstantText("Number of years 'no claims discount' entitlement?"));
		RelationDesign driverRelation = createRelation(carinsuranceCase, "driver", RelationType.OneToOneAggregation, "carinsuranceCase", driver);

		// PageFragments
		SelectDesign selectDriver = createSelect(createDeduction(driverRelation));
		HeaderDesign driverHeader = createHeader(createConstantText("Driver"));
		addContent(selectDriver, driverHeader);
		CompositePageFragmentDesign driverFields = createCompositePageFragment();
		addContent(driverHeader, driverFields);
		createField(driverFields, dateOfBirth, true);
		createField(driverFields, yearsInsured, true);
		createField(driverFields, yearsDriverslicense, true);
		createField(driverFields, noClaimsDiscount, true);
		createField(driverFields, disqualified, true);
		createField(driverFields, carUse, true);
		createField(driverFields, mileage, true);
		createField(driverFields, zipCode, true);
		
		// Flows
		EventDesign next = createEvent("Next");
		FlowDesign insureFlow = createFlow("Insure");
		PageDesign insureDriverPage = createPage(insureFlow, "Driver");
		FlowSourceDesign insureStartSource = createSource(insureFlow, null, insureDriverPage, null);
		insureDriverPage.content.set(selectDriver);
		applicationDesign.exposedFlows.add(insureFlow);
		
		// Finish up
		
		return applicationDesign;
	}
}

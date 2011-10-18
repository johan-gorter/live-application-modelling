package lbe.designerbootstrap;

import java.util.Date;

import lbe.designerbootstrap.Bootstrapper.RelationType;
import lbe.engine.CasePersister;
import app.designer.data.instance.ApplicationInstance;
import app.designer.data.instance.AttributeInstance;
import app.designer.data.instance.CompositePageFragmentInstance;
import app.designer.data.instance.EntityInstance;
import app.designer.data.instance.FlowInstance;
import app.designer.data.instance.FlowSourceInstance;
import app.designer.data.instance.HeaderInstance;
import app.designer.data.instance.PageInstance;
import app.designer.data.instance.RelationInstance;
import app.designer.data.instance.SelectInstance;

public class CarinsuranceBootstrapper extends BootstrapperUtil {

	public static ApplicationInstance createCarinsurance() {

		// Case
		applicationInstance = new ApplicationInstance();
		applicationInstance.name.set("CarInsuranceTest");
		
		// Data
		EntityInstance carinsuranceCase = createEntity("CarinsuranceCase", null);
		applicationInstance.caseEntity.set(carinsuranceCase);
		EntityInstance driver = createEntity("Driver", null);
		AttributeInstance dateOfBirth = createAttribute(driver, "dateOfBirth", Date.class);
		dateOfBirth.question.set(createConstantText("Date of birth"));
		AttributeInstance carUse = createAttribute(driver, "carUse", String.class);
		carUse.multivalue.set(true);
		carUse.domain.add(createDomainEntry("private", "Private"));
		carUse.domain.add(createDomainEntry("business", "Business"));
		carUse.question.set(createConstantText("How will the car be used?"));
		AttributeInstance disqualified = createAttribute(driver, "disqualified", Boolean.class);
		disqualified.question.set(createConstantText("Have you been disqualified in the last 5 years?"));
		AttributeInstance zipCode = createAttribute(driver, "zipCode", String.class);
		zipCode.question.set(createConstantText("ZIP code"));
		AttributeInstance yearsDriverslicense = createAttribute(driver, "yearsDriverslicense", Integer.class);
		yearsDriverslicense.question.set(createConstantText("How many years have you held your drivers licence?"));
		AttributeInstance yearsInsured = createAttribute(driver, "yearsInsured", Integer.class);
		yearsInsured.question.set(createConstantText("How many years have you been insured?"));
		AttributeInstance mileage = createAttribute(driver, "mileage", String.class);
		mileage.question.set(createConstantText("Annual mileage"));
		mileage.domain.add(createDomainEntry("k1", "< 7.500 km"));	
		mileage.domain.add(createDomainEntry("k2", "7.500 km - 12.000 km"));	
		mileage.domain.add(createDomainEntry("k1", "> 12.000 km"));	
		AttributeInstance noClaimsDiscount = createAttribute(driver, "noClaimsDiscount", Integer.class);
		noClaimsDiscount.question.set(createConstantText("Number of years 'no claims discount' entitlement?"));
		RelationInstance driverRelation = createRelation(carinsuranceCase, "driver", RelationType.OneToOneAggregation, "carinsuranceCase", driver);

		// PageFragments
		SelectInstance selectDriver = createSelect(driverRelation);
		HeaderInstance driverHeader = createHeader(createConstantText("Driver"));
		addContent(selectDriver, driverHeader);
		CompositePageFragmentInstance driverFields = createCompositePageFragment();
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
		FlowInstance insureFlow = createFlow("Insure");
		FlowSourceInstance insureStartSource = createStartSource(insureFlow, "start");
		PageInstance insureDriverPage = createPage(insureFlow, "Driver");
		insureDriverPage.content.set(selectDriver);
		createEdge(insureFlow, insureStartSource, "start", insureDriverPage, null);
		applicationInstance.exposedFlows.add(insureFlow);
		
		// Finish up
		
		return applicationInstance;
	}
}

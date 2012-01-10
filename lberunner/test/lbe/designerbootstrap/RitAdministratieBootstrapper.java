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

public class RitAdministratieBootstrapper extends BootstrapperUtil {

	public static ApplicationDesignCustomization createRitAdministratie() {

		// Case
		applicationDesign = new ApplicationDesignCustomization();
		applicationDesign.name.set("RitAdministratie");
		
		// Data
		EntityDesign jaar = createEntity("Jaar", null);
		EntityDesign auto = createEntity("Auto", null);
		EntityDesign maand = createEntity("Maand", null);
		EntityDesign dag = createEntity("Dag", null);
		EntityDesign rit = createEntity("Rit", null);
		EntityDesign stand = createEntity("Stand", null);
		EntityDesign traject = createEntity("Traject", null);
		EntityDesign ijking = createEntity("Ijking", null);
		
		applicationDesign.caseEntity.set(jaar);

		auto.setCustomization("custom.ritadministratie.AutoCustomization");
		maand.setCustomization("custom.ritadministratie.MaandCustomization");
		
		AttributeDesign kmStand = createAttribute(stand, "kmStand", Integer.class);
		AttributeDesign adres = createAttribute(stand, "adres", String.class);
		
		AttributeDesign via = createAttribute(rit, "via", String.class);
		AttributeDesign priveKm = createAttribute(rit, "priveKm", Integer.class);
		AttributeDesign priveRit = createAttribute(rit, "priveRit", Boolean.class);
		
		AttributeDesign dagNr = createAttribute(dag, "dagNr", Integer.class);
		AttributeDesign maandNr = createAttribute(maand, "maandNr", Integer.class);
		AttributeDesign jaartal = createAttribute(jaar, "jaartal", Integer.class);
		
		AttributeDesign kenteken = createAttribute(auto, "kenteken", String.class);

		RelationDesign autoRelation = createRelation(jaar, "autos", RelationType.OneToManyAggregation, "jaar", auto);
		RelationDesign maandRelation = createRelation(auto, "maanden", RelationType.OneToManyAggregation, "auto", maand);
		RelationDesign dagRelation = createRelation(maand, "dagen", RelationType.OneToManyAggregation, "maand", dag);
		RelationDesign opnameRelation = createRelation(dag, "ritten", RelationType.OneToManyAggregation, "dag", rit);
		RelationDesign eindstandRelation = createRelation(rit, "eindstand", RelationType.OneToOneAggregation, "eindstandVanRit", stand);
		RelationDesign beginstandRelation = createRelation(rit, "beginstand", RelationType.OneToZeroOrOne, "beginstandVanRit", stand);
		RelationDesign autoBeginstandRelation = createRelation(auto, "beginstand", RelationType.OneToOneAggregation, "beginstandVanAuto", stand);
		RelationDesign ijkingenRelation = createRelation(jaar, "ijkingen", RelationType.OneToManyAggregation, "jaar", ijking);
		
		return applicationDesign;
	}
}

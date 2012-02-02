package custom.ritadministratie;

import java.util.Date;

import org.instantlogic.core.CaseInstance;

import app.ritadministratie.Auto;
import app.ritadministratie.Dag;
import app.ritadministratie.Maand;

public class AutoCustomization extends Auto {

	public AutoCustomization(CaseInstance caseInstance, long id) {
		super(caseInstance, id);
	}

	public void initMaanden() {
		for (int i=1;i<=12;i++) {
			Maand maand = new Maand(getCase());
			maand.setMaandNr(i);
			maanden.add(maand);
			initMaand(maand);
		}
	}

	@SuppressWarnings("deprecation")
	private void initMaand(Maand maand) {
		for (int i=0;i<31;i++) {
			Date date = new Date(getJaar().getJaartal()-1900, maand.getMaandNr()-1, i+1);
			if (date.getMonth()!=maand.getMaandNr()-1) break;
			Dag dag = new Dag(getCase());
			dag.setDagNr(i+1);
			maand.dagen.add(dag);
		}
	}
}

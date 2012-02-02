package custom.ritadministratie;

import java.util.List;


import org.instantlogic.core.deduction.Deduction;
import org.instantlogic.core.util.DeductionContext;

import app.ritadministratie.Dag;
import app.ritadministratie.Maand;
import app.ritadministratie.Rit;
import app.ritadministratie.Stand;
import app.ritadministratie.entity.MaandEntity;

public class MaandBeginstandDeductionCustomization extends Deduction<Stand> {

	@Override
	public Stand deduct(DeductionContext context) {
		Maand maand = (Maand) context.getSelectedInstance(MaandEntity.INSTANCE);
		List<Maand> maanden = maand.getAuto().getMaanden();
		int maandIndex = maanden.indexOf(maand);
		if (maandIndex==0) return maand.getAuto().getBeginstand();
		Maand vorigeMaand = maanden.get(maandIndex-1);
		List<Dag> dagen = vorigeMaand.getDagen();
		for (int i=dagen.size()-1;i>=0;i--) {
			Dag dag = dagen.get(i);
			List<Rit> ritten = dag.getRitten();
			if (ritten.size()>0) {
				return ritten.get(ritten.size()-1).getEindstand();
			}
		}
		return vorigeMaand.getBeginstand();
	}

}

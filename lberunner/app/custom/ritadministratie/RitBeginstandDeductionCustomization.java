package custom.ritadministratie;

import java.util.List;
import java.util.ListIterator;

import lbe.engine.DeductionContext;
import lbe.model.deduction.Deduction;
import app.ritadministratie.Dag;
import app.ritadministratie.Maand;
import app.ritadministratie.Rit;
import app.ritadministratie.Stand;
import app.ritadministratie.entity.RitEntity;

public class RitBeginstandDeductionCustomization extends Deduction<Stand> {

	@Override
	public Stand deduct(DeductionContext context) {
		Rit rit = (Rit) context.getSelectedInstance(RitEntity.INSTANCE);
		Dag dag = rit.getDag();
		Rit vorigeRit = null;
		for (Rit r : dag.getRitten()) {
			if (rit==r) {
				break;
			}
			vorigeRit = r;
		}
		if (vorigeRit!=null) {
			return vorigeRit.getEindstand();
		}
		Maand maand = dag.getMaand();
		List<Dag> dagen = maand.getDagen();
		for (int i=dagen.indexOf(dag)-1;i>=0;i--) {
			Dag d = dagen.get(i);
			List<Rit> ritten = d.getRitten();
			if (ritten.size()>0) {
				return ritten.get(ritten.size()-1).getEindstand();
			}
		}
		return maand.getBeginstand();
	}

}

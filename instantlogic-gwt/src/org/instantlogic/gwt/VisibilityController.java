package org.instantlogic.gwt;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.deduction.Deduction;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.SingleInstanceDeductionContext;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;

import com.google.gwt.user.client.ui.Widget;

public class VisibilityController extends Controller {

	// TODO: Create a generic DeductionObserver which updates on transaction completed
	
	private ValueChangeObserver outdatedListener = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			update();
		}
	};
	
	private Widget widget;
	private Instance instance;
	private Deduction<Boolean> deduction;

	private ObservationsOutdatedObserver observationsOutdatedObserver;

	public VisibilityController(Deduction<Boolean> deduction, Instance instance, Widget widget) {
		this.deduction = deduction;
		this.instance = instance;
		this.widget = widget;
		update();
	}
	
	protected void update() {
		SingleInstanceDeductionContext context = new SingleInstanceDeductionContext(instance);
		CaseAdministration caseAdministration = instance.getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		boolean visible = deduction.deduct(context).getValue()==Boolean.TRUE;
		widget.setVisible(visible);
		Observations observations = caseAdministration.stopRecordingObservations();
		observationsOutdatedObserver = new ObservationsOutdatedObserver(observations, outdatedListener);
	}

	@Override
	public void close() {
		observationsOutdatedObserver.remove();
	}

	@Override
	public Widget getView() {
		return widget;
	}
}

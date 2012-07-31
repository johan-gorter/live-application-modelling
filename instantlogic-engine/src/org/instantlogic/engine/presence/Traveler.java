package org.instantlogic.engine.presence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;

public class Traveler extends AbstractTraveler {

	private static final Map<String, Object> PLACE_NOT_FOUND = new LinkedHashMap<String, Object>();
	static  {
		PLACE_NOT_FOUND.put("id", "1");
		PLACE_NOT_FOUND.put("type", "Page");
		PLACE_NOT_FOUND.put("pageType", "error");
		PLACE_NOT_FOUND.put("reason", "notfound");
	}
	
	private final TravelerProxy proxy;
	private final TravelerInfo travelerInfo;
	private final CaseManager caseManager;
	private final List<Update> queue = new ArrayList<Update>();

	private boolean placeOutdated;
	
	private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			placeOutdated = true;
			placeOutdatedObserver = null;
		}
	};
	
	private ObservationsOutdatedObserver placeOutdatedObserver;
	
	public Traveler(TravelerProxy proxy, CaseManager caseManager) {
		this.caseManager = caseManager;
		this.proxy = proxy;
		this.travelerInfo = proxy.getTravelerInfo();
		setId(travelerInfo.getTravelerId());
	}
	
	public void queuePlaceIfNeeded() {
		if (this.placeOutdated) {
			queuePlace();
		}
	}
	
	public Update queuePlace() {
		if (placeOutdatedObserver!=null) {
			placeOutdatedObserver.remove();
			placeOutdatedObserver = null;
		}
		
		Update update = new Update();
		update.setName("place");
		
		RenderContext renderContext = findPage();
		if (renderContext==null) {
			update.setRootFragment(PLACE_NOT_FOUND);
			return update;
		}
		PlaceTemplate placeTemplate = (PlaceTemplate)renderContext.getFlowContext().getFlowStack().getCurrentNode();
		
		CaseAdministration caseAdministration = renderContext.getCaseInstance().getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		update.setRootFragment(placeTemplate.render(renderContext));
		Observations observations = caseAdministration.stopRecordingObservations();

		placeOutdated = false;
		placeOutdatedObserver = new ObservationsOutdatedObserver(observations, placeOutdatedValueChangeObserver);
		return update;
	}
	
	public void queuePresenceIfNeeded() {
		
	}
	
	public void sendQueuedUpdates() {
		this.proxy.sendUpdates(queue);
		queue.clear();
	}
	
	private RenderContext findPage() {
		try {
			Application application = this.caseManager.getApplicationManager().getApplication();
			return RenderContext.create(application.getMainFlow(), getCurrentPlace().getUrl(), caseManager.getCase(), caseManager.getCaseId(), travelerInfo);
		} catch (NoSuchElementException e) {
			return null;
		}
	}
}

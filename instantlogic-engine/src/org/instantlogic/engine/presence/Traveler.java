package org.instantlogic.engine.presence;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.engine.presence.flow.MainFlow;
import org.instantlogic.engine.presence.flow.main.PresencePlaceTemplate;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.FlowStack;
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

	private boolean presenceOutdated;
	private boolean placeOutdated;
	
	private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			placeOutdated = true;
			placeOutdatedObserver = null;
		}
	};
	
	private ObservationsOutdatedObserver placeOutdatedObserver;
	
	public Traveler() {
		throw new RuntimeException("Not yet implemented");
	}
	
	public Traveler(TravelerProxy proxy, CaseManager caseManager) {
		this.caseManager = caseManager;
		this.proxy = proxy;
		this.travelerInfo = proxy.getTravelerInfo();
		setId(travelerInfo.getTravelerId());
	}
	
	public void queuePlaceIfNeeded() {
		if (this.placeOutdated) {
			queue.add(renderPlace());
		}
	}
	
	public Update renderPlace() {
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
		if (this.presenceOutdated) {
			queue.add(renderPresence());
		}
	}
	
	public Update renderPresence() {
		FlowContext flowContext = new FlowContext(caseManager.getPresence(), "presence", getTravelerInfo());
		FlowStack flowStack = new FlowStack(null, MainFlow.INSTANCE);
		flowStack.pushSelectedInstance(getUser());
		flowContext.setFlowStack(flowStack);
		RenderContext renderContext = new RenderContext(flowContext, getUser().getMetadata().getInstanceId()+"/Presence");
		CaseAdministration caseAdministration = caseManager.getPresence().getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		Map<String, Object> result = PresencePlaceTemplate.INSTANCE.render(renderContext);
		Observations observations = caseAdministration.stopRecordingObservations();
		Update update = new Update();
		update.setName("presence");
		update.setRootFragment(result);
		return update;
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

	public TravelerProxy getProxy() {
		return proxy;
	}

	public TravelerInfo getTravelerInfo() {
		return travelerInfo;
	}
}

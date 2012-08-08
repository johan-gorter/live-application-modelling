package org.instantlogic.engine.presence;

import java.util.ArrayList;
import java.util.Collections;
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

/**
 * Represents a traveler in the Presence application. Returning messages is possible through the TravelerProxy.
 */
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
	private List<Update> queue = new ArrayList<Update>();

	private boolean presenceOutdated = true;
	private boolean placeOutdated = true;
	
	private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			placeOutdated = true;
			placeOutdatedObserver = null;
		}
	};
	
	private ObservationsOutdatedObserver placeOutdatedObserver;

	private final ValueChangeObserver presenceOutdatedValueChangeObserver = new ValueChangeObserver() {
		@Override
		public void valueChanged(ValueChangeEvent event) {
			presenceOutdated = true;
			presenceOutdatedObserver = null;
		}
	};
	
	private ObservationsOutdatedObserver presenceOutdatedObserver;
	private ValueChangeObserver currentPlaceChangedObserver = new ValueChangeObserver() {
		
		@Override
		public void valueChanged(ValueChangeEvent event) {
			if (event.getOldStoredValue()!=null) {
				
			}
		}
	};
	
	public Traveler() {
		throw new RuntimeException("Not implemented");
	}
	
	public Traveler(TravelerProxy proxy, CaseManager caseManager) {
		this.caseManager = caseManager;
		this.proxy = proxy;
		this.travelerInfo = proxy.getTravelerInfo();
		setId(travelerInfo.getTravelerId());
		this.getCurrentPlaceRelationValue().addValueChangeObserver(currentPlaceChangedObserver);
	}
	
	public void queuePlaceIfNeeded() {
		if (this.placeOutdated && getCurrentPlace()!=null) {
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
		update.setLocation(getCurrentPlace().getUrl());
		
		RenderContext renderContext = locatePlace();
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
		if (presenceOutdatedObserver!=null) {
			presenceOutdatedObserver.remove();
			presenceOutdatedObserver = null;
		}

		FlowContext flowContext = new FlowContext(caseManager.getPresence(), "presence", getTravelerInfo());
		FlowStack flowStack = new FlowStack(null, MainFlow.INSTANCE);
		flowStack.pushSelectedInstance(getUser());
		flowContext.setFlowStack(flowStack);
		RenderContext renderContext = new RenderContext(flowContext, getUser().getMetadata().getInstanceId()+"/Presence");
		CaseAdministration caseAdministration = caseManager.getPresence().getMetadata().getCaseAdministration();
		caseAdministration.startRecordingObservations();
		Map<String, Object> result = PresencePlaceTemplate.INSTANCE.render(renderContext);
		Observations observations = caseAdministration.stopRecordingObservations();

		presenceOutdated = false;
		presenceOutdatedObserver = new ObservationsOutdatedObserver(observations, presenceOutdatedValueChangeObserver);
		
		Update update = new Update();
		update.setName("presence");
		update.setRootFragment(result);
		return update;
	}
	
	public void sendQueuedUpdates() {
		this.proxy.sendUpdates(queue);
		queue = new ArrayList<Update>();
	}
	
	private RenderContext locatePlace() {
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

	public void placeUpdated() {
		placeOutdated = true;
	}

	public void sendException(Exception exception, boolean rendering) {
		this.queue = new ArrayList<Update>();
		this.placeOutdated = false;
		this.presenceOutdated = false;

		if (presenceOutdatedObserver!=null) {
			presenceOutdatedObserver.remove();
			presenceOutdatedObserver = null;
		}

		if (placeOutdatedObserver!=null) {
			placeOutdatedObserver.remove();
			placeOutdatedObserver = null;
		}
		
		this.proxy.sendUpdates(Collections.singletonList(new Update(exception, rendering)));
	}
}

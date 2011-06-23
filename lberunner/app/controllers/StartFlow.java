package controllers;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lbe.engine.Case;
import lbe.engine.CaseManager;
import lbe.engine.ChangeContext;
import lbe.engine.PageCoordinates;
import lbe.engine.PageElement;
import lbe.instance.CaseInstance;
import lbe.model.Application;
import lbe.model.flow.Flow;

import org.apache.log4j.Logger;

import play.mvc.Controller;
import play.mvc.With;
import app.carinsurancetest.CarInsuranceTestApplication;
import app.designer.DesignerApplication;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
@With(Secure.class)
public class StartFlow extends Controller {

	private static final Logger LOG = Logger.getLogger(StartFlow.class);

	private static final List<Application> applications = Arrays.asList(new Application[]{
			CarInsuranceTestApplication.INSTANCE,
			DesignerApplication.INSTANCE
	});

	private static JsonSerializer<Date> dateSerializer = new JsonSerializer<Date>() {

		private final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat("MM/dd/yyyy");

		@Override
		public JsonElement serialize(Date arg0, Type arg1,
				JsonSerializationContext arg2) {
			return new JsonPrimitive(DATE_INTERNATIONAL.format(arg0));
		}
	};

	public static void index(String application, String startFlowName, String caseId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("index(" + application+ ", "  + caseId + ", " + startFlowName + ")");
		}
		CaseManager.fireChangesIfModelChanged();
		Application app = getApplication(application);
		if (caseId == null) {
			Case c = CaseManager.create((CaseInstance) app.getCaseModel().createInstance(null));
			redirect("StartFlow.index", application, startFlowName, c.getId());
		}
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		Flow startFlow;
		if (startFlowName == null) {
			startFlow = app.getExposedFlows()[0];
			redirect("StartFlow.index", application, startFlow.getName(), c.getId());
		}
		startFlow = app.getExposedFlow(startFlowName);
		
		render();
	}

	private static Application getApplication(String application) {
		for (Application appCandidate: applications) {
			if (appCandidate.getName().equals(application)) {
				return appCandidate;
			}
		}
		throw new RuntimeException("Unknown application: "+application);
	}

	public static void jumpToPage(String application, String startFlowName, String caseId, String pageCoordinates) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getFirstPage(" + application+ ", "  + caseId + ", " + startFlowName +  ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		Flow startFlow = app.getExposedFlow(startFlowName);

		PageElement renderedPage = c.startFlow(startFlow);
		
		renderJSON(renderedPage, dateSerializer);
	}

	public static void submit(String application, String startFlowName, String caseId, String pageCoordinates, JsonObject event, JsonObject keepAlive) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("submit(" + application+ ", "  + caseId + ", " + startFlowName +  ")");
		}
		CaseManager.fireChangesIfModelChanged();

		if (keepAlive!=null) {
			renderJSON("{}");
		}
		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		Flow startFlow = app.getExposedFlow(startFlowName);
		
		JsonArray valuesArray = event.getAsJsonArray("values");
		JsonElement submit = event.get("submit");
		JsonElement refresh = event.get("refresh");

		if (submit != null || refresh != null) {
			ChangeContext.FieldChange[] fieldChanges = new ChangeContext.FieldChange[valuesArray.size()];
			for (int i = 0; i < fieldChanges.length; i++) {
				JsonObject change = valuesArray.get(i).getAsJsonObject();
				Object value = toValue(change.get("value"));
				fieldChanges[i] = new ChangeContext.FieldChange(change.get("id").getAsString(), value);
			}
			c.submit(startFlow, PageCoordinates.parse(pageCoordinates), fieldChanges,
					submit == null ? null : submit.getAsString());
		}
		renderJSON("{}");
	}

	private static Object toValue(JsonElement jsonElement) {
		if (jsonElement.isJsonArray()) {
			JsonArray array = jsonElement.getAsJsonArray();
			Object[] result = new Object[array.size()];
			for (int i = 0; i < array.size(); i++) {
				result[i] = toValue(array.get(i));
			}
			return result;
		}
		JsonPrimitive jsonValue = jsonElement.getAsJsonPrimitive();
		return jsonValue.isBoolean() ? jsonValue.getAsBoolean() : jsonValue
				.isNumber() ? jsonValue.getAsNumber() : jsonValue.getAsString();
	}

	public static void waitForPageChange(String application, String startFlowName, String caseId, String pageCoordinates, int lastCaseVersion) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("waitForPageChange(" + application+ ", "  + caseId + ", " + startFlowName  + ", " + lastCaseVersion + ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		Flow startFlow = app.getExposedFlow(startFlowName);
		
		PageElement page = await(c.waitForChange(lastCaseVersion, startFlow, PageCoordinates.parse(pageCoordinates)));
		renderJSON(page, dateSerializer);
	}
}

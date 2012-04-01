package controllers;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.apache.log4j.Logger;
import org.instantlogic.designer.DesignerApplication;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.page.PageElement;
import org.instantlogic.interaction.util.ChangeContext;
import org.instantlogic.interaction.util.PageCoordinates;

import play.classloading.HotswapAgent;
import play.mvc.Controller;
import play.mvc.With;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import controllers.Secure.Security;
@With(Secure.class)
public class StartFlow extends Controller {

	static {
		HotswapAgent.enabled = false;
	}
	
	private static final Logger LOG = Logger.getLogger(StartFlow.class);

	private static final List<Application> applications = Arrays.asList(new Application[]{
//			CarInsuranceApplication.INSTANCE,
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

	public static void index(String application, String caseId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("index(" + application+ ", "  + caseId + ")");
		}
		CaseManager.fireChangesIfModelChanged();
		Application app = getApplication(application);
		if (caseId == null) {
			Case c = CaseManager.create((CaseInstance) app.getCaseModel().createInstance(null));
			redirect("StartFlow.index", application, c.getId());
		}
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		String sessionId = c.startSession(Security.connected(), null);
		renderArgs.put("sessionId", sessionId);
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

	public static void jumpToPage(String application, String caseId, String pageCoordinates, String sessionId) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("jumpToPage(" + application+ ", "  + caseId +  ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		PageCoordinates coordinates = PageCoordinates.parse(pageCoordinates);

		PageElement renderedPage = c.renderOrStartFlow(app, coordinates, sessionId, Security.connected());
		
		renderJSON(renderedPage, dateSerializer);
	}

	public static void submit(String application, String caseId, String pageCoordinates, String sessionId, JsonObject event, JsonObject keepAlive) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("submit(" + application+ ", "  + caseId +  ")");
		}
		CaseManager.fireChangesIfModelChanged();

		if (keepAlive!=null) {
			renderJSON("{}");
		}
		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		
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
			c.submit(app, PageCoordinates.parse(pageCoordinates),  sessionId, Security.connected(), 
					fieldChanges, submit == null ? null : submit.getAsString());
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
		if (jsonElement.isJsonNull()) {
			return null;
		}
		JsonPrimitive jsonValue = jsonElement.getAsJsonPrimitive();
		return jsonValue.isBoolean() ? jsonValue.getAsBoolean() : jsonValue
				.isNumber() ? jsonValue.getAsNumber() : jsonValue.getAsString();
	}

	public static void waitForPageChange(String application, String caseId, String pageCoordinates, String sessionId, int lastCaseVersion) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("waitForPageChange(" + application+ ", "  + caseId + ", " + lastCaseVersion + ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Application app = getApplication(application);
		Case c = CaseManager.getCase(caseId, app.getCaseInstanceClass());
		
		PageElement page = await(c.waitForChange(lastCaseVersion, app, PageCoordinates.parse(pageCoordinates), sessionId, Security.connected()));
		renderJSON(page, dateSerializer);
	}
}

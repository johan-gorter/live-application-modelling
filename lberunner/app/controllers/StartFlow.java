package controllers;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lbe.engine.Case;
import lbe.engine.CaseManager;
import lbe.engine.ChangeContext;
import lbe.engine.Navigator;
import lbe.engine.PageElement;
import lbe.engine.Session;
import lbe.model.Application;
import lbe.model.flow.Flow;

import org.apache.log4j.Logger;

import play.mvc.Controller;
import app.carinsurancetest.CarInsuranceTestApplication;
import app.carinsurancetest.data.instance.CarinsuranceCaseInstance;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class StartFlow extends Controller {

	private static final Logger LOG = Logger.getLogger(StartFlow.class);

	private static final Application application = CarInsuranceTestApplication.INSTANCE;
	private static final Class<CarinsuranceCaseInstance> caseInstanceClass = CarinsuranceCaseInstance.class; 

	private static JsonSerializer<Date> dateSerializer = new JsonSerializer<Date>() {

		private final DateFormat DATE_INTERNATIONAL = new SimpleDateFormat(
				"MM/dd/yyyy");

		@Override
		public JsonElement serialize(Date arg0, Type arg1,
				JsonSerializationContext arg2) {
			return new JsonPrimitive(DATE_INTERNATIONAL.format(arg0));
		}
	};

	public static void index(String caseId, String startFlowName) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("index(" + caseId + ", " + startFlowName + ")");
		}
		CaseManager.fireChangesIfModelChanged();
		Case c;
		if (caseId == null) {
			c = CaseManager.create(new CarinsuranceCaseInstance());
		} else {
			c = CaseManager.getCase(caseId, caseInstanceClass);
		}
		Flow startFlow;
		if (startFlowName == null) {
			startFlow = application.getExposedFlows()[0];
		} else {
			startFlow = application.getExposedFlow(startFlowName);
		}
		Session lbeSession = Navigator.startFlow(c, startFlow);
		redirect("StartFlow.continueSession", lbeSession.format());
	}

	public static void continueSession(String formattedSession) {
		renderArgs.put("formattedSession", formattedSession);
		render();
	}

	public static void getFirstPage(String formattedSession) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getFirstPage(" + formattedSession + ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Session lbesession = Session.parse(formattedSession, application);
		Case c = CaseManager.getCase(lbesession.getCaseId(), caseInstanceClass);
		renderJSON(c.render(lbesession), dateSerializer);
	}

	public static void submit(String formattedSession, JsonObject event, JsonObject keepAlive) {
		if (keepAlive!=null) {
			renderJSON("{}");
		}
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
			Session lbesession = Session.parse(formattedSession, application);
			Case c = CaseManager.getCase(lbesession.getCaseId(), caseInstanceClass);
			c.submit(lbesession, fieldChanges,
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

	public static void waitForPageChange(String formattedSession, int lastCaseVersion) {
		if (LOG.isDebugEnabled()) {
			LOG.debug("waitForPageChange(" + formattedSession + ", " + lastCaseVersion + ")");
		}
		CaseManager.fireChangesIfModelChanged();

		Session lbesession = Session.parse(formattedSession, application);
		Case c = CaseManager.getCase(lbesession.getCaseId(), caseInstanceClass);
		PageElement page = await(c.waitForChange(lastCaseVersion, lbesession));
		renderJSON(page, dateSerializer);
	}
}

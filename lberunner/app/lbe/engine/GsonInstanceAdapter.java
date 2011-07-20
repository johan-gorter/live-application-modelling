package lbe.engine;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.value.AttributeValue;
import lbe.instance.value.AttributeValues;
import lbe.instance.value.ReadOnlyAttributeValue;
import lbe.instance.value.RelationValue;
import lbe.instance.value.RelationValues;
import lbe.instance.value.impl.AttributeValueImpl;
import lbe.instance.value.impl.RelationValueImpl;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonInstanceAdapter implements JsonSerializer<Instance>, JsonDeserializer<Instance> {

	public static final SimpleDateFormat UNIVERSAL_DATE = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public JsonElement serialize(Instance src, Type typeOfSrc, JsonSerializationContext context) {
		Entity entity = src.getModel();
		JsonObject result = new JsonObject();
		result.add("instanceId", new JsonPrimitive(src.getInstanceId()));
		result.add("entityName", new JsonPrimitive(entity.getName()));
		if (src instanceof CaseInstance) {
			result.add("version", new JsonPrimitive(((CaseInstance)src).getVersion()));
		}
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				AttributeValue attributeValue = (AttributeValue) attribute.get(src);
				if (attributeValue.isStored()) {
					if (attribute.isMultivalue()) {
						AttributeValues attributeValues = (AttributeValues) attributeValue;
						JsonArray values = new JsonArray();
						for (Object value : (List)attributeValues.get()) {
							JsonPrimitive valueItem = toJsonPrimitive(attributeValue.get());
							values.add(valueItem);
						}
						result.add(attribute.getName(), values);
					} else {
						JsonPrimitive value = toJsonPrimitive(attributeValue.get());
						result.add(attribute.getName(), value);
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				AttributeValue attributeValue = (AttributeValue) relation.get(src);
				if (attributeValue.isStored()) {
					if (relation.isMultivalue()) {
						RelationValues target = (RelationValues)attributeValue;
						JsonArray values = new JsonArray();
						result.add(relation.getName(), values);
						for (Instance targetInstance: (List<Instance>)target.get()) {
							if (relation.isOwner()) {
								JsonElement childElement = context.serialize(targetInstance);
								values.add(childElement);
							} else {
								values.add(new JsonPrimitive(targetInstance.getInstanceId()));
							}
						}
					} else {
						RelationValue target = (RelationValue)attributeValue;
						Instance targetInstance = (Instance) target.get();
						if (relation.isOwner()) {
							JsonElement childElement = context.serialize(targetInstance);
							result.add(relation.getName(), childElement);
						} else {
							result.add(relation.getName(), new JsonPrimitive(targetInstance.getInstanceId()));
						}
					}
				}
			}
		}
		return result;
	}
	
	private JsonPrimitive toJsonPrimitive(Object value) {
		if (value instanceof Date) {
			return new JsonPrimitive(UNIVERSAL_DATE.format(value));
		} else if (value instanceof Boolean) {
			return new JsonPrimitive((Boolean) value);
		} else if (value instanceof Number) {
			return new JsonPrimitive((Number) value);
		} else {
			return new JsonPrimitive(value.toString());
		}
	}

	@Override
	public Instance deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		CaseInstance result;
		try {
			result = (CaseInstance) ((Class)typeOfT).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		JsonObject data = json.getAsJsonObject();
		result.setVersion(data.get("version").getAsInt());
		// Old id -> Instance
		Map<Long, Instance> instances = new HashMap<Long, Instance>();
		
		deserializeFirstPass(data, result, result, instances);
		deserializeSecondPass(data, result, instances);
		return result;
	}

	private void deserializeSecondPass(JsonObject data, Instance result, Map<Long, Instance> instances) {
		Entity entity = result.getModel();
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				if (data.has(relation.getName())) {
					JsonElement value = data.get(relation.getName());
					RelationValue relationValue = (RelationValue) relation.get(result);
					if (!relation.isOwner()) {
						// Set non-owning relations
						if (relation.isMultivalue()) {
							RelationValues values = (RelationValues) relationValue;
							for (JsonElement item: ((JsonArray)value)) {
								long itemId = item.getAsLong();
								values.add(instances.get(itemId));
							}
						} else {
							long itemId = value.getAsLong();
							relationValue.set(instances.get(itemId));
						}
					} else {
						// Recurse
						if (relation.isMultivalue()) {
							Iterable<Instance> targets = (Iterable<Instance>) relationValue.get();
							JsonArray items = (JsonArray) value;
							int index = 0;
							for (Instance target: targets) {
								JsonObject item = (JsonObject) items.get(index++);
								deserializeSecondPass(item, target, instances);
							}
						} else {
							Instance target = (Instance) relation.get(result).get();
							deserializeSecondPass((JsonObject) value, target, instances);
						}
					}
				}
			}
		}
	}

	private void deserializeFirstPass(JsonObject data, Instance result, CaseInstance caseInstance, Map<Long, Instance> instances) {
		long id = data.get("instanceId").getAsNumber().longValue();
		instances.put(id, result);
		Entity entity = result.getModel();
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				if (data.has(attribute.getName())) {
					JsonElement value = data.get(attribute.getName());
					AttributeValue attributeValue = (AttributeValue) attribute.get(result);
					if (attribute.isMultivalue()) {
						setMultivalueAttribute(attribute, (AttributeValues) attributeValue, value);
					} else {
						attributeValue.set(toPrimitive(attribute, value));
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				if (data.has(relation.getName())) {
					JsonElement value = data.get(relation.getName());
					AttributeValue relationValue = (RelationValue) relation.get(result);
					if (relation.isOwner()) {
						if (relation.isMultivalue()) {
							setMultivalueRelation(relation, (RelationValues)relationValue, value, result, caseInstance, instances);
						} else {
							JsonObject valueObject = value.getAsJsonObject();
							String entityName = valueObject.get("entityName").getAsString();
							long instanceId = valueObject.get("instanceId").getAsLong();
							Instance target = caseInstance.getApplication().getEntities().get(entityName).createInstance(caseInstance, instanceId);
							deserializeFirstPass(valueObject, target, caseInstance, instances);
							relationValue.set(target);
						}
					}
				}
			}
		}
	}

	private void setMultivalueRelation(Relation relation, RelationValues relationValue, JsonElement value, Instance owner, CaseInstance caseInstance, Map<Long, Instance> instances) {
		JsonArray values = (JsonArray)value;
		for (JsonElement item: values) {
			Instance target = relation.createTo(owner);
			deserializeFirstPass(item.getAsJsonObject(), target, caseInstance, instances);
			relationValue.add(target);
		}
	}

	private void setMultivalueAttribute(Attribute attribute, AttributeValues attributeValue, JsonElement value) {
		JsonArray values = (JsonArray)value;
		for (JsonElement item: values) {
			attributeValue.add(toPrimitive(attribute, item));
		}
	}

	private Object toPrimitive(Attribute attribute, JsonElement value) {
		if (attribute.getDatatype()==Date.class) {
			try {
				return UNIVERSAL_DATE.parse(value.getAsString());
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
		} else if (attribute.getDatatype()==Boolean.class) {
			return value.getAsBoolean();
		} else if (Number.class.isAssignableFrom(attribute.getDatatype())) {
			return value.getAsNumber();
		} else {
			return value.getAsString();
		}
	}
}

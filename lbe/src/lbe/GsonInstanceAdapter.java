package lbe;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lbe.instance.AttributeValue;
import lbe.instance.CaseInstance;
import lbe.instance.Instance;
import lbe.instance.SingleRelationValue;
import lbe.model.Attribute;
import lbe.model.Entity;
import lbe.model.Relation;

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
	public JsonElement serialize(Instance src, Type typeOfSrc,
			JsonSerializationContext context) {
		Entity entity = src.getModel();
		JsonObject result = new JsonObject();
		result.add("instanceId", new JsonPrimitive(src.getInstanceId()));
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				AttributeValue attributeValue = attribute.get(src);
				if (attributeValue.isStored()) {
					Object value = attributeValue.get();
					if (value instanceof Date) {
						result.add(attribute.getName(), new JsonPrimitive(UNIVERSAL_DATE.format(value)));
					} else if (value instanceof Boolean) {
						result.add(attribute.getName(), new JsonPrimitive((Boolean) value));
					} else if (value instanceof Number) {
						result.add(attribute.getName(), new JsonPrimitive((Number) value));
					} else {
						result.add(attribute.getName(), new JsonPrimitive(value.toString()));
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				AttributeValue attributeValue = relation.get(src);
				if (attributeValue.isStored()) {
					SingleRelationValue target = (SingleRelationValue)attributeValue;
					Instance targetInstance = target.get();
					if (relation.isOwner()) {
						JsonElement childElement = context.serialize(targetInstance);
						result.add(relation.getName(), childElement);
					} else {
						result.add(relation.getName(), new JsonPrimitive(targetInstance.getInstanceId()));
					}
				}
			}
		}
		return result;
	}
	
	@Override
	public Instance deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		Instance result;
		try {
			result = (Instance) ((Class)typeOfT).newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		JsonObject data = json.getAsJsonObject();
		// Old id -> Instance
		Map<Long, Instance> instances = new HashMap<Long, Instance>();
		
		deserializeFirstPass(data, result, instances);
		
		//TODO: second pass for non-owning relations
		return result;
	}

	private void deserializeFirstPass(JsonObject data, Instance result,
			Map<Long, Instance> instances) {
		long id = data.get("instanceId").getAsNumber().longValue();
		instances.put(id, result);
		Entity entity = result.getModel();
		for (Attribute attribute : entity.getAttributes()) {
			if (!attribute.isReadOnly()) {
				if (data.has(attribute.getName())) {
					JsonElement value = data.get(attribute.getName());
					AttributeValue attributeValue = attribute.get(result);
					if (attribute.getDatatype()==Date.class) {
						try {
							attributeValue.set(UNIVERSAL_DATE.parse(value.getAsString()));
						} catch (ParseException e) {
							throw new RuntimeException(e);
						}
					} else if (attribute.getDatatype()==Boolean.class) {
						attributeValue.set(value.getAsBoolean());
					} else if (Number.class.isAssignableFrom(attribute.getDatatype())) {
						attributeValue.set(value.getAsNumber());
					} else {
						attributeValue.set(value.getAsString());
					}
				}
			}
		}
		for (Relation relation : entity.getRelations()) {
			if (!relation.isReadOnly()) {
				if (data.has(relation.getName())) {
					JsonElement value = data.get(relation.getName());
					if (relation.isOwner()) {
						SingleRelationValue attributeValue = (SingleRelationValue)relation.get(result);
						Instance target = attributeValue.get();
						deserializeFirstPass(data.get(relation.getName()).getAsJsonObject(), target, instances);
					}
				}
			}
		}
	}
}

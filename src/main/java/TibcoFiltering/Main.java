package TibcoFiltering;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.json.*;

import java.lang.reflect.Type;
import java.util.*;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.text.StringEscapeUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        String queryFields = "Name";
        String response = "{\"Name\": \"John\", \"id\": 30, \"href\": \"New York\"}";
        String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]";
        System.out.println(filteringResponse(queryFields, str));
    }

    public static String filteringResponse(String queryFields, String payload) throws JsonProcessingException {
        if (!queryFields.isEmpty()) {
            HashMap<String, Object> filteredResponse = new LinkedHashMap<>();
            try {
                JSONArray array = new JSONArray(payload);
                JSONArray arrayResponse = new JSONArray();
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    arrayResponse.put(new JSONObject(filteringResponse(queryFields, String.valueOf(object))));
                }
                return String.valueOf(arrayResponse);
            } catch (Exception e) {
                JSONObject response = new JSONObject(payload);
                // filteredResponse.put("id", response.get("id"));
                // filteredResponse.put("href", response.get("href"));
                for (String field : queryFields.split(",")) {
                    if (!(response.get(field) instanceof JSONArray))
                        filteredResponse.put(field, response.get(field));
                    else {
                        filteredResponse.put(field, new ObjectMapper().readValue(StringEscapeUtils.unescapeJson(JsonPath.parse(new Gson().toJson(response.get(field))).read("$.myArrayList[*].map").toString()), new TypeReference<List<Map<String, Object>>>() {
                        }));
                    }
                }
                JsonElement jsonElement=JsonParser.parseString(new Gson().toJson(filteredResponse));
                removeKey(jsonElement.getAsJsonObject(), "myArrayList");
                removeKey(jsonElement.getAsJsonObject(), "map");
                return new Gson().toJson(jsonElement);
            }
        }
        return payload;
    }

    private static void removeKey(JsonObject jsonObject, String keyToRemove) {
        if (jsonObject.has(keyToRemove)) {
            JsonElement element = jsonObject.get(keyToRemove);
            jsonObject.remove(keyToRemove);
            if (element.isJsonObject()) {
                for (String key : element.getAsJsonObject().keySet()) {
                    jsonObject.add(key, element.getAsJsonObject().get(key));
                }
            } else if (element.isJsonArray()) {
                for (JsonElement arrayElement : element.getAsJsonArray()) {
                    if (arrayElement.isJsonObject()) {
                        for (String key : arrayElement.getAsJsonObject().keySet()) {
                            jsonObject.add(key, arrayElement.getAsJsonObject().get(key));
                        }
                    }
                }
            }
        }

        for (String key : jsonObject.keySet()) {
            JsonElement element = jsonObject.get(key);
            if (element.isJsonObject()) {
                removeKey(element.getAsJsonObject(), keyToRemove);
            } else if (element.isJsonArray()) {
                for (JsonElement arrayElement : element.getAsJsonArray()) {
                    if (arrayElement.isJsonObject()) {
                        removeKey(arrayElement.getAsJsonObject(), keyToRemove);
                    }
                }
            }
        }
    }
}

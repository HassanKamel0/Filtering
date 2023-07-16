package TibcoFiltering;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.text.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilteringResponse implements Serializable {
    public static String filteringResponse(String queryFields,String payload) throws JsonProcessingException {
        if (!queryFields.isEmpty()) {
            Map<String, Object> filteredResponse = new LinkedHashMap<>();
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
                filteredResponse.put("id",response.get("id"));
                filteredResponse.put("href",response.get("href"));
                for (String field : queryFields.split(",")) {
                    if (!(response.get(field) instanceof JSONArray))
                        filteredResponse.put(field, response.get(field));
                    else {
                        String cleanedFromAdditionalRoots = JsonPath.parse(new Gson().toJson(response.get(field))).read("$.myArrayList[*].map").toString();
                        filteredResponse.put(field, new ObjectMapper().readValue(StringEscapeUtils.unescapeJson(cleanedFromAdditionalRoots), new TypeReference<>() {
                        }));
                    }
                }
                return new ObjectMapper().writeValueAsString(filteredResponse);
            }
        }
        return payload;
    }
}
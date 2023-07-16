package TibcoFiltering;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Map;
import com.jayway.jsonpath.JsonPath;
import org.apache.commons.text.StringEscapeUtils;

public class Main {
    public static void main(String[] args) throws IOException {
        String queryFields = "isLocked,requester,attrs,items";
        String response = "{\"Name\": \"John\", \"id\": 30, \"href\": \"New York\"}";
        String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]";
        String s="{ \"id\":\"425345\", \"href\":\"http://dx10889:9090/processRequest\", \"isLocked\": false, \"biSpecification\": null, \"requester\": \"vewali\", \"requestID\": null, \"quoteOn\": null, \"attrs\": [ { \"name\": \"orderCreateDateTime\", \"value\": \"2023-05-01T11:55:12.000+04:00\" }, { \"name\": \"CONTACTS_MODIFIED\", \"value\": \"True\" }, { \"name\": \"CL_CALLBACK_URL\", \"value\": \"http://dx10889:9090/processRequest\" }, { \"name\": \"ETISALAT_PROMOTIONAL_SMS\", \"value\": \"False\" }, { \"name\": \"ETISALAT_PROMOTIONAL_CALL\", \"value\": \"False\" }, { \"name\": \"channelUserFullName\", \"value\": \"Veeresh Wali\" }, { \"name\": \"channelUserEmailId\", \"value\": \"vewali@etisalat.ae\" }, { \"name\": \"transactionID\", \"value\": \"6a029a7a-b3d5-4b99-9293-0f6b3d5bad0c\" }, { \"name\": \"priority\", \"value\": \"10\" }, { \"name\": \"SUB_CHANNEL_CODE\", \"value\": \"BCRM\" }, { \"name\": \"orderType\", \"value\": \"NEW\" }, { \"name\": \"orderSubType\", \"value\": \"NEW\" } ], \"items\": [ { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503560\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503589\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503602\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503616\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503638\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503661\" } ], \"notes\": [ { \"text\": \"g\", \"author\": \"Veeresh Wali\" } ] }";
        System.out.println(filteringResponse(queryFields,s));
    }
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
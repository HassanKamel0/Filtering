package TibcoFiltering;

import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) throws IOException {
        String queryFields = "Name";
        String response = "{\"Name\": \"John\", \"id\": 30, \"href\": \"New York\"}";
        String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]";
        System.out.println(filteringResponse(queryFields,str));
    }
    public static String filteringResponse(String queryFields,String payload) throws JsonProcessingException {
        Map<String, Object> filteredResponse=new LinkedHashMap<>();
        try {
            JSONArray array = new JSONArray(payload);
            JSONArray arrayResponse = new JSONArray();
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                arrayResponse.put(new JSONObject(filteringResponse(queryFields, String.valueOf(object))));
            }
            return String.valueOf(arrayResponse);
        }catch (Exception e) {
            JSONObject response = new JSONObject(payload);
             filteredResponse.put("id",response.get("id"));
             filteredResponse.put("href",response.get("href"));
            if (!queryFields.isEmpty())
                for (String field : queryFields.split(","))
                    filteredResponse.put(field, response.get(field));
        }
        return new ObjectMapper().writeValueAsString(filteredResponse);
    }
}
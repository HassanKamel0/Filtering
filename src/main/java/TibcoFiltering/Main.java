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
       // String returned= filteringResponse(queryFields, response);
       // System.out.println(returned);
//       String result= Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String prettyJson = gson.toJson(jsonObject);
//        System.out.println(prettyJson);
    }
    public static String filteringResponse(String queryFields,String response2) throws JsonProcessingException {
        Map<String, Object> filteredResponse=new LinkedHashMap<>();
        try {
            JSONArray array = new JSONArray(response2);
            JSONArray output = new JSONArray();
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                output.put(new JSONObject(filteringResponse(queryFields, String.valueOf(object))));
            }
            return String.valueOf(output);
        }catch (Exception e) {
            JSONObject response = new JSONObject(response2);
             filteredResponse.put("id",response.get("id"));
             filteredResponse.put("href",response.get("href"));
            if (!queryFields.isEmpty())
                for (String field : queryFields.split(","))
                    filteredResponse.put(field, response.get(field));
        }
        return new ObjectMapper().writeValueAsString(filteredResponse);
    }
}
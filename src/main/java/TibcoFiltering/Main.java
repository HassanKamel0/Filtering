package TibcoFiltering;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        String queryFields = "id,quoteID,notes,isBundled,requestedCompletionDate";
        JSONObject response = (JSONObject) new JSONParser().parse(new FileReader("\\Users\\hkamel\\Downloads\\Submit.json"));
        String returned= filteringResponse(queryFields, response);
        System.out.println(returned);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(JsonParser.parseString(String.valueOf(returned)));
        System.out.println(prettyJson);
    }
    private static String filteringResponse(String queryFields,JSONObject response) throws JsonProcessingException {
        Map<String, Object> filteredResponse=new LinkedHashMap<>();
        for (String field : queryFields.split(","))
            filteredResponse.put(field,response.get(field));
        return new ObjectMapper().writeValueAsString(filteredResponse);
    }
}
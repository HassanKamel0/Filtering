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
        String queryFields = "price,prodSpecCharValueUse";
        String response = "{\"Name\": \"John\", \"id\": 30, \"href\": \"New York\"}";
        String str = "[{\"No\":\"17\",\"Name\":\"Andrew\"},{\"No\":\"18\",\"Name\":\"Peter\"}, {\"No\":\"19\",\"Name\":\"Tom\"}]";
        String s = "{ \"id\":\"425345\", \"href\":\"http://dx10889:9090/processRequest\", \"isLocked\": false, \"biSpecification\": null, \"requester\": \"vewali\", \"requestID\": null, \"quoteOn\": null, \"attrs\": [ { \"name\": \"orderCreateDateTime\", \"value\": \"2023-05-01T11:55:12.000+04:00\" }, { \"name\": \"CONTACTS_MODIFIED\", \"value\": \"True\" }, { \"name\": \"CL_CALLBACK_URL\", \"value\": \"http://dx10889:9090/processRequest\" }, { \"name\": \"ETISALAT_PROMOTIONAL_SMS\", \"value\": \"False\" }, { \"name\": \"ETISALAT_PROMOTIONAL_CALL\", \"value\": \"False\" }, { \"name\": \"channelUserFullName\", \"value\": \"Veeresh Wali\" }, { \"name\": \"channelUserEmailId\", \"value\": \"vewali@etisalat.ae\" }, { \"name\": \"transactionID\", \"value\": \"6a029a7a-b3d5-4b99-9293-0f6b3d5bad0c\" }, { \"name\": \"priority\", \"value\": \"10\" }, { \"name\": \"SUB_CHANNEL_CODE\", \"value\": \"BCRM\" }, { \"name\": \"orderType\", \"value\": \"NEW\" }, { \"name\": \"orderSubType\", \"value\": \"NEW\" } ], \"items\": [ { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503560\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503589\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503602\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503616\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503638\" }, { \"id\": \"http://localhost:8080/eoc/on/v1/sc/203665/pooi/24196503661\" } ], \"notes\": [ { \"text\": \"g\", \"author\": \"Veeresh Wali\" } ] }";
        String e = "{\n" +
                "\t\"id\": \"base_Mobile_Common_Charge\",\n" +
                "\t\"href\": \"/TMFC001_PCM/TMF620_PCM/productOfferingPrice/base_Mobile_Common_Charge\",\n" +
                "\t\"lifecycleStatus\": \"ACT\",\n" +
                "\t\"name\": \"base_Mobile_Common_Charge\",\n" +
                "\t\"priceType\": \"CHAG\",\n" +
                "\t\"recurringChargePeriodType\": \"O\",\n" +
                "\t\"price\": {\n" +
                "\t\t\"unit\": \"AED\",\n" +
                "\t\t\"value\": 0\n" +
                "\t},\n" +
                "\t\"prodSpecCharValueUse\": [{\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"CASH_ON_DELIVERY_ALLOWED\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT03A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"CASH_ON_DELIVERY_ALLOWED\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"CONTRACT_PERIOD\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT0AA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"CONTRACT_PERIOD\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"CONTRACT_PERIOD_UNIT\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT0CA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"CONTRACT_PERIOD_UNIT\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"CONTRACT_TRANSFER\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT0BA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"CONTRACT_TRANSFER\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"DEAL_OF_THE_DAY_FLAG\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT09A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"DEAL_OF_THE_DAY_FLAG\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"DEVICE_DELIVERY_ALLOWED\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"diJyA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"DEVICE_DELIVERY_ALLOWED\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"DiscountVirtualBundleType\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"diK0A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"DiscountVirtualBundleType\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"INSURANCE_COMPANY_EMAIL_ID\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT05A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"INSURANCE_COMPANY_EMAIL_ID\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"INSURANCE_COMPANY_NAME\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT06A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"INSURANCE_COMPANY_NAME\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"INSTALLMENTS_SMARTPAY_FLAG\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"fX4gA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"INSTALLMENTS_SMARTPAY_FLAG\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"INSURANCE_ALLOWED\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT08A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"INSURANCE_ALLOWED\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"OFFER_ELIGIBILITY\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"diK4A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"OFFER_ELIGIBILITY\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"OFFER_GROUP\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"cUnzA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"OFFER_GROUP\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"PLAN_IDENTIFIER\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT07A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"PLAN_IDENTIFIER\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"PRODUCT_SEGMENT\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"1NjE9A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"PRODUCT_SEGMENT\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"SPLIT_BILLING\",\n" +
                "\t\t\"valueType\": \"CodeTable\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"BT04A\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"SPLIT_BILLING\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"WALLET_AMOUNT\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"gMqUA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"WALLET_AMOUNT\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"\"\n" +
                "\t}, {\n" +
                "\t\t\"maxCardinality\": 1,\n" +
                "\t\t\"name\": \"Amount\",\n" +
                "\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\"productSpecCharacteristicValue\": [{\n" +
                "\t\t\t\"isDefault\": true,\n" +
                "\t\t\t\"valueType\": \"Attribute Type\",\n" +
                "\t\t\t\"validFor\": {\n" +
                "\t\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"value\": \"0.0000\"\n" +
                "\t\t}],\n" +
                "\t\t\"validFor\": {\n" +
                "\t\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t\t},\n" +
                "\t\t\"type\": \"\",\n" +
                "\t\t\"translations\": [{\n" +
                "\t\t\t\"id\": \"gMqVA\",\n" +
                "\t\t\t\"fieldName\": \"name\",\n" +
                "\t\t\t\"translation\": [{\n" +
                "\t\t\t\t\"text\": \"Amount\",\n" +
                "\t\t\t\t\"language\": \"en-xx\"\n" +
                "\t\t\t}]\n" +
                "\t\t}, {\n" +
                "\t\t\t\"fieldName\": \"description\"\n" +
                "\t\t}],\n" +
                "\t\t\"displayValue\": \"0.0000\"\n" +
                "\t}],\n" +
                "\t\"validFor\": {\n" +
                "\t\t\"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "\t}\n" +
                "}";
        String q="{\n" +
                "    \"prodSpecCharValueUse\": [\n" +
                "        {\n" +
                "            \"maxCardinality\": 1,\n" +
                "            \"name\": \"CASH_ON_DELIVERY_ALLOWED\",\n" +
                "            \"valueType\": \"Attribute Type\",\n" +
                "            \"validFor\": {\n" +
                "                \"startDateTime\": \"1975-12-31T22:00:00Z\"\n" +
                "            },\n" +
                "            \"type\": \"\",\n" +
                "            \"translations\": [\n" +
                "                {\n" +
                "                    \"id\": \"BT03A\",\n" +
                "                    \"fieldName\": \"name\",\n" +
                "                    \"translation\": [\n" +
                "                        {\n" +
                "                            \"text\": \"CASH_ON_DELIVERY_ALLOWED\",\n" +
                "                            \"language\": \"en-xx\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"fieldName\": \"description\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println(filteringResponse(queryFields, e));
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
                filteredResponse.put("id", response.get("id"));
                filteredResponse.put("href", response.get("href"));
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

package com.nbnco.au.common;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class Helper {
   static Logger logger = Logger.getLogger(Helper.class);
   public static boolean flag = true;

    public static void checkStatusIs200 (Response res) {
    	assertEquals(200, res.getStatusCode(),"Http Status Check Failed!");
    }

    public static void checkStatusIs400 (Response res, String correlationId, String scenarioName) {
        if(res.getStatusCode() != 400){
            logger.error("Service HTTP Status 400 Failed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        else{
            logger.info("Service Status 400 Passed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        assertEquals(400, res.getStatusCode(),"Http Status Check Failed! : " + correlationId);
    }

    public static void checkStatusIs200 (Response res, String correlationId, String scenarioName) {
        if(res.getStatusCode() != 200){
            logger.error("Service HTTP Status 200 Failed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        else{
            logger.info("Service Status 200 Passed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        assertEquals(200, res.getStatusCode(),"Http Status Check Failed! : " + correlationId);
    }
    
    public static void checkContentInResponse (Response response, String correlationId, String scenarioName,String valuetoCheck) {
    	
        if((response.asString()).contains(valuetoCheck)){
            logger.error("Service HTTP Status 200 Failed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        else{
            logger.info("Service Status 200 Passed : ScenarioName : " + scenarioName + " : CorrelationId: " + correlationId);
        }
        assertEquals(true, flag,"Response Content Validation Failed! : " + correlationId);
    }

    public static void checkAssertEqualsTrue (boolean actualStatus , String correlationId, String scenarioName) {
        if(actualStatus != true){
            logger.error("AssertEquals Failed: ScenarioName :" + scenarioName + " : CorrelationId :" + correlationId);
        }
            assertEquals(actualStatus,true);
    }

    public static void checkAssertEqualsFalse (boolean actualStatus, String correlationId, String scenarioName) {
        if(actualStatus != false){
            logger.error("AssertEquals Failed: ScenarioName :" + scenarioName + " : CorrelationId :" + correlationId);
        }
        assertEquals(actualStatus,false);
    }

    public static void checkStatusIs200 (Response res, String uuid) {
        if(res.getStatusCode() != 200){
            logger.error("Service Failed : CorrelationId: " + uuid);
        }
        else
        {
            logger.info("Service Passed : CorrelationId: " + uuid);
        }
        assertEquals(200, res.getStatusCode(),"Http Status Check Failed! : " + uuid );
    }
    
    public static String replaceData(String request, Map<String, String> valuesMap){
    	
    	StrSubstitutor sub = new StrSubstitutor(valuesMap);
    	return sub.replace(request);
    	
    }

    public static String UUID(){
        return java.util.UUID.randomUUID().toString();
    }

    public static boolean ValidateElementIsPresent(JsonPath response, String path)
    {
        final List<String> dataCount = response.get(path);
        return dataCount.size() > 0;
    }

    public static boolean ValidateElementIsPresentAndNotEmpty(JsonPath response, String path,String correlationId, String scenarioName)
    {
        final List<String> item = response.get(path);
        boolean result =  item.size() > 0 && item != null && !item.isEmpty();
        if(result)
        {
            logger.info("AssertEquals Passed: " + scenarioName + " : CorrelationId :" + correlationId);
                    }
        else
        {
            logger.error("AssertEquals failed: " + scenarioName + " : CorrelationId :" + correlationId);
        }
        return result;
    }

    public static boolean ValidateElementIsPresentAndCompareValue(JsonPath response, String path,String correlationId, String scenarioName,String value)
    {
        final List<String> item = response.get(path);
        boolean result =  item.size() > 0 && item.contains(value);
        if(result)
        {
            logger.error("AssertEquals Passed: " + scenarioName + " : CorrelationId :" + correlationId);
        }
        else
        {
            logger.error("AssertEquals failed: " + scenarioName + " : CorrelationId :" + correlationId);
        }
        return result;
    }
    
}
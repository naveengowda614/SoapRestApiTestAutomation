package com.javacodegeeks.testng.maven;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.FileHelper;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.queryAddress;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class TestNgMavenSecondClass extends serviceBase {
	
	
	public queryAddress actualQueryAddressResponse;
	public String fileName="qaLocationId";
	
	
	@Test
	public void testQueryAddressServicewithLocationId() {
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		String correlationId = "CIS-QA-ASM-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
		String scenarioName = "Scenario Outline: Verifying the query address response when passing LocationId in request : ";
		
        RestAssuredHelper.setBaseURI(request,prop.getProperty("QueryAddressURL"));
        RestAssuredHelper.setRelaxedHTTPSValidation(request);
        RestAssuredHelper.setContentType(request,ContentType.XML);
        String requestXmlString = new FileHelper().GetXmlAsStringAndReplaceUUID(String.format(Constants.tvtResourceFolder,"queryAddress",fileName),correlationId);
        valuesMap.put("TEST_ACCESSSEEKER", prop.getProperty("TEST_ACCESSSEEKER"));
        valuesMap.put("QUERY_ADDRESS_LOCID", prop.getProperty("QUERY_ADDRESS_LOCID"));
        requestXmlString = Helper.replaceData(requestXmlString, valuesMap);
        RestAssuredHelper.setBody(request,requestXmlString);
        //System.out.println(requestXmlString);
        response = RestAssuredHelper.callAPI(request,"POST");
        actualQueryAddressResponse = new queryAddress(response);
        Helper.checkStatusIs200(response, fileName, scenarioName);
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_LOCID"));
        //System.out.println(response.asString());
    }
	
	@Test
	public void testQueryAddressServicewithGNAFID() {
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		String correlationId = "CIS-QA-ASM-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
		String scenarioName = "Scenario Outline: Verifying the query address response when passing LocationId in request : ";
		
        RestAssuredHelper.setBaseURI(request,prop.getProperty("QueryAddressURL"));
        RestAssuredHelper.setRelaxedHTTPSValidation(request);
        RestAssuredHelper.setContentType(request,ContentType.XML);
        String requestXmlString = new FileHelper().GetXmlAsStringAndReplaceUUID(String.format(Constants.tvtResourceFolder,"queryAddress",fileName),correlationId);
        valuesMap.put("TEST_ACCESSSEEKER", prop.getProperty("TEST_ACCESSSEEKER"));
        valuesMap.put("QUERY_ADDRESS_GNAFID", prop.getProperty("QUERY_ADDRESS_GNAFID"));
        requestXmlString = Helper.replaceData(requestXmlString, valuesMap);
        RestAssuredHelper.setBody(request,requestXmlString);
        //System.out.println(requestXmlString);
        response = RestAssuredHelper.callAPI(request,"POST");
        actualQueryAddressResponse = new queryAddress(response);
        Helper.checkStatusIs200(response, fileName, scenarioName);
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_GNAFID"));
        //System.out.println(response.asString());
    }
	
	
	@Test
	public void testQueryAddressServicewithSpatialGeocode() {
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		String correlationId = "CIS-QA-ASM-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
		String scenarioName = "Scenario Outline: Verifying the query address response when passing LocationId in request : ";
		
        RestAssuredHelper.setBaseURI(request,prop.getProperty("QueryAddressURL"));
        RestAssuredHelper.setRelaxedHTTPSValidation(request);
        RestAssuredHelper.setContentType(request,ContentType.XML);
        String requestXmlString = new FileHelper().GetXmlAsStringAndReplaceUUID(String.format(Constants.tvtResourceFolder,"queryAddress",fileName),correlationId);
        valuesMap.put("TEST_ACCESSSEEKER", prop.getProperty("TEST_ACCESSSEEKER"));
        valuesMap.put("QUERY_ADDRESS_LATITUDE", prop.getProperty("QUERY_ADDRESS_LATITUDE"));
        valuesMap.put("QUERY_ADDRESS_LONGITUDE", prop.getProperty("QUERY_ADDRESS_LONGITUDE"));
        requestXmlString = Helper.replaceData(requestXmlString, valuesMap);
        RestAssuredHelper.setBody(request,requestXmlString);
        //System.out.println(requestXmlString);
        response = RestAssuredHelper.callAPI(request,"POST");
        actualQueryAddressResponse = new queryAddress(response);
        Helper.checkStatusIs200(response, fileName, scenarioName);
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_LATITUDE"));
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_LONGITUDE"));
        //System.out.println(response.asString());
    }
	
	@Test
	public void testQueryAddressServicewithInCorrectPA() {
		
		Map<String, String> valuesMap = new HashMap<String, String>();
		String correlationId = "CIS-QA-ASM-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
		String scenarioName = "Scenario Outline: Verifying the query address response when passing LocationId in request : ";
		
        RestAssuredHelper.setBaseURI(request,prop.getProperty("QueryAddressURL"));
        RestAssuredHelper.setRelaxedHTTPSValidation(request);
        RestAssuredHelper.setContentType(request,ContentType.XML);
        String requestXmlString = new FileHelper().GetXmlAsStringAndReplaceUUID(String.format(Constants.tvtResourceFolder,"queryAddress",fileName),correlationId);
        valuesMap.put("TEST_ACCESSSEEKER", prop.getProperty("TEST_ACCESSSEEKER"));
        valuesMap.put("QUERY_ADDRESS_LATITUDE", prop.getProperty("QUERY_ADDRESS_LATITUDE"));
        valuesMap.put("QUERY_ADDRESS_LONGITUDE", prop.getProperty("QUERY_ADDRESS_LONGITUDE"));
        requestXmlString = Helper.replaceData(requestXmlString, valuesMap);
        RestAssuredHelper.setBody(request,requestXmlString);
        //System.out.println(requestXmlString);
        response = RestAssuredHelper.callAPI(request,"POST");
        actualQueryAddressResponse = new queryAddress(response);
        Helper.checkStatusIs200(response, fileName, scenarioName);
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_LATITUDE"));
        Helper.checkContentInResponse(response, correlationId, scenarioName, prop.getProperty("QUERY_ADDRESS_LONGITUDE"));
        //System.out.println(response.asString());
    }
}

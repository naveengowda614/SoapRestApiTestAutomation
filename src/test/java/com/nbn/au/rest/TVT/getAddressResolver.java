package com.nbn.au.rest.TVT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class getAddressResolver extends serviceBase {

    String correlationId = "CIS-AddressResolver-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
    String scenarioName = "Scenario: Verify the response for the Address Resolver API request : ";

    @Test
    public void addressResolverMakeTheRequestToTheAddressResolverAPI()  {
        RestAssuredHelper.setBaseURI(request,prop.getProperty("GetAddressResolverUrl"));
        RestAssuredHelper.setRelaxedHTTPSValidation(request); // Relax HTTPS Validation
        RestAssuredHelper.setContentType(request,ContentType.JSON);
        RestAssuredHelper.setQueryParam(request,"stateTerritoryCode","VIC");
        RestAssuredHelper.setQueryParam(request,"localityName","MELBOURNE");
        RestAssuredHelper.setQueryParam(request,"startsWith","S");
        RestAssuredHelper.setQueryParam(request,"limit","3");
        RestAssuredHelper.setHeader(request,Constants.nbnCorrelationID,correlationId);
        response = RestAssuredHelper.callAPI(request,"GET"); //Get response
        jsonResponse = RestAssuredHelper.getJsonPath(response);
        Helper.checkStatusIs200(response,correlationId,scenarioName);
        assertEquals(jsonResponse.get("response.roadName[0]").toString().startsWith("S"),true);
    }

     
}

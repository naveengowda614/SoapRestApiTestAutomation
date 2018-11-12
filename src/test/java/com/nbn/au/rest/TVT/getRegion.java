package com.nbn.au.rest.TVT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class getRegion extends serviceBase {

    String correlationId = "CIS-getRegion-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
    String scenarioName = "Scenario: Verify the response for the getRegion API request : ";

    @Test
    public void getRegionMakeTheRequestToTheGetRegionAPI()  {
        RestAssuredHelper.setBaseURI(request,String.format(prop.getProperty("GetRegionUrl"),prop.getProperty("REGION_LOCID")));
        RestAssuredHelper.setRelaxedHTTPSValidation(request); // Relax HTTPS Validation
        RestAssuredHelper.setContentType(request,ContentType.JSON);
        RestAssuredHelper.setHeader(request,Constants.accessSeekerID,prop.getProperty("TEST_ACCESSSEEKER"));
        RestAssuredHelper.setHeader(request,Constants.businessChannel,"CIS");
        RestAssuredHelper.setHeader(request,Constants.correlationID,correlationId);
        RestAssuredHelper.setHeader(request,Constants.nbnCorrelationID,correlationId);
        response = RestAssuredHelper.callAPI(request,"GET"); //Get response
        jsonResponse = RestAssuredHelper.getJsonPath(response);
        Helper.checkStatusIs200(response,correlationId,scenarioName);
        int count = 0;
        if(jsonResponse.get("slr") != null){
             count = jsonResponse.get("slr.size()");
         }
         assertEquals(count > 0,true);
    }
}
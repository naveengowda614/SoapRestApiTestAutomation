package com.nbn.au.rest.TVT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class getProdInst extends serviceBase {

    String correlationId = "CIS-getProdInst-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
    String scenarioName = "Scenario: Verify the response for the getProdInst API request : ";

    @Test
    public void getProdInstMakeTheRequestToTheGetProdInstAPI()  {
        RestAssuredHelper.setBaseURI(request,String.format(prop.getProperty("GetProdInstUrl"),prop.getProperty("PRI_ID")));
        RestAssuredHelper.setRelaxedHTTPSValidation(request); // Relax HTTPS Validation
        RestAssuredHelper.setContentType(request,ContentType.JSON);
        RestAssuredHelper.setHeader(request,Constants.accessSeekerID,prop.getProperty("TEST_ACCESSSEEKER"));
        RestAssuredHelper.setHeader(request,Constants.businessChannel,"CIS");
        RestAssuredHelper.setHeader(request,Constants.correlationID,correlationId);
        RestAssuredHelper.setHeader(request,Constants.nbnCorrelationID,correlationId);
        response = RestAssuredHelper.callAPI(request,"GET"); //Get response
        jsonResponse = RestAssuredHelper.getJsonPath(response);
        Helper.checkStatusIs200(response,correlationId,scenarioName);
        assertEquals(jsonResponse.get("data[0].id").toString().startsWith("PRI"),true);
    }
}
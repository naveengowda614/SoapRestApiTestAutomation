package com.nbn.au.rest.TVT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class LocFeas extends serviceBase {

    String correlationId = "CIS-LocFeas-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
    String scenarioName = "Scenario: Verify the response for the LocFeas API request : ";

    @Test
    public void locFeasMakeTheRequestToTheLocFeasAPI()  {
        RestAssuredHelper.setBaseURI(request,String.format(prop.getProperty("LocFeasibilityUrl"),prop.getProperty("LOCATION_FEASIBILITY_FTTC")));
        RestAssuredHelper.setRelaxedHTTPSValidation(request); // Relax HTTPS Validation
        RestAssuredHelper.setContentType(request,ContentType.JSON);
        RestAssuredHelper.setHeader(request,Constants.accessSeekerID,prop.getProperty("TEST_ACCESSSEEKER"));
        RestAssuredHelper.setHeader(request,Constants.businessChannel,"CIS");
        RestAssuredHelper.setHeader(request,Constants.correlationID,correlationId);
        RestAssuredHelper.setHeader(request,Constants.nbnCorrelationID,correlationId);
        response = RestAssuredHelper.callAPI(request,"GET"); //Get response
        jsonResponse = RestAssuredHelper.getJsonPath(response);
        Helper.checkStatusIs200(response,correlationId,scenarioName);
        assertEquals(jsonResponse.get("data.id").toString().startsWith("LOC"),true);
    }
}
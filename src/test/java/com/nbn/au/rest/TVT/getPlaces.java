package com.nbn.au.rest.TVT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nbnco.au.common.Constants;
import com.nbnco.au.common.Helper;
import com.nbnco.au.common.RestAssuredHelper;
import com.nbnco.au.services.serviceBase;

import io.restassured.http.ContentType;

public class getPlaces extends serviceBase {

    String correlationId = "CIS-Places-TVT-" +prop.getEnvValue() + "-"+ Helper.UUID();
    String scenarioName = "Scenario: Verify the response for the Places API request : ";

    @Test
    public void placesMakeTheRequestToThePlacesAPI()  {
        RestAssuredHelper.setBaseURI(request, String.format(prop.getProperty("GetPlacesRestUrl"),prop.getProperty("PLACES_LOCID")) );
        RestAssuredHelper.setRelaxedHTTPSValidation(request); // Relax HTTPS Validation
        RestAssuredHelper.setContentType(request,ContentType.JSON);
        RestAssuredHelper.setHeader(request,Constants.nbnCorrelationID,correlationId);
        RestAssuredHelper.setQueryParam(request,"include","containmentBoundaries");
        response = RestAssuredHelper.callAPI(request,"GET"); //Get response
        jsonResponse = RestAssuredHelper.getJsonPath(response);
        Helper.checkStatusIs200(response,correlationId,scenarioName);
        assertEquals(jsonResponse.get("data[0].id").toString().startsWith("LOC"),true);
    }
}

package com.nbnco.au.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import com.nbnco.au.common.PropertyLoader;

public class serviceBase {

    public Response response = null;
    public RequestSpecification request = given();
    public PropertyLoader prop;
    public JsonPath jsonResponse;

    public serviceBase(){
        prop = new PropertyLoader();
    }



}
package com.nbnco.au.common;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.File;
import java.util.List;

public  class RestAssuredHelper {

    public static String path; //Rest request path

    public static RequestSpecification setBaseURI (RequestSpecification request,String baseURI){
        return request.baseUri(baseURI); //= baseURI;
    }

    public static RequestSpecification setBasePath(RequestSpecification request,String basePathTerm){
        return request.basePath(basePathTerm);
    }

    public static RequestSpecification setRelaxedHTTPSValidation (RequestSpecification request){
        return request.relaxedHTTPSValidation();
    }

    public static RequestSpecification setHeader(RequestSpecification request,  String key, String val){
        return request.header(key, val);
    }

    public static RequestSpecification setParam(RequestSpecification request, String type, String key, String val){
        switch(type){
            case "parameters": 			request.param(key, val);break;
            case "form parameters": 	request.formParam(key, val);break;
            case "query parameters": 	request.queryParam(key, val);break;
            case "path parameters": 	request.pathParam(key, val);break;
        }
        return request;
    }

    public static RequestSpecification setQueryParam(RequestSpecification request, String key, String val){
        return	request.queryParam(key, val);
    }

    public static RequestSpecification setParamList(RequestSpecification request,  String key, List<String> val){
        return request.param(key, val);
    }

    public static RequestSpecification setContentType (RequestSpecification request, ContentType Type){
        return request.contentType(Type);
    }

    public static RequestSpecification setSoapActionHeader (RequestSpecification request, String ActionName){
       return request.header("SOAPAction",ActionName);
    }

    public static RequestSpecification setBody(RequestSpecification request,   String content){
        return request.body(content);
    }

    public static RequestSpecification setBody(RequestSpecification request,   File content){
        return request.body(content);
    }

    public static Response callAPI(RequestSpecification request, String method){
        Response response = null;
        switch(method){
            case "GET":		response = path != null ? request.get(path) : request.get();break;
            case "PUT":		response = path != null ? request.put(path) : request.put();break;
            case "POST":	response =  path != null ? request.post(path) : request.post();break;
            case "PATCH":	response = request.patch(path);break;
            case "DELETE":	response = request.delete(path);break;
        }
        return response;
    }

    public static Response callAPIWithLogging(RequestSpecification request, String method){
        Response response = null;
        switch(method){
            case "GET":		response = path != null ? request.log().all().get(path) : request.log().all().get();break;
            case "PUT":		response = path != null ? request.log().all().put(path) : request.log().all().put();break;
            case "POST":	response =  path != null ? request.log().all().post(path) : request.log().all().post();break;
            case "PATCH":	response = request.log().all().patch(path);break;
            case "DELETE":	response = request.log().all().delete(path);break;
        }
        return response;
    }

    public static void printResponse(Response res){
        System.out.println(res.then().log().all().extract().response());
    }

    public static JsonPath getJsonPath (Response res) {
        return new JsonPath(res.asString());
    }

    public static XmlPath getXMLPath (Response res) {
        return new XmlPath(res.asString());
    }

}

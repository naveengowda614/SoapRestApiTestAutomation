package com.javacodegeeks.testng.maven;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.nbnco.au.common.FileHelper;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class TestNgMavenExample {
	
	@BeforeTest
	public void load(){
		String filePath = "tvt/%s/%s.xml";
		
		
	}

	@Test
	public void exampleOfTestNgMaven() {
		String requestXmlString = new FileHelper().GetXmlAsStringAndReplaceUUID(String.format("tvt/%s/%s.xml","queryAddress","qaLocationId"),"qaLocationId");
		System.out.println(requestXmlString);
		//RequestSpecification request = 
		//RestAssured.
	}
}

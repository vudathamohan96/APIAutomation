package com.test.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class test {

	@Test(enabled=false)
	public void Test_01() {
		RestAssured.baseURI="https://reqres.in/api";
		RequestSpecification Request=RestAssured.given();
		Response response=Request.request(Method.GET, "/users?page=2");
		//System.out.println(response.body().asString());
	}
	@Test(enabled=false)
	public void Test_02() {
	
		Response response=given().get("https://apigenerator.dronahq.com/api/zLGH-lnj/data");
		JsonPath json=response.jsonPath();
	    List<String>list=json.get("player[0].findAll{it.role=='Wicket-keeper'}");
	    System.out.println(list.size());
	}
	
	@Test
	public void Test_03() {
		Response response=given().auth().basic("postman","password").get("https://postman-echo.com/basic-auth");
		System.out.println(response.asString());
		Assert.assertEquals(response.statusCode(), 200);
		ValidatableResponse valRes = response.then();

	      
	      valRes.time(Matchers.lessThan(3000L));
			// Asserting response time is greater than 2000 milliseconds
			valRes.time(Matchers.greaterThan(2000L));
			// Asserting response time in between some values
			valRes.time(Matchers.both(Matchers.greaterThanOrEqualTo(2000L)).and(Matchers.lessThanOrEqualTo(3000L)));
	 
			// If we want to assert in different time units
			valRes.time(Matchers.lessThan(3L), TimeUnit.SECONDS);
		
	}
	
	
}

package com.test.api;

import org.testng.Assert;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
    @Test(enabled=false)
	public void Get1(){
		// TODO Auto-generated method stub
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getContentType());
	}
    @Test(enabled=false)
	public void Get2() {
    given().
    get("https://reqres.in/api/users?page=2").
    then().
    statusCode(200).body("data.id[1]", equalTo(8)).
    body("data.first_name", hasItems("Michael","Lindsay"));
  
    }
    
    @Test(enabled=true)
   	public void Get3() {
   // given().get("https://jsonplaceholder.typicode.com/posts").then().statusCode(200);
    	RestAssured.baseURI="https://jsonplaceholder.typicode.com";
    	RequestSpecification req=RestAssured.given();
    	Response response=req.request(Method.GET,"/posts");
    	
    	String resposebody=response.getBody().asString();
    	//System.out.println(resposebody);
    	
    	int statuscode=response.getStatusCode();
    	Assert.assertEquals(statuscode, 200);
    	Assert.assertTrue(resposebody.contains("ratione ex tenetur perferendis"));
    }
}

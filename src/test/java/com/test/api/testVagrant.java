package com.test.api;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testVagrant {
	
	/*@BeforeClass
	public void setup() {
		RestAssured.baseURI = "https://retoolapi.dev";
       // RestAssured.basePath = "";
        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").
                build();
	}*/
	  @Test(enabled=true)
		public void TestCase0(){
		  
		 // Response response = get("https://retoolapi.dev/QyRg0S/data");
		// JsonPath jsonPath =  response.jsonPath();
		//System.out.println(response.toString());
		
		RestAssured.baseURI="https://apigenerator.dronahq.com/api/";
    	RequestSpecification req=RestAssured.given();
    	Response response=req.request(Method.GET,"/zLGH-lnj/data");
    	response.then().body("Wicket Keeper",Matchers.hasSize(1));
    	
    	
    	String responsebody=response.getBody().asString();
    	//System.out.println(responsebody);
    	
    	/*String headerName = response.getHeader("player.role");
    	System.out.println(headerName);
    	//assertThat(headerName).isNotBlank();
    	
    	
    	int statuscode=response.getStatusCode();
    	Assert.assertEquals(statuscode, 200);
    	Assert.assertTrue(responsebody.contains("Wicket-keeper"));*/
		 
		 
	
		 
		 
		 
		 
		 //Find all team names
		   
		   String total = response.path("player.findAll { it.country == India }");
		   // Set sn = ((Map<String, ?>) total).entrySet();
		    //Iterator it=sn.iterator();
	    System.out.println(total);
		  
		  //Fetch the teams array and save it to the list
		 // List<Map<String, ?>>  teamsData = response.path("teams");
		  //Fetch a Specific team based on name
		 // Map<String, ?> teamObj = response.path("teams.find { it.name == 'TSG 1899 Hoffenheim'}");
		  
	  }
	
    @Test(enabled=false)
	public void TestCase1(){
		// TODO Auto-generated method stub
		//Response response= RestAssured.get("https://retoolapi.dev/hLvvsA/data");
		//System.out.println(response.asString());
		//System.out.println(response.getStatusCode());
		//System.out.println(response.getContentType());
    	
		//Response response1=given().get("https://retoolapi.dev/hLvvsA/data").then().statusCode(200).body("role",equalTo("Wicket-keeper"));
	//System.out.println(response);
    	

    }
    
    @Test(enabled=false)
	public void Get2() {
    given().
    get("https://reqres.in/api/users?page=2").
    then().
    statusCode(200).body("data.id[1]", equalTo(8)).
    body("data.first_name", hasItems("Michael","Lindsay"));
  
    }
    
    @Test(enabled=false)
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

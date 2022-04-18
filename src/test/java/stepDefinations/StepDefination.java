package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;

import java.io.IOException;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class StepDefination extends Utils {

	TestDataBuild data = new TestDataBuild();
	RequestSpecification req;
	ResponseSpecification res;
	Response response;
	static String id;
	
	@Given("Add payload with {string} {string}")
	public void add_payload_with(String code, String name) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification reqspec = requestSpecification();
		
		req = given().spec(reqspec).body(data.addTestData(code, name));
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@Given("Get payload")
	public void get_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification reqspec = requestSpecification();
		
		req = given().spec(reqspec).queryParam("id", Integer.parseInt(id));
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@Given("Update payload with {string} {string}")
	public void update_payload_with(String code, String name) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification reqspec = requestSpecification();
		
		req = given().spec(reqspec).body(data.updateData(id, code, name));
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@Given("Delete payload")
	public void delete_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		RequestSpecification reqspec = requestSpecification();
		
		req = given().spec(reqspec).body(data.deleteData(id));
		res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@When("user calls {string} using {string} http method")
	public void user_calls_using_http_method(String resources, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resource = APIResources.valueOf(resources);
		String resourceURI = resource.getResource();
		
		if (method.equalsIgnoreCase("POST")) {
			response = req.when().post(resourceURI).then().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("GET")) {
			response = req.when().get(resourceURI).then().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("PUT")) {
			response = req.when().get(resourceURI).then().spec(res).extract().response();
		} else if (method.equalsIgnoreCase("DELETE")) {
			response = req.when().get(resourceURI).then().spec(res).extract().response();
		}
		
		
	}
	@Then("the API returns statusCode with {int}")
	public void the_api_returns_status_code_with(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.statusCode(), 200);
	}
	@Then("the {string} in response is returned")
	public void the_in_response_is_returned(String key) {
	    // Write code here that turns the phrase above into concrete actions
	    id = getJsonValue(response, key);
	}
}

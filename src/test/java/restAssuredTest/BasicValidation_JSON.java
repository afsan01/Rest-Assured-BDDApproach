package restAssuredTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidation_JSON {
	
	//1) Test Status Code
	@Test(priority=1)
	public void testStatusCode() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200);
			//.log().all();
	}
	
	//2) Test Log Response
	@Test(priority=2)
	public void testLogging() {
		
		given()
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	//3) Verifying single content
	@Test(priority=3)
	public void testSingleContent() {
		
		given()
		
		.when()
			.get("http://services.groupkt.com/country/get/iso2code/IN")
		
		.then()
			.statusCode(200)
			
			.body("RestResponse.result.name", equalTo("India"));//use the JSON Path finder and add into chrome browser
	}
	//4) Verifying Multiple content in the response body
		@Test(priority=4)
		public void testMultipleContent() {
			
			given()
			
			.when()
				.get("http://services.groupkt.com/country/get/all")
			
			.then()
				.statusCode(200)
				
				.body("RestResponse.result.name", hasItems("India","Australia","United States"));
		}
		
		//5 Setting parameters and headers
		@Test(priority=4)
		public void testParametersAndHeaders() {
			
			given()
				.param("My Name", "Mahbub")
				.header("My header","USA")
			
			.when()
				.get("http://services.groupkt.com/country/get/all")
			
			.then()
				.statusCode(200)
				
				.log().all();
		}
		
		
		
		
		
		
		
		
		
}

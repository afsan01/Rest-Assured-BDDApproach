package restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class DeleteRequest {

	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI= "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath= "/delete/85600";
		
		Response response=
		given()
		
		.when()
			.delete()
			
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 OK")
		.log().all()
		.extract().response();	
		
		String jsonAsString=response.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! deleted Records"),true);
		
	}
}

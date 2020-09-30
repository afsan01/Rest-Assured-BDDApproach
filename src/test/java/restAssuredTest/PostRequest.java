package restAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test; 
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class PostRequest {

	public static HashMap map=new HashMap(); 
	@BeforeClass
	public void postdata() {
		
		/*map.put("FirstName", RestUtils.getFirstName());
		map.put("LastName", RestUtils.getLastName());
		map.put("UserName", RestUtils.getUserName());
		map.put("Password", RestUtils.getPassword());
		map.put("Email", RestUtils.getEmail());
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";*/
		map.put("name", RestUtils.getName());
		map.put("salary", RestUtils.empSal());
		map.put("age", RestUtils.empAge());
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/create";
	}
	@Test
	public void testPost() 
	{
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
			
		.then()
			.statusCode(200)
			.and()
			.body("status", equalTo("success"))
			.and()
			//.body("Message", equalTo("null"))
			.log().all();
	}
}

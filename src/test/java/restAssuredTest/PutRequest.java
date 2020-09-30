package restAssuredTest;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import org.testng.annotations.Test; 
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class PutRequest {

	public static HashMap map=new HashMap();
	
	String empname=RestUtils.empName();
	String empSalary=RestUtils.empSal();
	String empAge=RestUtils.empAge();
	int emp_id=11254;

	
	
	@BeforeClass
	public void putData() {
		map.put("name", empname);
		map.put("Salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	@Test
	public void testPut() {
		
		given()
			.contentType("application/json")
			.body(map)
		.when()
		
			.put()
		
		.then()
		.statusCode(200)
		.log().all(); //to confirm that the data is updated or not, To see the complete body
			
	}
	
}

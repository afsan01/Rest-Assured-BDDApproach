package serializationDeserialization;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPITestNoSerialization {
	
	public HashMap map= new HashMap();
	
	//post requests creates a new students records
	
	@Test (priority=1)
	public void createNewStudend() {
		
		map.put("id", 101);
		map.put("firstName", "Mahbubur");
		map.put("lastName", "Rahman");
		map.put("email", "abcx@gmail.com");
		map.put("programm", "Manager");
		
		ArrayList<String> courseList= new ArrayList<String>();
		courseList.add("Java");
		courseList.add("Selenium");

		map.put("courses", courseList);
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		
		.when()
			.post("http://localhost.8085/student")
		.then()
			.statusCode(201)
			.assertThat()
			.body("msg", equalTo("Student added"));

	}
	//Get request to retrieve student details
	
	@Test(priority=2)
	public void getStudentDetails() {
		
		given()
		.when()
			.get("http://localhost.8085/student/101")
		.then()
			.statusCode(200)
			.assertThat()
			.body("id", equalTo(101));
	}

}

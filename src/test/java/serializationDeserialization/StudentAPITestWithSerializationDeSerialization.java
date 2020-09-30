package serializationDeserialization;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class StudentAPITestWithSerializationDeSerialization {
	
	@Test(priority=1)
	public void createNewStudentSerialization() {
		
		ArrayList<String> coursesList = new ArrayList<String>();
		coursesList.add("Java");
		coursesList.add("Selenium");
		
		Student stu= new Student();
		stu.setSId(101);
		stu.setFirstName("John");
		stu.setLastName("Deo");
		stu.setEmail("abc@gmail.com");
		stu.setProgramme("Computer science");
		stu.setCourses(coursesList);
		
		given()
			.contentType(ContentType.JSON)
			.body(stu)
		.when()
			.post("http://localhost.8085/student")
		.then()
			.statusCode(201)
			.assertThat().body("msg", equalTo("Student added"));
	}
	@Test(priority=2)
	public void createNewStudentDeSerialization() {
		Student stu= get("http://localhost.8085/student/101").as(Student.class);
		System.out.println(stu.getStudentRecord());
		Assert.assertEquals(stu.getSID(), 101);
	}

}

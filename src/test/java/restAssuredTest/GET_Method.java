package restAssuredTest;

import org.testng.annotations.Test; 
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GET_Method {
	
	@Test
    public void getWeatherDetails() {
		
		given()
		.when()
			.get("http://www.restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ok")
			.assertThat().body("City", equalTo("Hyderabad"))
			.header("Content-Type", "application/json");
		
	}

	
}

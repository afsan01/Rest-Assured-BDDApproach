package restAssuredTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicValidation_XML {
	
	//1)Verifying Single content in XML response
	@Test(priority=1)
	public void testSingleContent() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body("CUSTOMER.ID", equalTo("15"))//XML Path
			.log().all();
	}
	//2)Verifying Multiple content in XML response
	@Test(priority=2)
	public void testMultipleContent() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.body("CUSTOMER.STREET", equalTo("319 Upland Pl."))
			.body("CUSTOMER.CITY", equalTo("Seattle"));
			
	}
	//3.Verifying all the content in XML response in one go
	
	@Test(priority=3)
	public void testMultipleContentInOneGo() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
		
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"));//put all value in one text value
			
	}
	//4).Find the Values using XML Path in XML response
	
		@Test(priority=4)
		public void testUsingXPath1() {
			
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
			
			.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill")));
				
		}
		@Test(priority=5)
		public void testUsingXPath2() {
			
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/INVOICE/")
			
			.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()='30']"))
			.log().all();
		}
	 

}

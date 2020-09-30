package serializationDeserialization;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VideoGameAPITestwithSeriJSON {
	
	@Test(priority=1)
	public void tesVideoGameSerializationXML() {
		
		VideoGame myVideoGame = new VideoGame();
		myVideoGame.setId(11);
		myVideoGame.setName("xyz123");
		myVideoGame.setReleaseDate("2020-06-15");
		myVideoGame.setReviewScore(90);
		myVideoGame.setCategory("Driving");
		myVideoGame.setRating("Five");
		
		given()
			.contentType("application/json")
			.body(myVideoGame)
		.when()
			.post("http://localhost.8080/app/videogames")
		.then()
			.log().all()
			.body(equalTo("{\"statis\":\"Record Added Successfully\"}") );
	}
	@Test(priority=2)
	public void testVideoGameDeseriXML() {
		
		VideoGame myVideoGame = get("http://localhost.8080/app/videogames/11").as(VideoGame.class);
		System.out.println(myVideoGame.toString());
		
		
		
		
	}

}
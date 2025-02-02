package restAssureapi.testType3.serialization;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import restAssureapi.testType3.serializationPOJO.googleMapsBody;
import restAssureapi.testType3.serializationPOJO.location;
import restAssuredapi.testType2.oAuthDependencies.fileConverter;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

public class TC02_googleMapsUpdate {
	fileConverter FC = new fileConverter();
	googleMapsBody GMB = new googleMapsBody();
	location locvalues = new location();
	private String Responce = null;

	@Test
	public void TC02_Step1_setGoogleMapsObjects() {
		System.out.println(" [INFO]:::START:::SET BODY OBJECTS:::");
		GMB.setAccuracy(50);
		GMB.setName("frontline");
		GMB.setPhone_number("99999999");
		GMB.setWebsite("https://google.com");
		GMB.setAddress("5-79,INDR,CHANDANAGAR");
		GMB.setLanguage("French-IN");
		List<String> listTypes = new ArrayList<String>();
		listTypes.add("Head park");
		listTypes.add("shop");
		GMB.setTypes(listTypes);
		locvalues.setLat(-38.383494);
		locvalues.setLng(33.427362);
		GMB.setLocation(locvalues);
		System.out.println(" [INFO]:::DONE:::BODY OBJECTS SETTELED:::");
	}

	@Test
	public void TC02_Step2_Update_MapLocation() {
		System.out.println(" [INFO]:::START:::UPDATE RESPONCE:::");
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Responce = given().log().all().queryParam("key", "qaclick123").body(GMB).when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().asString();
		System.out.println(" [INFO]:::DONE:::UPDATED RESPONCE:::");
	}

	@Test
	public void TC02_Step3_VerifyUpdatedData() {
		System.out.println(" [INFO]:::START:::VERIFY RESPONCE:::");
		Assert.assertTrue(Responce != null);
		System.out.println(Responce);
		System.out.println(" [INFO]:::DONE:::VERIFIED RESPONCE:::");
	}
}

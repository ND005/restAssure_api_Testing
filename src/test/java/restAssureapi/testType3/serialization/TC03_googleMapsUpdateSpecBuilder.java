package restAssureapi.testType3.serialization;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import restAssureapi.testType3.serializationPOJO.SpecficationBuilder;
import restAssureapi.testType3.serializationPOJO.googleMapsBody;
import restAssureapi.testType3.serializationPOJO.location;

public class TC03_googleMapsUpdateSpecBuilder {
// Overall flow we can consider as single test including Request ,Condition and Response using Specification builder (Spec Builders).
// This test with rap all classes like POJO (Plain Old Java Object) for Request and Specs.
	@Test
	public void Test01_GoogleMapsUpdate() {
		
		googleMapsBody GMB = new googleMapsBody();
		location locvalues = new location();
		SpecficationBuilder SPB = new SpecficationBuilder();
		
		GMB.setAccuracy(50);
		GMB.setName("frontline");
		GMB.setPhone_number("99999999");
		GMB.setWebsite("https://google.com");
		GMB.setAddress("5-79,INDIRANAGAR,CHANDANAGAR");
		GMB.setLanguage("German-EU");
		
		List<String> listTypes = new ArrayList<String>();
		listTypes.add("BHEL park");
		listTypes.add("Shetter");
		GMB.setTypes(listTypes);
		
		locvalues.setLat(-38.383494);
		locvalues.setLng(33.427362);
		
		GMB.setLocation(locvalues);
		
		RequestSpecification res= given().spec(SPB.RequestSpecificationBuilder()).body(GMB);
		Response Resp = res.when().post("/maps/api/place/add/json").
				then().spec(SPB.ResponceSpecificationBuilder()).extract().response();
		System.out.println(":::EXPECTED RESPONCE:::");
		System.out.println(Resp.asString());
	}
}

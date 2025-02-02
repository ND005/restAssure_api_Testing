package restAssuredapi.testType2.oAuthTwoZero;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import restAssuredapi.testType2.oAuthDependencies.auth2Dependencies;
import restAssuredapi.testType2.oAuthDependencies.fileConverter;
import restAssuredapi.testType2.oAuthDependencies.listedData;

public class TC1_AuthAccess_To_Test_DB {
	// This is the process of verify the data through OAuth2.0 Authentication
	// Step 1:- To generate the Token based on credentials.
	// Step 2:- To Get the data using Token Generated through Step 1.
	// NOTE:- Step 1 execution is mandatory to execute Step 2, So Don't Skip Step 1.

	// Step 3:- To validate the data in the file or list
	auth2Dependencies AuthDep = new auth2Dependencies();
	fileConverter Converter = new fileConverter();
	private String Token = "";
	private listedData Info = null;

	@Test
	public void TC01_Step1_GenerateToken() {
		System.out.println(" [INFO]:::TOKEN SERVICE:::STARTED");
		String Resp = given().log().all().formParam("client_id", AuthDep.clientID())
				.formParam("client_secret", AuthDep.clientSecret()).formParam("grant_type", AuthDep.clientType())
				.formParam("scope", AuthDep.scope()).when().log().all().post(AuthDep.autharizationTokenURL()).then()
				.extract().asString();
		JsonPath JSON = new JsonPath(Resp);
		Token = JSON.getString("access_token");
		String processType = JSON.getString("scope");
		System.out.println(" [INFO]:::TOKEN SERVICE:::TOKEN:" + Token);
		System.out.println(" [INFO]:::TOKEN PROCESS:::PROCESS TYPE:" + processType);

	}

	@Test
	public void TC01_Step2_Verify_CoursesDB() {
		System.out.println(" [INFO]:::DATA SERVICE:::STARTED");
		try {

			Info = given().queryParam("access_token", Token).when()
					.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(listedData.class);
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(" [INFO]:::DATA SERVICE:::EXCEPTION:" + e.toString());
		}
		System.out.println(" [INFO]:::DATA SERVICE:::DONE:");
	}

	@Test
	public void TC01_Step3_Verify_DataInNodeWise() {
		System.out.println(" [INFO]:::DESERIALIZATION:::STARTED:");
		System.out.println(" [INFO]:::INSTRUCTER:" + Info.getInstructor());
		System.out.println(" [INFO]:::URL:" + Info.getUrl());
	}
}

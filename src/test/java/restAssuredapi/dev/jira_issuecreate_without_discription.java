package restAssuredapi.dev;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import restAssuredapi.dependentPackages.JsonReaderIntoString;
import restAssuredapi.dependentPackages.TokenEncryption;

public class jira_issuecreate_without_discription {

	// If we run overall Test
	// Test 1:- Will create the JIRA Story/Bug.
	// Test 2:- Delete JIRA story based on ID created by the Test 1.

	String Token = TokenEncryption.TokenUser("DINESH");
	String BaseURL = "https://nimmaladinesh5.atlassian.net/";
	String IssueID = "";
	JsonReaderIntoString BodyValue = new JsonReaderIntoString();

	@Test
	public void TS01_Issue_Create_without_Discription() {
		RestAssured.baseURI = BaseURL;
		System.out.println(" [INFO]:::TS - 01 - START:::");
		System.out.println(" [INFO]:::CREATE ISSUE - START:::");

		String Responce = given().log().all().header("Content-Type", "application/json")
				.header("Authorization", "Basic " + Token)
				.body(BodyValue.JsonIntoString("src\\test\\resources\\issueFeaturswithoutDescription.JSON")).when()
				.post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).extract().asString();
		System.out.println(" [INFO]:::" + Responce);
		JsonPath jS = new JsonPath(Responce);
		IssueID = jS.getString("id");

		System.out.println(" [INFO]:::CREATED ISSUE - DONE:::");
	}

	@Test
	public void TS02_Issue_Delete_Based_On_ID() {
		System.out.println(" [INFO]:::TS - 02 - START:::");
		System.out.println(" [INFO]:::DELETE ISSUE - START:::");

		given().pathParam("key", IssueID).header("Authorization", "Basic " + Token).when()
				.delete("/rest/api/3/issue/{key}").then().statusCode(204).extract().asString();

		System.out.println(" [INFO]:::DELETE ISSUE - DONE:::");
	}
}

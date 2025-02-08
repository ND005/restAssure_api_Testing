package restAssureapi.testType3.serializationPOJO;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecficationBuilder {
	//Request Specification Builder
	public RequestSpecification RequestSpecificationBuilder() {
	RequestSpecification ReqSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	return ReqSpec;
	}

	//Response Specification Builder
	public ResponseSpecification ResponceSpecificationBuilder() {
		ResponseSpecification RespSpac = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return RespSpac;
	}
}

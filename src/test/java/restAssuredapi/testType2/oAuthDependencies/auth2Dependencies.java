package restAssuredapi.testType2.oAuthDependencies;

public class auth2Dependencies {
	private String AutharizationURL = "https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token";
	private String ActualDBURL = "https://rahulshettyacademy.com/oauthapi/oauth2/resourcesOwner/token";
	private String clientSecret = "erZOWM9g3UtwNRj340YYaK_W";
	private String clientId = "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
	private String clientType = "client_credentials";
	private String scope = "trust";

	public String clientSecret() {
		return clientSecret;
	}

	public String clientID() {
		return clientId;
	}

	public String clientType() {
		return clientType;
	}

	public String scope() {
		return scope;
	}

	public String autharizationTokenURL() {
		return AutharizationURL;
	}

	public String actualDBURL() {
		return ActualDBURL;
	}

}

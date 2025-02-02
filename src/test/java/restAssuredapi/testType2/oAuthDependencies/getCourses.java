package restAssuredapi.testType2.oAuthDependencies;

import java.util.List;

public class getCourses {

	private List<webAutomationCourse> webAutomation;
	private List<apiAutomationCourse> api;
	private List<mobileAutomationCourse> mobile;

	public List<webAutomationCourse> getWebAutomation() {
		return webAutomation;
	}

	public void setWebAutomation(List<webAutomationCourse> webAutomation) {
		this.webAutomation = webAutomation;
	}

	public List<apiAutomationCourse> getApi() {
		return api;
	}

	public void setApi(List<apiAutomationCourse> api) {
		this.api = api;
	}

	public List<mobileAutomationCourse> getMobile() {
		return mobile;
	}

	public void setMobile(List<mobileAutomationCourse> mobile) {
		this.mobile = mobile;
	}

}
package restAssuredapi.dependentPackages;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;

public class JsonReaderIntoString {

	public String JsonIntoString(String Path) {
		try {
			JSONParser JP = new JSONParser();
			Object Obj = JP.parse(new FileReader(Path));
			return Obj.toString();
		} catch (Exception EX){
			System.out.println(" [ERROR] :::Unable to parse JSON:::");
		}
		return "";
	}
	
}

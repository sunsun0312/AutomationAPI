package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqspec;
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(reqspec == null) {
		PrintStream log = new PrintStream("log.txt");
		
		reqspec = new RequestSpecBuilder()
				.setBaseUri(getValueFromGlobal("CountryBaseUri")).setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.build();
		}
		return reqspec;
	}

	public String getJsonValue(Response response, String key) {
		JsonPath js = new JsonPath(response.asString());
		return js.getString(key);
	}
	
	public static String getValueFromGlobal(String key) throws IOException {
		Properties p = new Properties();
		FileInputStream file = new FileInputStream("/Users/jessie/Projects/AutomationAPI/src/test/java/resources/global.properties");
		p.load(file);
		return p.getProperty(key);
	}
}

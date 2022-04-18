package resources;

import java.io.IOException;

import pojo.AddCountry;

public class TestDataBuild {

	public AddCountry addTestData(String code, String name) throws IOException {
		AddCountry country = new AddCountry();
		country.setCode(code);
		country.setName(name);
		country.setPWD(Utils.getValueFromGlobal("PWD"));
		return country;
	}
	
	public String updateData(String id, String code, String name) throws IOException {
		return "{\n"
		+ "  \"Id\": "+id+",\n"
		+ "  \"Code\": \""+code+"\",\n"
		+ "  \"Name\": \""+name+"\",\n"
		+ "  \"PWD\": \""+Utils.getValueFromGlobal("PWD")+"\"\n"
		+ "}";
	}
	public String deleteData(String id) throws IOException {
		return "{\n"
		+ "  \"Id\": "+id+",\n"
		+ "  \"pwd\": \""+Utils.getValueFromGlobal("PWD")+"\"\n"
		+ "}";
	}
}

package com.example.demo;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.emp.Employee;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		parseJsonTree();
	}

	public static void parseJsonTree() {

		ObjectMapper mapper = new ObjectMapper();
		String personDetails;
		try {
			String personDetails1 = FileUtils.readFileToString(
					new File("C:\\Users\\nshas\\jsonws\\demo\\src\\main\\resources\\jsonfiles\\persondetails.json"));
			System.out.println("The json string is " + personDetails1);
			JsonFactory factory = mapper.getJsonFactory();
			JsonParser parser = factory.createJsonParser(personDetails1);
		
			Employee empFromJsonString = (Employee) mapper.readValue(parser,Employee.class);
			System.out.println("The object for employee string" );
			System.out.println(" " + empFromJsonString.toString());
			
			/*The commented approach is to read the json bytes instead of jsonstring
			 * byte [] jsondata = Files.readAllBytes(Paths.get("C:\\Users\\nshas\\jsonws\\demo\\src\\main\\resources\\jsonfiles\\persondetails.json"));
			Employee empFromJsonString = mapper.readValue(jsondata,Employee.class);
			//Employee obj = new Employee();
			System.out.println("The defualt id for employee is " + empFromJsonString.getId());
			System.out.println(" " + empFromJsonString.toString());*/
			
			//code follows here to update few details in employee object and write it back to a new file
			empFromJsonString.setId(1234);//one more digit added to employee
			JsonGenerator gen=mapper.createGenerator(new File("C:\\Users\\nshas\\jsonws\\demo\\src\\main\\resources\\jsonfiles\\genemp.json"),
					          JsonEncoding.UTF8);
			gen.useDefaultPrettyPrinter();//This helps in formating the json. this is more readable
			gen.writePOJO(empFromJsonString);
			gen.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
package com.example.demo.emp;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpAddress {

	private String street;
	private String city;
	private String zipcode;
	
	public static void main(String [] args) {
		EmpAddress address = new EmpAddress("newstreet","mycity","67890");
		System.out.println("Address is " + address.getStreet() + ":" +  address.getCity()+ ":" + address.getZipcode());
	}
}

package com.example.demo.emp;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7121729915631078554L;
	private long id;
	private String name;
	private boolean permanent;
	private EmpAddress address;
	private long [] phoneNumbers;
	private String role;
	private String [] cities;
	private Map<String,String> properties;

}

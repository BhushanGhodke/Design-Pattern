package com.pattern.singleton;

public class Employee {

	static Employee employee= null;
	
	private Employee() {
		
	}
	
	public static Employee getInstance() {
		
		if(employee==null) {
			employee= new Employee();
		}
		return employee;
	}
	
	

	
}

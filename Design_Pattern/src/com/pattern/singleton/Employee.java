package com.pattern.singleton;

import java.io.Serializable;

public class Employee  implements Serializable{

	static Employee employee= null;
	
	private Employee() {
		
	}
	
	public static Employee getInstance() {
		
		if(employee==null) {
			employee= new Employee();
		}
		return employee;
	}
	
	
  Object readResolve(){
	return employee;
	  
  }
	
}

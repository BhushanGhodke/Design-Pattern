package com.pattern.singleton;

public class Test {

	public static void main(String[] args) {
		
		Employee emp1 = Employee.getInstance();
	
		Employee emp2 = Employee.getInstance();
	
		System.out.println(emp1.hashCode());
		
		System.out.println(emp2.hashCode());
		
	}
}

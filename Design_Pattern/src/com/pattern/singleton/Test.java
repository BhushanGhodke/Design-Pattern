package com.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Employee emp1 = Employee.getInstance();
	
		Employee emp2 = Employee.getInstance();
	
		System.out.println(emp1.hashCode());
		
		System.out.println(emp2.hashCode());
	
		FileOutputStream fos = new FileOutputStream("C://Users//bhush//Desktop//Employee.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(emp1);
		
		System.out.println("Serialization Done ....");
		
		
		FileInputStream fis = new FileInputStream("C://Users//bhush//Desktop//Employee.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Employee employee =(Employee) ois.readObject();
		
		System.out.println(employee.hashCode());
		
	}
	
/*	 We can break singleton design pattern by using
*	1) Multithreading
*   2) Serialization
*   3) Reflection 
*   4) Cloning
*/	
	
			
}

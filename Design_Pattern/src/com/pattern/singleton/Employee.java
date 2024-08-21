package com.pattern.singleton;

import java.io.Serializable;

public class Employee implements Serializable {

	String name = "Jay";

	static Employee employee = null;

	private Employee() {

	}

	public static Employee getInstance() {

		if (employee == null) {
			synchronized (Employee.class) {

				if (employee == null) {
					employee = new Employee();
				}
				return employee;
			}
		}
		return employee;
	}

	Object readResolve() {
		return employee;

	}

}

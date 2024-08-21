package com.pattern.singleton;

public class Thread1 extends Thread{

	
	
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		
		Thread1 t2 = new Thread1();
	
		t1.setName("Thread1");
		t2.setName("Thread2");
		
		t1.start();
		t2.start();
	}
	
	
	@Override
	public void run() {

		Employee employee = Employee.getInstance();
		
		System.out.println(Thread.currentThread().getName());
		
	}
}

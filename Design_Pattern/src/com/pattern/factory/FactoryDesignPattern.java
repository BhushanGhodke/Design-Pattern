package com.pattern.factory;

public class FactoryDesignPattern {

	public static void main(String[] args) {
		
		Factory f = new Factory();
		
		Notification n1 = f.createNotification("Email");
	
		n1.notifi();
	
		Notification n2 = f.createNotification("SMS");
		
		n2.notifi();
		
	
	  Notification n3 = f.createNotification("Push");
		
	  n3.notifi();
	
	}
}

interface Notification{
	
	public void notifi();
}

class SMSNotification implements Notification{
	
	@Override
	public void notifi() {
	
		System.out.println("Triggering Notification through SMS");
		
	}
}



class EmailNotification implements Notification{
	
	@Override
	public void notifi() {
	
		System.out.println("Triggering Notification through Email");
		
	}
}


class PushNotification implements Notification{
	
	@Override
	public void notifi() {
	
		System.out.println("Triggering Notification through Push");
		
	}
}
class Factory {
	
	public Notification createNotification(String mode) {
		
		if(mode.equalsIgnoreCase("sms")) {
			Notification n= new SMSNotification();
			return n;
		}
		if(mode.equalsIgnoreCase("email")) {
			Notification n = new EmailNotification();
			return n;
		}
		if(mode.equalsIgnoreCase("push")) {
			Notification n = new PushNotification();
			return n;
		}
		
		return null;
		
	}
}

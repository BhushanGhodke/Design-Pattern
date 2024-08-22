package com.pattern.builderdesignpattern;


public class User {

	
	User(UserBuilder ub){
		this.firstName=ub.firstName;
		this.lastName=ub.lastName;
		this.age=ub.age;
		this.mobile=ub.mobile;
	}
	
	final private String firstName;
	final private String lastName;
	final private int age;
	final private long mobile;
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	public long getMobile() {
		return mobile;
	}
	
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", mobile=" + mobile + "]";
	}




	static class UserBuilder{
		
		private String firstName;
		private String lastName;
		private int age;
		private long mobile;
		
		
		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public UserBuilder age(int age) {
			this.age=age;
			return this;
		}

		public UserBuilder mobile(long mobile) {
			this.mobile=mobile;
			return this;
		}
		
		
		 User Build() {
		
			 User u = new User(this);
			 return u;
		}
	}

	
	public static void main(String[] args) {
		
		User user= new UserBuilder("shyam", "ABC").age(15).mobile(8741547).Build();
		System.out.println(user);
		
		User user1= new UserBuilder("Rajesh", "dcwhd").Build();
		System.out.println(user1);
	}
}

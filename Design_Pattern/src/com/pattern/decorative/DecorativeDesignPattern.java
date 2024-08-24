package com.pattern.decorative;

public class DecorativeDesignPattern {

	public static void main(String[] args) {
		
		pizzaInterface raju= new Pizza();
		
		System.out.println(raju.getPizzaDetails());
		System.out.println(raju.getPizzaAmount());
		
		
		raju= new extraChesse(raju);
		System.out.println(raju.getPizzaDetails());
		System.out.println(raju.getPizzaAmount());
		
		raju= new extraSauce(raju);
		System.out.println(raju.getPizzaDetails());
		System.out.println(raju.getPizzaAmount());
	}
}


interface pizzaInterface{
	
	String getPizzaDetails();
	
	int getPizzaAmount();
}


class Pizza implements pizzaInterface{

	@Override
	public String getPizzaDetails() {
		
		return "Basic Pizza";
	}

	@Override
	public int getPizzaAmount() {
	
		return 99;
	}
		
}

abstract class pizzaDecorator implements pizzaInterface{
	
	pizzaInterface pizza;
	
	public pizzaDecorator(pizzaInterface pizza) {
	
		this.pizza=pizza;
	}
	
	
	@Override
	public int getPizzaAmount() {		
		return pizza.getPizzaAmount();
	}
	
	@Override
	public String getPizzaDetails() {
		return pizza.getPizzaDetails();
	}
}


class extraChesse  extends pizzaDecorator{

	
	
	public extraChesse(pizzaInterface pizza) {
		super(pizza);
		
	}
	
	@Override
	public int getPizzaAmount() {
		// TODO Auto-generated method stub
		return super.getPizzaAmount()+20;
	}
	
	@Override
	public String getPizzaDetails() {
		// TODO Auto-generated method stub
		return super.getPizzaDetails()+" Extra Chesse added";
	}
}



class extraSauce extends pizzaDecorator{

	
	
	public extraSauce(pizzaInterface pizza) {
		super(pizza);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int getPizzaAmount() {
		// TODO Auto-generated method stub
		return super.getPizzaAmount() +10 ;
	}
	
	@Override
	public String getPizzaDetails() {
		// TODO Auto-generated method stub
		return super.getPizzaDetails() +" Extra Sauce Added" ;
	}
}
package com.pattern.chainofResponsibility;

import java.util.Scanner;

public class ChainOfResponsibilityExample {

	DispenceChain rack2000;
	
	public ChainOfResponsibilityExample() {
	
		this.rack2000= new Note2000Rack();
		
		DispenceChain rack500= new Note500Rack();
		
		DispenceChain rack100= new Note100Rack();
		
		rack2000.chain(rack500);
		
		rack500.chain(rack100);
	}
	
	public static void main(String[] args) {

		ChainOfResponsibilityExample c = new ChainOfResponsibilityExample();
		
		while(true) {
			
			System.out.println("Please enter the amount to be withdrawn");
			
			Scanner sc = new Scanner(System.in);
			
			int amount = sc.nextInt();
			
			if(amount!=0) {
				
				if(amount%100!=0) {
					
					System.out.println("Please Enter Mutiple of 100");
					
				}
				else {
					c.rack2000.dispence(new Currency(amount));
				}
			}
		}

	}	
}



class Currency{
	
	Currency(int amount){
	this.amount=amount;	
	}
	
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}


interface DispenceChain{
	
	void dispence(Currency currency);
	void chain(DispenceChain nextChain);
}


class Note2000Rack implements DispenceChain{

	DispenceChain chain= null;
	
	@Override
	public void dispence(Currency currency) {
	
		int noOf2000Notes=(int) currency.getAmount()/2000;
		System.out.println("Dispencing "+noOf2000Notes + " 2000 notes");
		int remainder=(int)currency.getAmount()%2000;
		
		if(remainder!=0) {

			this.chain.dispence(new Currency(remainder));
		}
	}

	@Override
	public void chain(DispenceChain chain) {
		
		this.chain=chain;
	}
	
}



class Note500Rack implements DispenceChain{

	DispenceChain chain= null;
	
	@Override
	public void dispence(Currency currency) {
	
		int noOf500Notes=(int) currency.getAmount()/500;
		System.out.println("Dispencing "+noOf500Notes + " 500 notes");
		int remainder=(int)currency.getAmount()%500;
		
		if(remainder!=0) {

			this.chain.dispence(new Currency(remainder));
		}
	}

	@Override
	public void chain(DispenceChain chain) {
		
		this.chain=chain;
	}
	
}




class Note100Rack implements DispenceChain{

	DispenceChain chain;
	
	@Override
	public void dispence(Currency currency) {
	
		int noOf100Notes=(int) currency.getAmount()/100;
		System.out.println("Dispencing "+noOf100Notes + " 100 notes");
		int remainder=(int)currency.getAmount()%100;
		
		if(remainder!=0) {

			this.chain.dispence(currency);
		}
	}

	@Override
	public void chain(DispenceChain chain) {
		
		this.chain=chain;
	}
	
}
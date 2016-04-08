package com.shaojiexu.www.designpattern.decorator;

public class DecoratorExample {
	
	public static void main(String... args){
		
		Pizza SimplePizza = new Mozzarella(new TomatoSource(new PlainPizza()));
		
		System.out.println(SimplePizza.getDescription());
		System.out.println(SimplePizza.getCost());
		
	}
	
}

interface Pizza {
	
	public String getDescription();
	
	public double getCost();
}

class PlainPizza implements Pizza{
	
	public PlainPizza() {
		System.out.println("Plain Pizza with white dough");
	}

	@Override
	public String getDescription() {
		return "Plain Dough";
	}

	@Override
	public double getCost() {
		return 4.00;
	}
	
}

abstract class toppingDecorator implements Pizza{
	
	protected Pizza pizzaToDecorate;
	
	public toppingDecorator(Pizza pizzaToDecorate){
		this.pizzaToDecorate = pizzaToDecorate;
	}
	
	public String getDescription() {
		return pizzaToDecorate.getDescription();
	}

	public double getCost() {
		return pizzaToDecorate.getCost();
	}
	
}


class Mozzarella extends toppingDecorator{

	public Mozzarella(Pizza pizzaToDecorate) {
		super(pizzaToDecorate);
		System.out.println("Adding Mozzarella");
	}
	
	public String getDescription() {
		return pizzaToDecorate.getDescription() + " Mozzarella";
	}

	public double getCost() {
		return pizzaToDecorate.getCost() + 1.5;
	}
	
	
}

class TomatoSource extends toppingDecorator{

	public TomatoSource(Pizza pizzaToDecorate) {
		super(pizzaToDecorate);
		System.out.println("Adding TomatoSource");
	}
	
	public String getDescription() {
		return pizzaToDecorate.getDescription() + " TomatoSource";
	}

	public double getCost() {
		return pizzaToDecorate.getCost() + 0.5;
	}
	
	
}




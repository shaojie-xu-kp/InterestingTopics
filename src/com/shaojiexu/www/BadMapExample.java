package com.shaojiexu.www;

import java.util.HashMap;
import java.util.Map;

/**
 * an example of bad code regarding usage of map
 * @author shaojiexu
 *
 */
public class BadMapExample {
	
	private static Map<Bond, Bond> bondMap = new HashMap<>();
	 
	public static void main(String... args){
		
		for(int i = 0; i < 5; i++){
			
			Bond bond = new Bond();
			register(bond);
			bond.setPrice(i);
			
		}
		
		System.out.println(String.format("map size expected to be 5, instead %d", bondMap.size()));
		
		for(Bond b : bondMap.keySet()) {
			System.out.println(String.format("Key %d : Value : %d", b.getPrice(), bondMap.get(b).getPrice()));
		}
		
	}

	public static void register(Bond b){
		bondMap.put(b,b);
	}
}


class Bond {
	
	private int price;

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public boolean equals(Object obj){
		
		if(this == obj) return true;
		
		if(obj == null || obj.getClass() != getClass()) 
			return false;
		
		return this.price == ((Bond)obj).getPrice();
	}
	
	public int hashCode(){
		return price;
	}
	
	
}

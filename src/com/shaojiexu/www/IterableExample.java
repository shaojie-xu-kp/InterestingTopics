package com.shaojiexu.www;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableExample implements Iterable<Integer> {

	@Override
	public Iterator<Integer> iterator() {
		System.out.println("for each called");
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		
		return numbers.iterator();
	}
	
	public static void main(String... args){
		IterableExample ix = new IterableExample();
		
		for(Integer num : ix) {
			System.out.println(num);
		}
	}

}

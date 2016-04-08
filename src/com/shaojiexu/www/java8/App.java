package com.shaojiexu.www.java8;



public class App {
	
	
	/*
	 () -> {
			System.out.println("This is code passed in a lambda expression");
			System.out.println("Hello there.");
			return 8;
		}
	 */
	
	
	public static void main(String... args){
		
		final int c = 100;
		
		Runner runner = new Runner();
		runner.run(new Executable(){

			@Override
			public int execute(int a, int b) {
				System.out.println("Hello there.");
				return c + a + b;
			}
		});
		
		System.out.println("====================================");
		
		runner.run((a, b) -> {
			return c+a+b;
			
		});
	}
	

}

interface Executable {
	int execute(int a, int b);
}

interface StringExecutable {
	int execute(String a);
}

class Runner {
	
	public void run(Executable e) {
		System.out.println("Executing code block");
		int value = e.execute(3, 7);
		System.out.println("Return value is " + value);
	}
	
	public void run(StringExecutable e){
		System.out.println("Executing code block");
		int value = e.execute("Hello ");
		System.out.println("Return value is " + value);
		
	}
}

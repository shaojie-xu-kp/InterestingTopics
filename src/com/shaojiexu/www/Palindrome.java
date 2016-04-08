package com.shaojiexu.www;

public class Palindrome {

	public static void main(String args[]) {

		System.out.println(solution(null));

	}

	private static boolean solution(String word) {
		
		if(word == null) {
			return true;
		}

		String pattern = "[^A-Za-z0-9]";

		String reverseInput = "";
		word = word.replaceAll(pattern, "");

		int length = word.length();

		for (int i = length - 1; i >= 0; i--) {
			reverseInput = reverseInput + word.charAt(i);
		}

		if (word.equals(reverseInput))
			return true;
		else
			return false;

	}

}

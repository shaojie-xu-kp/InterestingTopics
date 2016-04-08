package com.shaojiexu.www;
import java.util.ArrayDeque;
import java.util.Deque;

class StackMachineEmulator {

//	public static final String NUMBER_MATCH_REGEX = ".*\\d+.*";
	
	public static final String NUMBER_MATCH_REGEX = "[0-9]";


	public static final String MULIPLY = "*";

	public static final String ADD = "+";

	public int solution(String S) {

		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		if(S.length() == 0) {
			return -1;
		}

		for (int i = 0; i < S.length(); i++) {

			if (S.substring(i, i + 1).matches(NUMBER_MATCH_REGEX)) {

				stack.push(Integer.valueOf(S.substring(i, i + 1)));

			} else {
				// here it finds an operator and expects to have at least two
				// numbers in stack
				if (stack.size() < 2)
					return -1;

				if (S.substring(i, i + 1).equals(MULIPLY)) {
					stack.push(stack.pop() * stack.pop());
				} else if (S.substring(i, i + 1).equals(ADD)) {
					stack.push(stack.pop() + stack.pop());
				} else {
					// here it finds an operator that is not * neither +, not
					// recognized operator
					return -1;
				}

			}

		}

		return stack.pop();

	}
	
	public static void main(String... args) {
		StackMachineEmulator emulator = new StackMachineEmulator();
		System.out.println(emulator.solution("11+22+33*+*"));
		System.out.println(emulator.solution("11++"));
		System.out.println(emulator.solution("43567810294**+1**++12++*"));
		System.out.println(emulator.solution("11+"));
		System.out.println(emulator.solution(""));
		System.out.println(emulator.solution("222***222***222***222***"));
//		System.out.println(emulator.solution("11++"));
//		System.out.println(emulator.solution("11++"));
		
	}
}
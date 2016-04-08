package com.shaojiexu.www;

public class BugfixingNails {

	int solution(int[] A, int K) {
		int n = A.length;
		int best = 0;
		int count = 1;
		for (int i = 0; i < n - K - 1; i++) {
			if (A[i] == A[i + 1])
				count = count + 1;
			else
				count = 1;
			if (count > best)
				best = count;
		}
		int result = best + K;

		return result;
	}
	
	public static void main(String... args) {
		
		int[] array1 = {1,1,3,3,3,4,5,5,5,5};
		int[] arraySingle = {2};
		int[] arrayDouble = {2,4};
		
		BugfixingNails bn = new BugfixingNails();
		System.out.println(bn.solution(array1, 0) == 4);
		System.out.println(bn.solution(array1, 1) == 4);
		System.out.println(bn.solution(array1, 2) == 5);
		System.out.println(bn.solution(array1, 3) == 6);
		System.out.println(bn.solution(array1, 4) == 7);
		System.out.println(bn.solution(array1, 5) == 8);
		System.out.println(bn.solution(array1, 6) == 8);
		System.out.println(bn.solution(array1, 7) == 9);
		System.out.println(bn.solution(array1, 8) == 10);
		System.out.println(bn.solution(array1, 9) == 9);
		System.out.println(bn.solution(array1, 10) == 10);
		
		System.out.println("*********************");
		
		System.out.println(bn.solution(arraySingle, 0));
		System.out.println(bn.solution(arraySingle, 1));
		
		System.out.println("*********************");
		
		System.out.println(bn.solution(arrayDouble, 0));
		System.out.println(bn.solution(arrayDouble, 1));
		System.out.println(bn.solution(arrayDouble, 2));

		
	}

}

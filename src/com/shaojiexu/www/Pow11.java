package com.shaojiexu.www;

import java.math.BigDecimal;

public class Pow11 {

	public int solution(int N) {
		int base = 11;
		int count = 0;
		String result = power(base, N, new BigDecimal(1)).toString();
		for (int i = 0; i < result.length(); i++) {
			if (Integer.valueOf(result.substring(i, i + 1)) == 1) {
				count++;
			}
		}
		return count;
	}

	public BigDecimal power1(int base, int n) {
		if (n == 0) {
			return new BigDecimal(1);
		} else {
			return power1(base, n - 1).multiply(new BigDecimal(base));
		}
	}
	
	public BigDecimal power(int base, int n, BigDecimal result) {
		if (n == 0) {
			return result.multiply(new BigDecimal(1));
		} else {
			return power(base, n - 1, result.multiply(new BigDecimal(base)));
		}
	}
	
	public static void main(String ... args) {
		Pow11 p11 = new Pow11();
		System.out.println(p11.power1(500,1234));
		System.out.println(p11.power(500,1234,new BigDecimal(1)));
		System.out.println(p11.solution(1234));
		System.out.println(p11.solution(0));
		System.out.println(p11.solution(1));
		System.out.println(p11.solution(490));
		System.out.println(p11.solution(500));
	}

}

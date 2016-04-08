package com.shaojiexu.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuasiConstant {
	
	
	public int solution(int[] A) {
		
		int maxCount = 0;
		
		int maxLength = 0;
		
		Map<Integer, Integer> numberMap = new HashMap<>();
		
		List<Integer> integers = new ArrayList<>();
		
		
		Arrays.sort(A);
		
		for(int i = 0; i < A.length; i++){
			if(numberMap.keySet().contains(A[i])) {
				int count = numberMap.get(A[i]) + 1;
				if(count > maxCount) maxCount = count;
				numberMap.put(A[i], count);
			}else{
				numberMap.put(A[i], 1);
				integers.add(A[i]);
			}
		}
		
		for(int i = 0; i < integers.size(); i++){
			
			int length = 0; 
			
			int length1 = 0;
			
			int length2 = 0;
			 
			if(numberMap.get(integers.get(i)) == maxCount) {
				
				
				if(i != integers.size() -1  &&  integers.get(i + 1) - integers.get(i) == 1) {
					length1 = maxCount + numberMap.get(integers.get(i + 1));
				}
				
				if(i != 0 && integers.get(i) - integers.get(i-1) == 1) {
					length2 = maxCount + numberMap.get(integers.get(i - 1));
				}
				
			}
			
			length = Math.max(length1, length2);
			
			if( length > maxLength) {
				maxLength = length;
			}
			
		}
		

		
		return maxLength;
    }
	
	
	public static void main(String... strs){
		
		int[] A = {6, 10, 6, 9, 7,7, 8,8,9,9,9};
		
		QuasiConstant qc = new QuasiConstant();
		
		System.out.println(qc.solution(A));
		
		
		
	}

}

package com.shaojiexu.www;

import java.util.Arrays;

public class SortAlgorithm {
	
	static void merge_sort_recursive(int[] arr, int[] reg, int start, int end) {
		if (start >= end)
			return;
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, reg, start1, end1);
		merge_sort_recursive(arr, reg, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2)
			reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			reg[k++] = arr[start1++];
		while (start2 <= end2)
			reg[k++] = arr[start2++];
		for (k = start; k <= end; k++)
			arr[k] = reg[k];
	}
	
	
	static void quick_sort(int[] arr, int low, int high){
		
		if(low < high){
			
			int l = low, h = high, pivot = arr[l]; 
			
			while(l < h){
				
				while(l < h && arr[h] >= pivot){
					h--;
				}
				
				if(l < h) arr[l++] = arr[h];
				
				while(l < h && arr[l] < pivot) {
					l++;
				}
				
				if(l < h) arr[h--] = arr[l];
				
			}
			
			arr[l] = pivot;
			
			quick_sort(arr, low, l-1);
			quick_sort(arr, l+1, high);
			
		}
	}
	
	
	public static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] reg = new int[len];
		merge_sort_recursive(arr, reg, 0, len - 1);
	}
	
	
	public static void insertion_sort(int[] arr) {
		int i, j, len = arr.length;
		int temp;
		for (i = 1; i < len; i++) {
			temp = arr[i]; 
			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}
	}
	
	// Sort the numbers beginning with least-significant digit
    public static void radixSort(int[] array, int d){

        int n=1;//代表位数对应的数：1,10,100...
        int k=0;//保存每一位排序后的结果用于下一位的排序输入
        int length=array.length;
        int[][] bucket=new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order=new int[length];//用于保存每个桶里有多少个数字
        while(n<d)
        {
            for(int num:array) //将数组array里的每个数字放在相应的桶里
            {
                int digit=(num/n)%10;
                bucket[digit][order[digit]]=num;
                order[digit]++;
            }
            for(int i=0;i<length;i++)//将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if(order[i]!=0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for(int j=0;j<order[i];j++)
                    {
                        array[k]=bucket[i][j];
                        k++;
                    }
                }
                order[i]=0;//将桶里计数器置0，用于下一次位排序
            }
            n*=10;
            k=0;//将k置0，用于下一轮保存位排序结果
        }    
        
    }

    public static void countingSort(int[] A)
    {  
       int max=A[0];
       int min=A[0];
       for(int i=1; i<A.length; i++){
          if(A[i]>max) max=A[i];
          else if(A[i]<min) min=A[i];
       }
       
       int[] counts = new int[max - min + 1]; // this will hold all possible values, from low to high
       for (int x : A)
           counts[x - min]++; // - low so the lowest possible value is always 0

       int current = 0;
       for (int i = 0; i < counts.length; i++)
       {
           Arrays.fill(A, current, current + counts[i], i + min); // fills counts[i] elements of value i + low in current
           current += counts[i]; // leap forward by counts[i] steps
       }

    }
       
    public static void bubbleSort(int a[])  
    {  
           int j, n = a.length, temp = 0;  
           boolean flag = true;
           while(flag){
        	   flag = false;
        		   for (j = 1; j < n; j++)  
        			   if (a[j - 1] > a[j]) {
        				   flag = true;
        				   temp = a[j];
        				   a[j] = a[j - 1];
        				   a[j - 1] = temp;
        			   }
        		   n--;
           }
    }  

	
	public static void main(String... args) {
		
		int [] arr1 = {9,3,6,5,10,12};
		
		insertion_sort(arr1);
		
		for(int i = 0; i < arr1.length; i++)
			System.out.print(arr1[i] + " ");
		
	}


}

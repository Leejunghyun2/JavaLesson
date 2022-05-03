package Chap03;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		int[] arr = {7,2,3,4,5};
		int num = arr[0], min=arr[0];
		for(int i=0;i<arr.length;i++) {
			
			if(arr[i]>num) {
				num = arr[i];
			}else if(arr[i]<min) {
				min = arr[i];
			}
		}
		System.out.println(num);
		System.out.println(min);
		
	}
}

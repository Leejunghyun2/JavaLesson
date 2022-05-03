package Chap03;

import java.util.Arrays;

public class Array04 {

	public static void main(String[] args) {
		int[] arr1 = new int[7];
		
		for(int i = 0; i < arr1.length; i++) {
			arr1[i] = (int)((Math.random()*45)+1);
			System.out.print(arr1[i]+", ");
			
		}
		System.out.println();
		System.out.println(Arrays.toString(arr1));
	}
}

package Chap03;

public class Array01 {

	public static void main(String[] args) {
		int[] arr1;
		double[] arr2 =new double[5];
		arr1 = new int[10];
		
		for(int i=0; i<arr1.length;i++) {
			
			arr1[i] = i*10;
			
		}
		
		
		for(int i = 0; i < arr1.length; i++) {
		System.out.println(arr2[i]);
		
		}
		System.out.println(arr1.length);
		System.out.println(arr1);
		
	}
}

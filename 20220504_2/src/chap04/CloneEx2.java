package chap04;

import java.util.Arrays;

public class CloneEx2 {
	public static void main(String[] args) {
	int[] arr = {1,2,3,4,5};
	int[] arr2 = {1,2,3,4,5};
	int[] arrClone = arr.clone();
	int[] arrClone2 = new int[arr2.length];
	System.arraycopy(arr, 0, arrClone2, 0, 0);
	System.out.println(Arrays.toString(arr));
	System.out.println(Arrays.toString(arrClone));
	System.out.println(arr);
	System.out.println(arrClone);
	System.out.println(arr2);
	System.out.println(arrClone2);
		
	}
	
}

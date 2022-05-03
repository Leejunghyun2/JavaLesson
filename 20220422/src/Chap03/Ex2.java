package Chap03;

import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		int[] arr = new int[45];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		int temp = 0;

		for (int i = 0; i < 100; i++) {
			int j = (int) (Math.random() * 45);
			int k = (int) (Math.random() * 6);
			temp = arr[k];
			arr[k] = arr[j];
			arr[j] = temp;
		}
		for (int j = 0; j < 6; j++) {
			System.out.println("arr[" + j + "] = " + arr[j]);
		}

	}
}

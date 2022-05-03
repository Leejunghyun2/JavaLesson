package Chap03;

import java.util.Arrays;

public class Ex8 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}

		int temp = 0;
		for (int a = 0; a < arr.length-1; a++) {
			boolean changed = false;
			for (int j = 0; j < arr.length - 1 - a; j++) {
				if (arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					changed = true;
				}
				
				}
				System.out.println(Arrays.toString(arr));
				if(changed==false) {
				break;
				}
				
			}
		}

		

	}


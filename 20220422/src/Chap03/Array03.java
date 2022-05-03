package Chap03;

import java.util.Arrays;
import java.util.Scanner;

public class Array03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i=0, sum=0;
		double avg=0;
		int[] score = new int[10];
		for(int j=0;j<score.length;j++)
		{
			System.out.print((j+1) +" ¹ø¤Š ¼ýÀÚ : ");	
			score[j] = Integer.parseInt(sc.nextLine());
			
			sum = sum+score[j];
		}
		avg = (double)sum/10;
		System.out.println(sum);
		System.out.println(Arrays.toString(score));
	}
}

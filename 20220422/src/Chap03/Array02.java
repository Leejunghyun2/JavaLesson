package Chap03;

public class Array02 {

	public static void main(String[] args) {
		int[] score = {20,30,40,50,60};
		int sum = 0;
		double avg= 0;
		for(int i=0;i<score.length;i++) {
			sum += score[i];
			
		}
		avg= (double)sum/score.length;
		System.out.println("ÃÑÇÕ "+sum);
		System.out.println("Æò±Õ "+avg);
	}
}

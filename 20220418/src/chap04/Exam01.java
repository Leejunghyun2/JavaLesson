package chap04;

import java.util.Scanner;

public class Exam01 {

	  public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		  int x = 10;
		  int y = 20;
		  int temp = 0;
		  System.out.printf("x = %d , y = %d\n",x,y);
		  
		  temp = x;
		  x = y;
		  y = temp;
		  
		  System.out.printf("x = %d , y = %d\n",x,y);
		  
	}
}

package chap01;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		MyFunction mc2 = (int a, int b) -> a > b ? a : b;
		
		System.out.println(mc2.max(3,2));
	
		}
}

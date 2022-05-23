package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			int a = Integer.parseInt(sc.nextLine());
			if(a==0) {
				return;
			}
			if(a==1) {
				continue;
			}
		String[][][] s = new String[3][][];
		s[0] = new String[5][3];
		s[1] = new String[4][3];
		s[2] = new String[6][3];
		
		for(int i=0;i<s[0].length;i++) {
		System.out.println("12");
		}
		for(int i=0;i<s[1].length;i++) {
			System.out.println("11");
			}
		for(int i=0;i<s[2].length;i++) {
			for(int j=0; j<s[2][i].length;j++)

System.out.println("13");
			}
		continue;
		}
	}
	
	
	
	
}

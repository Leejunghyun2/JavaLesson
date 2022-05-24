package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		String[][][][] s = new String[3][6][6][9];
		for (int time = 0; time < s[0][0][0].length; time++) {
			for (int col = 0; col < s[0].length; col++) {
				for (int row = 0; row < s[0][col].length; row++) {
					s[0][col][row][time] = ((char) (col + 65)) + "" + (row + 1) + "";
				}
			}
		}
		System.out.println(" 忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" 弛                 S    C   R   E   E   N                   弛");
		System.out.println(" 戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		for (int i = 0; i < (s[0]).length; i++) {
			System.out.println(" \t忙式式式式忖  忙式式式式忖  忙式式式式忖  忙式式式式忖  忙式式式式忖  忙式式式式忖");
			for (int j = 0; j < (s[0][i]).length; j++) {
				System.out.print(("\t弛 "+s[0][i][j][7]) + " 弛 ");
			}
			System.out.println();
			System.out.println(" \t戌式式式式戎  戌式式式式戎  戌式式式式戎  戌式式式式戎  戌式式式式戎  戌式式式式戎");
		}
		
	
		
	}
}

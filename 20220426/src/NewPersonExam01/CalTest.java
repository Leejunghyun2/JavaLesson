package NewPersonExam01;

import java.util.Scanner;

public class CalTest {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
		System.out.print(" 1번째 값 : ");	
		double var1 = Double.parseDouble(sc.nextLine());
		
		System.out.print(" 부호 : ");	
		char cr = sc.nextLine().charAt(0);
		System.out.print(" 2번째 값 : ");	
				
		double var2 = Double.parseDouble(sc.nextLine());
		
		
		
		
		
		if(var1%1 == 0.0 && var2%1 == 0.0) {
			Cal gg = new Cal((int)var1,cr,(int)var2);
		} else if(var1%1 == 0.0 && var2%1 > 0.0) {
			Cal gg = new Cal((int)var1,cr,var2);
		} else if(var1%1 > 0.0 && var2%1 == 0.0) {
			Cal gg = new Cal(var1,cr,(int)var2);
		} else {
			Cal gg = new Cal(var1,cr,var2);
		}
		
		
	}
	
}

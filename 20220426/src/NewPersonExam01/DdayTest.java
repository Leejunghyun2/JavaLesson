package NewPersonExam01;

import java.util.Scanner;

public class DdayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=0,month=0,day=0,date=0;
		
		System.out.print("년도 : ");
		year = Integer.parseInt(sc.nextLine());
		System.out.print("월 : ");
		month = Integer.parseInt(sc.nextLine());
		System.out.print("일 : ");
		day = Integer.parseInt(sc.nextLine());
		System.out.print("몇일 뒤 ? : ");
		date = Integer.parseInt(sc.nextLine());
		Dday sh = new Dday(year,month,day,date);
	
		
	}
	
}

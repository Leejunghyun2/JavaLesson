package NewPersonExam01;

import java.util.Scanner;

public class DdayTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int year=0,month=0,day=0,date=0;
		
		System.out.print("�⵵ : ");
		year = Integer.parseInt(sc.nextLine());
		System.out.print("�� : ");
		month = Integer.parseInt(sc.nextLine());
		System.out.print("�� : ");
		day = Integer.parseInt(sc.nextLine());
		System.out.print("���� �� ? : ");
		date = Integer.parseInt(sc.nextLine());
		Dday sh = new Dday(year,month,day,date);
	
		
	}
	
}

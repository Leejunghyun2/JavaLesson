package Test;

import java.util.Scanner;

public class MainTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ReservationNumber ss = ReservationNumber.getInstance();
		int count = 1;
		while(true) {
		System.out.print("1  2  ==> ");
		int choice = Integer.parseInt(sc.nextLine());
		if(choice == 1) {
		String a =	ss.ReserNum(count++);
			System.out.println(a);
		}
		}
	}
}

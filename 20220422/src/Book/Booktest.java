package Book;

import java.util.Scanner;

public class Booktest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] bTest = new Book[3];

		for (int i = 0; i < bTest.length; i++) {
			bTest[i] = new Book();
			System.out.print("å �̸� :");
			bTest[i].setBook(sc.nextLine());
			
			System.out.print("�۾��� : ");
			bTest[i].setWrite(sc.nextLine());
			
			System.out.print("�⵵");
			bTest[i].setYear(Integer.parseInt(sc.nextLine()));
			
			System.out.print("��");
			bTest[i].setMonth(Integer.parseInt(sc.nextLine()));
			
			System.out.print("��");
			bTest[i].setDay(Integer.parseInt(sc.nextLine()));

			

		}
		System.out.println("ù ��°");
		bTest[0].showBook();
		System.out.println("�� ��°");
		bTest[1].showBook();
		System.out.println("�� ��°");
		bTest[2].showBook();
	}
}

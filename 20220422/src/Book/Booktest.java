package Book;

import java.util.Scanner;

public class Booktest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] bTest = new Book[3];

		for (int i = 0; i < bTest.length; i++) {
			bTest[i] = new Book();
			System.out.print("책 이름 :");
			bTest[i].setBook(sc.nextLine());
			
			System.out.print("글쓴이 : ");
			bTest[i].setWrite(sc.nextLine());
			
			System.out.print("년도");
			bTest[i].setYear(Integer.parseInt(sc.nextLine()));
			
			System.out.print("월");
			bTest[i].setMonth(Integer.parseInt(sc.nextLine()));
			
			System.out.print("일");
			bTest[i].setDay(Integer.parseInt(sc.nextLine()));

			

		}
		System.out.println("첫 번째");
		bTest[0].showBook();
		System.out.println("두 번째");
		bTest[1].showBook();
		System.out.println("세 번째");
		bTest[2].showBook();
	}
}

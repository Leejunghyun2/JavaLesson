package Report02;

import java.util.Scanner;

public class ForExam08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("for 문 :");

		for (int month = 1; month != 0;) {
			System.out.print("가장 좋아하는 월은 ?(종료 : 0) : ");
			month = Integer.parseInt(sc.nextLine());
			if (month <= 12 && month >= 1) {
				switch (month) {
				case 3:
				case 4:
				case 5:
					System.out.println(month + "월은 봄에 해당됩니다.");
					System.out.println();
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month + "월은 여름에 해당됩니다.");
					System.out.println();
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month + "월은 가을에 해당됩니다.");
					System.out.println();
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month + "월은 겨울에 해당됩니다.");
					System.out.println();
					break;
				case 0:
					break;
				}
			} else if (month == 0) {
				break;
			} else {
				System.out.println("잘못 입력하셧습니다.");
				System.out.println();
			}
		}

		System.out.println("종료");
		System.out.println("------------------------------");
		System.out.println("while 문 :");

		System.out.print("가장 좋아하는 월은 ?(종료 : 0) : ");
		int month2 = Integer.parseInt(sc.nextLine());
		while (month2 != 0) {
			if (month2 <= 12 && month2 >= 1) {
				switch (month2) {
				case 3:
				case 4:
				case 5:
					System.out.println(month2 + "월은 봄에 해당됩니다.");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month2 + "월은 여름에 해당됩니다.");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month2 + "월은 가을에 해당됩니다.");
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month2 + "월은 겨울에 해당됩니다.");
					break;
				}
			} else {
				System.out.println("잘못 입력하셧습니다.");
			}
			System.out.print("가장 좋아하는 월은 ?(종료 : 0) : ");
			month2 = Integer.parseInt(sc.nextLine());

		}
		System.out.println("종료");
		System.out.println("------------------------------");
		System.out.println("do while 문 :");
		System.out.print("가장 좋아하는 월은 ?(종료 : 0) : ");
		int month3 = Integer.parseInt(sc.nextLine());
		do {
			if (month3 <= 12 && month3 >= 1) {

				switch (month3) {
				case 3:
				case 4:
				case 5:
					System.out.println(month3 + "월은 봄에 해당됩니다.");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month3 + "월은 여름에 해당됩니다.");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month3 + "월은 가을에 해당됩니다.");
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month3 + "월은 겨울에 해당됩니다.");
					break;
				}
			} else {
				System.out.println("잘못 입력하셧습니다.");
			}
			System.out.print("가장 좋아하는 월은 ?(종료 : 0) : ");
			month3 = Integer.parseInt(sc.nextLine());
		} while (month3 != 0);
		System.out.println("종료");

	}
}

package Report02;

import java.util.Scanner;

public class ForExam08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("for �� :");

		for (int month = 1; month != 0;) {
			System.out.print("���� �����ϴ� ���� ?(���� : 0) : ");
			month = Integer.parseInt(sc.nextLine());
			if (month <= 12 && month >= 1) {
				switch (month) {
				case 3:
				case 4:
				case 5:
					System.out.println(month + "���� ���� �ش�˴ϴ�.");
					System.out.println();
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month + "���� ������ �ش�˴ϴ�.");
					System.out.println();
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month + "���� ������ �ش�˴ϴ�.");
					System.out.println();
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month + "���� �ܿ￡ �ش�˴ϴ�.");
					System.out.println();
					break;
				case 0:
					break;
				}
			} else if (month == 0) {
				break;
			} else {
				System.out.println("�߸� �Է��ϼ˽��ϴ�.");
				System.out.println();
			}
		}

		System.out.println("����");
		System.out.println("------------------------------");
		System.out.println("while �� :");

		System.out.print("���� �����ϴ� ���� ?(���� : 0) : ");
		int month2 = Integer.parseInt(sc.nextLine());
		while (month2 != 0) {
			if (month2 <= 12 && month2 >= 1) {
				switch (month2) {
				case 3:
				case 4:
				case 5:
					System.out.println(month2 + "���� ���� �ش�˴ϴ�.");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month2 + "���� ������ �ش�˴ϴ�.");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month2 + "���� ������ �ش�˴ϴ�.");
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month2 + "���� �ܿ￡ �ش�˴ϴ�.");
					break;
				}
			} else {
				System.out.println("�߸� �Է��ϼ˽��ϴ�.");
			}
			System.out.print("���� �����ϴ� ���� ?(���� : 0) : ");
			month2 = Integer.parseInt(sc.nextLine());

		}
		System.out.println("����");
		System.out.println("------------------------------");
		System.out.println("do while �� :");
		System.out.print("���� �����ϴ� ���� ?(���� : 0) : ");
		int month3 = Integer.parseInt(sc.nextLine());
		do {
			if (month3 <= 12 && month3 >= 1) {

				switch (month3) {
				case 3:
				case 4:
				case 5:
					System.out.println(month3 + "���� ���� �ش�˴ϴ�.");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println(month3 + "���� ������ �ش�˴ϴ�.");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println(month3 + "���� ������ �ش�˴ϴ�.");
					break;
				case 1:
				case 2:
				case 12:
					System.out.println(month3 + "���� �ܿ￡ �ش�˴ϴ�.");
					break;
				}
			} else {
				System.out.println("�߸� �Է��ϼ˽��ϴ�.");
			}
			System.out.print("���� �����ϴ� ���� ?(���� : 0) : ");
			month3 = Integer.parseInt(sc.nextLine());
		} while (month3 != 0);
		System.out.println("����");

	}
}

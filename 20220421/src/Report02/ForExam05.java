package Report02;

import java.util.Scanner;

public class ForExam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0, sq = 1;

		System.out.print("����� �Է� : ");
		int num = Integer.parseInt(sc.nextLine());

		for (i = 3; i <= num; i += 3) {
			sq += 1;
			if (i <= num) {
				sum += i;
			}
		}
		System.out.println(num + "�� �Ѿ��� ���� �� : " + i);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ��� �ΰ� : " + sq);
		System.out.println("------------------------------------");
		int j = 0, sum2 = 0, sq2 = 0;
		while (j <= num) {
			sq2 += 1;
			if (j <= num) {
				sum2 += j;
			}
			j += 3;
		}
		System.out.println(num + "�� �Ѿ��� ���� �� : " + j);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum2);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ��� �ΰ� : " + sq2);
		System.out.println("------------------------------------");

		int k = 0, sum3 = 0, sq3 = 0;

		do {
			if (k <= num) {
				sum3 += k;
			}
			sq3 += 1;
			k += 3;
		} while (k <= num);
		System.out.println(num + "�� �Ѿ��� ���� �� : " + k);
		System.out.println(num + "�� �Ѿ��� �������� ���հ� : " + sum3);
		System.out.println(num + "�� �Ѿ��� ������ �� ��° 3�� ��� �ΰ� : " + sq3);

	}
}

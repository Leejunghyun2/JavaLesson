package Report02;

import java.util.Scanner;

public class ForExam07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 0, num = 0, sum = 0;

		for (i = 1; i <= 10; i++) {
			System.out.print(i + "번째 숫자를 입력하세요 : ");
			num = Integer.parseInt(sc.nextLine());
			if (i % 2 == 0) {
				num = -(num);
			}
			sum += num;
		}
		System.out.println("10개의 정수의 합 : " + sum);
		System.out.println("---------------------------");

		int j = 1, num2 = 0, sum2 = 0;

		while (j <= 10) {
			System.out.print(j + "번째 숫자를 입력하세요 : ");
			num2 = Integer.parseInt(sc.nextLine());
			if (j % 2 == 0) {
				num2 = -(num2);
			}
			sum2 += num2;
			j++;
		}
		System.out.println("10개의 정수의 합 : " + sum2);
		System.out.println("---------------------------");

		int k = 1, num3 = 0, sum3 = 0;

		do {
			System.out.print(k + "번째 숫자를 입력하세요 : ");
			num3 = Integer.parseInt(sc.nextLine());
			if (k % 2 == 0) {
				num3 = -(num3);
			}
			sum3 += num3;
			k++;
		} while (k <= 10);
		System.out.println("10개의 정수의 합 : " + sum3);

	}
}

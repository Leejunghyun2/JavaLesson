package Report02;

import java.util.Scanner;

public class ForExam01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0, i = 0, sum = 0;
		System.out.print("숫자를 입력하세요 : ");
		num = Integer.parseInt(sc.nextLine());

		for (i = num; i >= 1; i--) {
			sum += i;
		}
		System.out.printf("%d 부터 1까지의 합은 : %d \n", num, sum);
		System.out.println("--------------------------");

		int j = num, sum2 = 0;
		while (j >= 1) {
			sum2 += j;
			j--;
		}
		System.out.printf("%d 부터 1까지의 합은 : %d \n", num, sum2);
		System.out.println("--------------------------");
		int k = num, sum3 = 0;
		do {
			sum3 += k;
			k--;
		} while (k >= 1);
		System.out.printf("%d 부터 1까지의 합은 : %d ", num, sum3);
	}
}

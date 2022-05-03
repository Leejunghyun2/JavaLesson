package Report02;

import java.util.Scanner;

public class ForExam03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0, num = 0, sum = 0, var = 0;
		double avg = 0.0;

		for (i = 1; i <= 10; i++) {
			System.out.print(i + "번째 숫자를 입력하세요 : ");
			num = Integer.parseInt(sc.nextLine());
			if (num > 0) {
				sum += num;
				var += 1;
			}
		}
		avg = sum / (double) var;
		System.out.printf("전체 합 : %d \n전체 평균 : %f \n", sum, avg);
		System.out.println("-------------------------------------");

		int j = 1, sum2 = 0, var2 = 0;
		double avg2 = 0.0;
		while (j <= 10) {
			System.out.print(j + "번째 숫자를 입력하세요 : ");
			int num2 = Integer.parseInt(sc.nextLine());
			if (num2 > 0) {
				sum2 += num2;
				var2 += 1;
			}
			j++;
		}
		avg2 = sum2 / (double) var2;
		System.out.printf("전체 합 : %d \n전체 평균 : %f \n", sum2, avg2);
		System.out.println("-------------------------------------");

		int k = 1, sum3 = 0, var3 = 0;
		double avg3 = 0.0;
		do {
			System.out.print(k + "번째 숫자를 입력하세요 : ");
			int num3 = Integer.parseInt(sc.nextLine());
			if (num3 > 0) {
				sum3 += num3;
				var3 += 1;
			}
			k++;
		} while (k <= 10);
		avg3 = sum3 / (double) var3;
		System.out.printf("전체 합 : %d \n전체 평균 : %f \n", sum3, avg3);
	}
}

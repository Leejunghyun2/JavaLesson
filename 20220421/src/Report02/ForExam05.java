package Report02;

import java.util.Scanner;

public class ForExam05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0, sq = 1;

		System.out.print("사용자 입력 : ");
		int num = Integer.parseInt(sc.nextLine());

		for (i = 3; i <= num; i += 3) {
			sq += 1;
			if (i <= num) {
				sum += i;
			}
		}
		System.out.println(num + "을 넘었을 때의 값 : " + i);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수 인가 : " + sq);
		System.out.println("------------------------------------");
		int j = 0, sum2 = 0, sq2 = 0;
		while (j <= num) {
			sq2 += 1;
			if (j <= num) {
				sum2 += j;
			}
			j += 3;
		}
		System.out.println(num + "을 넘었을 때의 값 : " + j);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum2);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수 인가 : " + sq2);
		System.out.println("------------------------------------");

		int k = 0, sum3 = 0, sq3 = 0;

		do {
			if (k <= num) {
				sum3 += k;
			}
			sq3 += 1;
			k += 3;
		} while (k <= num);
		System.out.println(num + "을 넘었을 때의 값 : " + k);
		System.out.println(num + "을 넘었을 때까지의 총합계 : " + sum3);
		System.out.println(num + "을 넘었을 때까지 몇 번째 3의 배수 인가 : " + sq3);

	}
}

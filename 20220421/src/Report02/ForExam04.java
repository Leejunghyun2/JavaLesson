package Report02;

public class ForExam04 {
	public static void main(String[] args) {
		int i = 1, sum = 0;

		for (i = 1; i <= 100; i++) {

			sum += i;
			if (i % 10 == 0) {
				System.out.printf("1-%d : %d \n", i, sum);
			}
		}
		System.out.println("-----------------------");

		int j = 1, sum2 = 0;

		while (j <= 100) {
			sum2 += j;
			if (j % 10 == 0) {
				System.out.printf("1-%d : %d \n", j, sum2);
			}
			j++;
		}
		System.out.println("-----------------------");

		int k = 1, sum3 = 0;

		do {
			sum3 += k;
			if (k % 10 == 0) {
				System.out.printf("1-%d : %d \n", k, sum3);
			}
			k++;
		} while (k <= 100);
	}
}

package Report02;

public class ForExom02 {
	public static void main(String[] args) {
		int i = 1, sum = 0;

		for (i = 1; i < 100; i += 2) {
			sum += i;
		}
		System.out.println("1~100 ���� Ȧ���� ���� : " + sum);
		System.out.println("--------------------------");

		int j = 1, sum2 = 0;

		while (j < 100) {
			sum2 += j;
			j += 2;
		}
		System.out.println("1~100 ���� Ȧ���� ���� : " + sum2);
		System.out.println("--------------------------");

		int k = 1, sum3 = 0;
		do {
			sum3 += k;
			k += 2;
		} while (k < 100);
		System.out.println("1~100 ���� Ȧ���� ���� : " + sum3);
	}

}

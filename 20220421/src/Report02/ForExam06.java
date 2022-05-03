package Report02;

import java.util.Scanner;

public class ForExam06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num =0, i = 0;
		System.out.print("사용자 입력: ");
		num = Integer.parseInt(sc.nextLine());
		
		for(i=num; i>0; i-=2) {
			System.out.printf("%d * %d = %d\n",i,num,i*num);
		}
		System.out.println("----------------------");
		
		int j = num;
		
		while(j>0) {
			System.out.printf("%d * %d = %d \n",j,num,j*num);
			j -= 2;
		}
		System.out.println("----------------------");
		
		int k = num;
		
		do {
			System.out.printf("%d * %d = %d \n",k,num,k*num);
			k -= 2;
		}while(k>0);
		
	}
}

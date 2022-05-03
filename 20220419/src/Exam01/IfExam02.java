package Exam01;

import java.util.Scanner;

public class IfExam02 {

	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 숫자를 입력하시오 : ");
			int first = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력하시오 : ");
			int second = Integer.parseInt(sc.nextLine());
		
		/*
		 둘다 홀수 또는 짝수가 나오는 건 두합을 더해 나머지가 안남으면 둘다 짝 수 이거나 홀수로 나타내는 방법이 있습니다.
		 int third = first + second;
		 if( third % 2 == 0 )
		 {
		  System.out.println("두 수 모두 짝수 이거나 홀수 입니다.);
		 }
		 */
			if(first % 2 == 0 && second % 2 == 0)
			{
				System.out.println("두 숫자는 같은 짝수입니다.");
			}
			else if(first % 2 == 1 && second % 2 == 1)
			{
				System.out.println("두 숫자는 같은 홀수입니다.");
			}
			else
			{
				System.out.println("두 숫자가 다릅니다.");
			}
		
	}
}

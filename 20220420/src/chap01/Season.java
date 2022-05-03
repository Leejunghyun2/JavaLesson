package chap01;

import java.util.Scanner;

public class Season {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 월 인가요 ?");
		int month = Integer.parseInt(sc.nextLine());
        int result = 0;
        result = month%12;
        if(month <=12 && month > 0) {
        	
        	if(result>=9) {
        		System.out.println("가을입니다.");
        	} else if(result>=6) {
        		System.out.println("여름입니다.");
        	} else if(result>=3) {
        		System.out.println("봄입니다.");
        	} else if(result>=0) {
        		System.out.println("겨울입니다.");
        	} 
        } else {
        	System.out.println("잘못 입력하셨습니다.");
        }
	/*	
		if(month > 0 && month <= 12){
			if(month >= 3 && month <= 5) {
				System.out.println("봄 입니다.");
			} else if(month >= 6 && month <= 8) {
				System.out.println("여름 입니다.");
			} else if(month >= 9 && month <= 11) {
				System.out.println("여름 입니다.");
			} else {
				System.out.println("겨울 입니다.");
			}
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	 */
}
}

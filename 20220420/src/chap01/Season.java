package chap01;

import java.util.Scanner;

public class Season {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("�� �� �ΰ��� ?");
		int month = Integer.parseInt(sc.nextLine());
        int result = 0;
        result = month%12;
        if(month <=12 && month > 0) {
        	
        	if(result>=9) {
        		System.out.println("�����Դϴ�.");
        	} else if(result>=6) {
        		System.out.println("�����Դϴ�.");
        	} else if(result>=3) {
        		System.out.println("���Դϴ�.");
        	} else if(result>=0) {
        		System.out.println("�ܿ��Դϴ�.");
        	} 
        } else {
        	System.out.println("�߸� �Է��ϼ̽��ϴ�.");
        }
	/*	
		if(month > 0 && month <= 12){
			if(month >= 3 && month <= 5) {
				System.out.println("�� �Դϴ�.");
			} else if(month >= 6 && month <= 8) {
				System.out.println("���� �Դϴ�.");
			} else if(month >= 9 && month <= 11) {
				System.out.println("���� �Դϴ�.");
			} else {
				System.out.println("�ܿ� �Դϴ�.");
			}
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	 */
}
}

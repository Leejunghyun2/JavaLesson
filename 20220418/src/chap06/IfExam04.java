package chap06;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ӵ��� �Է��Ͻÿ� :");
		double var = Double.parseDouble(sc.nextLine());
	    double per = 0.0;
	    final double INS= 400.0;
		per = INS/var;
	    if(per>=4.0)
	    {
	    	System.out.println("�ɸ��� �ð� : " + per +"�ð�");
	    	System.out.println("Good Speed");
	    }
	    else if (per>2.0)
	    {
	    	System.out.println("�ɸ��� �ð� : " + per +"�ð�");
	    	System.out.println("High speed");
	    }
	    else
	    {
	    	System.out.println("�ɸ��� �ð� : " + per +"�ð�");
	    	System.out.println("High High Speed");
	    }
	    
		
	}
}

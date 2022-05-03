package chap06;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("속도를 입력하시오 :");
		double var = Double.parseDouble(sc.nextLine());
	    double per = 0.0;
	    final double INS= 400.0;
		per = INS/var;
	    if(per>=4.0)
	    {
	    	System.out.println("걸리는 시간 : " + per +"시간");
	    	System.out.println("Good Speed");
	    }
	    else if (per>2.0)
	    {
	    	System.out.println("걸리는 시간 : " + per +"시간");
	    	System.out.println("High speed");
	    }
	    else
	    {
	    	System.out.println("걸리는 시간 : " + per +"시간");
	    	System.out.println("High High Speed");
	    }
	    
		
	}
}

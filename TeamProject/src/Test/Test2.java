package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test2 {
	Scanner sc = new Scanner(System.in);
	ReservationNumber sc1 = ReservationNumber.getInstance();
	
	private static Test2 se;
	
	private Test2() {
		
	}
	public static Test2 getInstance() {
		if(se == null) {
			se = new Test2();
			return se;
		}return se;
	}
	
	
	
	void Test() {
		System.out.print("�׽�Ʈ ���� :");
	int ia = Integer.parseInt(sc.nextLine());
		ReservationNumber.movieTime11 = new String[ia];
	
	for(int i=1; i<= ReservationNumber.movieTime11.length; i++) {
		System.out.print("�׽�Ʈ �̸� : ");
		String name = sc.nextLine();
		ReservationNumber.movieTime11[i-1] = name; 
	}
	System.out.println("����" + ia);
	System.out.println(Arrays.toString(ReservationNumber.movieTime11));
	}
	
	
	
}

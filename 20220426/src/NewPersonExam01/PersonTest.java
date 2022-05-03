package NewPersonExam01;

import java.util.Scanner;

public class PersonTest {
   static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	   
	    
	    System.out.print("이름 : ");
	    String name = sc.nextLine();
	    System.out.print("전번 : ");
	    String phoneNumber = sc.nextLine();
	    System.out.print("생일 : ");
	    String birth = sc.nextLine();
	    
	    
	    Person s2 = new Person(name, phoneNumber, birth);
	    
	   

	}
	
}

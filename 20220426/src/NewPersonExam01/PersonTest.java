package NewPersonExam01;

import java.util.Scanner;

public class PersonTest {
   static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	   
	    
	    System.out.print("�̸� : ");
	    String name = sc.nextLine();
	    System.out.print("���� : ");
	    String phoneNumber = sc.nextLine();
	    System.out.print("���� : ");
	    String birth = sc.nextLine();
	    
	    
	    Person s2 = new Person(name, phoneNumber, birth);
	    
	   

	}
	
}

package NewPersonExam01;

import java.util.Scanner;

public class MenuTest {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		MenuChoice cc = new MenuChoice();

		System.out.print("������ �����ϼ��� : 1.������ 2.������\n");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
			cc.galaxy();
			break;
		case 2:
			cc.iPhone();
			break;
			
		default:
			System.out.println("�߸��Է�");
		}
		
	}
	
}
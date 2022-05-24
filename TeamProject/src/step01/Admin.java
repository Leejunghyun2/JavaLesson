package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Admin extends User implements Serializable {
	private static Admin s;
	MovieReservation mm = MovieReservation.getinstance();
	NewMember nm = NewMember.getinfo();
	ArrayList<User> users = NewMember.userInstance();
	private static String id = "#admin";
	private static String pwd = "0462";

	private Admin() {

	}

	public static Admin getInstance() {
		if (s == null) {
			s = new Admin();
			return s;
		}
		return s;
	}

	static boolean Ad(String id, String pwd) {
		if (id.equals(Admin.id)) {
			if (pwd.equals(Admin.pwd)) {
				return true;
			}
		}
		return false;
	}
	private void showAllUser() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).showInfo();
			System.out.println(users.get(i));
		}
	}
	private void MovieManagement() throws Exception {
		MenuViewer.MovieManagement();
		int choice = Integer.parseInt(MovieReservation.sc.nextLine());
		switch (choice) {
		case 1:
			MovieName();
			break;
		case 2:
			MovieCount();
			break;
		}
	}
	
	private void MovieCount() throws ChoiceException {
		try {
			System.out.println("�󿵰��� �������ּ���");
			System.out.printf("1. 1�� 2. 2�� 3. 3�� \n ==>");
			int moviechoice = Integer.parseInt(MovieReservation.sc.nextLine());
			System.out.print("���� ������ �Է��ϼ��� \n ==> ");
			int number = Integer.parseInt(MovieReservation.sc.nextLine());
			System.out.printf("%d �� �½��ϱ�? 1. Yes 2. No \n==> ", number);
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 1 || choice > 2) {
				throw new ChoiceException();
			}
			if (choice == 1) {
				MovieSearch(moviechoice, number);
			} else {
				System.out.println("----���----");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���\n");
		}

	}


	private void MovieSearch(int choice, int num) {
			try {
			MovieReservation.movie[choice-1] = new String[6][6][num];
			MovieReservation.movieTime[choice-1] = new String[num];
		for (int i = 0; i < num; i++) {
			while (true) {
				System.out.printf(choice + "�� %d��° ��ȭ�ð��� �����ּ��� ed)10��20�� : 1020\n ==> ", i+1);
				int time = Integer.parseInt(MovieReservation.sc.nextLine());
				String hour = String.valueOf(time).substring(0, 2);
				String minute = String.valueOf(time).substring(2, 4);
				System.out.printf("%s �� %s �� �½��ϱ�?1.Yes 2.No\n ==> ", hour, minute);
				int yn = Integer.parseInt(MovieReservation.sc.nextLine());
				if (yn < 1 || yn > 2) {
					System.out.println("�߸��Է��ϼ˽��ϴ�.�ٽ��Է����ּ���");
					continue;
				}
				if (yn == 1) {
						MovieReservation.movieTime[choice-1][i] = hour + "�� " + minute + "��";
						break;
				} else {
					System.out.println("�ٽ� �Է����ּ���");
					continue;
				}
			}
		}
		System.out.println(num + "�� �����Ϸ�");
		mm.movieSeat(choice);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

	private void MovieName() throws ChoiceException {
		System.out.println("�������ּ���");
		System.out.print("1. 1��  2. 2�� 3. 3��\n ==> ");
		try {
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 0 || choice > 3) {
				throw new ChoiceException();
			}
				System.out.print(choice + "�� ��ȭ�̸��� �����ּ���. \n==>");
				MenuViewer.movieName[choice-1] = MovieReservation.sc.nextLine();
			
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���.\n");
		}

	}
	void adminChoice() {
		try {
		mm.MovieCheck();
		MenuViewer.showAdminChoice();
		int choice = Integer.parseInt(MovieReservation.sc.nextLine());
		switch(choice) {
		case 1:{
			System.out.println("----����x----");
			break;
		}
		case 2:{
			MovieManagement();
			break;
		}
		case 3:{
			mm.showSeat();
			break;
		}
		case 4:
			if (nm.searchList()) {
				System.out.println("ȸ�� ����� �������� �ʽ��ϴ�.");
				break;
			} else {
				showAllUser();
				break;
			}
		case 5:{
			mm.signOut();
			return;
		}
		
		}
		}catch(Exception e) {}
	}

}

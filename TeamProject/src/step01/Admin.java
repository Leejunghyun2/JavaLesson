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
	String fileName = "Admin.ser";
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

	void MovieManagement() throws Exception {
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

	void MovieCount() throws ChoiceException {
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

	void MovieSearch(int choice, int num) {
		switch (choice) {
		case 1:
			MovieReservation.movie1 = new String[3][num][6][6];
			MovieReservation.movieTime1 = new String[num];
			break;
		case 2:
			MovieReservation.movie2 = new String[3][num][6][6];
			MovieReservation.movieTime2 = new String[num];
			break;
		case 3:
			MovieReservation.movie3 = new String[3][num][6][6];
			MovieReservation.movieTime3 = new String[num];
			break;
		}
		for (int i = 1; i <= num; i++) {
			while (true) {
				System.out.printf(choice + "�� %d��° ��ȭ�ð��� �����ּ��� ed)10��20�� : 1020\n ==> ", i);
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
					switch (choice) {
					case 1:
						MovieReservation.movieTime1[i - 1] = hour + "�� " + minute + "��";
						break;
					case 2:
						MovieReservation.movieTime2[i - 1] = hour + "�� " + minute + "��";
						break;
					case 3:
						MovieReservation.movieTime3[i - 1] = hour + "�� " + minute + "��";
						break;
					}
					break;
				} else {
					System.out.println("�ٽ� �Է����ּ���");
					continue;
				}
			}
		}
		System.out.println(num + "�� �����Ϸ�");
		mm.movieSeat(choice);

	}

	void MovieName() throws ChoiceException {
		System.out.println("�������ּ���");
		System.out.print("1. 1��  2. 2�� 3. 3��\n ==> ");
		try {
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 0 || choice > 3) {
				throw new ChoiceException();
			}
			switch (choice) {
			case 1:
				System.out.print(choice + "�� ��ȭ�̸��� �����ּ���. \n==>");
				MenuViewer.movieName1 = MovieReservation.sc.nextLine();
				break;
			case 2:
				System.out.print(choice + "�� ��ȭ�̸��� �����ּ���. \n==>");
				MenuViewer.movieName2 = MovieReservation.sc.nextLine();
				break;
			case 3:
				System.out.print(choice + "�� ��ȭ�̸��� �����ּ���. \n==>");
				MenuViewer.movieName3 = MovieReservation.sc.nextLine();
				break;
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (NumberFormatException e) {
			System.out.println("���ڸ� �Է��ϼ���.\n");
		}

	}

}

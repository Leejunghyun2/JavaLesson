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
			System.out.println("상영관을 선택해주세요");
			System.out.printf("1. 1관 2. 2관 3. 3관 \n ==>");
			int moviechoice = Integer.parseInt(MovieReservation.sc.nextLine());
			System.out.print("상영할 갯수를 입력하세요 \n ==> ");
			int number = Integer.parseInt(MovieReservation.sc.nextLine());
			System.out.printf("%d 개 맞습니까? 1. Yes 2. No \n==> ", number);
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 1 || choice > 2) {
				throw new ChoiceException();
			}
			if (choice == 1) {
				MovieSearch(moviechoice, number);
			} else {
				System.out.println("----취소----");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요\n");
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
				System.out.printf(choice + "관 %d번째 영화시간을 적어주세요 ed)10시20분 : 1020\n ==> ", i);
				int time = Integer.parseInt(MovieReservation.sc.nextLine());
				String hour = String.valueOf(time).substring(0, 2);
				String minute = String.valueOf(time).substring(2, 4);
				System.out.printf("%s 시 %s 분 맞습니까?1.Yes 2.No\n ==> ", hour, minute);
				int yn = Integer.parseInt(MovieReservation.sc.nextLine());
				if (yn < 1 || yn > 2) {
					System.out.println("잘못입력하셧습니다.다시입력해주세요");
					continue;
				}
				if (yn == 1) {
					switch (choice) {
					case 1:
						MovieReservation.movieTime1[i - 1] = hour + "시 " + minute + "분";
						break;
					case 2:
						MovieReservation.movieTime2[i - 1] = hour + "시 " + minute + "분";
						break;
					case 3:
						MovieReservation.movieTime3[i - 1] = hour + "시 " + minute + "분";
						break;
					}
					break;
				} else {
					System.out.println("다시 입력해주세요");
					continue;
				}
			}
		}
		System.out.println(num + "개 생성완료");
		mm.movieSeat(choice);

	}

	void MovieName() throws ChoiceException {
		System.out.println("선택해주세요");
		System.out.print("1. 1관  2. 2관 3. 3관\n ==> ");
		try {
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 0 || choice > 3) {
				throw new ChoiceException();
			}
			switch (choice) {
			case 1:
				System.out.print(choice + "관 영화이름을 적어주세요. \n==>");
				MenuViewer.movieName1 = MovieReservation.sc.nextLine();
				break;
			case 2:
				System.out.print(choice + "관 영화이름을 적어주세요. \n==>");
				MenuViewer.movieName2 = MovieReservation.sc.nextLine();
				break;
			case 3:
				System.out.print(choice + "관 영화이름을 적어주세요. \n==>");
				MenuViewer.movieName3 = MovieReservation.sc.nextLine();
				break;
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.\n");
		}

	}

}

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


	private void MovieSearch(int choice, int num) {
			try {
			MovieReservation.movie[choice-1] = new String[6][6][num];
			MovieReservation.movieTime[choice-1] = new String[num];
		for (int i = 0; i < num; i++) {
			while (true) {
				System.out.printf(choice + "관 %d번째 영화시간을 적어주세요 ed)10시20분 : 1020\n ==> ", i+1);
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
						MovieReservation.movieTime[choice-1][i] = hour + "시 " + minute + "분";
						break;
				} else {
					System.out.println("다시 입력해주세요");
					continue;
				}
			}
		}
		System.out.println(num + "개 생성완료");
		mm.movieSeat(choice);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}

	}

	private void MovieName() throws ChoiceException {
		System.out.println("선택해주세요");
		System.out.print("1. 1관  2. 2관 3. 3관\n ==> ");
		try {
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if (choice < 0 || choice > 3) {
				throw new ChoiceException();
			}
				System.out.print(choice + "관 영화이름을 적어주세요. \n==>");
				MenuViewer.movieName[choice-1] = MovieReservation.sc.nextLine();
			
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력하세요.\n");
		}

	}
	void adminChoice() {
		try {
		mm.MovieCheck();
		MenuViewer.showAdminChoice();
		int choice = Integer.parseInt(MovieReservation.sc.nextLine());
		switch(choice) {
		case 1:{
			System.out.println("----구현x----");
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
				System.out.println("회원 목록이 존재하지 않습니다.");
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

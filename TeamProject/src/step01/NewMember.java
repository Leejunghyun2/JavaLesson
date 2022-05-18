package step01;

import java.util.ArrayList;

public class NewMember {
	private static NewMember member;

	static User user = new User();
	final String[] sign = new String[1]; 
	public static NewMember getinfo() {
		if (member == null) {
			member = new NewMember();
			return member;
		}
		return member;
	}
	ArrayList<User> users = new ArrayList<User>();
	boolean signIn() {
		 sign[0] = login();
		 if(sign[0]==null) {
			 return false;
		 }return true;
	}
	
	void input() {
		User tmp = loginInfo();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(tmp.getId())) {
				System.out.println("중복자료입니다.");
				return;
			}
		}
		users.add(tmp);
		System.out.println("---------가입완료----------");

	}

	void showAllUser() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).showInfo();
		}
	}

	String login() {
		System.out.print("ID를 입력하세요 ==> ");
		String id = MovieReservation.sc.nextLine().trim();
		System.out.println("비밀번호를 입력하세요 ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				if (users.get(i).getPwd().equals(pwd)) {
					System.out.println("---로그인 완료---");
					return id;
				}
			}

		}
		System.out.println("----잘못 입력 하셨습니다.----");
		return null;
	}

	public boolean searchList() {
		if (users.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	User loginInfo() {
		System.out.print("id ==>");
		String id = MovieReservation.sc.nextLine();
		System.out.print("pwd ==> ");
		String pwd = MovieReservation.sc.nextLine();
		System.out.print("name ==> ");
		String name = MovieReservation.sc.nextLine();
		System.out.print("phoneNumber ==> ");
		String phoneNumber = MovieReservation.sc.nextLine();

		return new User(id, pwd, name, phoneNumber);
	}
}
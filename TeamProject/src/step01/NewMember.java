package step01;

import java.util.ArrayList;

public class NewMember {
	private static NewMember member;

	private User user = new User();
	final static String[] SIGN = new String[1]; 
	public static NewMember getinfo() {
		if (member == null) {
			member = new NewMember();
			return member;
		}
		return member;
	}
	
	private static ArrayList<User> users;
	public static ArrayList<User> userInstance(){
		if(users == null) {
			users = new ArrayList<User>();
			return users;
		}
		return users;
	}
	
	String signIn() {
		 SIGN[0] = login();
		 if(SIGN[0]==null) {
			 return null;
		 }return SIGN[0];
	}
	
	void input() {
		User tmp = loginInfo();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(tmp.getId())) {
				System.out.println("중복된 ID입니다.");
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
		System.out.print("비밀번호를 입력하세요 ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				if (users.get(i).getPwd().equals(pwd)) {
					System.out.println("---로그인 완료---");
					SIGN[0] = id;
					return id;
				}
			}

		}
		System.out.println("----잘못 입력 하셨습니다.----");
		SIGN[0] = null;
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
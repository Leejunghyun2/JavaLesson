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
				System.out.println("�ߺ��ڷ��Դϴ�.");
				return;
			}
		}
		users.add(tmp);
		System.out.println("---------���ԿϷ�----------");

	}

	void showAllUser() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).showInfo();
		}
	}

	String login() {
		System.out.print("ID�� �Է��ϼ��� ==> ");
		String id = MovieReservation.sc.nextLine().trim();
		System.out.println("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				if (users.get(i).getPwd().equals(pwd)) {
					System.out.println("---�α��� �Ϸ�---");
					return id;
				}
			}

		}
		System.out.println("----�߸� �Է� �ϼ̽��ϴ�.----");
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
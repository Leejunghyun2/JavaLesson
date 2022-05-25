package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewMember {
	private static NewMember member;
	final static String[] SIGN = new String[1];

	public static NewMember getInfo() {
		if (member == null) {
			member = new NewMember();
			return member;
		}
		return member;
	}

	private NewMember() {
		fileSearch();
	}

	private static ArrayList<User> users;
	MovieReservation mm = MovieReservation.getinstance();

	public static ArrayList<User> userInstance() {
		if (users == null) {
			users = new ArrayList<User>();
			return users;
		}
		return users;
	}

	String fileName = "NewMember.ser";
	MovieReservation reserInfo = MovieReservation.getinstance();

	void joinMember() {
		User tmp = joinInfo();
		if (search(tmp.getId()) == null) {
			System.out.println("영문자로시작하거나 2글자 이상이어야합니다.");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(tmp.getId())) {
				System.out.println("중복된 ID입니다.");
				return;
			}
		}
		users.add(tmp);
		System.out.println("---------가입완료----------");

	}

	boolean userLogin(String id, String pwd) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(id)) {
				if (users.get(i).getPwd1(pwd)) {
					NewMember.SIGN[0] = id;
					return true;
				}
			}
		}
		return false;
	}

	void memberDelete() {
		System.out.print("비밀번호를 입력하세요 ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(SIGN[0])) {
				if (users.get(i).getPwd1(pwd)) {
					System.out.println("※회원으로 예매한 내역이 모두 취소됩니다※");
					System.out.print("정말 탈퇴하시겠습니까? 1. Yes 2. No\n");
					System.out.print("==> ");
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					if (choice == 1) {
						reserInfo.allCancel();
						users.remove(i);
						System.out.println("-----탈퇴완료-----");
						SIGN[0] = null;
						return;

					} else {
						System.out.println("취소");
						return;
					}
				} else {
					System.out.println("-----비밀번호가 틀렸습니다.-----");
					return;
				}
			}
		}
	}

	public boolean searchList() {
		if (users.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	User joinInfo() {
		System.out.print("id ==> ");
		String id = MovieReservation.sc.nextLine();
		System.out.print("pwd ==> ");
		String pwd = MovieReservation.sc.nextLine();
		System.out.print("name ==> ");
		String name = MovieReservation.sc.nextLine();
		System.out.print("phoneNumber ==> ");
		String phoneNumber = MovieReservation.sc.nextLine();

		return new User(id, pwd, name, phoneNumber);
	}

	private String search(String id) {
		if (id.length() < 2) {
			System.out.println("글자수가 적습니다.");
			return null;
		} else if (!(id.charAt(0) >= 'A' && id.charAt(0) <= 'Z')) {
			if (!(id.charAt(0) >= 'a' && id.charAt(0) <= 'z')) {
				return null;
			}
		}

		return id;
	}
	void userMenu() throws Exception {
		while (true) {
		try {
			MenuViewer.showMenu();
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			if(choice < 0 || choice >7) {
				throw new ChoiceException();
			}
			switch (choice) {
			case 1:
				mm.seatChoice();
				break;
			case 2:
				mm.reservationConfirm();
				break;
			case 3:
				mm.reservationCancel();
				break;
			case 4:
				mm.showSeatStatus();
				break;
			case 5:
				if(mm.signOut()) {
				return;
				}break;
			case 6:
				memberDelete();
				break;
			case 7:
				mm.test();
				break;
			case 0:
				return;
			}
			
		} catch (Exception e) {
			continue;
		}
		}
	}

	void objOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {

			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(users);
			System.out.println("저장 되었습니다..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	void objInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);

			users = (ArrayList<User>) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	

	void fileSearch() {
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\NewMember.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			objInputData();
		}
	}
}
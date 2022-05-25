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
			System.out.println("�����ڷν����ϰų� 2���� �̻��̾���մϴ�.");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(tmp.getId())) {
				System.out.println("�ߺ��� ID�Դϴ�.");
				return;
			}
		}
		users.add(tmp);
		System.out.println("---------���ԿϷ�----------");

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
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId1(SIGN[0])) {
				if (users.get(i).getPwd1(pwd)) {
					System.out.println("��ȸ������ ������ ������ ��� ��ҵ˴ϴ١�");
					System.out.print("���� Ż���Ͻðڽ��ϱ�? 1. Yes 2. No\n");
					System.out.print("==> ");
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					if (choice == 1) {
						reserInfo.allCancel();
						users.remove(i);
						System.out.println("-----Ż��Ϸ�-----");
						SIGN[0] = null;
						return;

					} else {
						System.out.println("���");
						return;
					}
				} else {
					System.out.println("-----��й�ȣ�� Ʋ�Ƚ��ϴ�.-----");
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
			System.out.println("���ڼ��� �����ϴ�.");
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
			System.out.println("���� �Ǿ����ϴ�..");
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
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
	public static NewMember getinfo() {
		if (member == null) {
			member = new NewMember();
			return member;
		}
		return member;
	}
	private NewMember() {
		FileSearch();
	}

	private static ArrayList<User> users;

	public static ArrayList<User> userInstance() {
		if (users == null) {
			users = new ArrayList<User>();
			return users;
		}
		return users;
	}

	String fileName = "NewMember.ser";
	MovieReservation reserInfo = MovieReservation.getinstance();



	void input() {
		User tmp = loginInfo();
		if(Search(tmp.getId()) == null){
			System.out.println("�����ڷν����ϰų� 2���� �̻��̾���մϴ�.");
			return;
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(tmp.getId())) {
				System.out.println("�ߺ��� ID�Դϴ�.");
				return;
			}
		}
		users.add(tmp);
		System.out.println("---------���ԿϷ�----------");

	}

	void MemberDelete() {
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(SIGN[0])) {
				if (users.get(i).getPwd().equals(pwd)) {
					System.out.println("��ȸ������ ������ ������ ��� ��ҵ˴ϴ١�");
					System.out.print("���� Ż���Ͻðڽ��ϱ�? 1. Yes 2. No\n");
					System.out.print("==> ");
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					if (choice == 1) {
						reserInfo.AllCancle();
						users.remove(i);
						System.out.println("-----Ż��Ϸ�-----");
						SIGN[0]=null;
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

	void showAllUser() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).showInfo();
		}
	}

	String login() {
		System.out.print("ID�� �Է��ϼ��� ==> ");
		String id = MovieReservation.sc.nextLine().trim();
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
		if(Admin.Ad(id, pwd))
		{
			System.out.println("-----������ �α���-----");
			SIGN[0] = "������";
			return "������";
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId().equals(id)) {
				if (users.get(i).getPwd().equals(pwd)) {
					System.out.println("---�α��� �Ϸ�---");
					SIGN[0] = id;
					return id;
				}
			}

		}
		System.out.println("----�߸� �Է� �ϼ̽��ϴ�.----");
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
	private String Search(String id) {
		 if(id.length()<2) {
			 System.out.println("���ڼ��� �����ϴ�.");
			 return null;
		 }else if(!(id.charAt(0) >='A' && id.charAt(0) <= 'Z')) {
			 if(!(id.charAt(0) >= 'a' && id.charAt(0) <= 'z')){
				 return null;
			 }
		 }
		 
		 return id;
	}

	void ObjOutputData() {
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
	void ObjInputData() {
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

	void FileSearch() {
		File f = new File("C:\\Users\\������\\eclipse-workspace\\TeamProject\\NewMember.ser");
		if (!f.exists()) {
			System.out.println("Start");
		} else if (f.exists()) {
			ObjInputData();
			System.out.println("-----���� �ҷ����� �Ϸ�-----");
		}
	}
}
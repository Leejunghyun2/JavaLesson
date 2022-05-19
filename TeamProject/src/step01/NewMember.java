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
	public static ArrayList<User> userInstance(){
		if(users == null) {
			users = new ArrayList<User>();
			return users;
		}
		return users;
	}
	String fileName="NewMember.ser";
	
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
				System.out.println("�ߺ��� ID�Դϴ�.");
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
		System.out.print("��й�ȣ�� �Է��ϼ��� ==> ");
		String pwd = MovieReservation.sc.nextLine().trim();
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
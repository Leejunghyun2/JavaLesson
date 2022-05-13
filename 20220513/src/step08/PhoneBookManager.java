package step08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneBookManager {
	private static PhoneBookManager s; // �ν��Ͻ�ȣ�� ���� ��밡��

	private PhoneBookManager() {// �ٸ� Ŭ�������� ��� ���ϰ�
	}

	public static PhoneBookManager getInstance() { // �ٸ� ������ ��ġ���ʱ� ���� �̱��� �۾�
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	int count = 1;
	Set<Person> infoStorage = new HashSet<Person>();

	void inputData() throws MenuChoiceException {
		System.out.print("�߰��� �׸��� �����ϼ���\n1. ģ�� 2.����ģ�� 3.ȸ��ģ�� ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());

		if (choice < 1 || choice > 3) { // �޴� ���̽��� 1,2,3,�̾ƴ϶�� �ͼ���
			throw new MenuChoiceException(choice);
		}
		Person tmp = null;
		switch (choice) {
		case SubMenu.FRIENDS: {
			tmp = PrimaryInfo(); // ģ��
			break;
		} // SubMenu.FRIENDS:��
		case SubMenu.UNIVFRIENDS: {
			tmp = UniPerson(); // ����ģ��
			break;
		} // SubMenu.UNIVFRIENDS:��
		case SubMenu.COMFRIENDS: {
			tmp = ComPerson(); // ȸ��ģ��
			break;
		} // case SubMenu.COMFRIENDS:��
		}// switch�� ��

		if (infoStorage.add(tmp)) { // infoStorage�� ���̵��� true �ߺ��̸� false
			System.out.println("�Է¿Ϸ�");
		} else {
			System.out.println("�Է½��� : �ߺ��ڷ�");
		}
	}

	void allDisplay() {
		if (infoStorage.isEmpty()) {
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
		}
		Iterator<Person> it = infoStorage.iterator(); // infoStorage�� �ִ� ������ ���ͷ������ؼ� ���
		while (it.hasNext()) { // �����ڷᰡ �ֳ� ���Ŀ� ���� true, false ��ȯ
			System.out.print(count + ": ");
			Person tmp = (Person) it.next();
			tmp.showPhoneInfo();
			System.out.println("-------------------------------------------------------------------");
			count++;
		}
		count = 1;
	}

	void searchData() {
		System.out.print("�˻��� �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = search(name);
		if (tmp != null) { // search���� name�� ã�����ϸ� null�� ��ȯ
			tmp.showPhoneInfo();
		} else {
			System.out.println("���� x");
		}
	}

	void updateData() {
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if (tmp != null) {
			System.out.print("������ ���� ? ==> ");
			tmp.phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("������ ���� ? ==> ");
			tmp.birth = MenuViewer.sc.nextLine();
			if (tmp instanceof UnivFriends) { // ����ȯ �������� Ȯ�� �� true�� ���� ���� ����
				UnivFriends tmp1 = null;
				tmp1 = (UnivFriends) tmp; // grade, major �����ϱ� ���� ����ȯ
				System.out.print("������ ���� ? ==> ");
				tmp1.major = MenuViewer.sc.nextLine();
				System.out.print("������ �г� ? ==> ");
				tmp1.grade = Integer.parseInt(MenuViewer.sc.nextLine());
			} else if (tmp instanceof CompanyFriends) { // ����ȯ �������� Ȯ�� �� true�� ���� ���� ����
				CompanyFriends tmp1 = null;
				tmp1 = (CompanyFriends) tmp;// comName �����ϱ� ���� ����ȯ
				System.out.print("������ ȸ���̸� ? ==> ");
				tmp1.comName = MenuViewer.sc.nextLine();
			}
		} else {
			System.out.println("���� x");
		}

	}

	void deleteData() {
		if (infoStorage.isEmpty()) { // infoStorage �� ��Ұ� ������ false ������ true ��ȯ
			System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = search(name);
		if (tmp == null) {
			System.out.println("������ ������ �����ϴ�.");
			return;
		}
		infoStorage.remove(tmp);
	}

	void allDelete() {
		if (infoStorage.isEmpty()) {
			System.out.println("������ �����Ͱ� �����ϴ�.");
			return;
		}
		System.out.print("��ü�����Ͻðڽ��ϱ�? 1. Yes 2. No ==>");
		int remove = Integer.parseInt(MenuViewer.sc.nextLine());
		if (remove == 1) {
			Iterator<Person> it = infoStorage.iterator();
			while (it.hasNext()) {
				it.next();
				it.remove();
			}
			System.out.println("-------��ü ���� �Ϸ�-------");
		} else {
			System.out.println("------- ��ü ���� ��� -------");
		}

	}

	private Person search(String name) {
		Iterator<Person> it = infoStorage.iterator();
		while (it.hasNext()) {
			Person tmp = (Person) it.next();
			if (name.equals(tmp.name))
				return tmp;
		}
		return null;
	}

	Person PrimaryInfo() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String birth = MenuViewer.sc.nextLine();

		return new Person(name, phoneNumber, birth);
	}

	Person UniPerson() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String birth = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String major = MenuViewer.sc.nextLine();
		System.out.print("�г� : ");
		int grade = Integer.parseInt(MenuViewer.sc.nextLine());
		return new UnivFriends(name, phoneNumber, birth, major, grade);
	}

	Person ComPerson() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String birth = MenuViewer.sc.nextLine();
		System.out.print("ȸ��� : ");
		String comName = MenuViewer.sc.nextLine();

		return new CompanyFriends(name, phoneNumber, birth, comName);
	}

	void ObjInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			String fileName = "Person.ser";
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);

			infoStorage = (HashSet) in.readObject();

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

	void ObjOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			String fileName = "Person.ser";
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(infoStorage);
			System.out.println("����ȭ�� �� �������ϴ�.");
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
	void FileSearch() {
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\20220513\\Person.ser");
		if (!f.exists()) {
			System.out.println("Start");
		} else if (f.exists()) {
			ObjInputData();
			System.out.println("-----���� �ҷ����� �Ϸ�-----");
		}
	}

}

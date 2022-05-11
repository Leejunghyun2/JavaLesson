package step07;

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

	Set infoStorage = new HashSet();

	void inputData() throws MenuChoiceException {
		System.out.print("�߰��� �׸��� �����ϼ���\n1. ģ�� 2.����ģ�� 3.ȸ��ģ�� ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());

		if (choice < 1 || choice > 3) {
			throw new MenuChoiceException(choice);
		}
		Person tmp = null;
		switch (choice) {
		case SubMenu.FRIENDS: {
			tmp = PrimaryInfo();
			break;
		}
		case SubMenu.UNIVFRIENDS: {
			tmp = UniPerson();
			break;
		}
		case SubMenu.COMFRIENDS: {
			tmp = ComPerson();
			break;
		}
		}
		
		if (infoStorage.add(tmp)){
			System.out.println("�Է¿Ϸ�");
		} else {
			System.out.println("�ߺ�");
		}
	}

	void allDisplay() {

		Iterator it = infoStorage.iterator();

		while (it.hasNext()) {

			Person tmp = (Person)it.next();

			tmp.showPhoneInfo();
		}
	}

	void searchData() {
		System.out.print("�˻��� �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if (tmp!=null) {

			tmp.showPhoneInfo();
		} else {
			System.out.println("���� x");
		}

	}

	void updateData() {
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		Iterator it = infoStorage.iterator();
		tmp = search(name);
		while (it.hasNext()) {
			tmp = (Person)it.next();
		}
		if(tmp != null) {
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
		
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if(tmp==null) {
			System.out.println("��������������");
			return;
		}
		Iterator it = infoStorage.iterator();
		while(it.hasNext()) {
			it.next();
			it.remove();
		}
		

	}

	private Person search(String name) {
		Iterator it = infoStorage.iterator();
		while(it.hasNext()) {
			Person tmp = (Person)it.next();
			if(name.equals(tmp.name))
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
		System.out.print("ȸ���̸� : ");
		String comName = MenuViewer.sc.nextLine();

		return new CompanyFriends(name, phoneNumber, birth, comName);
	}

}

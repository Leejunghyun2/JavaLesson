package Test;

public class PhoneBookManager {
	static PhoneBookManager s;

	private PhoneBookManager() {
	}

	public static PhoneBookManager getInstance() {
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	Person jun = new Person();
	int curCnt = 0;

	void inputData() {
		System.out.print("�߰��� �׸��� �����ϼ���\n1. ģ�� 2.����ģ�� 3.ȸ��ģ�� ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());

		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String birth = MenuViewer.sc.nextLine();
		switch (choice) {
		case 1: {
			infoStorage[curCnt++] = new Person(name, phoneNumber, birth);
			System.out.println("�Է¿Ϸ�");
			break;
		}
		case 2: {
			System.out.print("���� : ");
			String major = MenuViewer.sc.nextLine();
			System.out.print("�г� : ");
			int grade =Integer.parseInt(MenuViewer.sc.nextLine());
			infoStorage[curCnt++] = new UnivFriends(name, phoneNumber, birth, major,grade);
			System.out.println("�Է¿Ϸ�");
			break;
		}
		case 3: {
			System.out.print("���� : ");
			String comName = MenuViewer.sc.nextLine();
			infoStorage[curCnt++] = new CompanyFriends(name, phoneNumber, birth, comName);
			System.out.println("�Է¿Ϸ�");
			break; 
		}
		}
	}

	void allDisplay() {
		for (int i = 0; i < curCnt; i++) {
			infoStorage[i].showPhoneInfo();
		}
	}

	void searchData() {
		System.out.print("�˻��� �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		for (int i = 0; i < curCnt; i++) {
			if (name.equals(infoStorage[i].name)) {

				tmp = infoStorage[i];
				break;
			}
		}
		if (tmp != null) {
			tmp.showPhoneInfo();
		} else {
			System.out.println("���� x ");
		}
	}

	void updateData() {
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		int index = search(name);
		if (index > -1) {
			System.out.print("������ ���� ? ==> ");
			infoStorage[index].phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("������ ���� ? ==> ");
			infoStorage[index].birth = MenuViewer.sc.nextLine();
			System.out.println("-----------�Ϸ�------------");
			
		} else {
			System.out.println("���� x");
		}

	}

	void deleteData() {
		System.out.print("������ �̸��� ? ==> ");
		String name = MenuViewer.sc.nextLine();
		int num = -1;

		num = search(name);
		if (num > -1) {
			for (int i = num; i < curCnt; i++) {
				infoStorage[i] = infoStorage[i + 1];
			}
			System.out.println("-----�����Ϸ�------");
			curCnt--;

		} else {
			System.out.println("���� x");
		}

	}

	private int search(String name) {

		for (int i = 0; i < curCnt; i++) {
			if (name.equals(infoStorage[i].name)) {

				return i;

			}
		}
		return -1;
	}

}

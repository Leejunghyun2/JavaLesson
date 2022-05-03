package step06;

public class PhoneBookManager {
	private static PhoneBookManager s; // �ν��Ͻ�ȣ�� ���� ��밡��

	private PhoneBookManager() {// �ٸ� Ŭ�������� ��� ���ϰ�
	}

	public static PhoneBookManager getInstance() { // �ٸ� ������ ��ġ���ʱ� ���� �̱��� �۾�
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	int curCnt = 0;

	void inputData() throws MenuChoiceException{
		System.out.print("�߰��� �׸��� �����ϼ���\n1. ģ�� 2.����ģ�� 3.ȸ��ģ�� ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());
		
		if(choice < 1 || choice > 3)
		{
			throw new MenuChoiceException(choice);
		}
		
		switch (choice) {
		case SubMenu.FRIENDS: {
			infoStorage[curCnt++] = PrimaryInfo();
			System.out.println("�Է¿Ϸ�");
			break;
		}
		case SubMenu.UNIVFRIENDS: {

			infoStorage[curCnt++] = UniPerson();
			System.out.println("�Է¿Ϸ�");
			break;
		}
		case SubMenu.COMFRIENDS: {

			infoStorage[curCnt++] = ComPerson();
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
		int index = search(name);
		if (index > -1) {
			System.out.print("������ ���� ? ==> ");
			infoStorage[index].phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("������ ���� ? ==> ");
			infoStorage[index].birth = MenuViewer.sc.nextLine();

			if (infoStorage[index] instanceof UnivFriends) { // ����ȯ �������� Ȯ�� �� true�� ���� ���� ����

				UnivFriends tmp = null;
				tmp = (UnivFriends) infoStorage[index]; // grade, major �����ϱ� ���� ����ȯ
				System.out.print("������ ���� ? ==> ");
				tmp.major = MenuViewer.sc.nextLine();
				System.out.print("������ �г� ? ==> ");
				tmp.grade = Integer.parseInt(MenuViewer.sc.nextLine());

			} else if (infoStorage[index] instanceof CompanyFriends) { // ����ȯ �������� Ȯ�� �� true�� ���� ���� ����
				CompanyFriends tmp = null;
				tmp = (CompanyFriends) infoStorage[index];// comName �����ϱ� ���� ����ȯ
				System.out.print("������ ȸ���̸� ? ==> ");
				tmp.comName = MenuViewer.sc.nextLine();

			}

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

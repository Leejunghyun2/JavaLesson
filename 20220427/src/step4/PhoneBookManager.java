package step4;


public final class PhoneBookManager {
	static PhoneBookManager s;
	private PhoneBookManager(){}
	
	public static PhoneBookManager getInstance() {
		if(s==null) s = new PhoneBookManager();
		return s;		
	}
	
	
	
	
	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	Person jun = new Person();
	int curCnt = 0;

	
	
	void inputData() {
		System.out.print("�̸� : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("���� : ");
		String birth = MenuViewer.sc.nextLine();
		infoStorage[curCnt++] = new Person(name, phoneNumber, birth);
		System.out.println("�Է¿Ϸ�");
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
		tmp = infoStorage[search(name)];
		if (tmp != null) {
			System.out.print("������ ���� ? ==> ");
			tmp.phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("������ ���� ? ==> ");
			tmp.birth = MenuViewer.sc.nextLine();
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
package step06;

public class PhoneBookManager {
	private static PhoneBookManager s; // 인스턴스호출 없이 사용가능

	private PhoneBookManager() {// 다른 클래스에서 사용 못하게
	}

	public static PhoneBookManager getInstance() { // 다른 생성자 겹치지않기 위한 싱글톤 작업
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	final int MAX_CNT = 100;
	Person[] infoStorage = new Person[MAX_CNT];
	int curCnt = 0;

	void inputData() throws MenuChoiceException{
		System.out.print("추가할 항목을 선택하세요\n1. 친구 2.대학친구 3.회사친구 ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());
		
		if(choice < 1 || choice > 3)
		{
			throw new MenuChoiceException(choice);
		}
		
		switch (choice) {
		case SubMenu.FRIENDS: {
			infoStorage[curCnt++] = PrimaryInfo();
			System.out.println("입력완료");
			break;
		}
		case SubMenu.UNIVFRIENDS: {

			infoStorage[curCnt++] = UniPerson();
			System.out.println("입력완료");
			break;
		}
		case SubMenu.COMFRIENDS: {

			infoStorage[curCnt++] = ComPerson();
			System.out.println("입력완료");
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
		System.out.print("검색할 이름은 ? ==> ");
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
			System.out.println("정보 x ");
		}
	}

	void updateData() {
		System.out.print("수정할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		int index = search(name);
		if (index > -1) {
			System.out.print("수정할 전번 ? ==> ");
			infoStorage[index].phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("수정할 생일 ? ==> ");
			infoStorage[index].birth = MenuViewer.sc.nextLine();

			if (infoStorage[index] instanceof UnivFriends) { // 형변환 가능한지 확인 후 true면 다음 조건 실행

				UnivFriends tmp = null;
				tmp = (UnivFriends) infoStorage[index]; // grade, major 접근하기 위해 형변환
				System.out.print("수정할 전공 ? ==> ");
				tmp.major = MenuViewer.sc.nextLine();
				System.out.print("수정할 학년 ? ==> ");
				tmp.grade = Integer.parseInt(MenuViewer.sc.nextLine());

			} else if (infoStorage[index] instanceof CompanyFriends) { // 형변환 가능한지 확인 후 true면 다음 조건 실행
				CompanyFriends tmp = null;
				tmp = (CompanyFriends) infoStorage[index];// comName 접근하기 위해 형변환
				System.out.print("수정할 회사이름 ? ==> ");
				tmp.comName = MenuViewer.sc.nextLine();

			}

			System.out.println("-----------완료------------");
		} else {
			System.out.println("정보 x");
		}

	}

	void deleteData() {
		System.out.print("삭제할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		int num = -1;

		num = search(name);
		if (num > -1) {
			for (int i = num; i < curCnt; i++) {
				infoStorage[i] = infoStorage[i + 1];
			}
			System.out.println("-----삭제완료------");
			curCnt--;

		} else {
			System.out.println("정보 x");
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
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전번 : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("생일 : ");
		String birth = MenuViewer.sc.nextLine();
		return new Person(name, phoneNumber, birth);
	}

	Person UniPerson() {
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전번 : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("생일 : ");
		String birth = MenuViewer.sc.nextLine();
		System.out.print("전공 : ");
		String major = MenuViewer.sc.nextLine();
		System.out.print("학년 : ");
		int grade = Integer.parseInt(MenuViewer.sc.nextLine());
		return new UnivFriends(name, phoneNumber, birth, major, grade);
	}

	Person ComPerson() {
		System.out.print("이름 : ");
		String name = MenuViewer.sc.nextLine();
		System.out.print("전번 : ");
		String phoneNumber = MenuViewer.sc.nextLine();
		System.out.print("생일 : ");
		String birth = MenuViewer.sc.nextLine();
		System.out.print("회사이름 : ");
		String comName = MenuViewer.sc.nextLine();

		return new CompanyFriends(name, phoneNumber, birth, comName);
	}
}

package step07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PhoneBookManager {
	private static PhoneBookManager s; // 인스턴스호출 없이 사용가능

	private PhoneBookManager() {// 다른 클래스에서 사용 못하게
	}

	public static PhoneBookManager getInstance() { // 다른 생성자 겹치지않기 위한 싱글톤 작업
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	Set infoStorage = new HashSet();

	void inputData() throws MenuChoiceException {
		System.out.print("추가할 항목을 선택하세요\n1. 친구 2.대학친구 3.회사친구 ==> ");
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
			System.out.println("입력완료");
		} else {
			System.out.println("중복");
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
		System.out.print("검색할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if (tmp!=null) {

			tmp.showPhoneInfo();
		} else {
			System.out.println("정보 x");
		}

	}

	void updateData() {
		System.out.print("수정할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		Iterator it = infoStorage.iterator();
		tmp = search(name);
		while (it.hasNext()) {
			tmp = (Person)it.next();
		}
		if(tmp != null) {
			System.out.print("수정할 전번 ? ==> ");
			tmp.phoneNumber = MenuViewer.sc.nextLine();
			System.out.print("수정할 생일 ? ==> ");
			tmp.birth = MenuViewer.sc.nextLine();
			if (tmp instanceof UnivFriends) { // 형변환 가능한지 확인 후 true면 다음 조건 실행
				UnivFriends tmp1 = null;
				tmp1 = (UnivFriends) tmp; // grade, major 접근하기 위해 형변환
				System.out.print("수정할 전공 ? ==> ");
				tmp1.major = MenuViewer.sc.nextLine();
				System.out.print("수정할 학년 ? ==> ");
				tmp1.grade = Integer.parseInt(MenuViewer.sc.nextLine());
			} else if (tmp instanceof CompanyFriends) { // 형변환 가능한지 확인 후 true면 다음 조건 실행
				CompanyFriends tmp1 = null;
				tmp1 = (CompanyFriends) tmp;// comName 접근하기 위해 형변환
				System.out.print("수정할 회사이름 ? ==> ");
				tmp1.comName = MenuViewer.sc.nextLine();
			}
		} else {
			System.out.println("정보 x");
		}

	}

	void deleteData() {
		
		System.out.print("삭제할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if(tmp==null) {
			System.out.println("삭제할정보없음");
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

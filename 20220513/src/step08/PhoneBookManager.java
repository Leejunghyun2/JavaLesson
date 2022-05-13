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
	private static PhoneBookManager s; // 인스턴스호출 없이 사용가능

	private PhoneBookManager() {// 다른 클래스에서 사용 못하게
	}

	public static PhoneBookManager getInstance() { // 다른 생성자 겹치지않기 위한 싱글톤 작업
		if (s == null)
			s = new PhoneBookManager();
		return s;
	}

	int count = 1;
	Set<Person> infoStorage = new HashSet<Person>();

	void inputData() throws MenuChoiceException {
		System.out.print("추가할 항목을 선택하세요\n1. 친구 2.대학친구 3.회사친구 ==> ");
		int choice = Integer.parseInt(MenuViewer.sc.nextLine());

		if (choice < 1 || choice > 3) { // 메뉴 초이스가 1,2,3,이아니라면 익셉션
			throw new MenuChoiceException(choice);
		}
		Person tmp = null;
		switch (choice) {
		case SubMenu.FRIENDS: {
			tmp = PrimaryInfo(); // 친구
			break;
		} // SubMenu.FRIENDS:끝
		case SubMenu.UNIVFRIENDS: {
			tmp = UniPerson(); // 대학친구
			break;
		} // SubMenu.UNIVFRIENDS:끝
		case SubMenu.COMFRIENDS: {
			tmp = ComPerson(); // 회사친구
			break;
		} // case SubMenu.COMFRIENDS:끝
		}// switch문 끝

		if (infoStorage.add(tmp)) { // infoStorage에 값이들어가면 true 중복이면 false
			System.out.println("입력완료");
		} else {
			System.out.println("입력실패 : 중복자료");
		}
	}

	void allDisplay() {
		if (infoStorage.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		Iterator<Person> it = infoStorage.iterator(); // infoStorage에 있는 정보를 이터레이터해서 출력
		while (it.hasNext()) { // 다음자료가 있냐 없냐에 따라 true, false 반환
			System.out.print(count + ": ");
			Person tmp = (Person) it.next();
			tmp.showPhoneInfo();
			System.out.println("-------------------------------------------------------------------");
			count++;
		}
		count = 1;
	}

	void searchData() {
		System.out.print("검색할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = search(name);
		if (tmp != null) { // search에서 name을 찾지못하면 null값 반환
			tmp.showPhoneInfo();
		} else {
			System.out.println("정보 x");
		}
	}

	void updateData() {
		System.out.print("수정할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = null;
		tmp = search(name);
		if (tmp != null) {
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
		if (infoStorage.isEmpty()) { // infoStorage 에 요소가 있으면 false 없으면 true 반환
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		System.out.print("삭제할 이름은 ? ==> ");
		String name = MenuViewer.sc.nextLine();
		Person tmp = search(name);
		if (tmp == null) {
			System.out.println("삭제할 정보가 없습니다.");
			return;
		}
		infoStorage.remove(tmp);
	}

	void allDelete() {
		if (infoStorage.isEmpty()) {
			System.out.println("삭제할 데이터가 없습니다.");
			return;
		}
		System.out.print("전체삭제하시겠습니까? 1. Yes 2. No ==>");
		int remove = Integer.parseInt(MenuViewer.sc.nextLine());
		if (remove == 1) {
			Iterator<Person> it = infoStorage.iterator();
			while (it.hasNext()) {
				it.next();
				it.remove();
			}
			System.out.println("-------전체 삭제 완료-------");
		} else {
			System.out.println("------- 전체 삭제 취소 -------");
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
		System.out.print("회사명 : ");
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
			System.out.println("직렬화가 잘 끝났습니다.");
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
			System.out.println("-----파일 불러오기 완료-----");
		}
	}

}

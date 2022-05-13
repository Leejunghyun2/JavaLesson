package step08;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	String phoneNumber;
	String birth;
	int i=0;
	Person() {
		this("홍길동", "010-0000-0000", "1900/01/01");

	}

	Person(String name, String phoneNumber, String birth) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}

	Person(String name, String phoneNumber) {

		this(name, phoneNumber, null);
	}

	void showPhoneInfo() {
//		if(birth!=null && birth.length() !=0)
	
		if (birth != null && !birth.equals(""))
			System.out.printf("이름: %s\t 전화번호: %s\t 생일: %s\n", name, phoneNumber, birth);
		else
			System.out.printf("이름: %s\t 전화번호: %s\n", name, phoneNumber);
	}

	@Override
	public int hashCode() {
		return name.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			return name.equals(tmp.name);
		}
		return false;
	}

}

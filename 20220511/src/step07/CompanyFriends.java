package step07;

public class CompanyFriends extends Person {

	String comName;

	CompanyFriends(String name, String PhoneNumber, String birth, String comName) {
		super(name, PhoneNumber, birth);
		this.comName = comName;
	}
	
	//Person showPhoneInfo() overriding
	void showPhoneInfo() {
		
			if (!birth.equals(""))
				System.out.printf("이름: %s\t 전화번호: %s\t 생일: %s\t 회사명: %s\n", name, phoneNumber, birth, comName);
			else
				System.out.printf("이름: %s\t 전화번호: %s\t 회사명: %s \n", name, phoneNumber, comName);

	}
}

package PersonTest;

public class CompanyFriends extends Person {

	String comName;

	CompanyFriends(String name, String PhoneNumber, String birth, String comName) {
		super(name, PhoneNumber, birth);
		this.comName = comName;
	}
	
	//Person showPhoneInfo() overriding
	void showPhoneInfo() {
//		if (birth != null && birth.length() != 0)
			if (birth != null && !birth.equals(""))
				System.out.printf("이름: %s 전번: %s 생일: %s 회사이름: %s\n", name, phoneNumber, birth, comName);
			else
				System.out.printf("이름: %s 전번: %s 회사이름: %s \n", name, phoneNumber, comName);

	}
}

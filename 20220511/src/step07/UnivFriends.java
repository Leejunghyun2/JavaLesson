package step07;

public class UnivFriends extends Person {
	String major;
	int grade;

	UnivFriends(String name, String PhoneNumber, String birth, String major, int grade) {
		super(name, PhoneNumber, birth);
		this.major = major;
		this.grade = grade;

	}UnivFriends(String name, String PhoneNumber, String major, int grade) {
		super(name, PhoneNumber);
		this.major = major;
		this.grade = grade;

	}
	//Person showPhoneInfo() overriding 
	void showPhoneInfo() {
			if (!birth.equals(""))
				System.out.printf("이름: %s\t 전화번호: %s\t 생일: %s\t 전공: %s\t 학년: %d학년\n", name, phoneNumber, birth, major, grade);
			else
				System.out.printf("이름: %s\t 전화번호: %s\t 전공: %s\t 학년: %d학년\n", name, phoneNumber, major, grade);

	}

}

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
				System.out.printf("�̸�: %s\t ��ȭ��ȣ: %s\t ����: %s\t ����: %s\t �г�: %d�г�\n", name, phoneNumber, birth, major, grade);
			else
				System.out.printf("�̸�: %s\t ��ȭ��ȣ: %s\t ����: %s\t �г�: %d�г�\n", name, phoneNumber, major, grade);

	}

}

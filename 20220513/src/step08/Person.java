package step08;

import java.io.Serializable;

public class Person implements Serializable{
	String name;
	String phoneNumber;
	String birth;
	int i=0;
	Person() {
		this("ȫ�浿", "010-0000-0000", "1900/01/01");

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
			System.out.printf("�̸�: %s\t ��ȭ��ȣ: %s\t ����: %s\n", name, phoneNumber, birth);
		else
			System.out.printf("�̸�: %s\t ��ȭ��ȣ: %s\n", name, phoneNumber);
	}

	@Override
	public int hashCode() {
		return name.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			return name.equals(tmp.name);
		}
		return false;
	}

}

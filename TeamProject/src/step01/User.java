package step01;

import java.io.Serializable;

public class User extends Consumer implements Serializable{
	private String id;
	private String pwd;
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return this.pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	User(String id, String pwd, String name, String phoneNumber) {
		super(name, phoneNumber);
		this.id = id;
		this.pwd = pwd;
	}
	User() {
	}

	void showInfo() {
		System.out.printf(" %s : %s : %s : %s \n", id, pwd, name, phoneNumber);
	}

	@Override
	public int hashCode() {
		return id.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof User) {
			User tmp = (User) obj;
			return id.equals(tmp.id);
		}
		return false;
	}

}

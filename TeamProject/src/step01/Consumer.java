package step01;

import java.io.Serializable;

public class Consumer implements Serializable {
  String name;
  
  String phoneNumber;
  
  Consumer(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  
  Consumer(String name) {
    this.name = name;
  }
  
  Consumer() {}
  @Override
	public int hashCode() {
		return name.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof Consumer) {
			Consumer tmp = (Consumer) obj;
			return name.equals(tmp.name);
		}
		return false;
	}
}

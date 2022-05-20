package step01;

import java.io.Serializable;

public class NonReservInfo implements Serializable{
	String name, seat ,tel;
	int moviechoice;
	String reserNum;
	
	NonReservInfo(String name,String tel,int moviechoice,String seat,String reserNum){
		this.name = name;
		this.tel = tel;
		this.moviechoice = moviechoice;
		this.seat = seat;
		this.reserNum = reserNum;
	}
	NonReservInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return tel.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof NonReservInfo) {
			NonReservInfo tmp = (NonReservInfo) obj;
			return tel.equals(tmp.tel);
		}
		return false;
	}
	public String toString() {
		return "��ȭ�� �� " + moviechoice + "�� " + seat + "�� " + "���Ź�ȣ : " +reserNum ; 
	}
}

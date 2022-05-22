package step01;

import java.io.Serializable;

public class NonReservInfo extends Consumer implements Serializable{
	String seat;
	int moviechoice,movieTimeChoice;
	String reserNum;
	String movieTime;
	NonReservInfo(String name,String tel,int moviechoice,String seat,String reserNum,String movieTime,int movieTimeChoice){
		super.name = name;
		super.phoneNumber = tel;
		this.moviechoice = moviechoice;
		this.seat = seat;
		this.reserNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	NonReservInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return phoneNumber.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof NonReservInfo) {
			NonReservInfo tmp = (NonReservInfo) obj;
			return phoneNumber.equals(tmp.phoneNumber);
		}
		return false;
	}
	public String toString() {
		return "��ȭ�� �� " + moviechoice + "�� " + seat + "�� " + "���Ź�ȣ : " +reserNum+ "\n"; 
	}
}

package step01;

import java.io.Serializable;

public class MemberReservationInfo extends Consumer implements Serializable {
	String id, seat;
	int moviechoice,movieTimeChoice;
	String reserNum;
	String movieTime;
	

	MemberReservationInfo(String id, int moviechoice, String seat) {
		this.id = id;
		this.moviechoice = moviechoice;
		this.seat = seat;
	}
	MemberReservationInfo(String id, int moviechoice, String seat,String reserNum,String movieTime,int movieTimeChoice) {
		this.id = id;
		this.moviechoice = moviechoice;
		this.seat = seat;
		this.reserNum = reserNum;
		this.movieTime = movieTime;
		this.movieTimeChoice = movieTimeChoice;
	}
	public MemberReservationInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return id.hashCode(); // �ּ��� �ؽ��ڵ嵵 ���ؾ��ؼ� �������̵�
	}

	@Override
	public boolean equals(Object obj) { // ���� �ٸ����� ��� �ִ� ��ü���̶� �� ���� ������ Ȯ���ϱ����� �������̵�
		if (obj instanceof MemberReservationInfo) {
			MemberReservationInfo tmp = (MemberReservationInfo) obj;
			return id.equals(tmp.id);
		}
		return false;
	}
	
	public String toString() {
		return "��ȭ�� �� " + moviechoice + "�� " + seat + "�� " + "���Ź�ȣ : " +reserNum + "\n��ȭ�ð� : "+movieTime;
	}
}

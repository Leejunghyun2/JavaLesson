package step01;

public class MemberReservationInfo {
	String id, seat;
	int moviechoice;

	MemberReservationInfo(String id, int moviechoice, String seat) {
		this.id = id;
		this.moviechoice = moviechoice;
		this.seat = seat;
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
		return "��ȭ�� �� " + moviechoice + "��" + seat + "��"; 
	}
}

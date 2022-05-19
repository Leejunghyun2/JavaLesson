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
		return id.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof MemberReservationInfo) {
			MemberReservationInfo tmp = (MemberReservationInfo) obj;
			return id.equals(tmp.id);
		}
		return false;
	}
	
	public String toString() {
		return "영화관 제 " + moviechoice + "관" + seat + "번"; 
	}
}

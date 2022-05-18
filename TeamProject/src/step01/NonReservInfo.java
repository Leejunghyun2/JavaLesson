package step01;

public class NonReservInfo {
	String name, seat ,tel;
	int moviechoice;
	
	
	NonReservInfo(String name,String tel,int moviechoice,String seat){
		this.name = name;
		this.tel = tel;
		this.moviechoice = moviechoice;
		this.seat = seat;
	}
	NonReservInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return tel.hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof NonReservInfo) {
			NonReservInfo tmp = (NonReservInfo) obj;
			return tel.equals(tmp.tel);
		}
		return false;
	}
}

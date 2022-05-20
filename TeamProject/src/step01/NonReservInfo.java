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
	public String toString() {
		return "영화관 제 " + moviechoice + "관 " + seat + "번 " + "예매번호 : " +reserNum ; 
	}
}

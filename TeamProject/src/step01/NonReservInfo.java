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
}

package chap03;

public class PolyagmTest {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		b.buy(new Piano());
		
		b.summary();
		System.out.println("�ܾ� : "+ b.money + "\n���ʽ�����Ʈ : "+b.bonusPoint);
	
	}
}
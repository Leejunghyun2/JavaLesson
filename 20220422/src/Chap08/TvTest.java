package Chap08;

public class TvTest {

	public static void main(String[] args) {
		Tv t1 = new Tv(); // 인스턴스 화
		Tv t2 = new Tv();
		Tv[] tA = new Tv[3];
		
		t1.power = true;
	
		
		t1.channel = 7;
		t1.channelUp();

		t2.channel = 4;
		t2.channelUp();

		System.out.println("Tv color : " + t1.color);
		System.out.println("Tv channel : " + t1.channel);
		System.out.println(t2.channel);
		System.out.println(tA[0]);
		System.out.println(tA[1]);
	}
}

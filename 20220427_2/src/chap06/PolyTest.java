package chap06;

public class PolyTest {

	public static void main(String[] args) {
		Tv t= new Tv();
		CaptionTv ct= new CaptionTv();
		
		
		Tv t2 = new CaptionTv();
		
		ct.caption =true;
		ct.displayCaption("������");
		
//		t2.caption =true;
//		t2.displayCaption("������");
		
		t2.channel = 100;
		t2.channelUp();
		System.out.println(t2.channel);
	}
	
}

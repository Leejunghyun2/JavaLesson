package chap04;

public class Ver03 {
	
	public static void main(String[] args) {
		
		char ch = 'Y';
		int i = 500; //다운캐스팅 :값의 소실
		float f = 5.5f;
		double d = 10.9;
		boolean b = false;
		
		i = (int)f;
		System.out.println(i);
		
	}

}

package chap02;

public class AdderTest {

	public static void main(String[] args) {
		Myadder f = (int a,int b)-> a+b;
		Myadder f2 = (int a,int b)-> (a+b)*2;
		MyMin m = (int a,int b)-> a > b ? b : a;
		
		
		System.out.println(m.min(-5, 2));
	}
}

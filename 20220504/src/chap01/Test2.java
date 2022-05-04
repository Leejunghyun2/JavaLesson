package chap01;

public class Test2 {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(2,2),2);
		Circle c2 = c1.clone();
		System.out.println(c1);
		System.out.println(c2);
		
		
		c2.p.x = 1;
		System.out.println(c1);
		System.out.println(c2);
		
		
	}
}

package chap04;

public class SDCopy {

	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1,1),2.0);
		Circle c2 = c1.clone();
		
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		c2.p.x=9;
		c2.p.y=9;
		c2.r=3.0;
		System.out.println(c1);
		System.out.println(c2);

	}

}

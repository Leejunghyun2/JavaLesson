package Chap08;

public class Tvtest02 {

	
	public static void main(String[] args) {
		
		Tv tv1 = new Tv();
		Tv tv2 = new Tv();
		System.out.println(tv2);
		tv2 = tv1;
		
		tv1.channel = 7;
		
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		
		
		tv1.color = "Blue";
		
		System.out.println(tv1.color);
		System.out.println(tv2.color);
		
		tv2.channel = 9;
		
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);
		tv2 = new Tv();
		
		System.out.println(tv2);
		System.out.println(tv1.channel);
		System.out.println(tv2.channel);

	}
	
}

package chap06;

public class Cartest {

	public static void main(String[] args) {
		
		Car c1 = new Car();
		
		
		Car c2 = new Car("green","auto",6);
		
		System.out.println(c1.color);
		System.out.println(c1.door);
		System.out.println(c1.gearType);
		
		System.out.println(c2.color);
		System.out.println(c2.door);
		System.out.println(c2.gearType);
		
		Car c3 = new Car("blue");
		System.out.println(c3.color + " \n"+ c3.door+"\n" + c3.gearType);
				
		
		
		
	}
	
}

package chap06;

public class Stack01 {

	public static void main(String[] args) {
		
		firstMethod();
		
		System.out.println("mainMethod ��");
		
	}
	
	static void firstMethod() {
	
		secondMethod();
		System.out.println("firstmethod ��");
	}
	static void secondMethod() {
		System.out.println("secondMethod()");
		System.out.println("secondMethod() �� ");
	}
	
}

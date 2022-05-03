package chap06;

public class Stack01 {

	public static void main(String[] args) {
		
		firstMethod();
		
		System.out.println("mainMethod ³¡");
		
	}
	
	static void firstMethod() {
	
		secondMethod();
		System.out.println("firstmethod ³¡");
	}
	static void secondMethod() {
		System.out.println("secondMethod()");
		System.out.println("secondMethod() ³¡ ");
	}
	
}

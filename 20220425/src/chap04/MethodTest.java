package chap04;

public class MethodTest {

	public static void main(String[] args) {
		
		int[] arr2 = new int[10];
		
	    initArr(arr2);
		printArr(arr2);
	    
		initArr(arr2);
		printArr(arr2);
	    
	}
	
	static void initArr(int[] arr) {
		for(int i = 0 ; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10)+1;
			
		}
		
	}
	
	static void printArr(int[] arr) {
		for(int i = 0 ; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
	}
	
	void method() {
		
	}
}

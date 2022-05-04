package chap07;

public class BindingTest {

	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		
		
		System.out.println(c.x);
		c.method();
	}
	
	
	
}

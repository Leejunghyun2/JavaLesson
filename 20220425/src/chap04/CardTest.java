package chap04;

public class CardTest {

	
	public static void main(String[] args) {
		String name = "Lee";
		
		Card c1 = new Card();
		
		
		c1.kind= "Heart";
		c1.number = 7;
		
		System.out.println(c1.kind);
		System.out.println(c1.number);
		
	}
}

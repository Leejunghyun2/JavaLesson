package chap01;

public class CardTest {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card("HEART",2);

		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
	
}

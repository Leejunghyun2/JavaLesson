package chap08;

public class DeckTest {

	public static void main(String[] args) {
	
		Deck dec = new Deck();
		Card c = new Card();
		
		c = dec.pick(0);
		System.out.println(c);
		System.out.println("-------------------------");
		System.out.println("-------------------------");
		dec.shuffle();
		c = dec.pick(0);
		System.out.println(c);
		System.out.println("-------------------------");
		
		
		dec.printAll();
	}
}

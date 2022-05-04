package chap01;

public class Card {
	String kind;
	int number;
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	Card(){
		this("SPADE",1);
	}
	@Override
	public String toString() {
		return "Card [kind=" + kind + ", number=" + number + "]";
	}
	
	
}

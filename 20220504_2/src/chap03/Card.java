package chap03;

public class Card {
	String kind;
	int number;
	
	Card(){
		this("SPADE",1);
	}
	
	Card(String kind,int number){
		this.kind = kind;
		this.number =number;
	}
	
	public String toString() {
		return kind + "," + number;
	}
}

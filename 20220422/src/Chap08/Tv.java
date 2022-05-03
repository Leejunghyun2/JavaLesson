package Chap08;

public class Tv {
	
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}  //toggle
	void channelUp() {
		channel++;
	}
	void channelDown() {
		channel--;
	}
}

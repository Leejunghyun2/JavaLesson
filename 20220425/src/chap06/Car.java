package chap06;

public class Car {

	String color;
	String gearType;
	int door;
	
	
	Car(String color){
		
		this(color, "auto",5);
		this.door = 0;
	}
	
	Car() {

	}

	Car(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}


}

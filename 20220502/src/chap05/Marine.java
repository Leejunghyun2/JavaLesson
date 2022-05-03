package chap05;

public class Marine extends GroundUnit {
	Marine(){
		super(60);
		hitPoint = MAX_HP;
	}
	
	public String toString() {
		return "marine";
	}

}

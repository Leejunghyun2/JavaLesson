package chap01;

public class Point {
	int x,y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	Point(){
		this(1,1);
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	
}

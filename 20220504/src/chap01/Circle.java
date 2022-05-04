package chap01;

public class Circle implements Cloneable {
	Point p;
	int r;
	
	Circle(Point p,int r){
		this.p = p;
		this.r = r;
	}
	
	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}

//	@Override
//	protected Circle clone(){
//		Object obj = null;
//		try {
//			obj = super.clone();
//		} catch (Exception e) {}
//		return (Circle)obj;
//	}
	protected Circle clone(){
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}
		Circle c = (Circle)obj;
		c.p = new Point(this.p.x,this.p.y);
		return c;
	
	}
	
	
}

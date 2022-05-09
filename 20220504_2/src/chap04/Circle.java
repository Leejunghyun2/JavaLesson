package chap04;

public class Circle implements Cloneable {
	Point p;
	double r;
	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}
	
	public Circle clone() {
		Object obj = null;
		
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		Circle c = (Circle)obj;
		c.p= new Point(this.p.x,this.p.y);
		return c;
	}


	@Override
	public String toString() {
		return "Circle [p=" + p + ", r=" + r + "]";
	}

/*	@Override
	protected Circle clone() {
		// TODO Auto-generated method stub
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		Circle c = (Circle)obj;
		c.p = new Point(this.p.x,this.p.y);
		return c;
	}*/
	

	

	
	
}


package chap2;

public class Point3D extends Point {

	int z;

	
	String getLocation() {
		
//		return "x = "+x+ "y = " + y +" ,z=" + z;
		return super.getLocation()+", z=" + z;
	
	
	}
}
	
	
	


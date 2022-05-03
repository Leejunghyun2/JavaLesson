package chap04;

public final class Singleton {
	static Singleton s;
	private Singleton(){}
	
	
	public static Singleton getInstance() {
		if(s==null) s= new Singleton();
		return s;
	}
	
	
	
}

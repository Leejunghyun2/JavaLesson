package chap06;

import java.util.Enumeration;
import java.util.Properties;

public class PropertiesEx1 {
	public static void main(String[] args) {
		Properties prop = new Properties();
		
		prop.setProperty("timeout", "20");
		prop.setProperty("language", "kr");
		prop.setProperty("size", "10");
		prop.setProperty("capacity", "10");
		
		System.out.println(prop);
		Enumeration e = prop.propertyNames();
		
		while(e.hasMoreElements()) {
			String tmp=(String)e.nextElement();
			System.out.println(tmp + "=" + prop.getProperty(tmp));
		}

		System.out.println();
		
		prop.setProperty("size", "20");
		System.out.println("size="+prop.getProperty("size"));
		
		e = prop.propertyNames();
	
	
	
	}
}

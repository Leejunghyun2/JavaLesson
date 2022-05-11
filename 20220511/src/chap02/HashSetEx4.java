package chap02;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx4 {
	public static void main(String[] args) {
		Set set = new HashSet();
		Person2 s1 = new Person2("David",10);
		Person2 s2 = new Person2("David",20);
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",20));
		set.add(new Person2("David",10));

		System.out.println(set);
		System.out.println(s1.equals(s2));
	}
	
}

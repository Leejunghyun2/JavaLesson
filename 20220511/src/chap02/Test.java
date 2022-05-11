package chap02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Object[] arr = { 0, 0, 0, 0, 0, "1", 1, 1, 2, 2, 2, 3, 3, 3 };
		Set set = new HashSet();

		for (int i = 0; i < arr.length; i++) {
			System.out.println(set.add(arr[i]));
			System.out.println(set);
		}
	}
}

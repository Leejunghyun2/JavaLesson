package chap02;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		list1.add(5);
		list1.add(4);
		list1.add(2);
		list1.add(0);
		list1.add(1);
		list1.add(3);

		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1, list2);

		list2.add("A");
		list2.add("b");
		list2.add("c");
		print(list1, list2);
		Collections.sort(list1);
		print(list1, list2);
//		for(int i=list2.size()-1; i>=0; i--) {
//			if(list1.contains(list2.get(i))) {
//				list2.remove(i);
//				print(list1,list2);
//
//			}
//		}
		list1.retainAll(list2);
		print(list1, list2);
		System.out.println(list2.containsAll(list1));
		list1.add(3);
		list1.add(2);
		list1.add(3, "a");
		print(list1, list2);
		list1.add(3, "b");
		print(list1, list2);
		list1.set(4, "b");
		print(list1, list2);
		System.out.println(list1.size());

	}

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 :" + list1);
		System.out.println("list2 :" + list2);
		System.out.println();
	}

}

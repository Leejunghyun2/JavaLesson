package chap01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class IteratorEx01 {
	public static void main(String[] args) {
		List list = new ArrayList();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		ListIterator it = list.listIterator();
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
			
//		}
		
		
		//Iterator it = list.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			while(it.hasPrevious()) {
				System.out.println(it.previous());

			}
		
		}
}

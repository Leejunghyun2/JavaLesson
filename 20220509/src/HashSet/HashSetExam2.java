package HashSet;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetExam2 {
	public static void main(String[] args) {
		
		Set set = new HashSet();
		
		for(int i=0;set.size()<6;i++) {
			set.add((int)(Math.random()*45)+1);
			
		}
		System.out.println(set);
		List list = new LinkedList(set);
		Collections.sort(list);
		System.out.println(list);
	}
	
	
}

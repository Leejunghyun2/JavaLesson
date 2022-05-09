package HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExam2_1 {
	public static void main(String[] args) {
		
		Set set = new HashSet();
		int[] a= new int[6];
		
		for(int i=0;set.size()<6;i++) {
			set.add((int)(Math.random()*45)+1);
			
		}
		Iterator<Integer> it = set.iterator();
		for(int j=0; j < a.length;j++)
		{
			a[j] = it.next();
			System.out.print(a[j]+" ");
		}
		
	}
	
	
}

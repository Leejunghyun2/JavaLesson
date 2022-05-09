package HashSet;

import java.util.HashSet;
import java.util.Set;

public class HastSetExam1 {
	public static void main(String[] args) {
		Object[] objArr = {"1","51","45","35","32","42","53","62","82"};
		Set set = new HashSet();
		System.out.println(objArr.length);
		for(int i=0; i<objArr.length;i++) {
			set.add(objArr[i]);
		}
		System.out.println(set);
	}
}

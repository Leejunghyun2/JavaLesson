package chap02;

import java.util.List;
import java.util.ArrayList;

public class ArrayListEx2 {
	public static void main(String[] args) {
		final int LIMIT = 10;
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ";
		int length = source.length(); 
		List list = new ArrayList(length/LIMIT +10);// List는 ArrayList의 부모<다형성>
		
		for(int i=0; i< length; i+=LIMIT) {
			if(i+LIMIT < length) {
				list.add(source.substring(i,i+LIMIT));
			} else {
				list.add(source.substring(i));
			}
		}
			for(int j=0; j<list.size();j++) {
				System.out.println(list.get(j));
			}
			System.out.println(list.get(1));
		
	}
}

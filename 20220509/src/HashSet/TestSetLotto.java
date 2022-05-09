package HashSet;

import java.util.Set;
import java.util.TreeSet;

public class TestSetLotto {
	public static void main(String[] args) {
		Set set = new TreeSet();
		for(int i = 0 ; set.size()<6; i++) {
			set.add((int)(Math.random()*45)+1);
		}
		System.out.println(set);
	} //HashSet은 정렬이 안되어서 따로 정렬해주어야했는데 이건 정렬 따로안해도 정렬 되어있음.
}

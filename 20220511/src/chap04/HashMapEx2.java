package chap04;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx2 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("김자바", 90);
		map.put("나자바", 80);
		map.put("꽉자바", 90);
		map.put("이자바", 100);
		map.put("김자바", 100);

		System.out.println(map);

		Set set = map.entrySet();
		System.out.println(set);
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();// Map.Entry는 Map 클래스의 inner 클래스
			System.out.println("이름 : " + e.getKey() + "점수 : " + e.getValue());

		}
		set = map.keySet();
		System.out.println("참가자 명단 : " + set);

		Collection values = map.values();
		System.out.println(values);
		it = values.iterator();

		int total = 0;
		while (it.hasNext()) {
			int i = (Integer) it.next();
			total += i;
		}
		System.out.println(total);
		System.out.println((double) total / map.size());
		System.out.println(Collections.max(values));
		System.out.println(Collections.min(values));

	}
}

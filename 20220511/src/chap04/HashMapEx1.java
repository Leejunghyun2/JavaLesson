package chap04;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapEx1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap map = new HashMap();
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		System.out.println(map);

		while (true) {
			System.out.println("id와 password를 입력해주세요.");
			System.out.print("id : ");
			String id = sc.nextLine().trim();

			System.out.print("pw : ");
			String password = sc.nextLine().trim();

			if (!map.containsKey(id)) {

				System.out.println("입력하신 아이디가 존재하지 않습니다. 다시입력해주세요");
				continue;
			}
			if (!(map.get(id).equals(password))) {
				System.out.println("비밀번호 x");
			} else {
				System.out.println("ok");
				break;
			}

		}
	}
}

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
			System.out.println("id�� password�� �Է����ּ���.");
			System.out.print("id : ");
			String id = sc.nextLine().trim();

			System.out.print("pw : ");
			String password = sc.nextLine().trim();

			if (!map.containsKey(id)) {

				System.out.println("�Է��Ͻ� ���̵� �������� �ʽ��ϴ�. �ٽ��Է����ּ���");
				continue;
			}
			if (!(map.get(id).equals(password))) {
				System.out.println("��й�ȣ x");
			} else {
				System.out.println("ok");
				break;
			}

		}
	}
}

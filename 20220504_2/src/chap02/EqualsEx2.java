package chap02;

public class EqualsEx2 {

	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		
		if(p1.equals(p2)) {
			System.out.println("�����ϴ�");
		} else {
			System.out.println("�ٸ��ϴ�.");
		}
		if(p1==p2) {
			System.out.println("�����ϴ�");
		} else {
			System.out.println("�ٸ��ϴ�.");
		
		}
	}
}

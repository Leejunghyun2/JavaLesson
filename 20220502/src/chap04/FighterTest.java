package chap04;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();

		if (f instanceof Unit) {
			System.out.println("�ڼ�");
		}
		if (f instanceof Fightable) {
			System.out.println("�������̽�");
		}
		if (f instanceof Moveable) {
			System.out.println("�������̽�");
		}

		if (f instanceof Attackable) {
			System.out.println("�������̽�");
		}
		if (f instanceof Object) {
			System.out.println("�ڼ�");
		}

	}
}

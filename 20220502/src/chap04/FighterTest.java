package chap04;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();

		if (f instanceof Unit) {
			System.out.println("자손");
		}
		if (f instanceof Fightable) {
			System.out.println("인터페이스");
		}
		if (f instanceof Moveable) {
			System.out.println("인터페이스");
		}

		if (f instanceof Attackable) {
			System.out.println("인터페이스");
		}
		if (f instanceof Object) {
			System.out.println("자손");
		}

	}
}

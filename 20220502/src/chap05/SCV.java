package chap05;

public class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Unit) {
			Unit u = (Unit) r;
			while (u.hitPoint != u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString() + "�� ������ �������ϴ�.");
		}
	}

	void attack(GroundUnit g) {

		if (g instanceof Unit) {
			Unit u = (Unit) g;
			for (int i = u.hitPoint; i > 0; i -= 5) {
				System.out.println(u.toString()+"���� hp: " +u.hitPoint );
				System.out.println("����");
				
				u.hitPoint -= 5;
				System.out.println(u.toString() + "�� hp :" + u.hitPoint);
				System.out.println("--------------------------");
			}
		} else {
			System.out.println("���ݺҰ� ����");
		}

	}

	public String toString() {
		return "SCV";
	}

}
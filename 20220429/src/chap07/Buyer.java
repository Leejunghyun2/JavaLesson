package chap07;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	int count =0;
	Product[] x = new Product[100];
	void buy(Product t) {
		if(money < t.price) {
			System.out.println("�ܾ׺���!!!");
			return;
		}
		money = money - t.price;
		bonusPoint += t.bonusPoint;
		System.out.println(t+ "�� �����ϼ̽��ϴ�.");
		x[count++] = t;
	}
	void summary() {
		String[] sum = new String[count];

		for(int i=0; i<count;i++) {
			if(x[i]==null) {
				System.out.println("������ ��ǰ�� �����ϴ�.");
				return;
			} 
			sum[i] = ""+x[i];
		}
		System.out.println("��ǰ :"+ String.join(", ", sum)+" �� "+count+"�� �����ϼ̽��ϴ�.");
	}
	
	
}

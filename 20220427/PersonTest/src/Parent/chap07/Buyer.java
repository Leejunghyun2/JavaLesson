package chap07;

public class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	int count =0;
	Product[] x = new Product[100];
	void buy(Product t) {
		if(money < t.price) {
			System.out.println("잔액부족!!!");
			return;
		}
		money = money - t.price;
		bonusPoint += t.bonusPoint;
		System.out.println(t+ "를 구입하셨습니다.");
		x[count++] = t;
	}
	void summary() {
		String sum = " ";

		for(int i=0; i<count;i++) {
			if(x[i]==null) {
				System.out.println("구매한 물품이 없습니다.");
				return;
			} 
			sum += x[i]+", ";
		}
		System.out.println("물품 :"+ sum+"\b\b ");
	}
	
	
}

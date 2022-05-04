package chap1;

public class Menu {
	int jo, color;
	int gb, pr;
	String g1, g2;
	int price;

	Menu(int jo, int color, int gb) {

		this.jo = jo;
		this.color = color;
		this.gb = gb;
		

		showMenu();
	}

	Menu() {
		
	}

	void showMenu() {
		if (jo == 1) {
			price = 1000000;
			g1 = "갤럭시";
			switch (color) {
			case 1:
				g2 = "red";
				break;
			case 2:
				g2 = "green";
				break;
			case 3:
				g2 = "blue";
				break;
			case 4:
				g2 = "pink";
			}
		} else if (jo == 2) {
			price = 1400000;
			g1 = "아이폰";
			switch (color) {
			case 1:
				g2 = "gold";
				break;
			case 2:
				g2 = "green";
				break;
			case 3:
				g2 = "silver";
				break;
			case 4:
				g2 = "white";
				break;
			}
		}
		switch (gb) {
		case 1:
			pr = 64;
			break;
		case 2:
			pr = 128; price += 100000;
			break;
		case 3:
			pr = 256; price += 200000;
			break;
		case 4:
			pr = 512; price += 300000;
			break;
		}
		System.out.printf("종류 : %s \n색상 : %s \n용량 : %d GB \n가격 : %d원", g1, g2, pr,price);

	}
}

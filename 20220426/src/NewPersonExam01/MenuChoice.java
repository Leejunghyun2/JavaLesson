package NewPersonExam01;

public class MenuChoice {
	
	Menu choice = new Menu();
	String kinds; 
	void galaxy() {
		choice.price = 1000000;
		
		System.out.print("���� �����ϼ��� : 1. red 2. green 3. blue 4. pink \n");
		int color = Integer.parseInt(MenuTest.sc.nextLine());
		System.out.print("�뷮�� �����ϼ��� 1. 64GB 2. 128GB(+10��) 3. 256GB(20��) 4. 512GB(30��)\n");
		int cap = Integer.parseInt(MenuTest.sc.nextLine());
		for(int i = cap; i>1;i--) {
			choice.price += 100000;
		}
		kinds = kind(1,color,cap,choice.price);
		System.out.println(kinds);
	}
	
	void iPhone() {
		choice.price = 1300000;
		
		System.out.print("���� �����ϼ��� : 1. Gold 2. Green 3. Silver 4. White\n");
		int color = Integer.parseInt(MenuTest.sc.nextLine());
		System.out.print("�뷮�� �����ϼ��� 1. 64GB 2. 128GB(+10��) 3. 256GB(20��) 4. 512GB(30��)\n");
		int cap = Integer.parseInt(MenuTest.sc.nextLine());
		
		for(int i = cap; i>1;i--) {
			choice.price += 100000;
		}
		kinds = kind(2,color,cap,choice.price);
		System.out.println(kinds);
		
	}
		
	
	String kind(int i,int color, int cap,int price) {
		
		String[] kinds = {"","Galaxy","iPhone"};
		String[] colors1 = {"","Red","Green","Blue","Pink"};
		String[] colors2 = {"","Gold","Green","Silver","White"};
		String[] caps = {"","64GB","128GB","256GB","512GB"};
		if(i==1) {
			return "���� = "+kinds[i]+"\n���� = "+colors1[color]+"\n�뷮 = "+caps[cap]+"\n���� = "+price+"��";
		}else if(i==2) {
			return "���� = "+kinds[i]+"\n���� = "+colors2[color]+"\n�뷮 = "+caps[cap]+"\n���� = "+price+"��";
		}else {
			return "x";
		}
	}
	
}
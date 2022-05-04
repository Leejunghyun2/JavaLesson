package practice;

public class CatListVer01 {

	public static void main(String[] args) {
		Cat [] c = new Cat[5]; //배열이 들어갈 !공간!만! 5개를 만듦.
		
		c[0] = new Cat(); //그러면 값이 들어갈 배열 하나하나를 만들어야지.
		c[1] = new Cat("말랑", 13, "여", "고등어"); 
		c[2] = new Cat("둥지", 4, "남"); 
		c[3] = new Cat("무", 3, "남"); 
		c[4] = new Cat("애기씨",7,"여","치즈"); 
		
		for(int i=0; i<c.length; i++) {
			c[i].showInfo();
		}
	}

}

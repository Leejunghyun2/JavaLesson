package practice;

public class CatListVer01 {

	public static void main(String[] args) {
		Cat [] c = new Cat[5]; //�迭�� �� !����!��! 5���� ����.
		
		c[0] = new Cat(); //�׷��� ���� �� �迭 �ϳ��ϳ��� ��������.
		c[1] = new Cat("����", 13, "��", "����"); 
		c[2] = new Cat("����", 4, "��"); 
		c[3] = new Cat("��", 3, "��"); 
		c[4] = new Cat("�ֱ⾾",7,"��","ġ��"); 
		
		for(int i=0; i<c.length; i++) {
			c[i].showInfo();
		}
	}

}

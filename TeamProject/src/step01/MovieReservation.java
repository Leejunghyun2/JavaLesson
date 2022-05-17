package step01;

import java.util.Scanner;

public class MovieReservation implements ChoiceName {
	public static Scanner sc = new Scanner(System.in);
	private static MovieReservation s;

	private MovieReservation() {
		SEAT();
	}

	public static MovieReservation getinstance() { // �ٸ� ����� ��ȭ�����ص� ���������� ����ǰ� �̱����۾�
		if (s == null) {
			s = new MovieReservation();
			return s;
		} else {
			return s;
		}
	}

	final String[][] SEAT = new String[6][6];
	char num = 'A';
	
	
	
	void test() {
		System.out.print("�¼��� ������ A1~F6 : ");
		String at = sc.nextLine().trim();
		at.charAt(0);
		SEAT[numSearch(at.charAt(0))][getNum(at.charAt(1))] = "XX";
		
	}
	
	
	
	
	void showSeat() {
		
		
		for (int i = 0; i < SEAT.length; i++) {
			for (int j = 0; j < SEAT[i].length; j++) {
				System.out.print(SEAT[i][j]+" ");
			}
			System.out.println();
		}
	}

	void SEAT() {
		for (int i = 0; i < SEAT.length; i++) {
			for (int j = 0; j < SEAT[i].length; j++) {
				SEAT[i][j] = num + "" + (j + 1);
			}
			num++;
		}
	}
	
	int numSearch(char at) {
		if(at >= 'A' && at <='F' ) {
			return (int)at-65;
		} else if(at >= 'a' && at <= 'f'){
			return (int)at-97;
		}
		else return 0;
		
	}
	int getNum(char tmp) {
		if(tmp > '0' && tmp < '7') {
			return (int)tmp-49;
		}
		return 0;
	}

}

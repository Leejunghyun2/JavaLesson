package Chap08;

public class Tvtest03 {

	public static void main(String[] args) {

		Tv[] tArr = new Tv[3];

		for (int i = 0; i < tArr.length; i++) {

			tArr[i] = new Tv();
			tArr[i].channel = i + 10;

		}

		for (int i = 0; i < tArr.length; i++) {
			
			tArr[i].channelUp();
			System.out.println(tArr[i].channel);

		}

	}
}

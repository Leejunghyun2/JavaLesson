package Chap02;

public class Timetest {

	
	public static void main(String[] args) {
		
		Time t = new Time();
		
		t.setHour(50);//t.hour = 50;
		t.setMinute(67);//t.minute = 67;
		t.setSecond(66);//t.second =67;
		t.setHour(13);
		t.setSecond(59.9f);
		t.setMinute(59);
		
		t.showTime();
		
	}
}

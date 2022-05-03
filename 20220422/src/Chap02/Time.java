package Chap02;

public class Time {

	private int hour;
	private int minute;
	private float second;

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0 || hour > 24) {
			return;
		}

		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if (minute < 0 || minute > 60) {

			return;
		}
		this.minute = minute;
	}

	public float getSecond() {
		return second;
	}

	public void setSecond(float second) {
		if (second < 0.0f || second > 60.0f) {
			return;
		}
		this.second = second;
	}
	
	public void showTime() {
		System.out.printf("%d : %d : %.2f \n",hour,minute,second);
	}

}

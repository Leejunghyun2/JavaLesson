package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationNumber {
	private static ReservationNumber num;
	
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	int count = 0;
	private ReservationNumber(){
		
	}
	
	public static ReservationNumber getInstance() {
		if(num == null) {
			num = new ReservationNumber();
			return num;
		}return num;
	}
	void GetReserNum() {
		count++;
		ReserNum(count);
	}
	String Today() {
		return format.format(date);
	}
	String ReserNum(int count) {
		
		if(count >999){
			return Today()+String.valueOf(count);
		}else if(count >99) {
			return Today()+"0" + String.valueOf(count);
		}else if(count >9) {
			return Today()+"00"+String.valueOf(count);
		}else {
			return Today()+"000"+String.valueOf(count);
		}
	}
	
}

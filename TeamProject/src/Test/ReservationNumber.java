package Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReservationNumber {
	private static ReservationNumber num;
	public static String[][][][] movie11,movie22,movie33 =null;
	public static String[] movieTime11,movieTime22,movieTime33=null;
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	int count = 0;
	private ReservationNumber(){
		
	}
	final String[] COMPARE = new String[2];
	public static ReservationNumber getInstance() {
		if(num == null) {
			num = new ReservationNumber();
			return num;
		}return num;
	}
	String GetReserNum() {
		if(COMPARE[0] != null) {
			if(!COMPARE[0].equals(Today())){
				count = 0;
			}
		}
		COMPARE[0]=Today();
		count++;
		return ReserNum(count);
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

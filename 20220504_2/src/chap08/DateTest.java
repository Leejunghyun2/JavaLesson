package chap08;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date today = new Date();
		System.out.println();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/mm/dd hh/mm/ss");
		System.out.println(sf.format(today));
		
		
	}
}

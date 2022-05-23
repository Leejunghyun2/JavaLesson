package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReservationNumber {
	private static ReservationNumber num;
	String fileName = "reserNum.ser";
	Date date = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	private int count = 0;
	final String[] COMPARE = new String[1];

	private ReservationNumber() {
		FileSearch();
	}

	public static ReservationNumber getInstance() {
		if (num == null) {
			num = new ReservationNumber();
			return num;
		}
		return num;
	}

	String GetReserNum() {
		if (COMPARE[0] != null) {
			if (!COMPARE[0].equals(Today())) {
				count = 0;
			}
		}
		COMPARE[0] = Today();
		count++;
		return ReserNum(count);
	}

	private String Today() {
		return format.format(date);
	}

	private String ReserNum(int count) {

		if (count > 999) {
			return Today() + String.valueOf(count);
		} else if (count > 99) {
			return Today() + "0" + String.valueOf(count);
		} else if (count > 9) {
			return Today() + "00" + String.valueOf(count);
		} else {
			return Today() + "000" + String.valueOf(count);
		}
	}

	@Override
	public int hashCode() {
		return ReserNum(count).hashCode(); // 주소의 해쉬코드도 비교해야해서 오버라이드
	}

	@Override
	public boolean equals(Object obj) { // 각기 다른곳에 담겨 있는 객체들이라 그 값이 같은지 확인하기위한 오버라이드
		if (obj instanceof User) {
			ReservationNumber tmp = (ReservationNumber) obj;
			return ReserNum(count).equals(tmp.ReserNum(count));
		}
		return false;
	}

	void ObjOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {

			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(count);
			out.writeObject(COMPARE[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	void ObjInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);

			count = (int) in.readObject();
			COMPARE[0] = (String) in.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	void FileSearch() {
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\reserNum.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			ObjInputData();
			System.out.println("-----파일 불러오기 완료-----");
		}
	}

}

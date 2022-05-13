package chap06;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {

			String fileName = "UserInfo.ser";
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			//UserInfo u1 = (UserInfo)in.readObject();
			//UserInfo u2 = (UserInfo)in.readObject();
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)in.readObject();
			
			
			//System.out.println(u1);
			//System.out.println(u2);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (fis!=null) {
					fis.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}

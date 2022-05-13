package chap06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerialEx1 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			String fileName = "UserInfo.ser";
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			UserInfo u1 = new UserInfo("Lee", "1234", 30);
			UserInfo u2 = new UserInfo("Kim", "0000", 20);

			//out.writeObject(u1);
			//out.writeObject(u2);
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			list.add(u1);
			list.add(u2);
			
			out.writeObject(list);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e2) {
				// TODO: handle exception
			}
		}
	}
}

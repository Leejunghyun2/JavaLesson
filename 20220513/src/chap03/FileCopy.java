package chap03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args){
		try {
			
		FileInputStream fis = new FileInputStream("C:\\Users\\WU\\eclipse-workspace\\20220513\\src\\chap03\\FileViewer.java");
		FileOutputStream fos = new FileOutputStream("FileCopy.bak");
		
		int data = 0;
		while((data=fis.read())!=-1) {
			fos.write(data);
		}
		fis.close();
		fos.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}

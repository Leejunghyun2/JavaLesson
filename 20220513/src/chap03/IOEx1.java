package chap03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {
	public static void main(String[] args) {
		
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		while((data = input.read())!=-1) {//read 데이터 읽을게 없으면 -1 반환
			output.write(data); //스트림에 쌓아둠
		
		}
		
		outSrc = output.toByteArray();//스트림내용 바이트배열로 반환
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
		
	}
}

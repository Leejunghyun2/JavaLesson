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
		while((data = input.read())!=-1) {//read ������ ������ ������ -1 ��ȯ
			output.write(data); //��Ʈ���� �׾Ƶ�
		
		}
		
		outSrc = output.toByteArray();//��Ʈ������ ����Ʈ�迭�� ��ȯ
		
		System.out.println("Input Source : " + Arrays.toString(inSrc));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
		
	}
}
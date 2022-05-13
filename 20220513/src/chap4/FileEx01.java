package chap4;

import java.io.File;
import java.io.IOException;

public class FileEx01 {
	public static void main(String[] args) throws IOException{
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\20220513\\src\\chap4\\FileEx.java");
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("��θ� ������ �����̸� -" + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸� -"+ fileName.substring(0,pos));
		System.out.println("Ȯ���� -"+fileName.substring(pos+1));
		
		System.out.println("��θ� ������ �����̸� -" + f.getPath());
		System.out.println("������ ������ -"+f.getAbsolutePath());
		System.out.println("������ ���԰�� -"+f.getCanonicalPath());
		System.out.println("������ ���� �ִ� ���丮 -"+f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator -"+File.pathSeparator);
		System.out.println("File.pathSeparatorChar -"+File.pathSeparatorChar);
		System.out.println("File.separator -"+File.separator);
		System.out.println("File.separatorChar -" +File.separatorChar);
		System.out.println();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("sun,boot,class,path"));
	
	}
}

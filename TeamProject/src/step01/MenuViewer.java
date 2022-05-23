package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MenuViewer {
	private static MenuViewer e;
	private MenuViewer() {
		FileSearch();
	}
	public static MenuViewer getInstance() {
		if(e == null) {
			e = new MenuViewer();
			return e;
		}return e;
		
	}
	static String movieName[] = new String[3];
    String fileName = "MenuViwer.ser";
	static void showMenu() {
		System.out.println("1. ��ȭ����");
		System.out.println("2. ����Ȯ��");
		System.out.println("3. �������");
		System.out.println("4. �¼���ȸ");
		System.out.println("5. �α׾ƿ�");
		System.out.println("6. ȸ��Ż��");
		System.out.println("0. ���");
		System.out.print("==> ");
	}

	static void showMovieMenu() {
		

		for(int i=0; i<movieName.length; i++)
			if(movieName[i]==null) {
				movieName[i] = "��������������ȭ��";
			}
		System.out.println("1. " + movieName[0]);
		System.out.println("2. " + movieName[1]);
		System.out.println("3. " + movieName[2]);
		System.out.println("0. ���");
		System.out.print("==> ");
	}

	static void showUserManagement() {
		System.out.println("1. �α���");
		System.out.println("2. ȸ������");
		System.out.println("3. ��ȸ������");
		System.out.println("4. ��ȸ������Ȯ��");
		System.out.println("5. ��ȸ���������");
		System.out.println("6. �¼���ȸ");
		System.out.println("0. ���");
		System.out.print("==> ");
	}

	static void showAdminChoice() {
		System.out.println("1. ȸ������");
		System.out.println("2. ��ȭ����");
		System.out.println("3. �׽�Ʈ");
		System.out.println("4. ȸ�����");
		System.out.println("5. �α׾ƿ�");
		System.out.print("==> ");
	}

	static void MovieManagement() {
		System.out.println("1. �󿵿�ȭ�̸�");
		System.out.println("2. ��ȭ�ð�����");
	}
	void ObjOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {

			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(movieName);
			
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

			movieName = (String[]) in.readObject();
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
		File f = new File("C:\\Users\\������\\eclipse-workspace\\TeamProject\\MenuViwer.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			ObjInputData();
		}
	}

}
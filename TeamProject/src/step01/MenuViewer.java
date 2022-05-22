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
	static String movieName1 = null, movieName2 = null, movieName3 = null;
    String fileName = "MenuViwer.ser";
	static void showMenu() {
		System.out.println("1. 영화예매");
		System.out.println("2. 예매확인");
		System.out.println("3. 예매취소");
		System.out.println("4. 좌석조회");
		System.out.println("5. 로그아웃");
		System.out.println("6. 회원탈퇴");
		System.out.println("0. 취소");
		System.out.print("==> ");
	}

	static void showMovieMenu() {

		if (movieName1 == null) {
			movieName1 = "개설되지않은영화관";
		}
		System.out.println("1. " + movieName1);
		if (movieName2 == null) {
			movieName2 = "개설되지않은영화관";
		}
		System.out.println("2. " + movieName2);
		if (movieName3 == null) {
			movieName3 = "개설되지않은영화관";
		}
		System.out.println("3. " + movieName3);
		System.out.println("0. 취소");
		System.out.print("==> ");
	}

	static void showUserManagement() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 비회원예매");
		System.out.println("4. 비회원예매확인");
		System.out.println("5. 비회원예매취소");
		System.out.println("6. 좌석조회");
		System.out.println("0. 취소");
		System.out.print("==> ");
	}

	static void showAdminChoice() {
		System.out.println("1. 회원관리");
		System.out.println("2. 영화관리");
		System.out.println("3. 테스트");
		System.out.println("4. 회원목록");
		System.out.println("5. 로그아웃");
		System.out.println("0. 취소");
		System.out.print("==> ");
	}

	static void MovieManagement() {
		System.out.println("1. 상영영화이름");
		System.out.println("2. 영화시간설정");
	}
	void ObjOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {

			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);

			out.writeObject(movieName1);
			out.writeObject(movieName2);
			out.writeObject(movieName3);
			
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

			movieName1 = (String) in.readObject();
			movieName2 = (String) in.readObject();
			movieName3 = (String) in.readObject();
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
		File f = new File("C:\\Users\\이정현\\eclipse-workspace\\TeamProject\\MenuViwer.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			ObjInputData();
		}
	}

}
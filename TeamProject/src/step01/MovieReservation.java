package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
	static Scanner sc = new Scanner(System.in);
	private static MovieReservation s;
	static String[][][][] movie = new String[3][][][];
	static String[][] movieTime = new String[3][];

	private MovieReservation() {
		FileSearch();
	}

	public static MovieReservation getinstance() {
		if (s == null) {
			s = new MovieReservation();
			return s;
		}
		return s;
	}

	ArrayList<MemberReservationInfo> mri = new ArrayList<MemberReservationInfo>();
	ArrayList<NonReservInfo> nri = new ArrayList<NonReservInfo>();
	ArrayList<Integer> buffer = new ArrayList<Integer>();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	ArrayList<User> users = NewMember.userInstance();
	ReservationNumber getReserNum = ReservationNumber.getInstance();
	int moviechoice = 0, att, seatnum, movieTimeChoice;
	String name, tel, at;
	String fileName = "MovieReservation.ser";

	void test() {
		for (int i = 0; i < mri.size(); i++) {
			System.out.println(mri.get(i));
		}
	}
	
	void reservationConfirm() {
		if (NewMember.SIGN[0] != null) {
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("%s���� ���ų���\n", mri.get(i).id);
					break;
				} else {
					System.out.println("���ų����� �����ϴ�.");
				}
			}
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.println(mri.get(i));
				}
			}
		}
	}

	void reservationAllCancle() {
		int count = 0;

		if (NewMember.SIGN[0] != null) { // if(2) ����
			for (int i = 0; i < mri.size(); i++) { // for(1)����
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
					count += 1;
					buffer.add(i);
					System.out.println(count + " : " + mri.get(i));
				} else {
					System.out.println("���ų����� �����ϴ�.");
					return;
				}
			}
			System.out.print("���� ����Ͻðڽ��ϱ�? \n 1.Yes 2.No \n ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				for (int i = buffer.size() - 1; i >= 0; i--) {
					memberSeatCancleSearch(i);
					mri.remove((int) (buffer.get(i)));
					buffer.remove(i);
				}
				System.out.printf("�� %s�� ��ҿϷ�", count);
				count = 0;
			} else {
				System.out.println("------��Ҿ���------");
			}
		}
	}

	void reservationCancle() throws Exception {
		if (NewMember.SIGN[0] != null) { // if(2) ����
			System.out.print("�����ϼ��� : 1. ������� 2. ��ü���");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}
			if (choice == 1) {
				MemberCancle();
			} else {
				reservationAllCancle();
			}
		} else { // if(2) �� else(2)
			NonMemberCancle();
		}
	}

	void signOut() throws ChoiceException {
		System.out.print("�α׾ƿ� �Ͻðڽ��ϱ�? 1.YES 2.NO \n==>");
		try {

			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2) {
				throw new ChoiceException();
			}
			if (choice == 1) {
				NewMember.SIGN[0] = null;
				System.out.println("----�α׾ƿ� �Ϸ�----");
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (Exception e) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	void nonMemberReser() throws ChoiceException {
		try {
			nonmemberInfo();
			seatChoice();
		} catch (ChoiceException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void nonmemberInfo() {
		System.out.print("�̸��� �Է��ϼ��� ==> ");
		name = sc.nextLine();
		System.out.print("�ڵ�����ȣ�� �Է��ϼ��� ==> ");
		tel = sc.nextLine();
		con.add(new Consumer(name,tel));
	}

	void nonreserveConfirm() {
		System.out.print("�ڵ�����ȣ�� �Է����ּ��� ==> ");
		String phoneNumber = sc.nextLine();
		for (int i = 0; i < nri.size(); i++) {
			if (nri.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("%s���� ���ų���\n", nri.get(i).name);
				break;
			}
		}
		for (int i = 0; i < nri.size(); i++) {
			if (nri.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("�� %s�� %s��\n �󿵽ð� : %s\n", nri.get(i).moviechoice, nri.get(i).seat,
						nri.get(i).movieTime);
			} else {
				System.out.println("���ŵ� ������ �����ϴ�.");
				return;
			}
		}
	}

	void showSeatStatus() throws ChoiceException {
		if(showSeat());
		  return;
	}

	void nonShowSeatStatus() throws ChoiceException {
		showSeat();
	}

	void movieSeat(int i) {
		if (movie[i - 1] != null) {
			for (int time = 0; time < movie[i - 1].length; time++) {
				for (int col = 0; col < movie[i - 1][time].length; col++) {
					for (int row = 0; row < movie[i - 1][time][col].length; row++) {
						movie[i - 1][time][col][row] = ((char) (col + 65)) + "" + (row + 1) + "";
					}
				}
			}
		}
	}

	boolean showSeat() throws ChoiceException { // ��ȭ�������ؼ� �ڸ� �����ִ� �޼ҵ�
		if (movieChoice()) {
			if (movie[moviechoice - 1] == null) {
				System.out.println("������ ��ȭ�� �����ϴ�.");
				return false;
			}
			for (int count = 1; count <= movieTime[moviechoice - 1].length; count++) {
				System.out.println(count + " :" + movieTime[moviechoice - 1][count - 1]);
			}
			System.out.print("�ð� ���� : ");
			movieTimeChoice = Integer.parseInt(sc.nextLine());
			System.out.println("��ȭ�� �� " + moviechoice + " �� �ð�:" + movieTime[moviechoice-1][movieTimeChoice-1]);

			for (int i = 0; i < (movie[moviechoice - 1][movieTimeChoice - 1]).length; i++) {
				for (int j = 0; j < (movie[moviechoice - 1][movieTimeChoice - 1][i]).length; j++) {
					System.out.print((movie[moviechoice - 1][movieTimeChoice - 1][i][j]) + " ");
				}
				System.out.println();
			}

			return true;
		}
		return false;
	}

	void seatChoice() throws Exception {
		if (showSeat()) {
			try {
				while (true) {
					System.out.print("A1~F6 : ");
					at = sc.nextLine().toUpperCase().trim();
					att = numSearch(at.charAt(0));
					seatnum = getNum(at.charAt(1));

					if (movie[moviechoice - 1] != null) {
						if ("XX".equals(movie[moviechoice - 1][movieTimeChoice - 1][att][seatnum])) {
							System.out.print("�̹� ���� �Ǿ��ִ��ڸ��Դϴ�.\n");
							System.out.print("�ٽ� �������ּ���.\n");
							continue;
						}
					}
					break;
				}
				System.out.println("�¼��� �½��ϱ�? ==> " + at);
				System.out.println("1.Yes 2.No");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < 1 || choice > 2) {
					throw new ChoiceException();
				}
				if (choice == 1) {
					
					movie[moviechoice - 1][movieTimeChoice - 1][att][seatnum] = "XX";
					System.out.println("--------���ſϷ�--------");
					System.out.println("��ȭ�� �� " + moviechoice + "��\n" + "�¼� : " + at + "\n�󿵽ð� : "
							+ movieTime[moviechoice - 1][movieTimeChoice - 1]);
					
					if (NewMember.SIGN[0] != null) {
						mri.add(new MemberReservationInfo(NewMember.SIGN[0], moviechoice, at, getReserNum.GetReserNum(),
								movieTime[moviechoice - 1][movieTimeChoice - 1], movieTimeChoice));
					} else {
						nri.add(new NonReservInfo(name, tel, moviechoice, at, getReserNum.GetReserNum(), movieTime[moviechoice - 1][movieTimeChoice - 1],
								movieTimeChoice));
					}
					return;
				} else {
					return;
				}
			} catch (ChoiceException e) {
				e.showWrongChoice();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
			}
		} 
			return;
	} // ��������Ϸ�

	boolean movieChoice() throws ChoiceException {
		MenuViewer.showMovieMenu();
		if (movie[0] == null && movie[1] == null && movie[2] == null) {
			System.out.println("������ ��ȭ�� �����ϴ�.");
			return false;
		}
		moviechoice = Integer.parseInt(sc.nextLine());
		try {
			if (moviechoice < 0 || moviechoice > 3) {
				throw new ChoiceException();
			} else if (moviechoice == 0) {
				System.out.println("------�������-------");
				return false;
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		}
		return true;
	}

	int numSearch(char at) {
		if (at >= 'A' && at <= 'F')
			return at - 65;
		if (at >= 'a' && at <= 'f')
			return at - 97;
		return -1;
	}

	int getNum(char tmp) {
		if (tmp > '0' && tmp < '7')
			return tmp - 49;
		return -1;
	}

	void AllCancle() {
		buffer.clear();
		for (int i = 0; i < mri.size(); i++) { // for(1)����
			if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
				buffer.add(i);
			}
		}
		for (int j = buffer.size() - 1; j >= 0; j--) {
			memberSeatCancleSearch(j);
			buffer.remove(j);
		}
	}

	void MemberCancle() {
		int count = 0;
		int i = 0;
		buffer.clear();
		if (mri.isEmpty()) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		}
		for (i = 0; i < mri.size(); i++) { // for(1)����
			if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)����
				count += 1;
				buffer.add(i);
				System.out.println(count + " : " + mri.get(i));
			}
		}
		if (count == 0) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		} else if (count > 1) {
			System.out.print("� �� ����Ͻðڽ��ϱ�? ==> ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("���� ����Ͻðڽ��ϱ�?");
			System.out.print(mri.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				memberSeatCancleSearch(num - 1);
				System.out.println("-----��ҿϷ�-----");
				count = 0;
				mri.remove((int) (buffer.get(num - 1)));
			} else {
				System.out.println("------��Ҿ���-------");
				return;
			}

		} else {
			System.out.println("���� ����Ͻðڽ��ϱ�?");
			System.out.print("==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				memberSeatCancleSearch(buffer.get(0));
				System.out.println("----��ҿϷ�----");
				count = 0;
				mri.remove((int) buffer.get(0));
			} else {
				System.out.println("------��Ҿ���-------");
				return;
			}
		}
	}

	void memberSeatCancleSearch(int i) {
		movie[mri.get(buffer.get(i)).moviechoice - 1][mri.get(buffer.get(i)).movieTimeChoice - 1][numSearch(
				mri.get(buffer.get(i)).seat.charAt(0))][getNum(
						mri.get(buffer.get(i)).seat.charAt(1))] = mri.get(buffer.get(i)).seat;
	}

	void nonMemberSeatCancleSearch(int i) {
		movie[nri.get(buffer.get(i)).moviechoice - 1][nri.get(buffer.get(i)).movieTimeChoice - 1][numSearch(
				nri.get(buffer.get(i)).seat.charAt(0))][getNum(
						nri.get(buffer.get(i)).seat.charAt(1))] = nri.get(buffer.get(i)).seat;
	}

	void MovieCheck() {
		for (int i = 0; i < movie.length; i++) {
			if(movie[i]==null) {
			System.out.println((i + 1) + "�� ������ ��ȭ�� �����ϴ�.");
			}
		}
	}

	void NonMemberCancle() {
		int count = 0;
		int j = 0;
		String tel;
		buffer.clear();
		while (true) {
			System.out.print("�ڵ�����ȣ�� �Է����ּ��� ==> ");
			tel = sc.nextLine();
			if (tel.length() != 11) {
				System.out.println("�߸� �Է��ϼ˽��ϴ�. �ٽ� �Է����ּ���");
				continue;
			}
			break;
		}
		if (nri.isEmpty()) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		}
		for (j = 0; j < nri.size(); j++) {// for(2)����
			if (nri.get(j).phoneNumber.equals(tel)) { // if(4)����
				count += 1;
				buffer.add(j);
				System.out.println(count + " : " + nri.get(j));
			}
		}
		if (count == 0) {
			System.out.println("���� ������ �����ϴ�.");
			return;
		} else if (count > 1) {
			System.out.print("� �� ����Ͻðڽ��ϱ�? ==> ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("���� ����Ͻðڽ��ϱ�?");
			System.out.print(nri.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				nonMemberSeatCancleSearch(num - 1);
				System.out.println("---- ��ҿϷ� ----");
				count = 0;
				nri.remove((int) (buffer.get(num - 1)));
			} else {
				System.out.println("------�������------");
				return;
			}

		} else if (count == 1) {
			System.out.println("���� ����Ͻðڽ��ϱ�?");
			System.out.printf(nri.get(buffer.get(0)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				nonMemberSeatCancleSearch(0);
				System.out.println("----��ҿϷ�----");
				count = 0;
				nri.remove((int) buffer.get(0));
			} else {
				System.out.println("----��Ҿ���----");
				return;
			}
		}
	}

	void ObjOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(con);
			out.writeObject(mri);
			out.writeObject(nri);
			out.writeObject(movie);
			out.writeObject(movieTime);
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
			con = (ArrayList<Consumer>) in.readObject();
			mri = (ArrayList<MemberReservationInfo>) in.readObject();
			nri = (ArrayList<NonReservInfo>) in.readObject();
			movie = (String[][][][]) in.readObject();
			movieTime = (String[][]) in.readObject();
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
		File f = new File("C:\\Users\\������\\eclipse-workspace\\TeamProject\\MovieReservation.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			ObjInputData();
		}
	}
}
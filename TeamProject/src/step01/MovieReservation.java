package step01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
	public static Scanner sc = new Scanner(System.in);

	private static MovieReservation s;

	private String[][][] SEAT = new String[3][6][6];

	private MovieReservation() {
		SEAT();
		FileSearch();
	}

	public static MovieReservation getinstance() {
		if (s == null) {
			s = new MovieReservation();
			return s;
		}
		return s;
	}

	ArrayList<Integer> buffer = new ArrayList<Integer>();

	String name, tel, at;
	String fileName ="MovieReservation.ser";
	int moviechoice = 0, att, seatnum;
	ArrayList<User> users = NewMember.userInstance();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	private static ArrayList<MemberReservationInfo> mri = new ArrayList<MemberReservationInfo>();
	private static ArrayList<NonReservInfo> nri = new ArrayList<NonReservInfo>();

	void movieChoice() throws ChoiceException {
		MenuViewer.showMovieMenu();
		moviechoice = Integer.parseInt(sc.nextLine());
		try {
			if (moviechoice < 1 || moviechoice > 3)
				throw new ChoiceException();
		} catch (ChoiceException e) {
			e.showWrongChoice();
		}
	}

	void reservationConfirm() {
		if (NewMember.SIGN[0] != null) {
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("%s님의 예매내역\n", mri.get(i).id);
					break;
				}
			}
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("영화관 제 %s관 %s 번\n", mri.get(i).moviechoice, mri.get(i).seat);
				}
			}
		}
	}

	void nonreserveConfirm() {
		System.out.print("핸드폰번호를 입력해주세요 ==> ");
		String tel = sc.nextLine();
		for (int i = 0; i <nri.size(); i++) {
			if (nri.get(i).tel.equals(tel)) {
				System.out.printf("%s님의 예매내역\n",nri.get(i).name);
				break;
			}
		}
		for (int i = 0; i < nri.size(); i++) {
			if (nri.get(i).tel.equals(tel)) {
				System.out.printf("제 %s관 %s번\n", nri.get(i).moviechoice,nri.get(i).seat);
			} else {
				System.out.println("예매된 내역이 없습니다.");
				return;
			}
		}
	}

	void reservationCancle() {
		int count = 0;

		if (NewMember.SIGN[0] != null) { // if(2) 시작
			for (int i = 0; i < mri.size(); i++) { // for(1)시작
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
					count += 1;
					buffer.add(i);
					System.out.printf("%d : %s관 %s번\n", count, mri.get(i).moviechoice, mri.get(i).seat);
				} else {
					System.out.println("예매내역이 없습니다.");
				}
			}
			if (count > 1) {
				System.out.print("어떤 걸 취소하시겠습니까? ==> ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("예매 취소하시겠습니까?");
				System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ", mri.get(buffer.get(num - 1)).moviechoice,
						mri.get(buffer.get(num - 1)).seat);
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					SEAT[mri.get(buffer.get(num - 1)).moviechoice - 1]
							[numSearch(mri.get(buffer.get(num - 1)).seat.charAt(0))][getNum(
									mri.get(buffer.get(num - 1)).seat.charAt(1))] = mri.get(buffer.get(num - 1)).seat;
					System.out.println("-----취소완료-----");
					count = 0;
					mri.remove((int) (buffer.get(num - 1)));
					buffer.remove(num - 1);
				} else {
					System.out.println("------취소안함-------");
					return;
				}

			} else {
				System.out.println("예매 취소하시겠습니까?");
				System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ", mri.get(buffer.get(0)).moviechoice,
						mri.get(buffer.get(0)).seat);
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					SEAT[mri.get(buffer.get(0)).moviechoice - 1][numSearch(
							mri.get(buffer.get(0)).seat.charAt(0))][getNum(
									mri.get(buffer.get(0)).seat.charAt(1))] = mri.get(buffer.get(0)).seat;

					System.out.println("----취소완료----");
					count = 0;
					mri.remove(0);
					buffer.remove(0);
				} else {
					System.out.println("------취소안함-------");
					return;
				}
			}
		} else { // if(2) 끝 else(2)
			System.out.print("핸드폰번호를 입력해주세요 ==> ");
			String tel = sc.nextLine();
			for (int j = 0; j < nri.size(); j++) {// for(2)시작
				if (nri.get(j).tel.equals(tel)) { // if(4)시작
					count += 1;
					buffer.add(j);
					System.out.printf("%d : %s관 %s번\n", count, nri.get(j).moviechoice, nri.get(j).seat);
				} else { // if(4)끝 else(4)시작
					System.out.println("예매 내역이 없습니다.");
					return;
				} // else(4) 끝
			}
			if (count > 1) {
				System.out.print("어떤 걸 취소하시겠습니까? ==> ");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("예매 취소하시겠습니까?");
				System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ", nri.get(buffer.get(num - 1)).moviechoice,
						nri.get(buffer.get(num - 1)).seat);
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {

					SEAT[nri.get(buffer.get(num - 1)).moviechoice - 1][numSearch(
							nri.get(buffer.get(num - 1)).seat.charAt(0))][getNum(
									nri.get(buffer.get(num - 1)).seat.charAt(1))] = nri.get(buffer.get(num - 1)).seat;
					System.out.println("---- 취소완료 ----");
					count = 0;
					nri.remove((int) (buffer.get(num - 1)));
					buffer.remove(buffer.get(num - 1));
				} else {
					System.out.println("------취소종료------");
					return;
				}

			} else {

				System.out.println("예매 취소하시겠습니까?");
				System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ", nri.get(buffer.get(0)).moviechoice,
						nri.get(buffer.get(0)).seat);
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {

					SEAT[nri.get(0).moviechoice - 1][numSearch(nri.get(0).seat.charAt(0))][getNum(
							nri.get(0).seat.charAt(1))] = nri.get(0).seat;

					System.out.println("----취소완료----");
					count = 0;
					nri.remove(0);
					buffer.remove(0);
				} else {
					System.out.println("----취소안함----");
					return;
				}
			}

		} // else(3) 끝

	}

	void signOut() {
		System.out.print("로그아웃 하시겠습니까? 1.YES 2.NO \n==>");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			NewMember.SIGN[0] = null;
			System.out.println("----로그아웃 완료----");
		}
	}

	void seatChoice() throws ChoiceException {
		showSeat();
		while(true) {
		System.out.print("A1~F6 : ");
		at = sc.nextLine().toUpperCase().trim();
		att = numSearch(at.charAt(0));
		seatnum = getNum(at.charAt(1));
		if(SEAT[moviechoice-1][att][seatnum].equals("XX")) {
			System.out.println("이미 예매 되어있는자리입니다.");
			System.out.println("다시 선택해주세요.");
			continue;
		}
		break;
		}
		try {
			if (att < 0 || att > 6 || seatnum < 0 || seatnum > 6)
				throw new ChoiceException();
			System.out.println("좌석이 맞습니까? ==> " + at);
			System.out.println("1.Yes 2.No");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2)
				throw new ChoiceException();
			if (choice == 1) {
				SEAT[moviechoice - 1][att][seatnum] = "XX";
				System.out.println("--------예매완료--------");
				System.out.println("영화관 제 " + moviechoice + "관\n" + "좌석 : " + at);

				if (NewMember.SIGN[0] != null) {
					mri.add(new MemberReservationInfo(NewMember.SIGN[0], moviechoice, at));
				} else {
					nri.add(new NonReservInfo(name, tel, moviechoice, at));
				}
			} else {
				return;
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		}
	}

	void nonMemberReser() throws ChoiceException {

		con.add(nonmemberInfo());
		movieChoice();
		seatChoice();
	}

	void showSeat() {
		System.out.println("영화관 제 " + moviechoice + " 관");
		for (int i = 0; i < (SEAT[moviechoice - 1]).length; i++) {
			for (int j = 0; j < (SEAT[moviechoice - 1][i]).length; j++) {
				System.out.print((SEAT[moviechoice - 1][i][j]) + " ");
			}
			System.out.println();
		}
	}

	void showSeatStatus() throws ChoiceException {
		movieChoice();
		showSeat();
	}

	void nonShowSeatStatus() throws ChoiceException {
		movieChoice();
		showSeat();
	}

	private void SEAT() {
		for (int k = 0; k < SEAT.length; k++) {
			for (int i = 0; i < (SEAT[k]).length; i++) {
				for (int j = 0; j < (SEAT[k][i]).length; j++)
					SEAT[k][i][j] = ((char) (i + 65)) + "" + (j + 1) + "";
			}
		}
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

	Consumer nonmemberInfo() {
		System.out.print("이름을 입력하세요 ==> ");
		name = sc.nextLine();
		System.out.print("핸드폰번호를 입력하세요 ==> ");
		tel = sc.nextLine();
		return new Consumer(name, tel);
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
			out.writeObject(SEAT);
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
			SEAT = (String[][][])in.readObject();
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
		File f = new File("C:\\Users\\이정현\\eclipse-workspace\\TeamProject\\MovieReservation.ser");
		if (!f.exists()) {
			System.out.println("Start");
		} else if (f.exists()) {
			ObjInputData();
		}
	}
}

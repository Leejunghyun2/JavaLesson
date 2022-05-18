package step01;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
	public static Scanner sc = new Scanner(System.in);

	private static MovieReservation s;

	private final String[][][] SEAT = new String[3][6][6];

	private MovieReservation() {
		SEAT();
	}

	public static MovieReservation getinstance() {
		if (s == null) {
			s = new MovieReservation();
			return s;
		}
		return s;
	}

	String name;
	String tel;
	int moviechoice = 0;
	String store;
	int att;
	int seatnum;
	ArrayList<User> users = NewMember.userInstance();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	private ArrayList<MemberReservationInfo> mri = new ArrayList<MemberReservationInfo>();
	private ArrayList<NonReservInfo> nri = new ArrayList<NonReservInfo>();

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
					System.out.printf("%s님이 예매하신 자리는 \n영화관 제 %s관 %s 자리입니다.\n"
										, mri.get(i).id, mri.get(i).moviechoice,mri.get(i).seat );
				}
			}
		}
	}
	void nonreserveConfirm() {
		for(int i = 0; i < nri.size(); i++) {
			System.out.print("핸드폰번호를 입력해주세요 ==> ");
			String tel = sc.nextLine();
			if(nri.get(i).tel.equals(tel)) {
				System.out.printf("%s님의 자리는 영화관 제 %s관 %s자리입니다",
									nri.get(i).name,nri.get(i).moviechoice,nri.get(i).seat);
			}
			else {
				System.out.println("예매된 내역이 없습니다.");
				return;
			}
		}
	}

	void reservationCancle() {
		System.out.print("예매취소 하시겠습니까? 1.YES 2.NO \n==>");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			if (NewMember.SIGN[0] != null) {
				for (int i = 0; i < mri.size(); i++) {
					if (mri.get(i).id.equals(NewMember.SIGN[0])) {
						SEAT[mri.get(i).moviechoice-1][numSearch(mri.get(i).seat.charAt(0))][getNum(
								mri.get(i).seat.charAt(1))] = mri.get(i).seat;
						System.out.println("----취소완료----");
					} else {
						System.out.print("핸드폰번호를 입력해주세요 ==> ");
						String tel = sc.nextLine();
						for (int j = 0; j < nri.size(); j++) {
							if (nri.get(j).tel.equals(tel)) {
								SEAT[nri.get(j).moviechoice-1][numSearch(nri.get(j).seat.charAt(0))][getNum(
										nri.get(j).seat.charAt(1))] = nri.get(j).seat;
								System.out.println("----취소완료----");

							}else {
								System.out.println("잘못입력하셨습니다.");
								return;
							}
						}
					}
				}
			}
		} else {
			return;
		}
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
		System.out.print("A1~F6 : ");
		String at = sc.nextLine().toUpperCase().trim();
		att = numSearch(at.charAt(0));
		seatnum = getNum(at.charAt(1));
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
				store = at;
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
}

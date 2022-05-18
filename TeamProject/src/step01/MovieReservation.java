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
					System.out.printf("%s���� �����Ͻ� �ڸ��� \n��ȭ�� �� %s�� %s �ڸ��Դϴ�.\n"
										, mri.get(i).id, mri.get(i).moviechoice,mri.get(i).seat );
				}
			}
		}
	}
	void nonreserveConfirm() {
		for(int i = 0; i < nri.size(); i++) {
			System.out.print("�ڵ�����ȣ�� �Է����ּ��� ==> ");
			String tel = sc.nextLine();
			if(nri.get(i).tel.equals(tel)) {
				System.out.printf("%s���� �ڸ��� ��ȭ�� �� %s�� %s�ڸ��Դϴ�",
									nri.get(i).name,nri.get(i).moviechoice,nri.get(i).seat);
			}
			else {
				System.out.println("���ŵ� ������ �����ϴ�.");
				return;
			}
		}
	}

	void reservationCancle() {
		System.out.print("������� �Ͻðڽ��ϱ�? 1.YES 2.NO \n==>");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			if (NewMember.SIGN[0] != null) {
				for (int i = 0; i < mri.size(); i++) {
					if (mri.get(i).id.equals(NewMember.SIGN[0])) {
						SEAT[mri.get(i).moviechoice-1][numSearch(mri.get(i).seat.charAt(0))][getNum(
								mri.get(i).seat.charAt(1))] = mri.get(i).seat;
						System.out.println("----��ҿϷ�----");
					} else {
						System.out.print("�ڵ�����ȣ�� �Է����ּ��� ==> ");
						String tel = sc.nextLine();
						for (int j = 0; j < nri.size(); j++) {
							if (nri.get(j).tel.equals(tel)) {
								SEAT[nri.get(j).moviechoice-1][numSearch(nri.get(j).seat.charAt(0))][getNum(
										nri.get(j).seat.charAt(1))] = nri.get(j).seat;
								System.out.println("----��ҿϷ�----");

							}else {
								System.out.println("�߸��Է��ϼ̽��ϴ�.");
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
		System.out.print("�α׾ƿ� �Ͻðڽ��ϱ�? 1.YES 2.NO \n==>");
		int choice = Integer.parseInt(sc.nextLine());
		if (choice == 1) {
			NewMember.SIGN[0] = null;
			System.out.println("----�α׾ƿ� �Ϸ�----");
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
			System.out.println("�¼��� �½��ϱ�? ==> " + at);
			System.out.println("1.Yes 2.No");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2)
				throw new ChoiceException();
			if (choice == 1) {
				SEAT[moviechoice - 1][att][seatnum] = "XX";
				System.out.println("--------���ſϷ�--------");
				System.out.println("��ȭ�� �� " + moviechoice + "��\n" + "�¼� : " + at);
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
		System.out.println("��ȭ�� �� " + moviechoice + " ��");
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
		System.out.print("�̸��� �Է��ϼ��� ==> ");
		name = sc.nextLine();
		System.out.print("�ڵ�����ȣ�� �Է��ϼ��� ==> ");
		tel = sc.nextLine();
		return new Consumer(name, tel);
	}
}

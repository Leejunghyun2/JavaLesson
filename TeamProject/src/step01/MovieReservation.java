package step01;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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
	ArrayList<Integer> buffer = new ArrayList<Integer>();

	String name, tel;
	int moviechoice = 0 , att , seatnum;
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
					System.out.printf("%s님의 예매내역",mri.get(i).id);
					break;
				}
			}
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("영화관 제 %s관 %s 번\n"
										,  mri.get(i).moviechoice,mri.get(i).seat );
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
		int count = 0;
		
			if (NewMember.SIGN[0] != null) { //if(2) 시작
				for (int i = 0; i < mri.size(); i++) { //for(1)시작
					if (mri.get(i).id.equals(NewMember.SIGN[0])) {//if(3)시작 
						count += 1;
						buffer.add(i);
						System.out.printf("%d : %s관 %s번\n",count,mri.get(i).moviechoice,mri.get(i).seat);
					} else {
						System.out.println("예매내역이 없습니다.");
					}
				}
				if(count > 1) {
					System.out.print("어떤 걸 취소하시겠습니까? ==> ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("예매 취소하시겠습니까?");
					System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ",
										mri.get(buffer.get(num-1)).moviechoice,
												mri.get(buffer.get(num-1)).seat);
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						SEAT[mri.get(buffer.get(num-1)).moviechoice-1]
								[numSearch(mri.get(buffer.get(num-1)).seat.charAt(0))]
										[getNum(mri.get(buffer.get(num-1)).seat.charAt(1))] 
												= mri.get(buffer.get(num-1)).seat;
					System.out.println("-----취소완료-----");
					count = 0;
					mri.remove((int)(buffer.get(num-1)));
					buffer.remove(num-1);
					} else {
						System.out.println("------취소안함-------");
						return;
					}
					
				}else {
					System.out.println("예매 취소하시겠습니까?");
					System.out.printf("제 %s관 %s번 ==> 1. Yes 2. No\n==> ",
										mri.get(buffer.get(0)).moviechoice,
												mri.get(buffer.get(0)).seat);
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
					SEAT[mri.get(buffer.get(0)).moviechoice-1]
						[numSearch(mri.get(buffer.get(0)).seat.charAt(0))]
								[getNum(mri.get(buffer.get(0)).seat.charAt(1))] 
										= mri.get(buffer.get(0)).seat;
				
					System.out.println("----취소완료----");
					count = 0;
					mri.remove(0);
					buffer.remove(0);
					} else {
						System.out.println("------취소안함-------");
					}
				}
				} else { //if(2) 끝 else(2)
						System.out.print("핸드폰번호를 입력해주세요 ==> ");
						String tel = sc.nextLine();
						for (int j = 0; j < nri.size(); j++) {//for(2)시작
							if (nri.get(j).tel.equals(tel)) { //if(4)시작
								SEAT[nri.get(j).moviechoice-1]
										[numSearch(nri.get(j).seat.charAt(0))]
												[getNum(nri.get(j).seat.charAt(1))] 
														= nri.get(j).seat;
								
								System.out.println("----취소완료----");

							}else { //if(4)끝 else(4)시작
								System.out.println("잘못입력하셨습니다.");
								return;
							}//else(4) 끝
						}//for(2) 끝
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

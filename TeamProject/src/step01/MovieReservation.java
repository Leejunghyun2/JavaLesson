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
		fileSearch();
	}

	public static MovieReservation getinstance() {
		if (s == null) {
			s = new MovieReservation();
			return s;
		}
		return s;
	}

	ArrayList<MemberTicket> memberTicket = new ArrayList<MemberTicket>();
	ArrayList<NonMemberTicket> nonMemberTicket = new ArrayList<NonMemberTicket>();
	ArrayList<Integer> buffer = new ArrayList<Integer>();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	ArrayList<User> users = NewMember.userInstance();
	ReservationNumber getReservNum = ReservationNumber.getInstance();
	int movieChoice = 0, row, seatNum, movieTimeChoice;
	String name, tel, mySeat;
	String fileName = "MovieReservation.ser";

	void test() {
		for (int i = 0; i < memberTicket.size(); i++) {
			System.out.println(memberTicket.get(i));
		}
	}

	void reservationConfirm() {
		if (NewMember.SIGN[0] != null) {
			for (int i = 0; i < memberTicket.size(); i++) {
				if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("%s님의 예매내역\n", memberTicket.get(i).id);
					break;
				} else {
					System.out.println("예매내역이 없습니다.");
				}
			}
			for (int i = 0; i < memberTicket.size(); i++) {
				if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.println(memberTicket.get(i));
				}
			}
		}
	}

	void reservationAllCancel() {
		int count = 0;
		if (NewMember.SIGN[0] != null) { // if(2) 시작
			for (int i = 0; i < memberTicket.size(); i++) { // for(1)시작
				if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
					count += 1;
					buffer.add(i);
					System.out.println(count + " : " + memberTicket.get(i));
				} else {
					System.out.println("예매내역이 없습니다.");
					return;
				} 
			}
			while(true) {
				try {
				System.out.print("전부 취소하시겠습니까? \n 1.Yes 2.No \n ==> ");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice == 1) {
					for (int i = buffer.size() - 1; i >= 0; i--) {
						memberSeatCancelSearch(i);
						memberTicket.remove((int) (buffer.get(i)));
						buffer.remove(i);
					}
					System.out.printf("총 %s개 취소완료", count);
					count = 0;
				} else {
					System.out.println("------취소안함------");
				}
				}catch (Exception e) {
					System.out.println("정해진 숫자만 입력해주세요");
					continue;
				}break;
			}//while
		}
	}

	void reservationCancel() {
		while(true) {
			try {
				if (NewMember.SIGN[0] != null) { // if(2) 시작
					System.out.print("선택하세요 : 1. 단일취소 2. 전체취소");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice < 1 || choice > 2) {
						System.out.println("잘못 입력하셨습니다.");
						return;
					}
					if (choice == 1) {
						memberCancel();
					} else {
						reservationAllCancel();
					}
				} else { // if(2) 끝 else(2)
					nonMemberCancel();
				}
			}catch (Exception e) {
				System.out.println("정해진 숫자만 입력해주세요");
				continue;
			}
			break;
		}
	}

	boolean signOut() throws ChoiceException {
			System.out.print("로그아웃 하시겠습니까? 1.YES 2.NO \n==>");
				try {
		
					int choice = Integer.parseInt(sc.nextLine());
					if (choice < 1 || choice > 2) {
						throw new ChoiceException();
					}
					if (choice == 1) {
						NewMember.SIGN[0] = null;
						System.out.println("----로그아웃 완료----");
						return true;
					}
				} catch (ChoiceException e) {
					e.showWrongChoice();
				} catch (Exception e) {
					System.out.println("잘못 입력하셨습니다.");
				}return false;
			
		}
	

	void nonMemberReserv() throws ChoiceException {
		try {
			nonMemberInfo();
			seatChoice();
		} catch (ChoiceException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void nonMemberInfo() {
		while(true) {
			try {
				System.out.print("이름을 입력하세요 ==> ");
				name = sc.nextLine();
				System.out.print("핸드폰번호(11자를 입력하세요 ==> ");
				tel = sc.nextLine();
				boolean isNumeric=tel.matches("[+-]?\\d*(\\.\\d+)?");
				if(tel.length()==11){
					System.out.println("입력완료");
					con.add(new Consumer(name, tel));
				}else {
					System.out.println("휴대폰번호가 잘못되었습니다(11자리)");
				}
			}catch (Exception e) {
				System.out.println("숫자만 입력해주세요");
				continue;
			}
			break;
		}
	}

	void nonReservConfirm() {
		System.out.print("핸드폰번호를 입력해주세요 ==> ");
		String phoneNumber = sc.nextLine();
		for (int i = 0; i < nonMemberTicket.size(); i++) {
			if (nonMemberTicket.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("%s님의 예매내역\n", nonMemberTicket.get(i).name);
				break;
			}
		}
		for (int i = 0; i < nonMemberTicket.size(); i++) {
			if (nonMemberTicket.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("제 %s관 %s번\n 상영시간 : %s\n", nonMemberTicket.get(i).movieChoice, nonMemberTicket.get(i).seat,
						nonMemberTicket.get(i).movieTime);
			} else {
				System.out.println("예매된 내역이 없습니다.");
				return;
			}
		}
	}

	void showSeatStatus() throws ChoiceException {
		showSeat();
		
	}

	void nonShowSeatStatus() throws ChoiceException {
		showSeat();
	}

	void movieSeat(int i) {
		if (movie[i - 1] != null) {
			for (int time = 0; time < movie[i - 1][0][0].length; time++) {
				for (int col = 0; col < movie[i - 1].length; col++) {
					for (int row = 0; row < movie[i - 1][col].length; row++) {
						movie[i - 1][col][row][time] = ((char) (col + 65)) + "" + (row + 1) + "";
					}
				}
			}
		}
	}

	void showSeat() throws ChoiceException { // 영화관선택해서 자리 보여주는 메소드
		movieChoice(); 
			if (movie[movieChoice - 1] == null) {
				System.out.println("개설된 영화가 없습니다.");
				return;
			}
			for (int count = 1; count <= movieTime[movieChoice - 1].length; count++) {
				System.out.println(count + " :" + movieTime[movieChoice - 1][count - 1]);
			}
			System.out.print("시간 선택 : ");
			movieTimeChoice = Integer.parseInt(sc.nextLine());
			System.out.println(" ┌──────────────────────────────────────────────────────────┐");
			System.out.println(" │                 S    C   R   E   E   N                   │");
			System.out.println(" └──────────────────────────────────────────────────────────┘");
			System.out.println("영화관 제 " + movieChoice + " 관 시간:" + movieTime[movieChoice - 1][movieTimeChoice - 1]);

			for (int i = 0; i < (movie[movieChoice - 1]).length; i++) {
				System.out.println(" \t┌────┐  ┌────┐  ┌────┐  ┌────┐  ┌────┐  ┌────┐");
				for (int j = 0; j < (movie[movieChoice - 1][i]).length; j++) {
					System.out.print((movie[movieChoice - 1][i][j][movieTimeChoice - 1]) + " ");
				}
				System.out.println();
				System.out.println(" \t└────┘  └────┘  └────┘  └────┘  └────┘  └────┘");
			}

			return;
		
		
	}

	void seatChoice() throws Exception {
		showSeat(); 
			try {
				while (true) {
					System.out.print("A1~F6 : ");
					mySeat = sc.nextLine().toUpperCase().trim();
					row = numSearch(mySeat.charAt(0));
					seatNum = getNum(mySeat.charAt(1));
					if (movie[movieChoice - 1] != null) {
						if ("XX".equals(movie[movieChoice - 1][row][seatNum][movieTimeChoice - 1])) {
							System.out.print("이미 예매 되어있는자리입니다.\n");
							System.out.print("다시 선택해주세요.\n");
							continue;
						}
					}
					break;
				}
				while(true) {
					try {
						System.out.println("좌석이 맞습니까? ==> " + mySeat);
						System.out.println("1.Yes 2.No");
						int choice = Integer.parseInt(sc.nextLine());
						if (choice < 1 || choice > 2) {
							continue;
						}
						if (choice == 1) {
							movie[movieChoice - 1][row][seatNum][movieTimeChoice - 1] = "XX";
							System.out.println("--------예매완료--------");
							System.out.println("영화관 제 " + movieChoice + "관\n" + "좌석 : " + mySeat + "\n상영시간 : "
									+ movieTime[movieChoice - 1][movieTimeChoice - 1]);
							if (NewMember.SIGN[0] != null) {
								memberTicket.add(new MemberTicket(NewMember.SIGN[0], movieChoice, mySeat, getReservNum.getReservNum(),
										movieTime[movieChoice - 1][movieTimeChoice - 1], movieTimeChoice));
							} else {
								nonMemberTicket.add(new NonMemberTicket(name, tel, movieChoice, mySeat, getReservNum.getReservNum(),
										movieTime[movieChoice - 1][movieTimeChoice - 1], movieTimeChoice));
							}
						} else {
							return;
						}
					}catch (Exception e) {
						System.out.println("정해진 숫자만 입력하세요");
						continue;
					}//try
					break;
				}//while
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
			}
		
	} // 예약수정완료

	boolean movieChoice() throws ChoiceException {
		MenuViewer.showMovieMenu();
		if (movie[0] == null && movie[1] == null && movie[2] == null) {
			System.out.println("개설된 영화가 없습니다.");
			return false;
		}
		movieChoice = Integer.parseInt(sc.nextLine());
		try {
			if (movieChoice < 0 || movieChoice > 3) {
				throw new ChoiceException();
			} else if (movieChoice == 0) {
				System.out.println("------예매취소-------");
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

	void allCancel() {
		buffer.clear();
		for (int i = 0; i < memberTicket.size(); i++) { // for(1)시작
			if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
				buffer.add(i);
			}
		}
		for (int j = buffer.size() - 1; j >= 0; j--) {
			memberSeatCancelSearch(j);
			buffer.remove(j);
		}
	}

	void memberCancel() {
		int count = 0;
		int i = 0;
		buffer.clear();
		if (memberTicket.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
			return;
		}
		for (i = 0; i < memberTicket.size(); i++) { // for(1)시작
			if (memberTicket.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
				count += 1;
				buffer.add(i);
				System.out.println(count + " : " + memberTicket.get(i));
			}
		}
		if (count == 0) {
			System.out.println("예매 내역이 없습니다.");
			return;
		} else if (count > 1) {
			while(true) {
				try {
					System.out.print("어떤 걸 취소하시겠습니까? ==> ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("예매 취소하시겠습니까?");
					System.out.print(memberTicket.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						memberSeatCancelSearch(num - 1);
						System.out.println("-----취소완료-----");
						count = 0;
						memberTicket.remove((int) (buffer.get(num - 1)));
					} else {
						System.out.println("------취소안함-------");
						return;
					}
				}catch (Exception e) {
					System.out.println("정해진 숫자만 입력해주세요");
					continue;
				}
				break;
			}
		} else {
			while(true) {
				try {
					System.out.println("예매 취소하시겠습니까?");
					System.out.print("==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						memberSeatCancelSearch(buffer.get(0));
						System.out.println("----취소완료----");
						count = 0;
						memberTicket.remove((int) buffer.get(0));
					} else {
						System.out.println("------취소안함-------");
						return;
					}
				}catch (Exception e) {
					System.out.println("정해진 숫자만 입력해주세요");
					continue;
				}
				break;
			}
		}
	}

	void memberSeatCancelSearch(int i) {
		movie[memberTicket.get(buffer.get(i)).movieChoice - 1][numSearch(memberTicket.get(buffer.get(i)).seat.charAt(0))][getNum(
				memberTicket.get(buffer.get(i)).seat.charAt(1))][memberTicket.get(buffer.get(i)).movieTimeChoice
						- 1] = memberTicket.get(buffer.get(i)).seat;
	}

	void nonMemberSeatCancelSearch(int i) {
		movie[nonMemberTicket.get(buffer.get(i)).movieChoice - 1][numSearch(nonMemberTicket.get(buffer.get(i)).seat.charAt(0))][getNum(
				nonMemberTicket.get(buffer.get(i)).seat.charAt(1))][nonMemberTicket.get(buffer.get(i)).movieTimeChoice
						- 1] = nonMemberTicket.get(buffer.get(i)).seat;
	}

	void movieCheck() {
		for (int i = 0; i < movie.length; i++) {
			if (movie[i] == null) {
				System.out.println((i + 1) + "에 개설된 영화가 없습니다.");
			}
		}
	}

	void nonMemberCancel() {
		int count = 0;
		int j = 0;
		String tel;
		buffer.clear();
		while (true) {
			System.out.print("핸드폰번호를 입력해주세요 ==> ");
			tel = sc.nextLine();
			if (tel.length() != 11) {
				System.out.println("잘못 입력하셧습니다. 다시 입력해주세요");
				continue;
			}
			break;
		}
		if (nonMemberTicket.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
			return;
		}
		for (j = 0; j < nonMemberTicket.size(); j++) {// for(2)시작
			if (nonMemberTicket.get(j).phoneNumber.equals(tel)) { // if(4)시작
				count += 1;
				buffer.add(j);
				System.out.println(count + " : " + nonMemberTicket.get(j));
			}
		}
		if (count == 0) {
			System.out.println("예매 내역이 없습니다.");
			return;
		} else if (count > 1) {
			while(true) {
				try {
					System.out.print("어떤 걸 취소하시겠습니까? ==> ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("예매 취소하시겠습니까?");
					System.out.print(nonMemberTicket.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						nonMemberSeatCancelSearch(num - 1);
						System.out.println("---- 취소완료 ----");
						count = 0;
						nonMemberTicket.remove((int) (buffer.get(num - 1)));
					} else {
						System.out.println("------취소종료------");
						return;
					}
				}catch (Exception e) {
					System.out.println("정해진 숫자만 입력해주세요");
					continue;
				}
				break;
			}
		} else if (count == 1) {
			while(true) {
				try {
					System.out.println("예매 취소하시겠습니까?");
					System.out.printf(nonMemberTicket.get(buffer.get(0)) + "\n 1. Yes 2. No ==> ");
					int choice = Integer.parseInt(sc.nextLine());
					if (choice == 1) {
						nonMemberSeatCancelSearch(0);
						System.out.println("----취소완료----");
						count = 0;
						nonMemberTicket.remove((int) buffer.get(0));
					} else {
						System.out.println("----취소안함----");
						return;
					}
				}catch (Exception e) {
					System.out.println("정해진 숫자만 입력해주세요");
					continue;
				}
				break;
			}
		}
	}

	void objOutputData() {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(fileName);
			out = new ObjectOutputStream(fos);
			out.writeObject(con);
			out.writeObject(memberTicket);
			out.writeObject(nonMemberTicket);
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
	void objInputData() {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			con = (ArrayList<Consumer>) in.readObject();
			memberTicket = (ArrayList<MemberTicket>) in.readObject();
			nonMemberTicket = (ArrayList<NonMemberTicket>) in.readObject();
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

	void fileSearch() {
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\MovieReservation.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			objInputData();
		}
	}
}
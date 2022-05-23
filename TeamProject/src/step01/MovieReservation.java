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
	static String[][][] movie1, movie2, movie3;
	static String[] movieTime1, movieTime2, movieTime3;

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

	ArrayList<Integer> buffer = new ArrayList<Integer>();
	String name, tel, at;
	String fileName = "MovieReservation.ser";
	int moviechoice = 0, att, seatnum, movieTimeChoice;
	ArrayList<User> users = NewMember.userInstance();
	ArrayList<Consumer> con = new ArrayList<Consumer>();
	ArrayList<MemberReservationInfo> mri = new ArrayList<MemberReservationInfo>();
	ArrayList<NonReservInfo> nri = new ArrayList<NonReservInfo>();
	ReservationNumber getReserNum = ReservationNumber.getInstance();

	void test() {
		for (int i = 0; i < mri.size(); i++) {
			System.out.println(mri.get(i));
		}
	}

	void reservationConfirm() {
		if (NewMember.SIGN[0] != null) {
			for (int i = 0; i < mri.size(); i++) {
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {
					System.out.printf("%s님의 예매내역\n", mri.get(i).id);
					break;
				} else {
					System.out.println("예매내역이 없습니다.");
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

		if (NewMember.SIGN[0] != null) { // if(2) 시작
			for (int i = 0; i < mri.size(); i++) { // for(1)시작
				if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
					count += 1;
					buffer.add(i);
					System.out.println(count + " : " + mri.get(i));
				} else {
					System.out.println("예매내역이 없습니다.");
					return;
				}
			}
			System.out.print("전부 취소하시겠습니까? \n 1.Yes 2.No \n ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				for (int i = buffer.size() - 1; i >= 0; i--) {
					memberSeatCancleSearch(i);
					mri.remove((int) (buffer.get(i)));
					buffer.remove(i);
				}
				System.out.printf("총 %s개 취소완료", count);
				count = 0;
			} else {
				System.out.println("------취소안함------");
			}
		}
	}

	void reservationCancle() throws Exception {
		if (NewMember.SIGN[0] != null) { // if(2) 시작
			System.out.print("선택하세요 : 1. 단일취소 2. 전체취소");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2) {
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
			if (choice == 1) {
				MemberCancle();
			} else {
				reservationAllCancle();
			}
		} else { // if(2) 끝 else(2)
			NonMemberCancle();
		}
	}

	void signOut() throws ChoiceException {
		System.out.print("로그아웃 하시겠습니까? 1.YES 2.NO \n==>");
		try {

			int choice = Integer.parseInt(sc.nextLine());
			if (choice < 1 || choice > 2) {
				throw new ChoiceException();
			}
			if (choice == 1) {
				NewMember.SIGN[0] = null;
				System.out.println("----로그아웃 완료----");
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		} catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
		}
	}

	void nonMemberReser() throws ChoiceException {
		try {
		nonmemberInfo();
		seatChoice();
		}catch(ChoiceException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	void nonmemberInfo() {
		System.out.print("이름을 입력하세요 ==> ");
		name = sc.nextLine();
		System.out.print("핸드폰번호를 입력하세요 ==> ");
		tel = sc.nextLine();
		
	}
	void nonreserveConfirm() {
		System.out.print("핸드폰번호를 입력해주세요 ==> ");
		String phoneNumber = sc.nextLine();
		for (int i = 0; i < nri.size(); i++) {
			if (nri.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("%s님의 예매내역\n", nri.get(i).name);
				break;
			}
		}
		for (int i = 0; i < nri.size(); i++) {
			if (nri.get(i).phoneNumber.equals(phoneNumber)) {
				System.out.printf("제 %s관 %s번\n 상영시간 : %s\n", nri.get(i).moviechoice, nri.get(i).seat,nri.get(i).movieTime);
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
		switch (i) {
		case 1:
			if (movie1 != null) {
				for (int time = 0; time < movie1.length; time++) {
					for (int col = 0; col < movie1[time].length; col++) {
						for (int row = 0; row < movie1[time][col].length; row++) {
							movie1[time][col][row] = ((char) (col + 65)) + "" + (row + 1) + "";
						}
					}
				}
			}
			break;
		case 2:
			if (movie2 != null) {
				for (int time = 0; time < movie2.length; time++) {
					for (int col = 0; col < movie2[time].length; col++) {
						for (int row = 0; row < movie2[time][col].length; row++) {
							movie2[time][col][row] = ((char) (col + 65)) + "" + (row + 1) + "";
						}
					}
				}
			}
			break;
		case 3:
			if (movie3 != null) {
				for (int time = 0; time < movie3.length; time++) {
					for (int col = 0; col < movie3[time].length; col++) {
						for (int row = 0; row < movie3[time][col].length; row++) {
							movie3[time][col][row] = ((char) (col + 65)) + "" + (row + 1) + "";
						}
					}
				}
			}
			break;
		}

	}

	boolean showSeat() throws ChoiceException { // 영화관선택해서 자리 보여주는 메소드
		if(movieChoice()) {
		switch (moviechoice) {
		case 1:
			if (movie1 == null) {
				System.out.println("개설된 영화가 없습니다.");
				return false;
				
			}
			break;
		case 2:
			if (movie2 == null) {
				System.out.println("개설된 영화가 없습니다.");
				return false;
			}
			break;
		case 3:
			if (movie3 == null) {
				System.out.println("개설된 영화가 없습니다.");
				return false;
			}
			break;
		}
		movieTime();
		System.out.print("시간 선택 : ");
		movieTimeChoice = Integer.parseInt(sc.nextLine());
		System.out.println("영화관 제 " + moviechoice + " 관 시간:" + movieTimeCheck(moviechoice, movieTimeChoice));
		switch (moviechoice) {
		case 1:
			for (int i = 0; i < (movie1[movieTimeChoice - 1]).length; i++) {
				for (int j = 0; j < (movie1[movieTimeChoice - 1][i]).length; j++) {
					System.out.print((movie1[movieTimeChoice - 1][i][j]) + " ");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = 0; i < (movie2[movieTimeChoice - 1]).length; i++) {
				for (int j = 0; j < (movie2[movieTimeChoice - 1][i]).length; j++) {
					System.out.print((movie2[movieTimeChoice - 1][i][j]) + " ");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < (movie3[moviechoice - 1][movieTimeChoice - 1]).length; i++) {
				for (int j = 0; j < (movie3[movieTimeChoice - 1][i]).length; j++) {
					System.out.print((movie3[movieTimeChoice - 1][i][j]) + " ");
				}
				System.out.println();
			}
			break;
		}
		return true;
		}return false;
	}

	void seatChoice() throws Exception {
		if (showSeat()) {
			try {
				while (true) {
					System.out.print("A1~F6 : ");
					at = sc.nextLine().toUpperCase().trim();
					att = numSearch(at.charAt(0));
					seatnum = getNum(at.charAt(1));
				
					switch (moviechoice) {
					
					case 1:
						if(movie1 != null) {
						if ("XX".equals(movie1[movieTimeChoice - 1][att][seatnum])) {
							System.out.print("이미 예매 되어있는자리입니다.\n");
							System.out.print("다시 선택해주세요.\n");
							continue;
						}
						}
					case 2:
						if(movie2 != null) {
						if ("XX".equals(movie2[movieTimeChoice - 1][att][seatnum])) {
							System.out.print("이미 예매 되어있는자리입니다.\n");
							System.out.print("다시 선택해주세요.\n");
							continue;
						}
						}
					case 3:
						if(movie3 != null) {
						if ("XX".equals(movie3[movieTimeChoice - 1][att][seatnum])) {
							System.out.print("이미 예매 되어있는자리입니다.\n");
							System.out.print("다시 선택해주세요.\n");
							continue;
						}
						}
					default: break;
					}
					break;
				}
				System.out.println("좌석이 맞습니까? ==> " + at);
				System.out.println("1.Yes 2.No");
				int choice = Integer.parseInt(sc.nextLine());
				if (choice < 1 || choice > 2) {
					throw new ChoiceException();
				}
				if (choice == 1) {
					String timetmp = null;
					switch (moviechoice) {
					case 1:
						movie1[movieTimeChoice - 1][att][seatnum] = "XX";
						System.out.println("--------예매완료--------");
						System.out.println("영화관 제 " + moviechoice + "관\n" + "좌석 : " + at + "\n상영시간 : "
								+ movieTime1[movieTimeChoice - 1]);
						timetmp = movieTime1[movieTimeChoice - 1];
						break;
					case 2:
						movie2[movieTimeChoice - 1][att][seatnum] = "XX";
						System.out.println("--------예매완료--------");
						System.out.println("영화관 제 " + moviechoice + "관\n" + "좌석 : " + at + "\n상영시간 : "
								+ movieTime2[movieTimeChoice - 1]);
						timetmp = movieTime2[movieTimeChoice - 1];
						break;
					case 3:
						movie3[movieTimeChoice - 1][att][seatnum] = "XX";
						System.out.println("--------예매완료--------");
						System.out.println("영화관 제 " + moviechoice + "관\n" + "좌석 : " + at + "\n상영시간 : "
								+ movieTime3[movieTimeChoice - 1]);
						timetmp = movieTime3[movieTimeChoice - 1];
						break;
					}
					if (NewMember.SIGN[0] != null) {
						mri.add(new MemberReservationInfo(NewMember.SIGN[0], moviechoice, at, getReserNum.GetReserNum(),
								timetmp, movieTimeChoice));
					} else {
						nri.add(new NonReservInfo(name, tel, moviechoice, at, getReserNum.GetReserNum(), timetmp,
								movieTimeChoice));
					}
				} else {
					return;
				}
			} catch (ChoiceException e) {
				e.showWrongChoice();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				System.out.println(e.getMessage());
			}
		} else {
			return;
		}
	} // 예약수정완료

	String movieTimeCheck(int i, int j) { // seatTest에 시간찾아서 보여주는 메소드
		if (i == 1) {
			return movieTime1[j - 1];
		}
		if (i == 2) {
			return movieTime2[j - 1];
		}
		if (i == 3) {
			return movieTime2[j - 1];
		}
		return null;
	}

	void movieTime() {
		switch (moviechoice) {
		case 1:
			for (int count = 1; count <= movieTime1.length; count++) {
				System.out.println(count + " :" + movieTime1[count - 1]);
			}
			break;
		case 2:
			for (int count = 1; count <= movieTime2.length; count++) {
				System.out.println(count + " :" + movieTime2[count - 1]);
			}
			break;
		case 3:
			for (int count = 1; count <= movieTime3.length; count++) {
				System.out.println(count + " :" + movieTime3[count - 1]);
			}
		}
	}

	boolean movieChoice() throws ChoiceException {
		MenuViewer.showMovieMenu();
		if (movie1 == null && movie2 == null && movie3 == null) {
			System.out.println("개설된 영화가 없습니다.");
			return false;
		}
		moviechoice = Integer.parseInt(sc.nextLine());
		try {
			if (moviechoice < 0 || moviechoice > 3) {
				throw new ChoiceException();
			} else if (moviechoice == 0) {
				System.out.println("------예매취소-------");
				return false;
			}
		} catch (ChoiceException e) {
			e.showWrongChoice();
		}return true;
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
		for (int i = 0; i < mri.size(); i++) { // for(1)시작
			if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
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
		if (mri.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
			return;
		}
		for (i = 0; i < mri.size(); i++) { // for(1)시작
			if (mri.get(i).id.equals(NewMember.SIGN[0])) {// if(3)시작
				count += 1;
				buffer.add(i);
				System.out.println(count + " : " + mri.get(i));
			}
		}
		if (count == 0) {
			System.out.println("예매 내역이 없습니다.");
			return;
		} else if (count > 1) {
			System.out.print("어떤 걸 취소하시겠습니까? ==> ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("예매 취소하시겠습니까?");
			System.out.print(mri.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				memberSeatCancleSearch(num-1);
				System.out.println("-----취소완료-----");
				count = 0;
				mri.remove((int) (buffer.get(num - 1)));
				buffer.clear();
			} else {
				System.out.println("------취소안함-------");
				buffer.clear();
				return;
			}

		} else {
			System.out.println("예매 취소하시겠습니까?");
			System.out.print("==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				memberSeatCancleSearch(buffer.get(0));
				System.out.println("----취소완료----");
				count = 0;
				mri.remove((int)buffer.get(0));
				buffer.clear();
			} else {
				System.out.println("------취소안함-------");
				buffer.clear();
				return;
			}
		}
	}

	void memberSeatCancleSearch(int i) {
		switch (mri.get(buffer.get(i)).moviechoice) {
		case 1:
			movie1
					[mri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(mri.get(buffer.get(i)).seat.charAt(0))]
									[getNum(mri.get(buffer.get(i)).seat.charAt(1))] = mri.get(buffer.get(i)).seat;
			break;
		case 2:
			movie2
					[mri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(mri.get(buffer.get(i)).seat.charAt(0))]
									[getNum(mri.get(buffer.get(i)).seat.charAt(1))] = mri.get(buffer.get(i)).seat;
			break;
		case 3:
			movie3
					[mri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(mri.get(buffer.get(i)).seat.charAt(0))]
							[getNum(mri.get(buffer.get(i)).seat.charAt(1))] = mri.get(buffer.get(i)).seat;
			break;
		}
	}
	void nonMemberSeatCancleSearch(int i) {
		switch (nri.get(buffer.get(i)).moviechoice) {
		case 1:
			movie1
					[nri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(nri.get(buffer.get(i)).seat.charAt(0))]
									[getNum(nri.get(buffer.get(i)).seat.charAt(1))] = nri.get(buffer.get(i)).seat;
			break;
		case 2:
			movie2
					[nri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(nri.get(buffer.get(i)).seat.charAt(0))]
									[getNum(nri.get(buffer.get(i)).seat.charAt(1))] = nri.get(buffer.get(i)).seat;
			break;
		case 3:
			movie3
					[nri.get(buffer.get(i)).movieTimeChoice-1]
							[numSearch(nri.get(buffer.get(i)).seat.charAt(0))]
							[getNum(nri.get(buffer.get(i)).seat.charAt(1))] = nri.get(buffer.get(i)).seat;
			break;
		}
	}

	void MovieCheck() {
		if (movie1 == null) {
			System.out.println("movie1 영화가 없습니다.");
		}
		if (movie2 == null) {
			System.out.println("movie2 영화가 없습니다.");
		}
		if (movie3 == null) {
			System.out.println("movie3 영화가 없습니다.");
		}

	}
	
	void NonMemberCancle() {
		int count = 0;
		int j = 0;
		String tel;
		while (true) {
			System.out.print("핸드폰번호를 입력해주세요 ==> ");
			tel = sc.nextLine();
			if (tel.length() != 11) {
				System.out.println("잘못 입력하셧습니다. 다시 입력해주세요");
				continue;
			}
			break;
		}
		if (nri.isEmpty()) {
			System.out.println("예매 내역이 없습니다.");
			return;
		}
		for (j = 0; j < nri.size(); j++) {// for(2)시작
			if (nri.get(j).phoneNumber.equals(tel)) { // if(4)시작
				count += 1;
				buffer.add(j);
				System.out.println(count + " : " + nri.get(j));
			}
		}
		if (count == 0) {
			System.out.println("예매 내역이 없습니다.");
			return;
		} else if (count > 1) {
			System.out.print("어떤 걸 취소하시겠습니까? ==> ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("예매 취소하시겠습니까?");
			System.out.print(nri.get(buffer.get(num - 1)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				nonMemberSeatCancleSearch(num-1);
				System.out.println("---- 취소완료 ----");
				count = 0;
				nri.remove((int) (buffer.get(num - 1)));
				buffer.clear();
			} else {
				System.out.println("------취소종료------");
				buffer.clear();
				return;
			}

		} else if(count == 1){
			System.out.println("예매 취소하시겠습니까?");
			System.out.printf(nri.get(buffer.get(0)) + "\n 1. Yes 2. No ==> ");
			int choice = Integer.parseInt(sc.nextLine());
			if (choice == 1) {
				nonMemberSeatCancleSearch(0);
				System.out.println("----취소완료----");
				count = 0;
				nri.remove((int) buffer.get(0));
				buffer.clear();
			} else {
				System.out.println("----취소안함----");
				buffer.clear();
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
			out.writeObject(movie1);
			out.writeObject(movie2);
			out.writeObject(movie3);
			out.writeObject(movieTime1);
			out.writeObject(movieTime2);
			out.writeObject(movieTime3);
			
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
			movie1 = (String[][][])in.readObject();
			movie2 = (String[][][])in.readObject();
			movie3 = (String[][][])in.readObject();
			movieTime1 = (String[])in.readObject();
			movieTime2 = (String[])in.readObject();
			movieTime3 = (String[])in.readObject();
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
		File f = new File("C:\\Users\\WU\\eclipse-workspace\\TeamProject\\MovieReservation.ser");
		if (!f.exists()) {
		} else if (f.exists()) {
			ObjInputData();
		}
	}
}

package step01;

public class Test {
	public static void main(String[] args) {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getinfo();

		while (true) {
			try {
				if (NewMember.SIGN[0] == null) { //비회원
					MenuViewer.showUserManagement();
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					switch (choice) {
					case 1:
						if (users.login() == null) {
							System.out.println("로그인하세요.");
							continue;
						} else {
							break;
						}
					case 2:
						users.input();
						continue;
					case 3:
						if (users.searchList()) {
							System.out.println("회원 목록이 존재하지 않습니다.");
							continue;
						} else {
							users.showAllUser();
							continue;
						}
					case 4:
						mm.nonMemberReser();
						continue;
					case 5:
						mm.nonreserveConfirm();
						continue;
					case 6:
						mm.reservationCancle();
						continue;
					case 7:
						mm.nonShowSeatStatus();
						continue;
					case 0:
						mm.ObjOutputData();
						users.ObjOutputData();
						return;
					}
				}//비회원끝
				//로그인 후 시작구간
				MenuViewer.showMenu();
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				switch (choice) {
				case 1:
					mm.movieChoice();
					mm.seatChoice();
					break;
				case 2:
					mm.reservationConfirm();
					break;
				case 3:
					mm.reservationCancle();
					break;
				case 4:
					mm.showSeatStatus();
					break;
				case 5:
					mm.signOut();
					break;
				case 6:
					users.MemberDelete();
					break;
				case 0:
					mm.ObjOutputData();
					users.ObjOutputData();
					return;
				}
			} catch (ChoiceException e) {

			}
		}
	}
}

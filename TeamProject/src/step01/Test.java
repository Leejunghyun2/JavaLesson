package step01;

public class Test {
	public static void main(String[] args) {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getinfo();
		ReservationNumber rn = ReservationNumber.getInstance();
		Admin admin = Admin.getInstance();
		MenuViewer menu = MenuViewer.getInstance();
		while (true) {
			try {
				if(NewMember.SIGN[0] != null) {
					if (NewMember.SIGN[0].equals("관리자"))
					{	
						admin.adminChoice();
						continue;
					}
					
				}
//-----------------------------------------비회원메뉴-----------------------------------------------
				if (NewMember.SIGN[0] == null) { // 비회원
					MenuViewer.showUserManagement();
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					switch (choice) {
					case 1:
						users.login(); {
							System.out.println("로그인하세요.");
							continue;
						} // 회원 로그인

					case 2:
						users.input();
						continue;
					case 3:
						mm.nonMemberReser();
						continue;
					case 4:
						mm.nonreserveConfirm();
						continue;
					case 5:
						mm.reservationCancle();
						continue;
					case 6:
						mm.nonShowSeatStatus();
						continue;
					case 0:
						mm.ObjOutputData();
						users.ObjOutputData();
						rn.ObjOutputData();
						menu.ObjOutputData();
						return;
					}
				} // 비회원끝
//--------------------------------------비회원메뉴 끝 -----------------------------------------------
//--------------------------------------회원메뉴 시작 -----------------------------------------------
				MenuViewer.showMenu();
				int choice = Integer.parseInt(MovieReservation.sc.nextLine());
				switch (choice) {
				case 1:
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
				case 7:
					mm.test();
					break;
				case 0:
					mm.ObjOutputData();
					users.ObjOutputData();
					rn.ObjOutputData();
					menu.ObjOutputData();
					return;
//---------------------------------------------회원메뉴 끝-----------------------------------------
				}
			} catch (ChoiceException e) {
				System.out.println("잘못 입력하셨습니다.");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}

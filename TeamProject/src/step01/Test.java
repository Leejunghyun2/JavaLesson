package step01;

public class Test implements ChoiceName {
	public static void main(String[] args)  {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getInfo();
		ReservationNumber rn = ReservationNumber.getInstance();
		Admin admin = Admin.getInstance();
		MenuViewer menu = MenuViewer.getInstance();
		while (true) {
			try {
				if(NewMember.SIGN[0] != null) {
					if (NewMember.SIGN[0].equals("������"))
					{	
						admin.adminChoice();
						continue;
					}
					
				}
//-----------------------------------------��ȸ���޴�-----------------------------------------------
				if (NewMember.SIGN[0] == null) { // ��ȸ��
					MenuViewer.showUserManagement();
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					switch (choice) {
					case MEMBER_LOGIN:
						users.login(); {
							System.out.println("�α����ϼ���.");
							continue;
						} // ȸ�� �α���

					case JOIN_MEMBER:
						users.input();
						continue;
					case NON_MEMBER_RESERVATION:
						mm.nonMemberReser();
						continue;
					case N_MEMBER_RESERVATION_CHECK:
						mm.nonReserveConfirm();
						continue;
					case NON_MEMBER_CANCEL:
						mm.reservationCancel();
						continue;
					case SEARCH_MY_SEAT:
						mm.nonShowSeatStatus();
						continue;
					case QUIT:
						mm.objOutputData();
						users.objOutputData();
						rn.objOutputData();
						menu.objOutputData();
						return;
					}
				} // ��ȸ����
//--------------------------------------��ȸ���޴� �� -----------------------------------------------
//--------------------------------------ȸ���޴� ���� -----------------------------------------------
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
					mm.reservationCancel();
					break;
				case 4:
					mm.showSeatStatus();
					break;
				case 5:
					mm.signOut();
					break;
				case 6:
					users.memberDelete();
					break;
				case 7:
					mm.test();
					break;
				case QUIT:
					mm.objOutputData();
					users.objOutputData();
					rn.objOutputData();
					menu.objOutputData();
					return;
//---------------------------------------------ȸ���޴� ��-----------------------------------------
				}
			} catch (ChoiceException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}
	}
}

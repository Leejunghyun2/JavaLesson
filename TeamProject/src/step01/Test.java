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
					if (NewMember.SIGN[0].equals("������"))
					{	
						mm.MovieCheck();
						MenuViewer.showAdminChoice();
						int choice = Integer.parseInt(MovieReservation.sc.nextLine());
						switch(choice) {
						case 1:{
							System.out.println("----����x----");
							continue;
						}
						case 2:{
							admin.MovieManagement();
							continue;
						}
						case 3:{
							mm.showSeat();
							continue;
						}
						case 4:
							if (users.searchList()) {
								System.out.println("ȸ�� ����� �������� �ʽ��ϴ�.");
								continue;
							} else {
								users.showAllUser();
								continue;
							}
						case 5:{
							mm.signOut();
							continue;
						}
						case 0:{
							mm.ObjOutputData();
							users.ObjOutputData();
							rn.ObjOutputData();
							menu.ObjOutputData();
							return;
						}
						}
					}
				}
//-----------------------------------------��ȸ���޴�-----------------------------------------------
				if (NewMember.SIGN[0] == null) { // ��ȸ��
					MenuViewer.showUserManagement();
					int choice = Integer.parseInt(MovieReservation.sc.nextLine());
					switch (choice) {
					case 1:
						if (users.login() == null) {
							System.out.println("�α����ϼ���.");
							continue;
						} else if (NewMember.SIGN[0].equals("������"))// �����ڸ��
						{
							continue; // �ڵ� ������������ ���κ��������� �۾�
						} else {
							break;
						} // ȸ�� �α���

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
//---------------------------------------------ȸ���޴� ��-----------------------------------------
				}
			} catch (ChoiceException e) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
}

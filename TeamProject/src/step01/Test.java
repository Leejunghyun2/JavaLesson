package step01;

public class Test {
	public static void main(String[] args) {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getinfo();

		while (true) {
			if(users.sign[0] == null) {
			MenuViewer.showUserManagement();
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			switch (choice) {
			case 1:
				if (!users.signIn()) {
					System.out.println("�α����ϼ���.");
					continue;
				} else {
					break;
				}
			case 2:
				users.input();
				continue;
			case 3:
				if (users.searchList()) {
					System.out.println("ȸ�� ����� �������� �ʽ��ϴ�.");
					continue;
				} else {
					users.showAllUser();
					continue;
				}
				case 0:
					return;
			}
			}
			try {
			MenuViewer.showMenu();	
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			switch (choice) {
			case 1:
				mm.movieChoice();
				mm.seatChoice();
				break;
			case 2:
				System.out.println("����Ȯ�� ���� ���� x");
				break;
			case 3:
				System.out.println("������� ���� ���� x");
				break;
			case 4:
				mm.showSeatStatus();
				break;
			case 0:
				return;
			}
			}catch(ChoiceException e) {
				
			}
		}
	}
}
	
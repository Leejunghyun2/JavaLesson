package step01;

public class Test {
	public static void main(String[] args) {
		MovieReservation mm = MovieReservation.getinstance();
		NewMember users = NewMember.getinfo();

		while (true) {
			MenuViewer.showUserManagement();
			int choice = Integer.parseInt(MovieReservation.sc.nextLine());
			try {

				switch (choice) {
				case 1:
					if(!users.signIn()) {
						System.out.println("�α����ϼ���.");
						continue;
					}else {
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
					continue;
				}

				switch (choice) {
				case 1:
				case 2:
					MenuViewer.showMenu();
					choice = Integer.parseInt(MovieReservation.sc.nextLine());
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
						break;
					}
					break;
				case 0:
					break;
				}
			}

			catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
}

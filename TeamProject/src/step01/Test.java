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
				System.out.println("예매확인 아직 구현 x");
				break;
			case 3:
				System.out.println("예매취소 아직 구현 x");
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
	
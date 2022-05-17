package step08;


public class PhoneBookVer08 {
	public static void main(String[] args) {
		PhoneBookManager pm = PhoneBookManager.getInstance();
		int choice = 0;
		
		
		while (true) {
			try {

				MenuViewer.showMenu();
				choice = Integer.parseInt(MenuViewer.sc.nextLine());
				if (choice < 1 || choice > 7) {
					throw new MenuChoiceException(choice);
				}
				switch (choice) {
				case MainMenu.INPUT:
					pm.inputData();
					break;
				case MainMenu.SEARCH:
					pm.searchData();
					break;
				case MainMenu.UPDATE:
					pm.updateData();
					break;
				case MainMenu.DELETE:
					pm.deleteData();
					break;
				case MainMenu.ALLDELETE:
					pm.allDelete();
					break;
				case MainMenu.DISPLAY:
					pm.allDisplay();
					break;
				case MainMenu.EXIT:
					System.out.println("���α׷� ����");
					pm.ObjOutputData();
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڸ� �Է��ϼ���");
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
				System.out.println("ó�����ʹٽ��Է��ϼ���");
			}
		}
	}
}

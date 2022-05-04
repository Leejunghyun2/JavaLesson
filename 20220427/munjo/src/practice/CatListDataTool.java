package practice; //step2������(����Ŭ���� �ȿ� ���� �� ����)static �� ������µ� ���� �� �� ������?

public class CatListDataTool {
	// �׳� ����ٰ��� ��ĳ�� ������ �ȵǳ�? �����ȴ�. ���� ����ΰ� �޴����� ���Ⲭ ����� �� �� �ִ�
	// �޴�Ŭ������ ������ ���� ��� ����� �޴�Ŭ������ ���ٽᵵ �Ȱ��� �ǰ�? ���� �׷���
	// �ٵ� ���� Ŭ�������� ������ ��ĳ�ʿ� ����ƽ�ʼ�.
	int here = 0;
	Cat[] storage = new Cat[1000];

	void inputData() {
		// �ڹ� �迭�� �� ������ ũ�⸦ ������ �����ؾ���!!!
		// �������� �迭 ����. �迭�� ����� ��ġ here.

		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = Menu.sc.nextLine();
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = Integer.parseInt(Menu.sc.nextLine());
		System.out.print("������ �Է��ϼ��� : ");
		String gender = Menu.sc.nextLine();
		System.out.print("��(����)�� �Է��ϼ��� : ");
		String color = Menu.sc.nextLine();
//ctrl shift f ��ü ����
//art ȭ��ǥ ����� ȭ������ ���� ���� 		
		storage[here] = new Cat(name, age, gender, color);
		here++; // ���� �迭 �ڸ��� �ű��. �׷��� �ٸ� ������ �� �Է��� �� ����,,
	}

	void updateData() {
		System.out.println("������ �̸���? ");
		String name = Menu.sc.nextLine();

		int index = -1;
		index = search(name);

		if (index > -1) {
			System.out.println("���� ���Է� : ");
			storage[index].age = Integer.parseInt(Menu.sc.nextLine());
			System.out.println("���� ���Է� : ");
			storage[index].gender = Menu.sc.nextLine();
			System.out.println("����(����) ���Է� : ");
			storage[index].color = Menu.sc.nextLine();

			System.out.println("���� �Ϸ�");
		} else
			System.out.println("�ش� ������ ����");
	}

	void searchData() {
		System.out.println("ã�� �̸���? ");
		String name = Menu.sc.nextLine();

		int index = search(name);

		if (index > -1) {
			storage[index].showInfo();
		} else { // �˻� ���н� �޼���
			System.out.println("�ش��ϴ� ������ �������� ����");
		}
	}

	int search(String name) {

		for (int i = 0; i < here; i++) {
			if (name.equals(storage[i].name)) {
				return i;
			}
		}
		return -1;
	}

	void deleteData() {

		System.out.println("������ �̸���? ");
		String name = Menu.sc.nextLine();
		int index = search(name);
		
		if(index>-1) {
			for(int i=index; i<here; i++) {
				storage[i]=storage[i+1];
			}here--;
		}
		else System.out.println("�ش� ������ ����");
	}

	void displayAll() {
		for(int i=0; i<here; i++) {
			storage[i].showInfo();
		}

	}

}

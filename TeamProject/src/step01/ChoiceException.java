package step01;

public class ChoiceException extends Exception {
	int wrongChoice;
	
	public ChoiceException(int choice)
	{
		super("�߸� ������ �̷������ϴ�.");
		wrongChoice=choice;
	}
	public void showWrongChoice() {
		System.out.println(wrongChoice+"�� �ش��ϴ� ������ ���������ʽ��ϴ�.");
	}
}

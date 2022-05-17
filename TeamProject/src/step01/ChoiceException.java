package step01;

public class ChoiceException extends Exception {
	int wrongChoice;
	
	public ChoiceException(int choice)
	{
		super("잘못 선택이 이뤄졌습니다.");
		wrongChoice=choice;
	}
	public void showWrongChoice() {
		System.out.println(wrongChoice+"에 해당하는 선택은 존재하지않습니다.");
	}
}

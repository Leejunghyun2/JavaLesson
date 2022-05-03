package chap06;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerEx7 {

	public static void main(String[] args) {
		Button b = new Button("start");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent occurred!!");  //앱에서 많이사용 웹에선 자주 안씀(이런것도 있구나 정도만 알아 둘것)
			}
		});
	}

}


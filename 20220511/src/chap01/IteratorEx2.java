package chap01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorEx2 {
	public static void main(String[] args) {
		ArrayList original = new ArrayList();
		ArrayList copy1 = new ArrayList();
		ArrayList copy2 = new ArrayList();

		for (int i = 0; i < 10; i++) {
			original.add(i + "");
		}

		Iterator it = original.iterator();

		while (it.hasNext()) {
			copy1.add(it.next());
		}

		System.out.println("=original에서 copy1로 복사=");
		System.out.println("original : " + original);
		System.out.println("copy1 : " + copy1);

		it = original.iterator();
		while (it.hasNext()) {
			//copy2.add(it.next());
			it.next();
			it.remove(); // original 배열 삭제 삭제할땐 읽어온후 삭제해야 제대로됨 
		}
		System.out.println("=original에서 copy2로 복사=");
		System.out.println("original = " + original);
		System.out.println("copy2 = " + copy2);

	}
}

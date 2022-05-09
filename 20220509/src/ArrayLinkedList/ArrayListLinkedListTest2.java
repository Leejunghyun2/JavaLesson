package ArrayLinkedList;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListLinkedListTest2 {

	public static void main(String[] args) {
		ArrayList a1 = new ArrayList(1000000);
		LinkedList l1 = new LinkedList();
		add(a1);
		add(l1);
		
		System.out.println("=���ٽð� �׽�Ʈ=");
		System.out.println("ArrayList :"+access(a1));
		System.out.println("LinkedList :"+access(l1));
	}
	
	public static void add(List list) {
		for(int i=0; i<100000;i++) list.add(i+""); //�ڸ��� ���ִ��ڵ�
	}
	public static long access(List list) {
		long start = System.currentTimeMillis();
		for(int i=0; i<10000;i++) list.get(i);	//�����͸� �о���� �ӵ�
		long end = System.currentTimeMillis();
		return end - start;
	}
}

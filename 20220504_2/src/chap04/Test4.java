package chap04;

public class Test4 {
	public static void main(String[] args) {
		String s = "abc";
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(s.length());
		System.out.println(sb.length());
		System.out.println(sb2.capacity());
		
		System.out.println(sb.equals(sb2));
		String s1 = sb.toString();
		String s2 = sb2.toString();
		System.out.println(s1.equals(s2));
		StringBuffer sss = new StringBuffer("0123456");
		StringBuffer sss2 = sss.delete(3, 6);
		System.out.println(sss2);
		System.out.println(sss);
		System.out.println(sss.reverse());
		StringBuffer ss = new StringBuffer("123456789");
		System.out.println(ss.insert(4, "."));
		
		
	}
}

package chap02;

public class EqualsEx1 {

	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = (Value)v1.clone();

		if (v1.equals(v2)) {
			System.out.println(v1.value);
		} else {
			System.out.println(""+v1+"\n"+v2);
		}

		//v2 = v1;
		if(v1==v2) {
			System.out.println(v2);
		} else {
			System.out.println(v2.value);
		}
	}
}

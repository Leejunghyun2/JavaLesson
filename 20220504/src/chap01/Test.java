package chap01;

public class Test {
	public static void main(String[] args) {
		Person s1 = new Person(9994446666444l);
		Person s2 = new Person(9994446666444l);
	
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}

}

class Person{
	long id;
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person)
		return id ==((Person) obj).id;
		else return false;
	}




	Person(long id){
		this.id = id;
	}
	
}

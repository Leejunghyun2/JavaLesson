package chap02;

import java.util.Objects;

public class Person2 {
	String name;
	int age;
	
	Person2(String name,int age){
		this.name = name;
		this.age = age;
	}
	public boolean equals(Object obj) {
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age==tmp.age;
		}
		return false;
	}
//	public int hashCode() {
//		return (name+age).hashCode();
//	}
	public int hashCode() {
		return Objects.hash(name,age);  //HashSet은 해쉬코드도 비교하기때문에 해쉬코드도 오버라이딩해줘야함
	}
	
	
	public String toString() {
		return name + ":" + age;
	}
}

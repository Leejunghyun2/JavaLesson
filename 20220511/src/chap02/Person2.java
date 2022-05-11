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
		return Objects.hash(name,age);  //HashSet�� �ؽ��ڵ嵵 ���ϱ⶧���� �ؽ��ڵ嵵 �������̵��������
	}
	
	
	public String toString() {
		return name + ":" + age;
	}
}

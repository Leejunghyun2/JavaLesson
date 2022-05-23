package Thread;

public class Increment {
	int num = 0;
	public  void incre() {synchronized(this) { num++;}}
	public int getNum() {return num;}
}

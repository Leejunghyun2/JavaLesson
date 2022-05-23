package chap08;

public class Test {

	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();
		
		NewsReader r1 = new NewsReader(paper);
		NewsReader r2 = new NewsReader(paper);
		NewsReader r3 = new NewsReader(paper);
		
		NewsWriter w = new NewsWriter(paper);
		
		r1.start();
		r2.start();
		r3.start();
		w.start();
	}

}

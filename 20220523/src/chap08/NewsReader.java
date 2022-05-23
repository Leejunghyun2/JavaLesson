package chap08;

public class NewsReader extends Thread{
	NewsPaper paper;
	
	NewsReader(NewsPaper paper){
		this.paper = paper;
	}

	@Override
	public void run() {
		System.out.println("ø¿¥√¿« ¥∫Ω∫:" + paper.getTodayNews());
	}
	
	
}

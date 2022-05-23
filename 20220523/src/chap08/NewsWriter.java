package chap08;

public class NewsWriter extends Thread{
	NewsPaper paper;
	
	NewsWriter(NewsPaper paper){
		this.paper = paper;
	}

	@Override
	public void run() {
			paper.setTodayNews("¤·¤·");
	}
	
	
}

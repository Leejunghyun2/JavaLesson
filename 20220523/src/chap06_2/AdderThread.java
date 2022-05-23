package chap06_2;

public class AdderThread extends Thread {
	Sum suminst;
	int start, end;
	
	public AdderThread(Sum sum,int s,int e) {
		suminst = sum;
		start = s;
		end = e;
	}

	@Override
	public void run() {
		for(int i= start;i<=end;i++) {
			suminst.addNum(i);
		}
	}
	
}

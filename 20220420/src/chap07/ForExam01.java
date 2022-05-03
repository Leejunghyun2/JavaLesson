package chap07;

public class ForExam01 {

	public static void main(String[] args) {
		int j = 0 ;
		/*
		String a = "hello world",c="";
		
		
		for(int i=0;i<=10;i++) {
			char b = a.charAt(i);	
			c += b;
			System.out.println(c);
		}
		*/
		for(int i=1;i<=9;i++)
		{
		  for(j=1;j<=9;j++)
		  {
			  System.out.printf("%d * %d = %d \t",j,i,i*j);
		  }
		  System.out.println();
		}
	}

}

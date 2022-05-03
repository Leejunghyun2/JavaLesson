package chap07;

public class GuGuDan {

	public static void main(String[] args) {
		
		int j = 0;
		for(int i=2;i<=9;i++)
		{
		  for(j=1;j<=9;j++)
		  {
			  System.out.printf("%d * %d = %d \t",i,j,i*j);
		  }
		  System.out.println();
		}
		
		
		System.out.println("--------------------------------------------------------------");
		
		int a=2,b=1;
		while(a<10)
		{
			while(b<10)
			{
				System.out.printf("%d * %d = %d \t",a,b,a*b);
				b++;
			}
			b= 1;
			a++;
			System.out.println();
		}
		
		
		System.out.println("--------------------------------------------------------------");
		
		int c=1,d=1;
		do{
		  c++;
		  System.out.println();
		  d=1;
		
			do {
		
			System.out.printf("%d * %d = %d \t",c,d,c*d);
			d++;
			}while(d<10);
		}while(c<9);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		
		
	
		
	}
}

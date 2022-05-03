package NewPersonExam01;

public class Cal {

	int var1 , var2;
	char x;
	double result;
	
	Cal(int var1,char x,int var2){
		
		if(x == '+') {
			System.out.printf("%d + %d = %d",var1,var2,var1+var2);
		} else if(x == '*') {
			System.out.printf("%d * %d = %d",var1,var2,var1*var2);
		} else if(x == '/') {
			System.out.printf("%d / %d = %d",var1,var2,var1/var2);
		} else if(x == '-') {
			System.out.printf("%d - %d = %d",var1,var2,var1-var2);
		}
		
	}
	Cal(double var1,char x,int var2){
		
		if(x == '+') {
			System.out.printf("%.2f + %d = %.2f",var1,var2,var1+var2);
		} else if(x == '*') {
			System.out.printf("%.2f * %d = %.2f",var1,var2,var1*var2);
		} else if(x == '/') {
			System.out.printf("%.2f / %d = %.2f",var1,var2,var1/var2);
		} else if(x == '-') {
			System.out.printf("%.2f - %d = %.2f",var1,var2,var1-var2);
		}
		
	}
	Cal(int var1,char x,double var2){
		if(x == '+') {
			System.out.printf("%d + %.2f = %.2f",var1,var2,var1+var2);
		} else if(x == '*') {
			System.out.printf("%d * %.2f = %.2f",var1,var2,var1*var2);
		} else if(x == '/') {
			System.out.printf("%d / %.2f = %.2f",var1,var2,var1/var2);
		} else if(x == '-') {
			System.out.printf("%d - %.2f = %.2f",var1,var2,var1-var2);
		}
		
	}
	Cal(double var1,char x,double var2){
		if(x == '+') {
			System.out.printf("%.2f + %.2f = %.2f",var1,var2,var1+var2);
		} else if(x == '*') {
			System.out.printf("%.2f * %.2f = %.2f",var1,var2,var1*var2);
		} else if(x == '/') {
			System.out.printf("%.2f / %.2f = %.2f",var1,var2,var1/var2);
		} else if(x == '-') {
			System.out.printf("%.2f - %.2f = %.2f",var1,var2,var1-var2);
		}
	}
	Cal(){
		
	}
	
}

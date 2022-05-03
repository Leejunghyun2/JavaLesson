package Book;

import java.util.Scanner;

public class Book {
	Scanner sc = new Scanner(System.in);

	private String book;
	private String write;
	private int date,year,month,day;
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	
	public void showBook() {
		System.out.printf("Date : %d - %d - %d \n",year,month,day);
		System.out.printf("저자 : %s \n", write);
		System.out.printf("책 이름 : %s \n", book);
		
		
	}
	
	
	
	
	
	
}

package step01;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
  public static Scanner sc = new Scanner(System.in);
  
  private static MovieReservation s;
  
  private final String[][][] SEAT = new String[3][6][6];
  

  private MovieReservation() {
    SEAT();
  }
  public static MovieReservation getinstance() {
	    if (s == null) {
	      s = new MovieReservation();
	      return s;
	    } 
	    return s;
	  }
  int moviechoice =0;
  ArrayList<User> users = new ArrayList();
  
  void movieChoice() throws ChoiceException {
    MenuViewer.showMovieMenu();
    moviechoice = Integer.parseInt(sc.nextLine());
    try {
      if (moviechoice < 1 || this.moviechoice > 3)
        throw new ChoiceException(); 
    } catch (ChoiceException e) {
      e.showWrongChoice();
    } 
  }
  
  
  
  
  void seatChoice() throws ChoiceException {
    showSeat();
    System.out.print("A1~F6 : ");
    String at = sc.nextLine().toUpperCase().trim();
    int att = numSearch(at.charAt(0));
    int seatnum = getNum(at.charAt(1));
    try {
      if (att < 0 || att > 6 || seatnum < 0 || seatnum > 6)
        throw new ChoiceException(); 
      System.out.println("좌석이 맞습니까? ==> " + at);
      System.out.println("1.Yes 2.No");
      int choice = Integer.parseInt(sc.nextLine());
      if (choice < 1 || choice > 2)
        throw new ChoiceException(); 
      if (choice == 1) {
        SEAT[moviechoice - 1][att][seatnum] = "XX";
        System.out.println("--------예매완료--------");
        System.out.println("영화관 제 "+moviechoice+"관\n"+"좌석 : "+ at);
      } else {
        return;
      } 
    } catch (ChoiceException e) {
      e.showWrongChoice();
    } 
  }
  
  void showSeat() {
    System.out.println("영화관 제 " + moviechoice + " 관");
    for (int i = 0; i < (SEAT[moviechoice - 1]).length; i++) {
      for (int j = 0; j < (SEAT[moviechoice - 1][i]).length; j++) {
        System.out.print((SEAT[moviechoice - 1][i][j]) + " "); 
      }System.out.println();
    } 
  }
  
  void showSeatStatus() throws ChoiceException {
    movieChoice();
    showSeat();
  }
  
  private void SEAT() {
    for (int k = 0; k < SEAT.length; k++) {
      for (int i = 0; i < (SEAT[k]).length; i++) {
        for (int j = 0; j < (SEAT[k][i]).length; j++)
          SEAT[k][i][j] = ((char)(i + 65))+"" + (j + 1)+""; 
      } 
    } 
  }
  
  int numSearch(char at) {
    if (at >= 'A' && at <= 'F')
      return at - 65; 
    if (at >= 'a' && at <= 'f')
      return at - 97; 
    return -1;
  }
  
  int getNum(char tmp) {
    if (tmp > '0' && tmp < '7')
      return tmp - 49; 
    return -1;
  }
}

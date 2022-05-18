package step01;

public class MenuViewer {
  static void showMenu() {
    System.out.println("1. 영화예매");
    System.out.println("2. 예매확인" );
    System.out.println("3. 예매취소");
    System.out.println("4. 좌석조회");
    System.out.println("5. 로그아웃");
    System.out.println("0. 취소" );
    System.out.print("==> ");
  }
  
  static void showMovieMenu() {
    System.out.println("1. 영화1" );
    System.out.println("2. 영화2" );
    System.out.println("3. 영화3" );
    System.out.println("0. 취소");
    System.out.print("==> ");
  }
  
  static void showUserManagement() {
	  System.out.println("1. 로그인");
	  System.out.println("2. 회원가입");
	  System.out.println("3. 회원목록(테스트용)");
	  System.out.println("4. 비회원예매");
	  System.out.println("5. 예매확인");
	  System.out.println("6. 좌석조회");
	  System.out.println("0. 취소");
	  System.out.print("==> ");
  }
  static void showChoice() {
	  System.out.println("1. 회원관리");
	  System.out.println("2. 영화예매");
	  System.out.println("0. 취소");
	  System.out.print("==> ");
  }
}
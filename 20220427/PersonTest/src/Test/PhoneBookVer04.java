package Test;

public class PhoneBookVer04 {
	public static void main(String[] args) {
		PhoneBookManager pm = PhoneBookManager.getInstance();
		int choice = 0;

		pm.infoStorage[0] = new Person("ggg","Ggg","Ggg");
		pm.infoStorage[1] = new UnivFriends("ggg","Ggg","ggg","ggg",3);
		pm.infoStorage[2] = new CompanyFriends("ggg","Ggg","ggg","ggg");
		System.out.println(pm.infoStorage[2] instanceof UnivFriends);
		
	}
}

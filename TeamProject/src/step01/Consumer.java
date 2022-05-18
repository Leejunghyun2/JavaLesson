package step01;

public class Consumer {
  String name;
  
  String phoneNumber;
  
  Consumer(String name, String phoneNumber) {
    this.name = name;
    this.phoneNumber = phoneNumber;
  }
  
  Consumer(String name) {
    this.name = name;
  }
  
  Consumer() {}
}

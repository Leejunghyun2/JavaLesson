package step01;

public class Manager extends Consumer {
  int managerNum;
  
  Manager(int managerNum, String name) {
    super(name);
    this.managerNum = managerNum;
  }
}

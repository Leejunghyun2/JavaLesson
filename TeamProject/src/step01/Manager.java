package step01;

import java.io.Serializable;

public class Manager extends Consumer implements Serializable {
  int managerNum;
  
  Manager(int managerNum, String name) {
    super(name);
    this.managerNum = managerNum;
  }
}

package com.sample.basics;

public class SwitchCaseSample {
  public static void main(String[] args) {
    Integer i = 10;
    switch (i) {
      case 1:
        System.out.println("Case 1");
        i = 2;
        break;
      case 2:
        System.out.println("Changed to Case 2");
        break;
      default:
        System.out.println("noting");
    }

    System.out.println("Final value of i " + i);
  }
}

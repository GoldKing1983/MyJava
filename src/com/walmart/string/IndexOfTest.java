package com.walmart.string;

public class IndexOfTest {
  public static void main(String[] args) {
    String s = "HelloInMoon";
    System.out.println(s.indexOf('o'));
    System.out.println(s.lastIndexOf('o'));
    // \t \n are considered single character only.
    s = "Hell\toIn\nMoon";
    System.out.println(s.indexOf('o'));
    System.out.println(s.indexOf('\t'));
  }
}

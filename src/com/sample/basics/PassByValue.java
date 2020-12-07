package com.sample.basics;

/*
Java is PassByValue proof.
https://levelup.gitconnected.com/tricky-java-interview-questions-cfc546fd03ab
 */
public class PassByValue {

  public static void main(String[] args) {
    PassByValue p = new PassByValue();
    String s = "1";
    Integer i = 1;
    Boolean b = true;
    p.method(s, i, b);

    System.out.println(s);
    System.out.println(i);
    System.out.println(b);
  }

  public void method(String s, Integer i, Boolean b) {
    s = "100";
    i = 100;
    b = false;
  }
}

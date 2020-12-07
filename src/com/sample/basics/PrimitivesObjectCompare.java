package com.sample.basics;

public class PrimitivesObjectCompare {

  public static void main(String[] args) {
    Integer x = 10;
    Integer y = new Integer(10);
    // == is never guaranteed to be true all times. There are so many cases
    // Use equals always for Objects
    System.out.println(x == y);
    System.out.println(x.equals(y));
  }
}

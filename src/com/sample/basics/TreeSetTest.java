package com.sample.basics;

import java.util.TreeSet;

public class TreeSetTest {
  public static void main(String[] args) {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(5);
    set.add(1);
    set.add(10);
    System.out.println(set.first());
    System.out.println(set.higher(4));
    System.out.println(set.higher(5));
    System.out.println(set.higher(10));
    System.out.println(set.floor(4));
    // Returns greater than or equal to the given element, or null if there is no such element.
    System.out.println(set.ceiling(4));
  }
}

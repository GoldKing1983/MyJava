package com.sample.basics;

import java.util.Collections;
import java.util.TreeSet;

public class TreeSetCharacterTest {
  public static void main(String[] args) {
    //TreeSet<Character> set = new TreeSet<>();
    TreeSet<Character> set = new TreeSet<>(Collections.reverseOrder());
    set.add('b');
    set.add('a');
    set.add('c');
    System.out.println(set.first());
    System.out.println(set.iterator().next());

    // Returns greater than or equal to the given element, or null if there is no such element.
  }
}

package com.sample.basics;

import java.util.ArrayDeque;
import java.util.Deque;

// ArrayDeque will not allow null to offer.
public class ArrayDequeVsLinkedList {
  public static void main(String[] args) {

    Deque<Integer> dQ = new ArrayDeque<>();
    dQ.add(10);
    dQ.add(20);
    dQ.add(30);
    dQ.add(40);

    // bottom10 20 30 40top
    System.out.println(dQ.getFirst()); // 10
    System.out.println(dQ.getLast()); // 40

  }
}

package com.interview.leetcode.google.medium;

import java.util.LinkedList;

/*
Design an Iterator class, which has:
====================================================Requirement==================================================================
A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.

====================================================Example1=====================================================================
CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
=================================================Solution Approach===============================================================
1) For Each of currentChar, call recursion with nextChar.
2) If the currentResult.size()==k. Result found. Return from recursion
3) If the recursion returned, remove the lastChar from currentResult, try the nextChar from input.

 */
public class IteratorForCombination {
  LinkedList<String> combo = new LinkedList<>();

  public IteratorForCombination(String characters, int combinationLength) {
    recur(characters, 0, new StringBuilder(), combinationLength, characters.length());
  }

  public String next() {
    return combo.poll();
  }

  private void recur(String word, int index, StringBuilder currentResult, int k, int n) {
    if (currentResult.length() == k) {
      combo.offer(currentResult.toString());
      return;
    }
    while (index < n) {
      currentResult.append(word.charAt(index));
      index++; // Send nextCharacter for recursion.
      recur(word, index, currentResult, k, n);
      currentResult.deleteCharAt(currentResult.length() - 1);
    }
  }

  public boolean hasNext() {
    return !combo.isEmpty();
  }
}

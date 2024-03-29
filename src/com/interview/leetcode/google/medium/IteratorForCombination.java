package com.interview.leetcode.google.medium;

import java.util.LinkedList;

/*
Design an Iterator class, which has:
====================================================Requirement==================================================================
1) A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
2) A function next() that returns the next combination of length combinationLength in lexicographical order.
3) A function hasNext() that returns True if and only if there exists a next combination.

============================================================Example1=============================================================  
    abcd k=3
    
    abc
    abd
    acd
    bcd
============================================================Example2=============================================================
    abcd k=2    
    
    ab 
    ac 
    ad 
    bc 
    bd 
    cd

========================================================Solution Approach========================================================
Classic BackTracking similar to "Combinations".
0) Generate the combination and save it queue. Return from the list
            ==how to generate combination - similar to FactorCombinations==
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

  private void recur(String inputString, int index, StringBuilder currentResult, int k, int n) {
    if (currentResult.length() == k) {
      combo.offer(currentResult.toString());
      return;
    }
    while (index < n) {
      currentResult.append(inputString.charAt(index));
      recur(inputString, index + 1, currentResult, k, n); // Send nextCharacter for recursion.
      currentResult.deleteCharAt(currentResult.length() - 1);
    }
  }

  public boolean hasNext() {
    return !combo.isEmpty();
  }
}

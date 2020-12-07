package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
Could you do this in O(n) runtime?

Input: [3, 10, 5, 25, 2, 8] Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.

Requirement is a bit odd. "Sum(X-OR) of Maximum of 2 of numbers". Which application would require this?

x ^ 0 = x  ==> (if x is 0 then result is 0, if x is 1 then result is 1.)
x ^ x = 0  ==> (if x is 0 then result is 0, if x is 1 then result is 0.)
x ^ 1 = !x ==> (if x is 0 then result is 1, if x is 1 then result is 0.)

====================================InCompleted===================Solution Approach=======================================================
Code for the image MaximumXOROfTwoNumbersInANArrayTrieBFS.png

1) To get the maximum of 2 x-or, take the big number then do x-or with all remaining number.

	25 => 11001
	 5 => 00101
	      =====
	28 => 11100

2) Out of 2 Number, number1 must be big number to get "maximumOf2XorNumbers".
3) Choose the 2nd number by looking at individual bits of remaining numbers.

 */
public class MaximumXOROfTwoNumbersInANArrayTrieBFS {

  class Trie {
    private Map<Character, Trie> children = new HashMap<>();
    private int num;
  }

  private Trie trie = new Trie();

  private void insert(String num, int intNum) {
    Trie node = trie;
    for (Character bit : num.toCharArray()) {
      // insert new number in trie
      if (node.children.containsKey(bit)) {
        node = node.children.get(bit);
      } else {
        Trie newNode = new Trie();
        node.children.put(bit, newNode);
        node = newNode;
      }
    }
    node.num = intNum;
  }

  public int findMaximumXOR(int[] nums) {
    // Compute length L of max number in a binary representation
    int maxNum = nums[0];
    String maxNumString = "";
    for (int num : nums) maxNum = Math.max(maxNum, num);
    int lengthOfFirstBigNumber = (Integer.toBinaryString(maxNum)).length();

    // zero left-padding to ensure L bits for each number
    int n = nums.length, bitmask = 1 << lengthOfFirstBigNumber;
    String[] strNums = new String[n];
    for (int i = 0; i < n; ++i) {
      strNums[i] = Integer.toBinaryString(bitmask | nums[i]).substring(1);
      insert(strNums[i], nums[i]);
      if (nums[i] == maxNum) maxNumString = strNums[i];
    }
    /// ======================================
    for (int i = 0; i < maxNumString.length(); i++) {
      char maxBit = maxNumString.charAt(i);
      if (maxBit == '1') {
        // Try to pick 0, to get maximum else 1.
        trie = trie.children.get('0') == null ? trie.children.get('1') : trie.children.get('0');
      } else {
        // Try to pick 1, to get maximum. else 0.
        trie = trie.children.get('1') == null ? trie.children.get('0') : trie.children.get('1');
      }
    }
    int maxSecond = trie.num;
    return maxNum ^ maxSecond;
  }
}

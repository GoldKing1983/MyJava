package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePermutationII {
  public List<String> generatePalindromes(String s) {
    int[] charCounts = new int[128]; // considering all a-zA-z0-9 and other weird chars!

    // use charCounts for incrementing char occurences in s
    // use count to keep track of number of chars occuring exactly once in s!
    int count = 0;
    for (char ch : s.toCharArray()) {
      charCounts[ch]++;
      count += charCounts[ch] % 2 == 0 ? -1 : 1;
    }

    List<String> res = new ArrayList<>();
    // check if a valid Palindrome Permutation exists for given string s
    // if count > 1, then no!!
    if (s.length() == 0 || count > 1) return res;

    // find out that middle char, if any exists!
    String curr = "";
    for (int i = 0; i < 128; i++) {
      if (charCounts[i] % 2 == 1) {
        charCounts[i]--;
        curr += (char) i; // converting int i to char!
      }
    }

    helper(charCounts, s.length(), curr, res);

    return res;
  }

  private void helper(int[] charCounts, int n, String curr, List<String> res) {
    if (curr.length() == n) {
      res.add(new String(curr));
      return;
    }

    for (int i = 0; i < 128; i++) {
      if (charCounts[i] > 0) {
        char ch = (char) i;
        charCounts[i] -= 2;

        // This is brilliant! IMP!
        // We greedily place chars to create palindrome permutations,
        // by still avoiding duplicates
        helper(charCounts, n, ch + curr + ch, res);

        charCounts[i] += 2;
      }
    }
  }
}

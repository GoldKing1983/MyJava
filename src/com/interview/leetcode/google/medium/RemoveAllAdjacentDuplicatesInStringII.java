package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation:
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

=====================Solution Approach===========Similar to MinStack=====================
1) If current and previous match and if "previousCount+1=k" we can ignore adding to stack.
2) If current and previous match and if "previousCount+1!=k" increment count of Character.
3) If current and previous don't match  --> new Object[] {c, 1}
4) Stack hold the answer in reverse. So reverse the result.
 */
public class RemoveAllAdjacentDuplicatesInStringII {
  static class Pair {
    Character c;
    int charCount;

    public Pair(Character c, int charCount) {
      this.c = c;
      this.charCount = charCount;
    }
  }

  public String removeDuplicates(String s, int k) {
    Deque<Pair> stack = new ArrayDeque<>();
    for (Character c : s.toCharArray()) {
      if (!stack.isEmpty() && (stack.peek().c).equals(c)) {
        Pair pair = stack.pop();
        if (pair.charCount + 1 == k) continue;
        stack.push(new Pair(c, pair.charCount + 1));
      } else stack.push(new Pair(c, 1));
    }
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
      Pair pair = stack.pop();
      int count = pair.charCount;
      while (count-- > 0) result.append(pair.c);
    }
    return result.reverse().toString();
  }
}

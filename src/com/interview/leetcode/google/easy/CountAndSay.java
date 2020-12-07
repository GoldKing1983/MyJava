package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/count-and-say/
Almost same problem as StringCompression

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221

==========================================Solution Approach==============================
Just code for the requirement, no magic.
1) Pick the character at index "i", lets say "currNumber".
2) Mark the "currNumberCount" as 1.
3) Increment "currNumberCount" as many times "currNumber" is re-occurring.
 */
public class CountAndSay {
  // Runtime: 1 ms, faster than 91.69%...Memory Usage: 36.9 MB, less than 69.00%.
  public String countAndSay(int n) {
    StringBuilder answer = new StringBuilder("1");
    while (n-- != 1) { // If n=2 loop runs only one time.
      String prevAnswer = answer.toString();
      answer = new StringBuilder();
      for (int i = 0; i < prevAnswer.length(); i++) {
        int currNumberCount = 1;
        char currNumber = prevAnswer.charAt(i);
        while (i + 1 < prevAnswer.length()) { // Count unique continuous numbers
          char nextNumber = prevAnswer.charAt(i + 1);
          if (nextNumber != currNumber) break;
          i++;
          currNumberCount++;
        }
        answer.append(currNumberCount).append(currNumber);
      }
    }
    return answer.toString();
  }
}

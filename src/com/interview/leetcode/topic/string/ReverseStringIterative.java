package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/reverse-string/

1) Recurse till n/2 length of input String.
2) Then do swap.
3) Similar to Post-Order Traversal.

 */
public class ReverseStringIterative {

  public void reverseString(char[] str) {

    int n = str.length - 1;
    for (int startIndex = 0, endIndex = n; startIndex < endIndex; startIndex++, endIndex--) {
      char temp = str[startIndex];
      str[startIndex] = str[endIndex];
      str[endIndex] = temp;
    }
  }

  public void reverseStringXOR(char[] s) {
    for (int left = 0, right = s.length - 1; left < right; left++, right--) {
      if (s[left] == s[right]) continue;
      s[left] ^= s[right];
      s[right] ^= s[left];
      s[left] ^= s[right];
    }
  }
}

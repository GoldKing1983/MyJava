package com.walmart.string;

/*
https://leetcode.com/problems/reverse-string/

1) Recurse till n/2 length of input String.
2) Then do swap.
3) Similar to Post-Order Traversal.

 */
public class ReverseStringRecursion {

  public void reverseString(char[] s) {
    recur(s, 0, s.length - 1);
  }

  public void recur(char[] str, int startIndex, int endIndex) {
    if (startIndex >= endIndex) return;

    // recur(str, startIndex + 1, endIndex - 1); Pre-Order or PostOrder both will work

    char temp = str[startIndex];
    str[startIndex] = str[endIndex];
    str[endIndex] = temp;

    recur(str, startIndex + 1, endIndex - 1); // recur can be below or above swap. Both works.
  }



  private void recurPostOder(char[] s, int start, int end) {
    if (start < end) {
      recur(s, start + 1, end - 1);
      char temp = s[start];
      s[start] = s[end];
      s[end] = temp;
    }
  }
}

package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/reverse-string/

1) Recurse till n/2 length of input String.
2) Then do swap.
3) Similar to Post-Order Traversal.

 */
public class ReverseStringRecursion {

  public void reverseString(char[] s) {
    recurPreOrder(s, 0, s.length - 1);
  }

  public void recurPreOrder(char[] str, int startIndex, int endIndex) {
    if (startIndex >= endIndex) return;

    char temp = str[startIndex];
    str[startIndex] = str[endIndex];
    str[endIndex] = temp;

    recurPreOrder(str, startIndex + 1, endIndex - 1); // recur can be below or above swap. Both works.
  }



  private void recurPostOder(char[] s, int startIndex, int endIndex) {
    if (startIndex >= endIndex) return;

    recurPostOder(s, startIndex + 1, endIndex - 1);

    char temp = s[startIndex];
    s[startIndex] = s[endIndex];
    s[endIndex] = temp;

  }
}

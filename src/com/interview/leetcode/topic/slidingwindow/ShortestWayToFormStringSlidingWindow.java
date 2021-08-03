package com.interview.leetcode.topic.slidingwindow;

/*
https://leetcode.com/problems/shortest-way-to-form-string/

1) Given a sourceString and targetString.
2) Try to concat sourceString as many time as possible to make up targetString.
3) When doing concat you are allowed to delete any number of characters.
4) If the task is impossible, return -1.

============================================================Example1=============================================================
Input: source = "abc", target = "abcbc"
Output: 2
Explanation: 
abc + abc = abcabc
delete "a" index3, which matches abcbc 
============================================================Example2=============================================================
Input: source = "abc", target = "abab"
Output: 2
Explanation: 
abc + abc = abcabc
delete "c" index2. and "c" at index5, which matches abab
============================================================Example4=============================================================
Input: source = "abc", target = "acdbc"
Output: -1
Explanation: 
d which is present in targetString is not present in sourceString. 
So whatever the number of time we append sourceString again and again, we cannot get targetString 
============================================================Example5=============================================================
Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: 

xyz + xyz = xyzxyz...delete char at index1,index3,index5 = xzy
xzy + xyz = xzyxyz...delete char at index4 =  xzyxz

The target string can be constructed as follows "xz" + "y" + "xz".
========================================================Solution Approach========================================================
0) Simple Sliding Window.
1) left point source and right point target.
2) When there is a  match both source and target moves. 
3) When there is no match only source moves.


Ex: source = "xyz", target = "xzyxz"
Iteration1: Number of Matching = 2. i.e. "xz" at target. target index stays at 2
Iteration2: Number of Matching = 1. i.e. "y" at target. target index stays at 3
Iteration3: Number of Matching = 2. i.e. "xz" at target. target index goes to end at 5


 */
public class ShortestWayToFormStringSlidingWindow {
  public int shortestWay(String sourceString, String targetString) {
    char[] source = sourceString.toCharArray();
    char[] target = targetString.toCharArray();
    int resultCount = 0;
    while (true) {
      boolean atLeastOneMatch = common(source, target, 0);
      if (atLeastOneMatch) {
        resultCount++;
        if (right == target.length) return resultCount;
      } else {
        return -1; // If no match in current iteration, return -1.
      }
    }
  }

  int right = 0;

  private boolean common(char[] source, char[] target, int left) {
    boolean atLeastOneMatch = false;
    while (left < source.length && right < target.length) {
      if (source[left] == target[right]) {
        left++;
        right++;
        atLeastOneMatch = true;
      } else {
        left++;
      }
    }
    return atLeastOneMatch;
  }
}

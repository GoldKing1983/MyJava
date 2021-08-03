package com.interview.leetcode.topic.recursion;

/*
https://leetcode.com/problems/edit-distance/description/
===========================================================Requirement===========================================================
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
====================================Solution Approach - Exponential O(3^m+n)===========================================================
1) A basic brute-force solution could be to try all operations (one by one) on each character of s1.
2) We can iterate through s1 and s2 together.
3) Let’s assume index1 and index2 point to the current indexes of s1 and s2 respectively,
so we have two options at every step:
3a) If the strings have a matching character, we can recursively match for the remaining lengths.
3b) If the strings don’t match, we start three new recursive calls representing the three edit operations.
Whichever recursive call returns the minimum count of operations will be our answer.
=======================================================================================================================================
*/
public class EditDistanceRecursion {
  public int minDistance(String str1, String str2) {
    return findMinOperationsRecursive(str1, 0, str1.length(), str2, 0, str2.length());
  }

  private int findMinOperationsRecursive(String str1, int i1, int n1, String str2, int i2, int n2) {
    // if we have reached the end of s1, then we have to insert all the remaining characters of s2
    if (i1 == n1) return n2 - i2;

    // if we have reached the end of s2, then we have to delete all the remaining characters of s1
    if (i2 == n2) return n1 - i1;

    // If the strings have a matching character, we can recursively match for the remaining lengths.
    if (str1.charAt(i1) == str2.charAt(i2))
      return findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2 + 1, n2);

    // str1 is source. deletion is incrementing str1 length
    int delete = 1 + findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2, n2);
    // str1 is source. insertion is incrementing str2 length
    int inserte = 1 + findMinOperationsRecursive(str1, i1, n1, str2, i2 + 1, n2);
    int replace = 1 + findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2 + 1, n2);

    return Math.min(delete, Math.min(inserte, replace));
  }
}

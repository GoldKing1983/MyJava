package com.interview.leetcode.linkedin.hard;

/*
 * https://leetcode.com/problems/edit-distance/description/
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
    return findMinOperationsRecursive(str1, str2, 0, 0);
  }

  private int findMinOperationsRecursive(String str1, String str2, int len1, int len2) {
    // if we have reached the end of s1, then we have to insert all the remaining characters of s2
    if (len1 == str1.length()) return str2.length() - len2;

    // if we have reached the end of s2, then we have to delete all the remaining characters of s1
    if (len2 == str2.length()) return str1.length() - len1;

    // If the strings have a matching character, we can recursively match for the remaining lengths.
    if (str1.charAt(len1) == str2.charAt(len2))
      return findMinOperationsRecursive(str1, str2, len1 + 1, len2 + 1);

    // str1 is source. deletion is incrementing str1 length
    int delete = 1 + findMinOperationsRecursive(str1, str2, len1 + 1, len2);
    // str1 is source. insertion is incrementing str2 length
    int inserte = 1 + findMinOperationsRecursive(str1, str2, len1, len2 + 1);
    int replace = 1 + findMinOperationsRecursive(str1, str2, len1 + 1, len2 + 1);

    return Math.min(delete, Math.min(inserte, replace));
  }
}

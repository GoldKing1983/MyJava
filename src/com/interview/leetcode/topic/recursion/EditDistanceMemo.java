package com.interview.leetcode.topic.recursion;

public class EditDistanceMemo {

  public int minDistance(String str1, String str2) {
    return findMinOperationsRecursive(str1, 0, str1.length(), str2, 0, str2.length(),
        new Integer[str1.length()][str2.length()]);
  }

  private int findMinOperationsRecursive(String str1, int i1, int n1, String str2, int i2, int n2,
      Integer[][] cache) {
    // if we have reached the end of s1, then we have to insert all the remaining characters of s2
    if (i1 == n1) return n2 - i2;

    // if we have reached the end of s2, then we have to delete all the remaining characters of s1
    if (i2 == n2) return n1 - i1;

    if (cache[i1][i2] != null) return cache[i1][i2];
    // If the strings have a matching character, we can recursively match for the remaining lengths.
    if (str1.charAt(i1) == str2.charAt(i2))
      return findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2 + 1, n2, cache);

    // str1 is source. deletion is incrementing str1 length
    int delete = 1 + findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2, n2, cache);
    // str1 is source. insertion is incrementing str2 length
    int inserte = 1 + findMinOperationsRecursive(str1, i1, n1, str2, i2 + 1, n2, cache);
    int replace = 1 + findMinOperationsRecursive(str1, i1 + 1, n1, str2, i2 + 1, n2, cache);

    return cache[i1][i2] = Math.min(delete, Math.min(inserte, replace));
  }

}

package com.interview.leetcode.amazon.medium;

/*
 * https://leetcode.com/problems/compare-version-numbers/
 *
Compare two version numbers version1 and version2.
If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
You may assume that the version strings are non-empty and contain only digits and the . character.

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”

Input: version1 = "1.1", version2 = "1.0.2"
Output: 1


===============================Solution Approach======================================================
1) Loop starts with biggest size of version. Ex: version1 = "7.5.2.4", version2 = "7.5.3". length would be 4
2) Convert the String to number and set default if number is empty.
Ex: version1= "1.2.3.4" version2="1.2.3" In4th loop version2 num2 will be 0.
(001 will be converted to 1)
3) Compare num1 vs num2
3) If first is bigger return 1. If second is bigger return -1. Else continue

 */
public class CompareVersionNumbers {
  public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");
    int length = Math.max(levels1.length, levels2.length);
    for (int i = 0; i < length; i++) {
      Integer num1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
      Integer num2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
      int compare = num1.compareTo(num2);
      if (compare != 0) return compare;
    }
    return 0;
  }
}

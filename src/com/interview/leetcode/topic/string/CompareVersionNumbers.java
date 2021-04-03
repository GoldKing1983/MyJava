package com.interview.leetcode.topic.string;

/*
https://leetcode.com/problems/compare-version-numbers/
===========================================================Requirement===========================================================
1) Compare two version numbers version1 and version2.
If version1 > version2 return 1; 
if version1 < version2 return -1;
if version1 == version2 return 0.
2) You may assume that the version strings are non-empty and contain only digits and the . character.
============================================================Example1=============================================================
Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
============================================================Example2=============================================================
Input: version1 = "1.0.1", version2 = "1"
Output: 1
============================================================Example3=============================================================
Input: version1 = "1.1", version2 = "1.0.2"
Output: 1
============================================================Example4=============================================================
Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: version1 does not specify revision 2, which means it is treated as "0".
============================================================Example5=============================================================
Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
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
      /*
       * If both are version are different, return result immediately. Ex: v1=1 and v2=2
       * Else compare next set after "." Ex: v1=1.2 and v2=1.3
       * 
       * num1.compareTo(num2); returns... 1 if num1 is bigger. 0 if both same. -1 if num1 is smaller. 
       * 
       */
      int compare = num1.compareTo(num2); 
      if (compare != 0) return compare;
    }
    return 0;
  }
}

package com.interview.leetcode.google.hard;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/cracking-the-safe/

n===> length of password (not the final answer "n". It is Each Password "n")
k===> Upto what number I can use
k = 1 (Only 0 can be used)
k = 2 (0 and 1 can be used)
k = 3 (0,1,2 can be used)
k = 4 (0,1,2,3 can be used)
n = 1(password can be 0,1)
n = 2(password can be 00,01,10,11)
n = 3(password can be "000","001","010","011","100","101","110","111")
==================================================================================================================
In this question you are trying to unlock the safe by putting password.
The length of password is "n".
Everytime you enter the pasword the last n digits are matched.
Since you do not know the password you want to try all combinations from k digits of length n to unlock the safe.
Eg. when n = 2, k = 2, the password could be 00, 01, 10, 11.
Hence your solution must contain all these combinations. When you unlock safe, last n digits are matched.
Solution is "00110" or anyone of "01100", "10011", "11001"
For "00110"
Digit entered '0' - no operation
Digit entered '0' - (you formed '00') will try to match if 00 is solution
Digit entered '1' : your solution '001' will try to match last n i.e. 01
Digit entered '1' : your solution '0011', will try to match '11'
Digit entered '0' : your solution will try to match last n i.e '10'
Hence you must come with shortest solution string containing all possible combinations
==================================================================================================================

Total Possible passwords : k^n
Total Length: n*k^n
Total Length: 2*2^2 = 8

============Example 1:============
Input: n = 1, k = 2(0 and 1 can be used)
the password could be "0" or "1"
So combo result would be "01" or "10" which includes all of above2.
Output: "01" or "10"
============Example 2:============
Input: n = 2, k = 2(0 and 1 can be used)
the password could be "00", "01", "10", "11"
So combo result would be anyone of "01100" or "10011" or "11001" which includes all of above4.
Output: "01100" or "10011" or "11001"
============Example 3:============
Input: n = 3, k = 2(0 and 1 can be used)
the password could be "000","001","010","011","100","101","110","111"
So combo result would be anyone of "0011101000" or ?
Output: "0011101000" or
============Example 4:============
Input: n = 2, k = 3(0,1,2 can be used)
the password could be
"00",
"11",
"22",
"01", "10" --> 01 combo
"02", "20" --> 02 combo
"12", "21" --> 12 combo
So combo result would be anyone of "0221120100" or ?
Output: "0221120100" or

=========================================Solution Approach=========================================================================

0) Related to "FactorCombinations", "CombinationSumOrCoinChange" to make Permutations
1) See Picture CrackingTheSafe.png for logical understanding.
Understanding  below diagram. "Think of each password as node", traverse from "one password" to "another password",
by considering(adding in result - "post-order") last digit.
2) See Picture CrackingTheSafe.jpg for how permutation is formed using DFS.
 */
public class CrackingTheSafe {
  Set<String> seen;
  StringBuilder ans;

  public String crackSafe(int n, int k) {
    if (n == 1 && k == 1) return "0";
    seen = new HashSet<>();
    ans = new StringBuilder();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n - 1; ++i) sb.append("0");
    String start = sb.toString();
    dfs(start, k);
    return new String(ans) + start;
  }

  public void dfs(String node, int k) {
    for (int x = 0; x < k; ++x) {
      String nei = node + x;
      if (!seen.contains(nei)) {
        seen.add(nei);
        dfs(nei.substring(1), k);
        ans.append(x);
      }
    }
  }
}

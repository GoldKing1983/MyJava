package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/license-key-formatting/

Given a non-empty string S and a number K, format the string according to the rules described above.

Input: S = "5F3Z-2e-9-w", K = 4 Output: "5F3Z-2E9W"
Explanation: The string S has been split into two parts, each part has 4 characters.
Note that the two extra dashes are not needed and can be removed.

Input: S = "2-5g-3-J", K = 2 Output: "2-5G-3J"
Explanation: The string S has been split into three parts, each part has 2 characters except the
first part as it could be shorter as mentioned above.

====================================Solution Approach- Easy - Code for Requirement====================================
1) Key point is calculating totalSize.
2) Fill from last to first. Because as per requirement, from the beginning short word can present.
3) Instead of StringBuilder using char[] is another key to faster result.
 */
public class LicenseKeyFormatting {
  public String licenseKeyFormatting(String S, int K) {
    String s = S.replace("-", "");
    int n = s.length();
    if (n == 0) return "";

    int totalSize = n % K == 0 ? n + (n / K) - 1 : n + (n / K);
    char[] result = new char[totalSize];

    totalSize--;
    n--;

    while (true) {
      for (int j = 0; j < K && totalSize >= 0; j++) {
        result[totalSize] = Character.toUpperCase(s.charAt(n));
        n--;
        totalSize--;
      }
      if (totalSize <= 0) break;
      result[totalSize] = '-';
      totalSize--;
    }
    return new String(result);
  }
}

package com.leetcode.maths;

/*
 
 Do like wordBreak. If a match found cut the str1 and send remaining for comapare.
 It fails for below input or return "". But answer is "AB"
  
  "ABABAB"
  "ABAB"
 */
public class GreatestCommonDivisorOfStringsWrongApproach {
  public String gcdOfStrings(String str1, String str2) {
    int n1 = str1.length(), n2 = str2.length();
    if (n2 > n1) {
      if (n2 % n1 != 0) return "";
      return recur(str2, str1);
    }
    if (n1 % n2 != 0) return "";
    return recur(str1, str2);
  }

  public String recur(String str1, String str2) {
    if (str1.equals(str2)) return str1;

    if (!str1.startsWith(str2)) return "";

    return recur(str1.substring(str2.length()), str2);
  }
}

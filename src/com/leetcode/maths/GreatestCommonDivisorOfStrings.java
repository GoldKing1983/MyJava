package com.leetcode.maths;

/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.


Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Input: str1 = "ABCABC", str2 = "BC"
Output: ""

Input: str1 = "ABCABC", str2 = "ABCD"
Output: ""

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

=====Solution Approach=====

GCD is about, 1) swapping
              2) passing str2 in str1. 
              3) passing str1 in str2 with remaining 
              
              
              
=====Data Flow Analysis=====
Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB"

ABABAB ABAB
ABAB AB
AB AB


 */
public class GreatestCommonDivisorOfStrings {
  public String gcdOfStrings(String str1, String str2) {

    while (true) {

      if (str2.length() > str1.length()) { // Keep str1 as bigger always
        String s = str1;
        str1 = str2;
        str2 = s;
      }

      if (str1.equals(str2)) return str2; // return the small string

      if (!str1.startsWith(str2)) return "";

      String tempStr1 = str1;
      str1 = str2;
      str2 = tempStr1.substring(str2.length());

    }


  }

}

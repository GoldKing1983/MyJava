package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/greatest-common-divisor-of-strings/
See also WaterAndJugProblemGCD
===========================================================Requirement===========================================================
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.


Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Input: str1 = "ABCABC", str2 = "BC"
Output: ""

Input: str1 = "ABCABC", str2 = "ABCD"
Output: ""

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

========================================================Solution Approach========================================================
Same code as GCDMaths.
1) Keep the biggest string as str1. Ex: ABABAB ABAB
2) If str1 not startswith str2 return false. Because we cannot find GCD.
3) If yes cut str1 by str2length. 
   E
              
              
=======================================================Data Flow Analysis========================================================
Input: str1 = "ABABAB", str2 = "ABAB" Output: "AB"

str1= ABABAB, str2= ABAB
str1= ABAB, str2= AB
str1= AB, str2= AB
str1= , str2= AB
str1 is empty return "AB"

=======================================================Data Flow Analysis========================================================
Input: str1 = "ABABAC", str2 = "ABAB" Output: "AB"

str1= ABABAC, str2= ABAB
str1= ABAB, str2= AC

(!str1.startsWith(str2))...return false


 */
public class GreatestCommonDivisorOfStrings {
  public String gcdOfStrings(String str1, String str2) {

    while (true) {
      if (str2.length() > str1.length()) { // Keep str1 as bigger always
        String s = str1;
        str1 = str2;
        str2 = s;
      }
      if (!str1.startsWith(str2)) return "";

      //Ex:"ABCD" "AB" str1 =CD 
      str1 = str1.substring(str2.length(), str1.length()); 

      if (str1.isEmpty()) return str2;
    }
  }
}

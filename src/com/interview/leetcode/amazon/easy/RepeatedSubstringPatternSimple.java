package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/repeated-substring-pattern/description/

Given a non-empty string check if it can be constructed by taking a substring of it and appending
multiple copies of the substring together.

Ex1: abcabcabcabc -- true
Ex2: abcabcabc -- true
Ex: cacac -- false

The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for length/2
If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true

=======================
Repeated pattern string looks like PatternPattern, and the others like Pattern1Pattern2.

Let's double the input string:

PatternPattern --> PatternPatternPatternPattern

Patter1Patter2 --> Patter1Patter2Patter1Patter2

Now let's cut the first and the last characters in the doubled string:

PatternPattern --> *atternPatternPatternPatter*

Patter1Patter2 --> *atter1Patter2Patter1Patter*

It's quite evident that if the new string contains the input string, the input string is a repeated pattern string.

Time complexity: O(N^ 2) because of the way in and contains are implemented.


*/
public class RepeatedSubstringPatternSimple {

  public boolean repeatedSubstringPattern(String s) {
    String doub = s + s;
    int doubleLength = 2 * s.length();
    return doub.substring(1, doubleLength - 1).contains(s);
  }
}

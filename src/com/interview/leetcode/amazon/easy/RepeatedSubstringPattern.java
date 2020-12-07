package com.interview.leetcode.amazon.easy;

/*
https://leetcode.com/problems/repeated-substring-pattern/description/

Given a non-empty string check if it can be constructed by taking a substring of it and appending
one or more copies of the substring together.

Ex1: abcabcabcabc -- true..... Take "abc" append 4 times the same.
Ex2: abcabcabc -- true	 ..... Take "abc" append 3 times the same.
Ex: cacac -- false		 ..... Whatever the combo I pick, I can not form the source again.

Point1)The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for length/2
If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true

EX: for a 30 char input. Repeat can occur in 15, 10, 6, 5, 3, and 2
   5,3 and 2 can be ignored.
   Because 5 covered in 15,
   3 covered in 6
   2 covered in 6 and 10
   Below code is not efficient enough to skip (5,3,2). Need improvement
I can execute logic only for that-->30%15==0, 30%10==0, 30%6==0, 30%5==0, 30%3==0, 30%2==0
So start from 30/2. i.e 15. do a substring
Then do 10 char substring
Then do 6 char substring.
If anyone matches true. Else False

 */
public class RepeatedSubstringPattern {

  public boolean repeatedSubstringPattern(String str) {
    int n = str.length();
    for (int i = n / 2; i >= 1; i--) {
      if (n % i == 0) {
        String subS = str.substring(0, i);
        StringBuilder sb = new StringBuilder();

        while (sb.length() < n) {
          sb.append(subS);
        }
        if (sb.toString().equals(str)) return true;
      }
    }
    return false;
  }
}

package com.interview.leetcode.facebook.easy;

/*
https://leetcode.com/problems/valid-palindrome/
===========================================================Requirement===========================================================
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Input: "A man, a plan, a canal: Panama"
Output: true

Input: "race a car"
Output: false
===========================================================Solution Approach=====================================================
0) Traverse from left side and right side at the same time
1) Traverse from left side, Skip special characters, convert upperCase to lowerCase. assign leftPtrChar to valid character.
2) Traverse from right side, Skip special characters, convert upperCase to lowerCase. assign rightPtrChar to valid character.
3) if (leftPtrChar == ' ' || rightPtrChar == ' ') return true; // It means reached the end on either side.
		Ex: "a.b" ---> leftPtrChar=' '
		Ex: "a."  ---> rightPtrChar=' '
4) if (leftPtrChar != rightPtrChar) return false.
 */
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int leftPtr = 0;
    int rightPtr = s.length() - 1;
    char leftPtrChar = ' ';
    char rightPtrChar = ' ';
    while (true) {
      while (leftPtr < rightPtr) {
        char tempLeftPtrChar = s.charAt(leftPtr);
        if (Character.isAlphabetic(tempLeftPtrChar)) {
          leftPtrChar = Character.toLowerCase(tempLeftPtrChar);
          break;
        } else if (Character.isDigit(tempLeftPtrChar)) {
          leftPtrChar = tempLeftPtrChar;
          break;
        }
        leftPtr++;
      }
      while (leftPtr < rightPtr) {
        char tempRightPtrChar = s.charAt(rightPtr);
        if (Character.isAlphabetic(tempRightPtrChar)) {
          rightPtrChar = Character.toLowerCase(tempRightPtrChar);
          break;
        } else if (Character.isDigit(tempRightPtrChar)) {
          rightPtrChar = tempRightPtrChar;
          break;
        }
        rightPtr--;
      }
      if (leftPtrChar == ' ' || rightPtrChar == ' ')
        return true;
      if (leftPtrChar != rightPtrChar)
        return false;

      leftPtr++;
      rightPtr--;
      // Reset values
      leftPtrChar = ' ';
      rightPtrChar = ' ';
    }
  }
}

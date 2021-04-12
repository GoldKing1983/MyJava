package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/integer-to-roman/description/
===========================================================Requirement===========================================================
Given an integer, convert it to a roman numeral.
Ex: Input: 8...  Output: VIII         
Ex: Input: 39... Output: XXXIX
Ex: Input: 33... Output: XXXIII
Ex: Input: 58... Output: LVIII...Explanation: L = 50, V = 5, III = 3.
========================================================Solution Approach========================================================
1) Break the numbers into slices by below pattern 
2) The slice must be made from big number to small number.
3) Initially Code intToRomanStepByStepApproach...
4) Then do the full stretch code.   

Remember 1		4  		5 		9 from left till 1000...
		 10 	40 		50		90
		 100 	400 	500		900
		 1000

Add relevant Roman Numbers for the same.
		 I		IV		V		IX
		 X		XL		L		XC
		 C		CD		D		CM
		 M


 */
public class IntegerToRoman {

  // Below code will work from 1 to 39. 
  // Add this in loop with corresponding "number and roman"... Evaluate from big always
  public String intToRomanStepByStepApproach(int num) {
    StringBuilder result = new StringBuilder();
    while (num >= 1) {
      if (num >= 10) {
        result.append("X");
        num = num - 10;
      } else if (num >= 9) {
        result.append("IX");
        num = num - 9;
      } else if (num >= 5) {
        result.append("V");
        num = num - 5;
      } else if (num >= 4) {
        result.append("IV");
        num = num - 4;
      } else {
        result.append("I");
        num = num - 1;
      }
    }
    return result.toString();
  }


  public String intToRoman(int num) {
    int[] numbers = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] romanNumbers = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    StringBuilder result = new StringBuilder();
    for (int i = numbers.length - 1; num > 0; i--) {
      while (true) {
        if (num >= numbers[i]) {
          result.append(romanNumbers[i]);
          num = num - numbers[i];
        } else break;
      }
    }
    return result.toString();
  }
}

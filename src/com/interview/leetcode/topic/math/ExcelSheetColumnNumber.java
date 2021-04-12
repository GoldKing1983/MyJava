package com.interview.leetcode.topic.math;

/*
https://leetcode.com/problems/excel-sheet-column-number/

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27		index0===>0*26+1 index1===> 1*26+1 ===> 27
    AB -> 28 		index0===>0*26+1 index1===> 1*26+2 ===> 28
    ABC -> 731 		index0===>0*26+1 index1===> 1*26+2 index2===> 28*26+3 ===> 731
    ABCD ->19010 	index0===>0*26+1 index1===> 1*26+2 index2===> 28*26+3 index3===> 731*26+4 ===> 19010
==============================================================Where I stuck======================================================
1) Getting the value of 'A' is tricky.
2) Generally in problems, we want to save 'a' to 'z' in array or 'A' to 'Z' in array.
   So we do
   " index = currentChar -'a' " ===> for lowercase to save in array with index 0 to 25
   " index = currentChar -'A' " ===> for uppercase to save in array with index 0 to 25
3) Here we want A=1 .... Z=26.
      So do "currentNumber=currentChar-A+1" ===> for uppercase to get value 1 to 26
    "
 */
public class ExcelSheetColumnNumber {
  public int titleToNumber(String s) {
    int answer = 0;
    for (char c : s.toCharArray()) {
      int currentNumber = (c - 'A' + 1);
      answer = answer * 26 + currentNumber;
    }
    return answer;
  }
}

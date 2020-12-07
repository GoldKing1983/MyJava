package com.interview.leetcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/gray-code
Binary to Gray-Code : https://www.youtube.com/watch?v=IeWcvAsz88o
=============================================================Requirement=========================================================
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.
 
Decimal      Binary     GrayCode
     
  0            00         00
  1            01         01 
  2            10         11
  3            11         10
 
===========================================================Solution Approach=====================================================
1) GrayCode and BinaryCode of 0 and 1 is same. So add 0 and 1 to result. If n=0 or n=1 return result directly.   
2) Add k to previousResult from bottomToTop. Thats it. 
3) k goes like 2,4,8,16
===========================================================Data Flow Analysis====================================================
n=0: 0 

n=1, 0, 1
 
n=2, k=2: 
      0 (previousResult) 
      1 (previousResult)
      1 + 2 (Adding 2 to 1) = 3
      0 + 2 (Adding 2 to 0) = 2
      
        
n=3, k=4: 
      0 (previousResult)
      1 (previousResult)
      3 (previousResult)
      2 (previousResult)
      2 + 4 (Adding 4 to 2) = 6 
      3 + 4 (Adding 4 to 3) = 7
      1 + 4 (Adding 4 to 1) = 5 
      0 + 4 (Adding 4 to 0) = 4 
 */
public class GrayCode {

  // For 0 and 1 BinaryCode and GrayCode are same. So return as such. 
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0);
    if (n == 0) return result;
    result.add(1);
    if (n == 1) return result;

    int k = 1;
    for (int i = 2; i <= n; i++) {
      k = k * 2;
      for (int j = result.size() - 1; j >= 0; j--) {
        int prevResultFromLast = result.get(j);
        result.add(prevResultFromLast + k);
      }
    }
    return result;
  }
}

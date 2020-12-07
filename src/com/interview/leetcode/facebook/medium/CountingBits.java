package com.interview.leetcode.facebook.medium;
/*
https://leetcode.com/problems/counting-bits/
https://www.youtube.com/watch?v=awxaRgUB4Kw

Given a non negative integer number num.
For every numbers from 0 to num. Fill number of 1s present.

Input: 5 Output: [0,1,1,2,1,2]
0	==> 0   ==> NumberOfOnes : 0
1	==> 1   ==> NumberOfOnes : 1
2	==> 10  ==> NumberOfOnes : 1
3	==> 11  ==> NumberOfOnes : 2
4	==> 100 ==> NumberOfOnes : 1
5	==> 101 ==> NumberOfOnes : 2
=======================================Solution Approach - DP=======================================
1) Dividing any number by 2 gives same number of 1s, if it is even.
2) Dividing any number by 2 gives same number of 1s +1 , if it is odd.
		Ex: 4/2 = 2. ==> 2 and 4 have same answer.
		Ex: 5/2 = 2. ==> So 5 answer is 2s answer +1.
3) Build a DP from 0.

 */
public class CountingBits {
  public int[] countBits(int num) {
    int[] result = new int[num + 1];
    for (int i = 1; i <= num; i++) {
      if (i % 2 == 0) {
        result[i] = result[i / 2];
      } else {
        result[i] = 1 + result[i / 2];
      }
    }
    return result;
  }
}

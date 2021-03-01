package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/plus-one/

[1,2,3] is number 123 and plus one is 123+1 = 124,
then convert this result number to a new array [1,2,4].

The example should include carry. e.g. [2,9,9] plus one to result [3,0,0]
[9,9] plus one to [1,0,0].

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

===================Solution Approach=================
In interview just 2 case is enough is explain 98 and 99.

1) Come from last
2) If the digit is not 9 ... Increment it send response instant.
3) Else update that to 0. Do above step.
4) Finally, if the loop ends then answer must be 10 or 100 or 1000 or 10000......

 */
public class PlusOne {

  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] < 9) { // digits[i] != 9
        digits[i]++;
        return digits;
      }
      digits[i] = 0;
    }

    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
  }
}

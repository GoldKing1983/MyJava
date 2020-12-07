package com.interview.leetcode.amazon.easy;

/*
 *
 * https://leetcode.com/problems/baseball-game
 *
Number -> just add
+ -> sum of the last two
D -> previous * 2
C -> cancel previous. Reduce the sum.

Input: ["5","2","C","D","+"]
Output: 30
Explanation:
Round 1: You could get 5 points. The sum is: 5.
Round 2: You could get 2 points. The sum is: 7.
Operation 1: The round 2's data was invalid. The sum is: 5.
Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 5*2+5=15.
Round 4: You could get 5 + 10 = 15 points. The sum is: 30.

0  1  2
5       ==>sum=5

0  1  2
5  7    ==>sum=7

0  1  2
5       ==>sum=5

0  1  2
5  10   ==>sum=15

0  1  2
5  10 15==>sum=30


*/

public class BaseballGame {

  public int calPoints(String[] ops) {
    int cache[] = new int[ops.length];
    int i = 0;
    int sum = 0;
    for (String s : ops) {
      switch (s) {
        case "+":
          cache[i] = cache[i - 2] + cache[i - 1];
          sum = sum + cache[i];
          i++;
          break;
        case "D":
          cache[i] = 2 * cache[i - 1];
          sum = sum + cache[i];
          i++;
          break;
        case "C":
          i--;
          sum = sum - cache[i];
          break;
        default:
          cache[i] = Integer.valueOf(s);
          sum = sum + cache[i];
          i++;
      }
    }
    return sum;
  }
}

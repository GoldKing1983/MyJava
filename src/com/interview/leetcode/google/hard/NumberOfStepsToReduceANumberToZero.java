package com.interview.leetcode.google.hard;

/*
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

Input: num = 8
Output: 4
Explanation:
Step 1) 8 is even; divide by 2 and obtain 4.
Step 2) 4 is even; divide by 2 and obtain 2.
Step 3) 2 is even; divide by 2 and obtain 1.
Step 4) 1 is odd; subtract 1 and obtain 0.

 */
public class NumberOfStepsToReduceANumberToZero {

  /*
  Test example 3 and 4. both output is 3.
  		3=11  --> 2 + 2 - 1 = 3
  		4=100 --> 2 + 1 + 1 - 1 = 3
  	 */
  public int numberOfSteps(int num) {
    String binaryString = Integer.toBinaryString(num); // Get the binary for num, as a String.
    int steps = 0;
    for (char bit : binaryString.toCharArray()) {
      if (bit == '1') { // If the bit is a 1
        steps = steps + 2; // Then it'll take 2 to remove.
      } else { // bit == '0'
        steps = steps + 1; // Then it'll take 1 to remove.
      }
    }
    return steps - 1; // We need to subtract 1, because the last bit was over-counted.
  }

  public int numberOfSteps2(int num) {
    int steps = 0;
    while (num > 0) {
      if ((num & 1) == 1) num--;
      else num = num >> 1;
      steps++;
    }
    return steps;
  }

  public int numberOfStepsSimple(int num) {
    int steps = 0;
    while (num > 0) {
      num = (num % 2 == 0) ? num / 2 : num - 1;
      steps++;
    }

    return steps;
  }
}

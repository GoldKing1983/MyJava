package com.sample.basics;

import java.util.Arrays;

/*
https://leetcode.com/problems/count-primes/description/
https://www.youtube.com/watch?v=I6HrVRGGYNI

Prime Numbers are : 2, 3, 5, 7, 11, 13, 17, 19, 23 and 29.

1) Initially consider all elements as primes. So create a "dp" of boolean of n and set to true.
2) Start from 2. Set multiples of i to false.
	2a) Set all multiples of 2 to false.
	2b) Set all multiples of 3 to false.
	2c) 4 is already set to false. Logically thinking 2 already covered 4.
	2d) Set all multiples of 5 to false.
3) Step2 is done for sqrt(n) times. It is done as per maths or all upComing numbers are covered in lower range itself.
		Ex: n=50...till 7
		Ex: n=100...till 10
4) Count all the prime number in dp array.
 */
public class PrintPrimeNumbers {

  public int countPrimes(int n) {
    int sqrtN = (int) Math.sqrt(n - 1);
    boolean[] dp = new boolean[n];
    Arrays.fill(dp, true);

    for (int currentNumber = 2; currentNumber <= sqrtN; currentNumber++) {
      // Ex: 4 is false. We don't need to do multiplesOf4, because it is already covered in 2.
      if (dp[currentNumber]) {
        // set multiples of currentNumber(Ex: for 2... 2,4,6,8,10...) to false.
        int multiplesOfCurrentNumber = currentNumber + currentNumber;
        while (multiplesOfCurrentNumber < n) {
          dp[multiplesOfCurrentNumber] = false;
          multiplesOfCurrentNumber += currentNumber;
        }
      }
    }
    int count = 0;
    for (int i = 2; i < n; i++) if (dp[i]) count++;
    return count;
  }
}

package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/valid-triangle-number

Similar to ThreeSum problem.
Take a number. do 2sum.   

 */
public class ValidTriangleBetter {
  public static int triangleNumber(int[] arr) {
    Arrays.sort(arr);
    int count = 0, n = arr.length - 1;
    // lets say arr=[10,15,30] thirdNumber=30, firstNumber=10, secondNumber=15
    for (int thirdNumber = n; thirdNumber >= 2; thirdNumber--) {

      int firstNumber = 0, secondNumber = thirdNumber - 1;

      while (firstNumber < secondNumber) {
        if (arr[firstNumber] + arr[secondNumber] > arr[thirdNumber]) {
          count += secondNumber - firstNumber;
          secondNumber--;
        } else firstNumber++;
      }
    }
    return count;
  }
}

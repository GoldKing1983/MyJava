package com.leetcode.maths;

/*

https://www.hackerearth.com/problem/algorithm/magnificent-fountains/description/


 * 1) Take 0th element as result.
 * 2) Do lcm for result and 1stElement. Update result.
 * 3) Do lcm for result and 2ndElement. Update result.
 */
public class LCMOfArrayOfNumbers {

  public static void main(String[] args) {

    int[] nums = {1, 2, 8, 3};
    int n = nums.length;
    int result = nums[0];
    for (int i = 1; i < n; i++) {
      result = lcm(result, nums[i]);

    }
    System.out.println(result);

  }

  private static int lcm(int num1, int num2) {
    return num1 * num2 / gcd(num1, num2);
  }

  /*
    6,8 =2
  
  */
  private static int gcd(int num1, int num2) {
    while (true) {
      int temp = num1;
      num1 = num2 % num1; //2,0
      num2 = temp; // 6,2
      if (num1 == 0) break; //This line cannot go above. Because we are returning num2
    }
    return num2;
  }

}

package com.sample.tricky;

/*
https://leetcode.com/problems/sqrtx/description/

The logic is to breakdown the problem using binary search.
Start from number/2
Ex: for 1000. 1 to 500, 1 to 250, 1 to 125, 1 to 62, 62 to 125... etc....

======return "high"====

Note: (mid*mid) will go beyond Integer.MAX_VALUE range
Option1 : Use mid as long.
Option2 : convert multiplication to division ===>  (mid * mid == target) ===>  (mid == target / mid)

Ex:
 input is 15, low will be 4 and high will be 3.
 input is 8, low will be 3 and high will be 2.
 At anypoint low exceeds high we break the logic and return high

 */
public class SquareRoot {

  public int mySqrt(int x) {
    if (x <= 1) return x;
    return binSearch(2, x / 2, x);
  }

  private int binSearch(int low, int high, int target) {
    if (low > high) return high;
    int mid = low + (high - low) / 2;
    // mid * mid == target ===> converted to  mid == target / mid ===> for overflow issue
    if (mid == target / mid) return mid;
    // mid * mid > target ===> converted to  mid > target / mid ===> for overflow issue
    else if (mid > target / mid) return binSearch(low, mid - 1, target);
    else return binSearch(mid + 1, high, target);
  }
}

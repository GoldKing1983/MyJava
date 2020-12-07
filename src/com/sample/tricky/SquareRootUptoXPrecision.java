package com.sample.tricky;

/*

https://leetcode.com/problems/sqrtx/description/

1) Get the value before precision
2) Ex: For 8 Value Before precision is 2.
=================================Data Flow Analysis for 8 with 2 precision=================================
		===========Updating precision for first digit from left to right===========
Adding precision: 0.1 to Current SquareRoot number: 2.0 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.1

Adding precision: 0.1 to Current SquareRoot number: 2.1 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.2

Adding precision: 0.1 to Current SquareRoot number: 2.2 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.3000000000000003

Adding precision: 0.1 to Current SquareRoot number: 2.3000000000000003 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.4000000000000004

Adding precision: 0.1 to Current SquareRoot number: 2.4000000000000004 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.5000000000000004

Adding precision: 0.1 to Current SquareRoot number: 2.5000000000000004 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.6000000000000005

Adding precision: 0.1 to Current SquareRoot number: 2.6000000000000005 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.7000000000000006

Adding precision: 0.1 to Current SquareRoot number: 2.7000000000000006 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.8000000000000007
	===========Updating precision for second digit from left to right===========
Adding precision: 0.01 to Current SquareRoot number: 2.8000000000000007 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.8100000000000005

Adding precision: 0.01 to Current SquareRoot number: 2.8100000000000005 doesn't exceeds target: 8.
So Updated SquareRoot answer is : 2.8200000000000003
====================================================================================================================================
*/
public class SquareRootUptoXPrecision {

  static float squareRoot(int number, int precision) {
    SquareRoot s = new SquareRoot();
    double ans = s.mySqrt(number);

    double increment = 0.1;
    for (int i = 0; i < precision; i++) {
      while ((ans + increment) * (ans + increment) <= number) {
        ans += increment;
      }
      increment = increment / 10; // For precision 4, divide by .1 then .01 then .001 and .0001
    }
    return (float) ans;
  }

  public static void main(String[] args) {
    System.out.println("Square Root of 25 is: " + squareRoot(25, 2));
    System.out.println("Square Root of 81 is: " + squareRoot(8, 2));
    System.out.println("Square Root of -100 is: " + squareRoot(-100, 2));
    System.out.println("Square Root of 1 is: " + squareRoot(1, 2));
    System.out.println("Square Root of 0 is: " + squareRoot(0, 2));
  }
}

package com.leetcode.maths;

/*
==== GCD of n number can be obtained by gcd of 2 numbers transitively ===
Ex : for 10,15,30.

iteration 1 : Do GCD for 10,15. Result is 5
Whatever the result we get, take that result and do it with next number.
iteration 1 : Do GCD for 5,30.

================================GCD of 2 numbers can be obtained by mod operator====================================
Like School Math, don't think of dividing each number(Ex:10,15) from 2 to n/2. Swap and MOD is the best answer.

1) Swap a and b.
2) In swapping code change, a = b%a
3) If a==0. Result found. Stop swapping.

Input=[15, 10] Output:5

			  a: 15 b: 10 =====>Iteration1
			      \_____
			            \_____
			   				  \
			  a: 10(10%15) b: 15 =====>Iteration2
			      \_____
			            \_____
			   				  \
			  a: 5(15%10)  b: 10  =====>Iteration3
			      \_____
			            \_____
			   				  \
			  a: 0(10%5)   b : 5  =====>Iteration4
=====================================================================================================================
*
*/
public class GCDMaths {
  // GCD of [3,5] = 1...[3,6] = 2
  public int gcd(int a, int b) {
    if (a == 0) return b; // To avoid DivideByZero issue
    while (true) {
      
      int temp = a;
      a = b % a;
      b = temp;
      if (a == 0) return b;
    }

  }

  // a or b can be 0. To avoid DivideByZero issue below method is better.
  // I don't need to add "if (a == 0) return b" in first step like above method.
  public int gcdBetter(int a, int b) {
    while (a != 0) {
      int temp = a;
      a = b % a;
      b = temp;
    }
    return b;
  }

  // Function to find gcd of array of numbers
  int findGCD(int arr[], int n) {
    int result = arr[0];
    for (int i = 1; i < n; i++) {
      result = gcd(result, arr[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    GCDMaths g = new GCDMaths();
    int[] arr = {15, 10, 30};
    // int arr[] = { 4,10 };
    int n = arr.length;
    System.out.println(g.findGCD(arr, n));
    int[] arr1 = {3, 5};
    // int arr[] = { 4,10 };
    n = arr1.length;
    System.out.println(g.findGCD(arr1, n));
  }
}

package com.leetcode.maths;

import java.util.Arrays;

/*
https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd/problem
================================GCD of 2 numbers can be obtained by mod operator====================================
1) Keep the big number as num1 always.
2) In each iteration update num1 = num1 %num2==0) 
3) if num1==0 return num2.
================================GCD of n number can be obtained by gcd of 2 numbers transitively================================
Ex : for 10,15,30.

iteration 1 : Do GCD for 10,15. Result is 5
Whatever the result we get, take that result and do it with next number.
iteration 1 : Do GCD for 5,30. Result is 5
=======================================================Data Flow Analysis========================================================
input: [10,15]

num1=15,num2= 10
num1=10,num2= 5
num1=0,num2= 5
=======================================================Data Flow Analysis========================================================
input: [3,5]

num1=5,num2= 3
num1=3,num2= 2
num1=2,num2= 1
num1=0,num2= 1


*/
public class GCDMaths {

  private int gcd(int num1, int num2) {
    while (true) {
      if (num1 < num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
      }
      num1 = num1 % num2; // 5.. 10..0
      if (num1 == 0) return num2;
    }
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
    System.out.println("gcd of array " + Arrays.toString(arr) + " is " + g.findGCD(arr, n));
    int[] arr1 = {3, 5};
    // int arr[] = { 4,10 };
    n = arr1.length;
    System.out.println("gcd of array " + Arrays.toString(arr1) + " is " + g.findGCD(arr1, n));
  }
}

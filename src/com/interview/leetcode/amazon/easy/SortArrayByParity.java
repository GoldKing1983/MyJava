package com.interview.leetcode.amazon.easy;

/*
* https://leetcode.com/problems/sort-array-by-parity/submissions/
=== Solution====
1) Keep 2 pointer left and right. left points firstData and right points lastData
2) if leftData is even. increment left.
3) if leftData is odd, swap left and right. decrement right.


*/
public class SortArrayByParity {

  public int[] sortArrayByParity(int[] A) {
    int n = A.length;
    int left = 0, right = n - 1;
    while (left <= right) {
      if (A[left] % 2 == 0) {
        left++;
      } else {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;

        right--;
      }
    }
    return A;
  }
}

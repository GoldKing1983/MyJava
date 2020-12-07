package com.interview.leetcode.google.easy;

/*
https://leetcode.com/problems/duplicate-zeros/


Input:  [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]

=======================================Solution Approach=======================================
1) This problem has so many ways to solve. So many corner cases to cover. Odd Length, even length issues.

2) Below solution is like fast-pointer slow-pointer approach.

3) First pass to count the number of 0's.
4) Set write at n+zeroCount-1
5) Second pass is to write in the values in appropriate locations, moving from right to left
6) if( write < n) then write, to avoid IndexOutOfException.... else do rest of logic.

*/

public class DuplicateZeros {
  public void duplicateZeros(int[] arr) {
    int n = arr.length, zeroCount = 0;

    for (int num : arr) if (num == 0) zeroCount++;
    int last = n - 1;
    int write = n + zeroCount - 1;

    while (last >= 0) {

      if (arr[last] != 0) { // Non-zero, just write it in
        if (write < n) arr[write] = arr[last];

      } else { // Zero found, write it in twice if we can
        if (write < n) arr[write] = arr[last];
        write--;
        if (write < n) arr[write] = arr[last];
      }

      last--;
      write--;
    }
  }
}

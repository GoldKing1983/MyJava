package com.interview.leetcode.topic.array;

/*

// This code will work from 0 to 100 numbers
for below questing I started with brutefore n^2... 
then n(log(n)) java sorting... 
then o(k)... where k is the number of elements in bucket... I felt good. lets c...

 */
public class MaximumGap {
  
  private static final int SIZE = 101; // 0 to 100                 

  public int maximumGap(final int[] nums) {
    if (nums == null || nums.length <= 1) return -1;
    boolean[] bucket = new boolean[SIZE];
    for (int num : nums) {
      bucket[num] = true; // ex: num=1... bucket[1] = true;
    }
    // capture the biggest result.
    int result = 0;
    int previousIndex = -1;
    // ex: 1 10 100... 
    for (int i = 0; i < SIZE; i++) {
      if (bucket[i]) { // do the computation for true alone
        if (previousIndex == -1) { //if(previousIndex == -1) then I need for previousIndex first... 
          previousIndex = i; // 1
        } else {
          // get the result...
          int currentResult = i - previousIndex; // 10-1 = 9
          result = Math.max(result, currentResult);
          previousIndex = i;
        }
      }
    }
    return result;

  }
}

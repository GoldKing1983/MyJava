package com.interview.leetcode.topic.binarysearch;

import java.util.Arrays;

/*
https://leetcode.com/problems/divide-chocolate/
https://leetcode.com/problems/divide-chocolate/discuss/555554/Java-with-explanation-binary-search
This problem can be compared to MissingElementInSortedArrayBinarySearch,FindKthSmallestPairDistance,SplitArrayLargestSum
================================================================Requirement:================================================
1) Given an array, split into K partitions of "optimal-continuous" array and return lowest partition value.
2) This problem is almost same as "SplitArrayLargestSum".
Note: K = K+1 because self is not included in argument.

Input: arr = [1,2,3,4,5,6,7,8,9], K = 5 Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

Input: arr = [10,20,10], K = 1 Output: 10
Optimal-Continuous SplitUp is : [10] [20,10] So return smallest i.e 10

=====================================================Solution Approach=====================================================
1) Initialize low with minimal number in array i.e The left bound is max(A),
2) Initialize high with sum of array and "not maximal number" i.e The right bound is sum(A).
3) Pick a number(mid) between low and high. Verify if you can make K partition for that number.
3a) If yes then go right, meaning we can optimize more.
Ex: If I can able to partition into 2 for input [10,20,30] with number 15.
I can try between 15 to 30 to get optimal partitions. Also, going left doesn't make sense.
If I can able to "make" 2 partition for input [10,20,30] with number 15.
Then all numbers between 10 and 15 can still give the same result.

3b) Else go left, meaning to make minimum K partition we still need a small number.

====canCutIntoK() - Verifies whether the array can be "cut into K partitions" for the "number passed"
=====================================================Data Flow Analysis=====================================================
Input: arr = [1,2,3,4,5,6,7,8,9], K = 5 Output: 6
      ============
low: 1, mid: 23, high: 45
Going to verify whether, we can make minimum 6 partitions for the number: 23
Array cannot be cut into minimum required 6 partitions for number 23
So moving left.
      ============
low: 1, mid: 11, high: 22
Going to verify whether, we can make minimum 6 partitions for the number: 11
Array cannot be cut into minimum required 6 partitions for number 11
So moving left.
      ============
low: 1, mid: 5, high: 10
Going to verify whether, we can make minimum 6 partitions for the number: 5
We Need minimum of 6 partitions and Array can be cut into 6 partitions for number 5. The partition is [[1, 2, 3], [4, 5], [6], [7], [8], [9]]
So moving right.
      ============
low: 6, mid: 8, high: 10
Going to verify whether, we can make minimum 6 partitions for the number: 8
Array cannot be cut into minimum required 6 partitions for number 8
So moving left.
      ============
low: 6, mid: 6, high: 7
Going to verify whether, we can make minimum 6 partitions for the number: 6
We Need minimum of 6 partitions and Array can be cut into 6 partitions for number 6. The partition is [[1, 2, 3], [4, 5], [6], [7], [8], [9]]
So moving right.
      ============
low: 7, mid: 7, high: 7
Going to verify whether, we can make minimum 6 partitions for the number: 7
Array cannot be cut into minimum required 6 partitions for number 7
low>high......Exiting
============================================================================================================================
Input: arr = [1,2,3,4,5,6,7], K = 1 Output: 13 ... [1, 2, 3, 4, 5], [6, 7]
      ============
low: 1, mid: 14, high: 28
Going to verify whether, we can make minimum 2 partitions for the number: 14
Array cannot be cut into minimum required 2 partitions for number 14
So Moving Left.
      ============
low: 1, mid: 7, high: 13
Going to verify whether, we can make minimum 2 partitions for the number: 7
We Need minimum of 2 partitions. But Array can be cut upto 3 partitions for number 7. We can still optimize .
The partition is [[1, 2, 3, 4], [5, 6], [7]]
So Moving Right.
      ============
low: 8, mid: 10, high: 13
Going to verify whether, we can make minimum 2 partitions for the number: 10
We Need minimum of 2 partitions and Array can be cut into 2 partitions for number 10. The partition is [[1, 2, 3, 4], [5, 6]]
      ============
low: 11, mid: 12, high: 13
Going to verify whether, we can make minimum 2 partitions for the number: 12
We Need minimum of 2 partitions and Array can be cut into 2 partitions for number 12. The partition is [[1, 2, 3, 4, 5], [6, 7]]
      ============
low: 13, mid: 13, high: 13
Going to verify whether, we can make minimum 2 partitions for the number: 13
We Need minimum of 2 partitions and Array can be cut into 2 partitions for number 13. The partition is [[1, 2, 3, 4, 5], [6, 7]]
============================================================================================================================

 */
public class DivideChocolate {
  public int maximizeSweetness(int[] arr, int partitionSize) {
    int low = Arrays.stream(arr).min().getAsInt();
    int high = Arrays.stream(arr).sum();
    return binSearch(arr, low, high, partitionSize + 1) - 1;
  }

  int binSearch(int[] arr, int low, int high, int partitionSize) {
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    if (canCutArrayIntoKPartitions(arr, mid, partitionSize))
      return binSearch(arr, mid + 1, high, partitionSize);
    return binSearch(arr, low, mid - 1, partitionSize);
  }

  // from 0 to n-1, verify if "sumRequired" with "requiredPartitionSize" can be formed.
  private boolean canCutArrayIntoKPartitions(
      int[] arr, int sumRequired, int requiredPartitionSize) {
    int currentPartitionSize = 0;
    int total = 0;
    for (int i = 0; i < arr.length; i++) {
      total += arr[i];
      if (total >= sumRequired) { // Note it is >= and not ==
        total = 0;
        currentPartitionSize++;
        if (currentPartitionSize == requiredPartitionSize) return true;
      }
    }
    return false;
  }
}

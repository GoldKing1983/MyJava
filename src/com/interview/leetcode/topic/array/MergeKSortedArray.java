package com.interview.leetcode.topic.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*

Solution1:
1) Create a output array of size (n*k).
2) Traverse the matrix from start to end and insert all the elements in output array.
3) Sort and print the output array.

Time Complexity :O((n*k)*log(n*k)).

How--> for n element time complexity is O(n log n)
       here n = n*k. So replace n with (n*k)
       So Time Complexity is O((n*k)*log(n*k)).

Solution2:
  Similar to MergeKSortedListsRecursion.
  

Solution3:
  Similar to MergeKSortedLists
1) Create a minHeap and insert the first element of all k arrays.
2) Remove the top element of the minHeap and add it to result.
3) Now insert the next element from the same array in which the removed element belonged.
4) If the array doesn’t have any more elements... that array can be ignored.

Time Complexity : O( n * k * log k)
        k is total number of array. 
        n is count of elements in all array 

 */
public class MergeKSortedArray {
  public int[] solveUsingPriorityQueue(int[][] lists) {
    // data, row, col, maxSizeOfArray
    Queue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    int n = lists.length;
    for (int row = 0; row < n; row++) {
      if (lists[row].length == 0) continue; // for empty array
      pQ.offer(new int[] {lists[row][0], row, 0, lists[row].length});
    }

    List<Integer> result = new ArrayList<>();
    while (!pQ.isEmpty()) {
      int[] top = pQ.poll();
      result.add(top[0]); // add min polled element to result
      int currentRow = top[1];
      int currentCol = top[2];
      int maxCol = top[3];

      int nextCol = currentCol + 1;
      if (nextCol == maxCol) continue; // fetched all elements in the row

      pQ.offer(new int[] {lists[currentRow][nextCol], currentRow, nextCol, maxCol});

    }
    int[] resultArr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) resultArr[i] = result.get(i);
    return resultArr;
  }

}

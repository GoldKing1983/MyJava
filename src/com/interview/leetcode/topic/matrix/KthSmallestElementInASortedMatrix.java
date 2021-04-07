package com.interview.leetcode.topic.matrix;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/#
 * =======Below is not the best solution===========
 * Because both row and column are sorted, binary search is the best solution. 
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
 * =======Below is not the best solution===========
 * Step 1) Take 0th element from each row and offer it on priority queue.
 * Step 2) When poll a element for the first minimum, offer next element from the same row.
 * Step 3) Repeat step2 until k size.
 * 
 * Step 1 can be in built like taking the first row and comparing with each row...
 * Because matrix is sorted row wise and column wise.  
 * 
 *   Note: This problem is similar to MergetKSortedLists
 */
public class KthSmallestElementInASortedMatrix {

  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    // Adding 1 column from each row to queue
    for (int i = 0; i < matrix.length; i++) {
      int[] tuple = new int[] {matrix[i][0], i, 0};
      q.offer(tuple);
    }
    while (true) {
      int[] top = q.poll();
      int currentData = top[0];
      int currentRow = top[1];
      int currentCol = top[2];

      int nextCol = currentCol + 1;
      if (--k == 0) {
        return currentData;
      }
      if (currentCol + 1 == matrix[0].length) { // Reached maximum column in the row. 
        continue;
      }
      q.offer(new int[] {matrix[currentRow][nextCol], currentRow, nextCol});
    }


  }


  public static void main(String[] args) {
    KthSmallestElementInASortedMatrix k = new KthSmallestElementInASortedMatrix();
    System.out.println(k.kthSmallest(new int[][] {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));

  }

}

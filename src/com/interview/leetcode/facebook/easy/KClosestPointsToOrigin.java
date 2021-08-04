package com.interview.leetcode.facebook.easy;

import java.util.*;

/*
===========================================================Requirement==============================================================
https://leetcode.com/problems/k-closest-points-to-origin
https://www.youtube.com/watch?v=eaYX0Ee0Kcg

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
You may return the answer in any order.

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is 1^2+ 3^2 = 10
The distance between (-2, 2) and the origin is -2^2+ 2^2 = 8
Since 8<10, (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
===========================================================Solution Approach===========================================================
1) Solution1 : Just sort and return top K. O(n(log(n)))
2) Solution2 : Use priorityQueue. O(n(log(k)))
		2a) If I set priorityQueue as minHeap or ascendingOrder. Then answer will be at top.
		I need to wait all "n" element to be pushed and then return topK which is costly by memory and not recommended.
		2b) Set priorityQueue as maxHeap or descendingOrder. Keep only top K or remove more than topK elements.
		Finally return all the elements in priorityQueue. The advantage of this solution is it can deal with real-time(online)
		stream data.
3) Solution3 : Use QuickSelect. Since topK can be of any order, this approach will work.
If topK needs to be in sorted order then Solution3 is not
possible. The average time complexity is O(N) , but just like quick sort, in the worst case, this
solution would be degenerated to O(N^2),
 */
public class KClosestPointsToOrigin {

  // Elements are sorted from Ascending order. So pick 0 to k elements from beginning. O(n(log(n)))
  public int[][] kClosestSimple(int[][] points, int k) {
    Arrays.sort(points, (p1, p2) -> calculateOrigin(p1) - calculateOrigin(p2));
    return Arrays.copyOfRange(points, 0, k);
  }

  private int calculateOrigin(int[] point) {
    int x = point[0];
    int y = point[1];
    return x * x + y * y;
  }

  // Sort the element in descending order. So that we can remove maximum element. O(n(log(k)))
  public int[][] kClosest(int[][] points, int k) {
    // To do the descending order, do (p2-p1)
    PriorityQueue<int[]> q =
        new PriorityQueue<>((p1, p2) -> calculateOrigin(p2) - calculateOrigin(p1));

    for (int i = 0; i < points.length; i++) {
      q.offer(points[i]);
      if (q.size() > k) q.poll();
    }
    int[][] result = new int[k][2];
    while (k > 0) {
      result[--k] = q.poll();
    }
    return result;
  }

  public int[][] kClosestUsingSort(int[][] points, int k) {
    Map<Integer, List<int[]>> result = new TreeMap<>();
    for (int[] point : points) {
      result.computeIfAbsent(calculateOrigin(point), key -> new ArrayList<>()).add(point);
    }
    int[][] finalResult = new int[k][2];
    k--;
    outer:
    for (List<int[]> res : result.values()) {
      for (int[] r : res) {
        finalResult[k] = r;
        if (k-- == 0) break outer;
      }
    }
    return finalResult;
  }
}

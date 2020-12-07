package com.interview.leetcode.google.medium;

import java.util.PriorityQueue;

/*

Requirement Conditions
1) Firstly, all elements in the subsequence should be consecutive integers with no duplicates.
2) Secondly, each subsequence should contain at least 3 elements.
3) No elements should be left.

Input: [1,2,3,3,4,5] Output: True
Explanation: You can split them into two consecutive subsequences :
1, 2, 3
3, 4, 5

Input: [1,2,3,3,4,4,5,5] Output: True
Explanation: You can split them into two consecutive subsequences :
1, 2, 3, 4, 5
3, 4, 5

Input: [2,2,3,3,3,4,4,4,5,5]
Output: True
2,3,4,5
2,3,4
3,4,5

[] -> True (This means that the empty subsequences are also considered a valid sub-sequence
[1,2,3] -> True because [1,2,3] and [] are two valid subsequence splits
[1,2,3,4,4,5] -> False because if you split like [1, 2, 3, 4, 5] and [], there would be a
				duplicate 4 that would be unaccounted for so that's why it is false.
				There isn't a way to split the input into 2 subsequences such that duplicates are
				accounted for and both subsequences have length >= 3.
[1,2,3,4,5] -> True because [1,2,3,4,5] and [] is a valid split

[1, 2, 4, 4, 5, 5, 6, 6] -> False. 1 and 2 are left.

===================================================Solution Approach - Greedy==================================================
1) If there are multiple previous sequences, select the one with smallest length. So use priorityqueue
Ex: Already [2,3,4] and [3,4]is formed, now there is only 5 is left. It must be added to [3,4].

=======================================Data flow analysis=======================================
//        -> 3, 4, 5, 5, 6, 6, 6, 7, 7, 7, 8, 9, 10
//
// create sequence from (3,4,5,6,7), (5,6,7), (6,7,8,9,10)
//
//
// At 3
//    [3] will be created
//
// At 4,
//    [3 4)
//
// At 5
//     [3 4 5)

// At 5
//         [5) will be created
//     [3 4 5)
//
// At 6
//       [3 4 5)
//         [5 6)
// At 6
//         [5 6)
//     [3 4 5 6)

// At 6
//           [6)
//         [5 6)
//     [3 4 5 6)
//
// At 7
//           [5 6)
//       [3 4 5 6)
//           [6 7)

// At 7
//       [3 4 5 6)
//           [6 7)
//         [5 6 7)

// At 7
//           [6 7)
//         [5 6 7)
//     [3 4 5 6 7)
//
// At 8,
//     [3 4 5 6 7]
//         [5 6 7]
//           [6 7 8)
//
// At 9
//     [3 4 5 6 7] --> remove from queue. Because 8 is valid, we can keep, 9 or greater is no longer valid.
//         [5 6 7] --> remove from queue
//       [6 7 8 9)
 *
 *
 * At 10
//           [6 7 8 9 10)
//
//
 */
public class SplitArrayIntoConsecutiveSubsequences {
  // int[0]=end, int[1]=size
  public boolean isPossible(int[] nums) {
    // For 2 same ends, keep the sameEnd with lowest size at top. Else lowestEnd(MinHeap) at top.
    PriorityQueue<int[]> pq =
        new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int i = 0; i < nums.length; i++) {

      while (!pq.isEmpty() && pq.peek()[0] + 1 < nums[i]) if (pq.poll()[1] < 3) return false;

      if (pq.isEmpty()) {
        pq.offer(new int[] {nums[i], 1});
        continue;
      }

      int[] p = pq.peek();
      if (p[0] == nums[i] || p[0] + 1 < nums[i]) pq.offer(new int[] {nums[i], 1});
      else pq.offer(new int[] {nums[i], pq.poll()[1] + 1});
    }

    while (!pq.isEmpty()) if (pq.poll()[1] < 3) return false;

    return true;
  }
}

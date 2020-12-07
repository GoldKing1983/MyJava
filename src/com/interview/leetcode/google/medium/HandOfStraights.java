package com.interview.leetcode.google.medium;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/hand-of-straights/description/
======================================================Requirement================================================================
Alice has a hand of cards, given as an array of integers.
Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
Return true if and only if she can.
======================================================Solution Approach==========================================================
1) Insert all number to priorityQueue.
2) "Poll" the top number from queue.
3) For groupSize-1 try "removing" nextNumber from queue. If not possible return false.

KeyPoint: PriorityQueue is efficiently used to "poll" firstNumber in group and "remove" for "nextNumber" in group.

Time Complexity : O(n(log)n) for pQ + remove() takes O(logN) time.  poll() takes O(logN) time.
In HandOfStraightsTreeMap poll and remove takes O(1) time. So map is better.
=========================================Data Flow Analysis======================================================================
hand = [1,2,3,6,2,3,4,7,8] W=3. Output: True
minHeap = [1, 2, 2, 3, 3, 4, 6, 7, 8]
Number deleted(poll operation) is : 1
Next Number to delete(remove operation): 2 is Found. So continuing
Next Number to delete(remove operation): 3 is Found. So continuing
Number deleted(poll operation) is : 2
Next Number to delete(remove operation): 3 is Found. So continuing
Next Number to delete(remove operation): 4 is Found. So continuing
Number deleted(poll operation) is : 6
Next Number to delete(remove operation): 7 is Found. So continuing
Next Number to delete(remove operation): 8 is Found. So continuing
=========================================Data Flow Analysis======================================================================

hand = [1, 2, 3, 4, 5, 5] W=3. Output: False
Number deleted(poll operation) is : 1
Next Number to delete(remove operation): 2 is Found. So continuing
Next Number to delete(remove operation): 3 is Found. So continuing
Number deleted(poll operation) is : 4
Next Number to delete(remove operation): 5 is Found. So continuing
Next Number to delete: 6 is Not Found. So returning false
=================================================================================================================================
 *
 */
public class HandOfStraights {

  public boolean isNStraightHand(int[] hands, int groupSize) {
    int n = hands.length;
    if (n % groupSize != 0) return false;
    int totalGroup = n / groupSize;
    PriorityQueue<Integer> pQ = new PriorityQueue<>();
    for (int h : hands) pQ.offer(h);

    while (totalGroup-- > 0) {
      Integer topNumber = pQ.poll();
      for (int i = 1; i < groupSize; i++) {
        int nextNumber = topNumber + i;
        if (pQ.remove(nextNumber)) continue;
        return false;
      }
    }
    return true;

  }
}

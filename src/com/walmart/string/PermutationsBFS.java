package com.walmart.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

https://leetcode.com/problems/permutations/
https://www.educative.io/collection/page/5668639101419520/5671464854355968/5720758194012160
=======================================================Solution Approach========================================================
1) Add Empty to result. Empty doesn't mean "". 
   We add "new LinkedList<>()". But size is zero. 
2) For each of currentNumber. For Each of previousCombo. Insert currentNumber to eachIndex of previousCombo.
=======================================================Implementation Trick======================================================
1) Trick to the solution is how the K Loop runs and creates permutations.
2) For each of "oldCombo", K runs "oldCombo + 1" time to create permutations.
Note: This is achieved by running from 0 to oldComboTimes...for (int k = 0; k <= oldCombo.size(); k++) {
3) Each Time K loop inserts current value at old combo of various indexes.
4) During the first time for the empty. oldCombo size is 0. so loop run 1 time and insert 0th element
=============================================Data Flow Analysis==================================================================
Ex: [1,2,3]
		=============Step1 - Adding Empty================
oldCombo [] - 0 size.
		=============Step2 - Adding 1====================
[1]
		=============Step3 - Adding 2====================
oldCombo [1]
[2, 1]
[1, 2]
		=============Step4 - Adding 3====================
OuterLoop
oldCombo [2, 1]
[3, 2, 1]
[2, 3, 1]
[2, 1, 3]
oldCombo [1, 2]
[3, 1, 2]
[1, 3, 2]
[1, 2, 3]
		=================================
*/
public class PermutationsBFS {

  /*
  Time Complexity : N*N! ---> i loop N times, j&k loop combinely N!
  Space complexity N!
   */
  public List<List<Integer>> permute(int[] nums) {
    LinkedList<List<Integer>> queue = new LinkedList<>();
    // Step1) Add Empty as initialResult.
    queue.offer(new ArrayList<>()); // Insert empty at initial
    // Step2) Iterate each of number from index0 to indexN-1.
    for (int currentNumber : nums) {
      int existingComboSize = queue.size();

      // Step3) Pick the currentNumber from indexI. Add currentNumber to each of previousCombo.
      while (existingComboSize-- > 0) {
        List<Integer> oldCombo = queue.poll();
        for (int k = 0; k <= oldCombo.size(); k++) {
          List<Integer> currentCombo = new ArrayList<>(oldCombo);
          currentCombo.add(k, currentNumber);
          queue.offer(currentCombo);
        }
      }
    }
    return queue;
  }
}

package com.sample.tricky;

/*
https://leetcode.com/problems/find-the-celebrity/discuss/

There will be only 1 celebrity or no celebrity
==============BruteForce================
1) For each candidate call other candidate.
Time Complexity : O(n^2)
================Better Solution================
1) Find possible celebrity by comparing adjacent candidate.
   a) Assign 0th person as celebrity.
   b) Verify 0th person knows anyone. If yes that person possibly be celebrity.
   c) Do stepB for n-1 candidate.

2) Now we deduced possible celebrity. Now verify "everyone known him" and "he knows no one".

3) Performance: Add knows method result to localCache and improve it. 
*/
public class FindTheCelebrity {

  public int findCelebrity(int n) {

    // 0-->1
    // 2-->1
    // 2-->0
    // Ans : 1
    // Initially select Celebrity as 0
    // check 0 knows 1... Yes....updatedCelebrity is 1.
    // check 1 knows 2... No....   stillCelebrity is 1.

    int celebrity = 0; // Assume celebrity is 0
    for (int i = 1; i < n; i++) {
      if (knows(celebrity, i)) { // If 0 knows someone then he might be celebrity.
        celebrity = i;
      }
    }
    // Now we deduced celebrity. Now he must be celebrity or no one can.
    // Make sure "everyone known him" and "he knows no one".

    for (int i = 0; i < n; i++) {
      if (i == celebrity) continue;
      if (knows(i, celebrity) && !knows(celebrity, i)) {
        // candidate is good
      } else {
        return -1;
      }
    }
    return celebrity;
  }

  // Not completed fully
  public boolean knows(int i, int j) {
    return true;
  }
}

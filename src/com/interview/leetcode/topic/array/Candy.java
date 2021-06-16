package com.interview.leetcode.topic.array;

import java.util.Arrays;

/*
https://leetcode.com/problems/candy/

===========================================================Requirement===========================================================
1) There are N children standing in a line. Each child is assigned a rating value.
2) You are giving candies to these children subjected to the following requirements:
2a) Each child must have at least one candy.
2b) Children with a higher rating get more candies than adjacent childrens(left or right).
      ex: 1 2 3.... 2 is higher than 1 so it must get more than 1.... 3 is higher than 2 so it must get 1 more than 2.
      ex: 1 3 2...  3 is more than 1 and 2, so it must get more than 1 and 2.
      
3) What is the total candies needed.
=========================================================Initial Thought=========================================================
1) For the current, compare adjacentRating and increment based on anyone adjacent who is low.
2) But the above logic will not work. Because it has go like chain reactions, if I calculate on only 1 side. 
Ex: [5,4,3,2,1] 
    [1,1,1,1,1] - initial
    [2,1,1,1,1] - 5 is greater than 4 so add 1 at index0 
    [2,2,1,1,1] - 4 is greater than 3 so add 1 at index0... Here chain reaction starts. 
    Because now 4 and 5 are getting same number of candy, which is wrong. I need to verify and update all left side again.
    If I code for chain reaction using loop, then Time Complexity is O(n^2). 
    Because If i take example [5,4,3,2,1] for each point, i need to update all left.
     
3) So right solution is from leftToRight compare previous and current. Find max. 
                         from rightToLeft compare current and next. Find max.
4) Pick the max for each point and sum it.
==========================================================Deep Thinking==========================================================
answer for [1,2,3]     is same as     [3,2,1]..... answer: 6
answer for [1,2,3,4,5] is same as [5,4,3,2,1]..... answer: 11    
========================================================Solution Approach========================================================
1) Initial assign 1 candy to all children.
2) Neighbors are calculated from leftToRight and rightToLeft.
3) from leftToRight if current>previous increment candies for that kid.
4) from rightToLeft if previous>current increment candies for that kid.
5) Pick max candies for that kid and sum it.
============================================================Example1=============================================================
Input: [1,2,3]
Output: 6

Initial: [1, 1, 1]
After leftToRight: [1, 2, 3]
After rightToLeft: [1, 1, 1]
                  ==========
  sum+=Math.max()   1+ 2+ 3 = 6       
============================================================Example2=============================================================
Input: [3,2,1]
Output: 6

Initial: [1, 1, 1]
After leftToRight: [1, 1, 1]
After rightToLeft: [3, 2, 1]
                  ==========
  sum+=Math.max()   3+ 2+ 1 = 6       
============================================================Example3=============================================================
Input: [3,2,1,2,3]
Output: 11

Initial: [1, 1, 1]
After leftToRight: [1, 1, 1, 2, 3]
After rightToLeft: [3, 2, 1, 1, 1]
                  ==========
  sum+=Math.max()   3+ 2+ 1+ 2+ 3  = 11       
============================================================Example4=============================================================
Input: [1,0,2]
Output: 5

Initial: [1, 1, 1]
After leftToRight: [1, 1, 2]
After rightToLeft: [2, 1, 2]
                  ==========
  sum+=Math.max()   2 + 1 + 2 = 5       
============================================================Example5=============================================================
Input: [1,2,2]
Output: 4

Initial: [1, 1, 1]
After leftToRight: [1, 2, 1]
After rightToLeft: [1, 2, 1]
  sum+=Math.max()   2 + 1 + 1 = 4       
==============================================================================================================================
 */
public class Candy {
  public int candy(int[] ratings) {
    int n = ratings.length;

    int[] leftToRight = new int[n];
    Arrays.fill(leftToRight, 1);
    for (int i = 1; i < n; i++) {
      int current = ratings[i];
      int previous = ratings[i - 1];
      if (current > previous) {
        leftToRight[i] = leftToRight[i - 1] + 1;
      }
    }

    int[] rightToLeft = new int[n];
    Arrays.fill(rightToLeft, 1);
    for (int i = n - 2; i >= 0; i--) {
      int current = ratings[i];
      int next = ratings[i + 1];
      if (current > next) {
        rightToLeft[i] = rightToLeft[i + 1] + 1;
      }
    }

    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = Math.max(leftToRight[i], rightToLeft[i]);
    }

    int sum = 0;
    for (int r : dp) sum += r;

    return sum;
  }
}

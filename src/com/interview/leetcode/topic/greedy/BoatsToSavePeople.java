package com.interview.leetcode.topic.greedy;

import java.util.Arrays;

/*
===========================================================Requirement===========================================================
1) Given an array of people of their weight.
2) A boat can carry only 2 people at a time, less than or equal to limit.
3) Return the minimum number of boats to carry all the person.
4) weight of the people will be always less than or equal to boat weight carry limit.
============================================================Example1=============================================================
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)
============================================================Example2=============================================================
Input: people = [1,3,1,3], limit = 3 ===> without sorting getting solution for this not possible or I have to run 2 loop.
Output: 3
Explanation: 3 boats (1, 1), (3) and (3)
========================================================Solution Approach========================================================
1) Sort the person by weight. 
      Greedily choose "1 heavy person" and "1 light person" if both are with in limit.
          else choose "1 heavy person" alone.
2) The solution works, because boat can carry only 2 at a time, if three or more... then the solution is complex
 */
public class BoatsToSavePeople {
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int low = 0, high = people.length - 1;
    int maxBoatCount = 0;

    while (low <= high) {
      maxBoatCount++;
      if (people[low] + people[high] <= limit) { // boat can take 2 person
        low++;
        high--;
      } else {// boat can take only 1 person and that person must be heavy person
        high--;
      }
    }

    return maxBoatCount;
  }
}

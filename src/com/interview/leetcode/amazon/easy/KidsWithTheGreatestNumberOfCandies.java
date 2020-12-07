package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.List;

/*
============================================================Requirement==========================================================
Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.

For each kid check if we give extraCandies, whether they can reach biggestNumberOfCandies

==============================================================Example1===========================================================
Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true] 
Explanation:
5 is the biggestNumberOfCandies.
For 0th index. If i give 3 candies, it will reach 5. It is equal to  5. So true.
For 1st index. If i give 3 candies, it will reach 6. It is more than 5. So true.
For 2nd index. If i give 3 candies, it will reach 8. It is more than 5. So true.
For 3rd index. If i give 3 candies, it will reach 4. It is less than 5. So false.
For 4th index. If i give 3 candies, it will reach 6. It is more than 5. So true.
==========================================================Solution Approach======================================================
1) Find the max in array.
2) Iterate each number. If currentNumber+extraCandies >= max. Set true else false. 
 */
public class KidsWithTheGreatestNumberOfCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int largestCandyCount = 0;
    for (int currentCandyCount : candies) {
      largestCandyCount = Math.max(currentCandyCount, largestCandyCount);
    }
    List<Boolean> result = new ArrayList<>(candies.length);

    for (int currentCandyCount : candies) {
      if (currentCandyCount + extraCandies >= largestCandyCount) result.add(true);
      else result.add(false);
    }
    return result;
  }
}

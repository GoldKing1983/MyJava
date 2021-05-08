package com.interview.leetcode.topic.binarysearch;

/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
===========================================================Requirement===========================================================
1) Given a list of sorted characters letters containing only lower-case letters, 
2) Given a target letter target,
3) Find the next element in the list that is larger than the given target.
============================================================Example1=============================================================
letters = ["c", "f", "j"]
target = "a"
Output: "c"
============================================================Example2=============================================================
letters = ["c", "f", "j"]
target = "c"
Output: "f"
============================================================Example3=============================================================
letters = ["c", "f", "j"]
target = "d"
Output: "f"
============================================================Example4=============================================================
letters = ["c", "f", "j"]
target = "j"
Output: "c"
============================================================Example5=============================================================
letters = ["c", "f", "j"]
target = "k"
Output: "c"
========================================================Solution Approach========================================================
1) find 1st greater and not equal..
    
2) if(mid==target)--> move low.. Ex: [c f j] mid=f target=f.. Because answer is 'j'
    
3) if(mid<target) --> move low.. Ex: [c f j] mid=c target=j
    
4) if(mid>target) --> move high.. Ex: [c f j] mid=j target=c

5) Similar to find a ceiling of a number in binary search. In ceil, we return target, if found.
Here we still move right to get next. See also FindClosestElementsCeil.

*/
public class FindSmallestLetterGreaterThanTargetBinarySearch {
  public char nextGreatestLetter(char[] letters, char target) {
    int lowIndex = binSearch(letters, target, 0, letters.length - 1);

    // if the target is at before beginning see Example1. We don't need to worry. Because low=0 and high=-1 
    // if the target is at end or beyond end see Example4 and Example5. Then lowIndex goes beyond arraySize. Return index0 result
    lowIndex = lowIndex >= letters.length ? 0 : lowIndex; // letters[index % letters.length];

    return letters[lowIndex];
  }

  private int binSearch(char[] letters, char target, int low, int high) {
    if (low > high) return low;

    int mid = low + (high - low) / 2;

    if (letters[mid] == target) return binSearch(letters, target, mid + 1, high);

    if (letters[mid] < target) return binSearch(letters, target, mid + 1, high);

    return binSearch(letters, target, low, mid - 1);
  }
}

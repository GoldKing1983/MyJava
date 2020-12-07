package com.interview.leetcode.linkedin.easy;

/*
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

Requirement:Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
find the next element in the list that is larger than the given target.


https://www.educative.io/courses/grokking-the-coding-interview/qA5wW7R8ox7

Similar to find a ceiling of a number in binary search. In ceil, we return target, if found.
Here we still move right to get next.


1) if target matches a letter, then we have to move right.
2) low goes beyond index for the below sample. So mod the result.
	letters = ["c", "f", "j"]
	target = "j"
	Output: "c"
*/
public class FindSmallestLetterGreaterThanTargetBinarySearch {
  public char nextGreatestLetter(char[] letters, char target) {
    int index = binarySearch(letters, target, 0, letters.length - 1);
    return letters[index % letters.length];
  }

  public int binarySearch(char[] letters, char target, int low, int high) {
    if (low > high) return low;
    int mid = (low + high) / 2;
    if (letters[mid] == target) {
      return binarySearch(letters, target, mid + 1, high);
    } else if (letters[mid] > target) {
      return binarySearch(letters, target, low, mid - 1);
    } else {
      return binarySearch(letters, target, mid + 1, high);
    }
  }
}

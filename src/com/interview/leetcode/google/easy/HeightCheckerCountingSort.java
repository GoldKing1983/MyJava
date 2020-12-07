package com.interview.leetcode.google.easy;

/*

Students are asked to stand in non-decreasing order of heights for an annual photo.
Return the minimum number of students that must move in order for all students to be standing in non-decreasing order of height.
Notice that when a group of students is selected they can reorder in any possible way between themselves and
the non selected students remain on their seats.

Input: heights = [1,1,4,2,1,3] Output: 3
Current array : [1,1,4,2,1,3]... Target array  : [1,1,1,2,3,4]
On index 2 (0-based) we have 4 vs 1 so we have to move this student.
On index 4 (0-based) we have 1 vs 3 so we have to move this student.
On index 5 (0-based) we have 3 vs 4 so we have to move this student.

Input: heights = [5,1,2,3,4]
Output: 5

Input: heights = [1,2,3,4,5]
Output: 0
================================================Solution Approach================================================
1) Build the correct order of heights by sorting another array, then compare the two arrays.
2) Use Counting Sort which is efficient for this requirement.
================================================Data flow Analysis================================================
Input: heights = [1,1,4,2,1,3] Output: 3

count = [0, 3, 1, 1, 1]

Student at index0 don't have to change
Student at index1 don't have to change
Student at index2 have to change
Student at index3 don't have to change
Student at index4 have to change
Student at index5 have to change
========================================================================================================================

 */
public class HeightCheckerCountingSort {
  public int heightChecker(int[] heights) {
    int[] count = new int[101];
    for (int height : heights) count[height]++;

    int changeNeeded = 0;
    int heightIndex = 0;
    for (int countIndex = 1; countIndex <= 100; ) {
      if (count[countIndex] == 0) {
        // No Student Found for that index or all students moved
        countIndex++;
      } else {
        if (countIndex == heights[heightIndex]) {
          // Students don't have to change.
          System.out.println("Students dont have to change");
        } else {
          System.out.println("Students have to change");
          changeNeeded++;
        }
        count[countIndex]--;
        heightIndex++;
      }
    }
    return changeNeeded;
  }
}

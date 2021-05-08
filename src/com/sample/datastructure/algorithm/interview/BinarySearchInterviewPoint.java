package com.sample.datastructure.algorithm.interview;

/*

https://leetcode.com/discuss/interview-question/313216/Binary-search-Interview-Questions
https://leetcode.com/discuss/general-discussion/691825/binary-search-for-beginners-problems-patterns-sample-solutions


===============Must See===============
1) FindSmallestLetterGreaterThanTargetBinarySearch
2) FindClosestElementsCeil
3) FindClosestElementsFloor
====================================

Binary Search with no Exit Condition
GuessNumberHigherOrLower, PeakIndexInAMountainArrayBinarySearch



1) When to choose low vs high.
MissingElementInSortedArrayBinarySearch - high selected
FindFirstAndLastPositionOfElementInSortedArrayBinarySearch - high selected for last position of element
SquareRoot - high selected
FindClosestElementsFloor - high selected
TimeBasedKeyValueStoreBinarySearch - high selected
SquareRootUptoXPrecision - high selected
FirstBadVersion - low selected

2) Find Floor - equal or greater - FindClosestElementsFloor, TimeBasedKeyValueStoreBinarySearch, ArrangingCoinsBestBinSearch
	Note: high selected for floor. Because high keep comes to the left to find the first available number
2a) Find Greater - FindSmallestLetterGreaterThanTargetBinarySearch
	Note: low selected

3) Find Ceil - equal or lesser - FindClosestElementsCeil
	Note: low selected for ceil. Because low keep goes to the right find the first available number


4) Find Index Of First Duplicate
5) Find Index Of Last Duplicate

6) Find Closest to Target

7) Compare adjacent from mid --->  FindPeakElement

8) BinarySearch streams - SearchInASortedArrayOfUnknownSize
HIndexBinSearch

=====================================SortedRotatedArray problems=================================================================
1) SearchInRotatedSortedArray
2) Compare firstElement and mid ---> FindMinimumInRotatedSortedArray

 */
public class BinarySearchInterviewPoint {
}

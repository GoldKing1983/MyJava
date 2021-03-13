package com.sample.tricky;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode.com/problems/find-median-from-data-stream/description/
===========================================================Requirement===========================================================
What is Median?
1) In an sorted data,
2) If the input size is odd, we take the middle element/.
3) If the input size is even, we pick two elements in middle and average the 2 numbers.
============================================================Solution Approach =============================================

1) Use Insertion Sort.
1a) Using binary-search find index where number needs to be added.
1b) Then insert the number at appropriate location.
2) Once we have the sorted number, find Median based on size is odd or even.

*/
public class FindMedianFromDataStreamInsertionSort {

}

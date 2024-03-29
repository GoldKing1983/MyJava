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
1) Save the data like "n" shape in to queue. Ex: below

					3        ---> this goes to lowToHigh
 				2      4
 				1      5
 		 highToLow	 lowToHigh
 		 
2) Insert data into both queue equally, starting from lowToHigh.
3) If highToLow top is bigger than lowToHigh top, then swap them.
Ex: 10,20,30

		Offer10:		lowToHigh=[10] 		    highToLow=[]
		
		Offer20:		lowToHigh=[10] 		    highToLow[20]
		
		Offer30:		lowToHigh=[10,30] 		highToLow[20]
		Now swap lowToHigh and highToLow "topValue"
					    lowToHigh=[10,20] 		highToLow[30]
================
Note: To return float. do the type casting or divide the number by 2.0
*/
public class FindMedianFromDataStream {

  // Java Priority Queue is min heap(Ascending) by default. Changing it to Max Heap for Descending
  Queue<Integer> lowToHigh = new PriorityQueue<>(Collections.reverseOrder());
  Queue<Integer> highToLow = new PriorityQueue<>();

  public void addNum(int num) {
    if (lowToHigh.size() == highToLow.size()) {
      lowToHigh.offer(num);
    } else {
      highToLow.offer(num);
    }
    // If HighToLow has big number than lowToHigh. Then swap them.
    if (!highToLow.isEmpty() && lowToHigh.peek() > highToLow.peek()) {
      int temp = lowToHigh.poll();
      lowToHigh.offer(highToLow.poll());
      highToLow.offer(temp);
    }
  }

  public double findMedian() {
    if (lowToHigh.size() == highToLow.size()) return (lowToHigh.peek() + highToLow.peek()) / 2.0;
    return lowToHigh.peek();
  }
}

package com.sample.datastructure.algorithm.interview;

/*

See SortingTimeAndSpaceComplexity.png

1) stable sort - if an element is sorted already, then their position will not change. 
2) in-place sort - don't use additional space to sort. 
3) Time Complexity
4) Space Complexity

1) Quicksort is faster than merge sort and costs less memory. 
2) But Arrays.sort method uses Quicksort for arrays of primitives and merge sort for arrays of objects

Reason is 
1) quicksort is not stable, i.e. equal entries can change their relative position during the sort;
this means that if you sort an already sorted array, the sorted position may/may-not still change.
So stable merge sort is used for objects.
2) Since primitive types have no identity (there is no way to distinguish two ints with the same value), 
stable/not-stable does not matter for them. So quick-sort is better. 

 
 */
public class SortingInterviewPoint {

}

package com.sample.datastructure.graph;

/*
https://www.youtube.com/watch?v=eTaWFhPXPz4&t=1160s
Watch from 14th minute.

1) Group element one by one
2) If there is a cycle. Find of 2 elements will return same.

Ex1: [0,1][0,2][2,3]
		0------1
		|
		|
		2------3
Initial	==> Array Representation[-1,-1,-1,-1]
For 0,1 ==> Array Representation [1,-1,-1,-1]
For 0,2 ==> Array Representation [1,-1, 1,-1] --> 0 and 2 pointing 1. There can be other possibilities too.
For 2,3 ==> Array Representation [1,-1, 1, 1] --> 0,2,3 all pointing 1.

Ex2: [0,1][0,2][2,3][1,3]
		0------1
		|	   |
		|	   |
		2------3
For 1,3 ==> Find returns 1 for both Find1 and Find3. So cycle.


===============================================Time Complexity O(V*E)===============================================
*/
public class DetectCycleInUnDirectedGraphUnionFind {}

package com.sample.datastructure.graph;

/*
	 ----------<---------
	|					 |
    |		  ---->2---->3
	 -->1----|
		      ---->

1) UnionFind cannot be applied to DetectCycleInDirectedGraph because Union has no direction.
2) Ex: If we say Element0 and Element1 are in same group or set. Then there is nothing direction. 
As per UnionFind logic, Element0 can point Element1 or Element1 can point Element0. Don't confuse too much.  
See video from https://www.youtube.com/watch?v=eTaWFhPXPz4&t=1160s 21:00
*/
public class DetectCycleInDirectedGraphUnionFind {}

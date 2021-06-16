package com.sample.datastructure.algorithm.interview;

/*

=====UnionFind======
In an disJoint set of groups
1) Union merges 2 groups together or adds an element to a group.
2) find tells what group the element belongs to or finds "absoluteParent" of element.
================================================

Ex1: Array Representation : [0, -1, 1, 1] ==> (0th index notUsed) ==> -1 represents "absoluteParent"
 		----3---->
				  |---->1
		----2---->

Ex2: Array Representation : [0, -1, 1, 2] ==> (0th index notUsed) ==> -1 represents "absoluteParent"
		----3---->----2---->----1

In both above examples there is only1 group and the "absoluteParent" is 1.
So if we want to add another element to group. It can be added to childOf3 or child2 or childOf1 all are good.

==============Path-Compression:==================
1) Select a "group leader".
2) Remove the "chain of links" that connects to the "group-leader" and
3) Make all the nodes to point to "group leader" directly.
4) This makes the number of hops to 1, rather than so many hops.
============================================================
Algorithm that uses UnionFind- Kruskal Minimum Spanning Tree

Problems on UnionFind
1) NumberOfConnectedComponentsInAnUndirectedGraphUnionFind
2) GraphValidTreeUnionFind
3) ConnectingCitiesWithMinimumCost


 */
public class UnionFindInterviewPoint {}

package com.sample.datastructure.algorithm.interview;

/*
============================================Important Note===============================================================
1) When going in 4 direction logic. visited logic is a must. Because I am going from pointA to pointB un-conditionally.
So "pointB" will come back to "pointA".
2) visited logic could have handled differently. Watch it carefully.
3) Example:
	a) In WallsAndGates "visited" logic is handled by condition "rooms[row][col] < dist"
	b) In NumberOfIslands "visited" logic is handled by condition "grid[r][c] == '0'"
===============================Where to set visited Logic=================================================================
1) Inside recursion, Make sure to set visited logic inside for loop.
2) This makes to write more code.
Ex: In NumberOfIslandsDFS, 2 place I need to update '0'
		a) i have to set "grid[row][col] = '0';" outside for loop and inside
		b) inside recursiongrid[nextRow][nextCol] = '0';
3) I can shorten the code by setting visited logic outside for loop. But that makes too many un-necessary calls.
  Ex: 4*4*4*4*4.
  We can visualize this in queue actually. Change NumberOfIslandsBFS visited logic outside for loop.
  Queue will consume too much memory and runtime increases from 18ms to 50ms.
===========================================================================================================================
1) Queue or BFS ==> used to find the "Path/Shortest-Path" from the root node to the target node.
2) Stack or DFS ==> used to find the "Path" from the root node to the target node.
3) BFS with visited vs BFS without visited.

 */
public class StackQueueInterviewPoint {}

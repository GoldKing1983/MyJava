package com.interview.leetcode.topic.graph;

/*
https://leetcode.com/problems/critical-connections-in-a-network/
===========================================================Requirement===========================================================
1) Given a undirected graph of nodes which are all inter-connected.
2) If I remove any one link, then all the nodes are not reachable.
3) Find that link...It could be one or more
========================================================Solution Approach========================================================
1) BruteForce
2) Remove an edge(link) from the link.
3) Randomly pick anyone node as start node.
4) If all N nodes are not reachable, then the edge is critical link.
5) Continue Step2 to Step4 for all edges.
Time Complexity : O(E*(V+E))... like n^2
 */
public class CriticalConnectionsInANetwork {
}

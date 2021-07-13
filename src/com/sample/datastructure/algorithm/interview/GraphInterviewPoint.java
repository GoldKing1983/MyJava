package com.sample.datastructure.algorithm.interview;

/*
=================================================================Graph Theory====================================================
https://practice.geeksforgeeks.org/tracks/ppc-graph/?batchId=221

What Graph consists of
1) A finite set of vertices also called nodes.
2) A finite set of ordered pair of the form (u, v) called as edge.
The pair is ordered because (u, v) is not the same as (v, u) in case of a directed graph(di-graph).
The pair of the form (u, v) indicates that there is an edge from vertex u to vertex v.
The edges may contain weight/value/cost.

Graph Representation
1) Adjacency Matrix. un-necessary waste of space.
2) Adjacency List. Good. If node start from 0 to n-1.
3) Adjacency Map.
=================================================================BFS and DFS=====================================================
The Breadth First Traversal or BFS traversal of a graph is similar to that of the Level Order Traversal of Trees.

See BFS.java and DFS.java for basic template on algorithm.
BFS always finds the shortest path, assuming the graph is undirected and unweighted.
DFS does not always find the shortest path.
===================================================Graph Must See Problem========================================================
AllPathsFromSourceToTarget - 3Solutions. BFS/DFS/Backtracking
NumberOfConnectedComponentsInAnUndirectedGraphDFS
CourseScheduleDFS
Find Cycle in directed-graph : CourseScheduleDFS
Find Cycle in un-directed-graph : GraphValidTreeDFS
=======================================================Grouping Nodes============================================================
Graph Coloring - FlowerPlantingWithNoAdjacent/PossibleBipartition
Group or MergeNodes - AccountsMergeGraphDFS

============Spanning Tree vs Minimum Spanning Tree(MST)============
1) Spanning Tree is all possible permutation combination of reaching all node from source node.
So If graph has 4 nodes. Then there will be 3 edges to traverse all nodes.

2) Minimum spanning Tree(MST) is about(there will be always more than one solution.)
	a) getting minimum cost to visit all nodes from source node
	b) getting minimum cost to visit all nodes from any node
============================Solving problem with pQ============================================
===problems NetworkDelayTime,CheapestFlightsWithinKStops, ConnectingCitiesWithMinimumCost,
PathWithMinimumEffort,FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance===
1) In above problems, we pick a sourceNode and declare sourceCost to 0, then we push neighbors of sourceNode to pQ.
2) In pQ lowest cost neighbors float on top.
3) We pick the lowestCostNeigbbor and see if all visited. If yes we return output immediately.
4) Else push all neighbors of lowestCostNeigbbor to pQ again. Till exit condition satisfied.
========================================================================
1) Single Source Shortest path - unidirectional(directed graph)
	Algorithm1: Dijkstra's Algorithm - O(E log V) - better in most case
	Algorithm2: BellMan Ford Algorithm - O(V*E) - https://www.youtube.com/watch?v=KudAWAMiQog

	Problems: NetworkDelayTime, CheapestFlightsWithinKStops

2) Any Source Shortest path - bidirectional(undirected graph) : ConnectingCitiesWithMinimumCost.
   Find the cheapest set of edges needed to reach all nodes in a weighted graph.

3) Topological Sort: Arranges the nodes in a directed, acyclic graph in a special order based on incoming edges.
============================Graph Applications - Social Network Design using Graph============================
https://www.youtube.com/watch?v=z5gkMQNSVro&feature=youtu.be --> watch from 10:00 minute
1) Facebook/Instagram - Bidirectional relation between 2 userNodes. Because userA is friend of userB. Then userB is also
friend of userA. A<---->B
    1a) How to suggest friend recommendation on FaceBook. 
      A<--->B<--->C
      On parsing this graph we can suggest userA to userC and userC to userA. 
    1b) How to suggest similar product for user to buy. The product recommendation is not similar to friendRecommendation. It is
    a big system compromised of MachineLearning/GraphTheory etc...      
    https://medium.com/@madasamy/introduction-to-recommendation-systems-and-how-to-design-recommendation-system-that-resembling-
    the-9ac167e30e95    
    
2) Twitter - Unidirectional relation between 2 userNodes. Because userA follows userB. So all tweets created by userB goes
to userA, but not vice-versa.
3) Web-Crawler - SiteA--> SiteB--> SiteC.... At any-point SiteC or SiteB can create loop so use visited[] to avoid loop.
 

 */
public class GraphInterviewPoint {
}

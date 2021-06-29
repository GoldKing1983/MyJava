package com.interview.leetcode.topic.unionfind;

/*
 * https://leetcode.com/problems/graph-valid-tree/discuss/69018/AC-Java-Union-Find-solution

Requirement: Verify given graph is a valid tree.

1) For the graph to be a valid tree, it must have exactly n - 1 edges with no cycle.
2) if number of edges are less, then it is not fully connected or some nodes are hanging.
3) if number of edges are more, then there is cycle.
4) Additionally, if the graph is fully connected and contains exactly n - 1 edges, it can't possibly contain a cycle.
============================================================Example1=============================================================
See Image GraphValidTreeExample1.jpg
Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]].Output: true

				--- 0 ---
			   |    |    |
			   1    2    3
			   |
			   4
============================================================Example2=============================================================
See image GraphValidTreeExample2.jpg
Input: n = 5 and edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]. Output: false

        0
        |
    --- 1 --- 2 --- 3
   |    |			|
   4     -----------

======processing : [0,1]======
0 is pointing 0
1 is pointing 1
Grouping 0 and 1 to 1
Nodes After Grouping : [1, 1, 2, 3, 4]
======processing : [1,2]======
1 is pointing 1
2 is pointing 2
Grouping 1 and 2 to 2
Nodes After Grouping : [1, 2, 2, 3, 4]
======processing : [2,3]======
2 is pointing 2
3 is pointing 3
Grouping 2 and 3 to 3
Nodes After Grouping : [1, 2, 3, 3, 4]
======processing : [1,3]======
1 is pointing 3
3 is pointing 3
Both the nodes are pointing 3. So returning false

============================================================Example3=============================================================
n = 6 and edges = [[0, 5], [4, 0], [1, 2], [4, 5], [3, 2]]. Output: false

							0                 1
						 /     \             /
 						5 ----- 4           2
 										   /
 										  3

======processing : [0,5]======
0 is pointing 0
5 is pointing 5
Grouping 0 and 5 to 5
Nodes After Grouping : [5, 1, 2, 3, 4, 5]
======processing : [4,0]======
4 is pointing 4
0 is pointing 5
Grouping 4 and 0 to 5
Nodes After Grouping : [5, 1, 2, 3, 5, 5]
======processing : [1,2]======
1 is pointing 1
2 is pointing 2
Grouping 1 and 2 to 2
Nodes After Grouping : [5, 2, 2, 3, 5, 5]
======processing : [4,5]======
4 is pointing 5
5 is pointing 5
Both the nodes are pointing 5. So returning false


============================================================Example4=============================================================
n=5 and edges= [[0,1],[1,2],[2,3],[1,3]] Output: false
              0--- 1 --2
                    \  |
                      3

======processing : [0,1]======
0 is pointing 0
1 is pointing 1
Grouping 0 and 1 to 1
Nodes After Grouping : [1, 1, 2, 3, 4]
======processing : [1,2]======
1 is pointing 1
2 is pointing 2
Grouping 1 and 2 to 2
Nodes After Grouping : [1, 2, 2, 3, 4]
======processing : [2,3]======
2 is pointing 2
3 is pointing 3
Grouping 2 and 3 to 3
Nodes After Grouping : [1, 2, 3, 3, 4]
======processing : [1,3]======
1 is pointing 3
3 is pointing 3
Both the nodes are pointing 3. So returning false


 */
public class GraphValidTreeUnionFind {

  public boolean validTree(int n, int[][] edges) {
    int[] root = new int[n]; // initialize n isolated islands

    for (int i = 0; i < n; i++) root[i] = i;// initially assign each node to to point itself.

    for (int[] edge : edges) {
      int sourceNodeGroup = find(root, edge[0]);
      int targetNodeGroup = find(root, edge[1]);

      // if two vertices happen to be in the same set then there's a cycle
      if (sourceNodeGroup == targetNodeGroup) return false;

      // union
      root[sourceNodeGroup] = targetNodeGroup;
      n--;
    }
    return n == 1;
  }

  public int find(int[] root, int id) {
    while (true) {
      if (root[id] == id) return id;
      id = root[id];
    }

  }

}

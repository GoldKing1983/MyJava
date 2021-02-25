package com.interview.leetcode.topic.tree;

import com.interview.leetcode.Node;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
https://leetcode.com/problems/find-root-of-n-ary-tree/

1) Given all the nodes of N-Ary Tree in random order, return the root.

Ex: Assume below is the actual tree.
                 1
              /  |  \
             2   3   4
            / \
           5   6

2) Input may come as [2,3,4,5,6,1] or [1,2,3,4,5,6] or [6,5,4,3,2,1]
3) any combinations but all the nodes will come in input list.

========================================================Solution Approach========================================================
1) Iterate each node and add its child to set.
2) Iterate each node again. If the node is not present in set, then that node is root. Because
only root node will not have child.
=======================================================Data Flow Analysis========================================================
Ex: Assume below is the actual tree.
                 1
              /  |  \
             2   3   4
            / \
           5   6
input = [6,5,4,3,2,1]
=======Loop1=======
1) 6 has no child. So set=[]
2) 5 has no child. So set=[]
3) 4 has no child. So set=[]
4) 3 has no child. So set=[]
5) 2 has child 5 and 6. So set=[5,6]
6) 1 has child 2,3,4. So set=[2,3,4,5,6]
=======Loop2=======
1 is not found in set. So 1 is the result.
=================================================================================================================================

 */
public class FindRootOfNAryTree {

    public Node findRoot(List<Node> tree) {

        Set<Node> seen = new HashSet<>();

        // For each node in the tree
        for (Node node : tree) {
            // For each of the current node, add children to set
            for (Node child : node.children) seen.add(child);
        }

        // For each node in the tree, if node doesn't exist in the set, return it as it's our root
        for (Node node : tree) {
            if (seen.contains(node)) continue;
            return node;
        }
        return null;
    }
}

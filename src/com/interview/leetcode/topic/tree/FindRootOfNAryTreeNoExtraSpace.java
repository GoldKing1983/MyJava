package com.interview.leetcode.topic.tree;

import com.interview.leetcode.Node;

import java.util.List;

/*
https://leetcode.com/problems/find-root-of-n-ary-tree/
========================================================Solution Approach========================================================
1) Understand the requirement/solution of FindRootOfNAryTree.
2) Input has a constraint i.e value will be from 1 to n. So we can use that property.
=======================================================Data Flow Analysis========================================================
Ex: Assume below is the actual tree.
                 1
              /  |  \
             2   3   4
            / \
           5   6
=======Loop1=======
sumOfChildNodesValue = 2+3+4+5+6 = 20.
sumOfAllNodesValue = 1+2+3+4+5+6 = 21.
rootNodeValue = sumOfAllNodesValue - sumOfChildNodesValue;
=======Loop2=======
Iterate the input nodes again. if (rootNodeValue == currentNode.val) return node;
=======================================================Data Flow Analysis========================================================
Ex: Assume below is the actual tree.
                 6
              /  |  \
             5   4   3
            / \
           2   1
=======Loop1=======
sumOfChildNodesValue = 1+2+3+4+5 = 15.
sumOfAllNodesValue = 1+ 2+3+4+5+6 = 21.
rootNodeValue = sumOfAllNodesValue - sumOfChildNodesValue = 6;
=======Loop2=======
Iterate the input nodes again. if (rootNodeValue == currentNode.val) return node;

=================================================================================================================================

 */
public class FindRootOfNAryTreeNoExtraSpace {

    public Node findRoot(List<Node> tree) {

        int sumOfChildNodesValue = 0;
        int sumOfAllNodesValue = 0;
        // For each node in the tree
        for (Node currentNode : tree) {
            sumOfAllNodesValue += currentNode.val;
            // For each of the current node, add children to set
            for (Node child : currentNode.children) {
                sumOfChildNodesValue += child.val;
            }
        }
        int rootNodeValue = sumOfAllNodesValue - sumOfChildNodesValue;

        // For each node in the tree, if node doesn't exist in the set, return it as it's our root
        for (Node currentNode : tree) {
            if(rootNodeValue == currentNode.val) return currentNode;
        }
        return null;
    }
}

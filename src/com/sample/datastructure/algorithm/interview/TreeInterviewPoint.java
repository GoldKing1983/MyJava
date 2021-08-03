package com.sample.datastructure.algorithm.interview;

/*
=======================Traversal style -- Pre-Order / In-order /Post-order==========================================
Pre-order traversal is to visit the root first. Then traverse the left subtree. Finally, traverse the right subtree.
Top-Down recursion is Pre-Order Traversal

In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.

Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.
Bottom-Up recursion is Post-Order Traversal
===============================When to Use Pre-Order / In-order /Post-order=========================================
Pre-order: Used to create a copy of tree Example : If you want to create a replica of a tree and need node
values in an array and when you insert those values from index 0 to end in a new tree, you get a replica
Ex: ConstructBinarySearchTreeFromPreorderTraversal

In-order: : In BST, to get values of node in ascending/descending order 

Post-order:  
In post-order we will have root/left/right... all node in hand. So case where we need all 3 node in hand
Ex: 
DeleteNodesAndReturnForest -- Note:  root.left=recur()....you cannot do TreeNode leftResult... because this code changes tree.
LowestCommonAncestorOfABinaryTreeOrLCADetail - Note: TreeNode leftResult
RangeSumQueryMutable - update method.

1) When you want to delete a tree from leaf to root. Reason is when you delete a node,
you will delete its left child and its right child before you delete the node itself.
2) Also post-order is widely use in mathematical expression. See BasicCalculatorInfixToPostFixApproach

=============Tree Problems - must see - very basics======
1) HeightBalancedTree
2) SymmetricTreeBottomUp
3) SumRootToLeafNumbersBottomUp
4) PathSum and PathSumII
5) FindLeavesOfBinaryTreeBottomUpRecurse 
6) BinaryTreeLevelOrderTraversalDFS
7) BinaryTreePathsBackTrack/BinaryTreePathsClone
8) LowestCommonAncestorOfABinaryTreeOrLCADetail
9) ConstructBinarySearchTreeFromPreorderTraversal
10) ConstructBinaryTreeFromPreorderAndInorderTraversal

=====================================Problem that depend on tree index===============================================
IndexingNode at each level....MaximumWidthOfBinaryTree
ShuffleTheArray/DecompressRunLengthEncodedList -->similar indexing like binaryTree
CompleteBinaryTreeInserter
=============BST Problems - must see - very basics======
1) TrimABinarySearchTreeRecursionMust
2) ConvertSortedArrayToBinarySearchTree
3) TreeHeight/BalancedBinaryTree
4) MergeTwoBinaryTreesBottomUpClone
5) CloneTree/CloneNAryTree/CloneGraphDFS
6) InvertBinaryTreeOrMirrorOfTreeBottomUp
7) ClosestBinarySearchTreeValue


=============Count left and right======
1) CountCompleteBinaryTreeNodes
2) SumRootToLeafNumbersBottomUp
3) DiameterOfBinaryTreeOrLongestPath
4) TreeDiameter
5) BinaryTreeMaximumPathSum
=============Max between left and right======
1) HouseRobberIII
2) TreeHeight / DiameterOfBinaryTreeOrLongestPath
=============================Insertion of a node through recursion=============================
1) InsertIntoABinarySearchTree,
2) MergeTwoSortedListsClone / MergeTwoBinaryTreesBottomUpClone
3) ConstructBinarySearchTreeFromPreorderTraversal
=====================================Deletion of a Node=====================================
1) DeleteNodesAndReturnForest
2) TrimABinarySearchTreeRecursionMust
=====================================Convert Tree to Graph=====================================
AllNodesDistanceKInBinaryTree
 */
public class TreeInterviewPoint {
}

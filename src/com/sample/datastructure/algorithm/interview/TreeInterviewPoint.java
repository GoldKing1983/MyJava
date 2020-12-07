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

In-order: : To get values of node in non-increasing order (BST)

Post-order:  1) When you want to delete a tree from leaf to root. Reason is when you delete a node,
you will delete its left child and its right child before you delete the node itself.
2) Also post-order is widely use in mathematical expression. See BasicCalculatorInfixToPostFixApproach
=====================================Problem that depend on tree index===============================================
IndexingNode at each level....MaximumWidthOfBinaryTree
ShuffleTheArray/DecompressRunLengthEncodedList -->similar indexing like binaryTree

=============BST Problems - must see - very basics======
1) TrimABinarySearchTreeRecursionMust
2) ConvertSortedArrayToBinarySearchTree
3) TreeHeight/BalancedBinaryTree
4) MergeTwoBinaryTreesBottomUpClone
5) CloneTree/CloneNAryTree/CloneGraphDFS
6) InvertBinaryTreeOrMirrorOfTreeBottomUp

=============Tree Problems - must see - very basics======
1) BinaryTreePathsBackTrack/BinaryTreePathsClone

=============Count left and right======
1) CountCompleteBinaryTreeNodes
2) SumRootToLeafNumbersBottomUp
3) DiameterOfBinaryTreeOrLongestPath
4) TreeDiameter
=============================Insertion of a node through recursion=============================
1) InsertIntoABinarySearchTree,
2) MergeTwoSortedListsClone / MergeTwoBinaryTreesBottomUpClone
3) ConstructBinarySearchTreeFromPreorderTraversal
=====================================Deletion of a Node=====================================
1) DeleteNodesAndReturnForest
=====================================Convert Tree to Graph=====================================
AllNodesDistanceKInBinaryTree
 */
public class TreeInterviewPoint {
}

package com.interview.leetcode.amazon.medium;

import java.util.LinkedList;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

				           1
				         /   \
				        2     3
				       / \   / \  
				      4   5 6   7

1) If only one node(node1 or node2) is found in entireTree. This approach returns "null" as result, which is logically right.
Other solutions returns node1 or node2 whichever is found. 
2) If both node1 and node2 are notPresent in entireTree, all the solutions, returns null.
3) Keep this solution in mind, verify with interviewer before solving the problem.

==================================================Solution Approach==============================================================
1) Traverse tree. Save path from root to node1 in a list. 
2) Traverse tree. Save path from root to node2 in a list.
3) Iterate from top to bottom of both list, Keep update result from top to bottom.

 */

public class LowestCommonAncestorOfABinaryTreeAlternateApproach {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2) {
    LinkedList<TreeNode> node1Path = new LinkedList<>();
    LinkedList<TreeNode> node2Path = new LinkedList<>();
    findPath(root, node1, node1Path);
    findPath(root, node2, node2Path);
    int n1 = node1Path.size(), n2 = node2Path.size();
    TreeNode commonParent = null;
    for (int i = 0; i < n1 && i < n2; i++) {
      TreeNode currentNode1 = node1Path.get(i);
      TreeNode currentNode2 = node2Path.get(i);
      if (currentNode1 == currentNode2) commonParent = currentNode1;
      else break;
    }
    return commonParent;
  }

  private boolean findPath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
    if (root == null) return false;
    path.add(root);
    if (root == target) return true;
    boolean left = findPath(root.left, target, path);
    boolean right = findPath(root.right, target, path);
    if (left || right) return true;
    // backtrack if target matched on both side
    path.removeLast();
    return false;


  }
}

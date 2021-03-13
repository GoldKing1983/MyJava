package com.interview.leetcode.ebay;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/subtree-of-another-tree/description/
====================================================Requirement==================================================================
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a 
subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be 
considered as a subtree of itself.
=======================================================Example1==================================================================
                                                Given tree s:
                                                     3
                                                    / \
                                                   4   5
                                                  / \
                                                 1   2
                                                Given tree t:
                                                   4 
                                                  / \
                                                 1   2
                                  Return true, because t has the same structure and node values with a subtree of s.

                                s = ,3,4,1##,2##,5##
                                t = ,4,1##,2##

=======================================================Example2==================================================================
                                              Given tree s:
                                              
                                                   3
                                                  / \
                                                 4   5
                                                / \
                                               1   2
                                                  /
                                                 0
                                              Given tree t:
                                                 4
                                                / \
                                               1   2
                                              Return false.
                                  s = ,3,4,1##,2,0###,5##
                                  t = ,4,1##,2##

=======================================================Solution Approach - Time Complexity O(m*n)================================
1) Serialize the String s. Refer "SerializeAndDeserializeBinaryTreeRecursionBestPreOrder" for serialization analysis.
2) Serialize the String t.
3) If s.contains(t) return true else false.

 */
public class SubtreeOfAnotherTreeSerializeApproach {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    StringBuilder sString = new StringBuilder();
    StringBuilder tString = new StringBuilder();
    serialize(s, sString);
    serialize(t, tString);
    return sString.toString().contains(tString.toString());
  }

  private void serialize(TreeNode cur, StringBuilder res) {

    if (cur == null) {
      res.append("#");
      return;
    }
    res.append(",").append(cur.val);
    serialize(cur.left, res);
    serialize(cur.right, res);
  }
}

package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
=======================================================Example3==================================================================
                                              Given tree s:
                                              
                                                   3
                                                  / \
                                                 3   5
                                                / \
                                               1   2
                                              Given tree t:
                                                 3
                                                / \
                                               1   2
                                               
                                              Return true.
=======================================================Solution Approach - Time Complexity O(m*n)================================
Step1) a) Push all the nodeValue with node to map.
       b) Duplicates can occur. See Example3: nodeWithValue3 occurred 2 times. So keep key as nodeValue and node as list.

Step2) a) Get the ListOfSearchKeyNodes from map by "s" nodes key.
       b) In Example3. We look for 3 in map. Map will return List<Node> with 3.
       c) For each of List<Node> call isSame.
        


 *
 */
public class SubtreeOfAnotherTreeBFS {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    if (s == null) return false;
    Deque<TreeNode> q = new LinkedList<>();
    q.offer(s);
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode sNode = q.poll();
        map.computeIfAbsent(sNode.val, (k) -> new ArrayList<>()).add(sNode);
        if (sNode.left != null) q.offer(sNode.left);
        if (sNode.right != null) q.offer(sNode.right);
      }
    }

    List<TreeNode> list = map.get(t.val);
    if (list == null) return false;
    for (TreeNode sNode : list) {
      boolean isSame = isSame(sNode, t);
      if (isSame) return true;
    }
    return false;

  }

  private boolean isSame(TreeNode s, TreeNode t) {
    if (s == null && t == null) return true;
    if (s == null || t == null) return false;

    if (s.val != t.val) return false;

    return isSame(s.left, t.left) && isSame(s.right, t.right);
  }
}

package com.interview.leetcode.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*

1) This problem cannot easily solved using DFS.
2) Because as per complete-binary-tree, nodes are filled from left to right. 
========================================================Solution Approach========================================================
1) Do BFS.
2) At any point if null node is seen. Then everything must be null after it. Then it is valid complete-binary-tree. 
3) See below tree - answer is true... Because we have not seen any notNullNode after nullNode.

                 1
                / \
               2   3
          queue=[1]
          queue=[2,3]
          queue=[null, null, null, null]
          
4) See below tree - answer is false... Because we are seeing notNullNode after nullNode.                  
                
                  1
                   \
                    3 
          queue=[1]
          queue=[null,2]
          after processing null 2 is found, so false.          
                    
                   
 * 
 */
public class CheckCompletenessOfABinaryTree {
  public boolean isCompleteTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean seenEmpty = false;

    while (!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr != null) {
        if (seenEmpty) return false; // if currentNode is notNull and already we have seen nullNode. return false.
        queue.offer(curr.left);
        queue.offer(curr.right);
      } else {
        seenEmpty = true;
      }
    }

    return true;
  }
}

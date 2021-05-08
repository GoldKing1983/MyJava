package com.interview.leetcode.topic.tree;

import java.util.LinkedList;
import java.util.Queue;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

=============Note: Previous result for root node is 0.=====================
				    1        -----level0------
				   / \
				  0   1      -----level1------
		   -----level0------
   					0*2+1 = 1
   		   -----level1------
 					1*2+0 = 2
 					1*2+1 = 3
 					      ===
 					        5
 */
public class SumOfRootToLeafBinaryNumbersBFS {
  public int sumRootToLeaf(TreeNode root) {
    int result = 0;
    Queue<Object[]> queue = new LinkedList<>();
    queue.offer(new Object[] {root, 0});
    while (!queue.isEmpty()) {
      Object[] curr = queue.poll();
      TreeNode currNode = (TreeNode) curr[0];
      if (currNode == null) continue;
      int currentNumber = (Integer) curr[1];
      currentNumber = currentNumber * 2 + currNode.val;
      if (currNode.left == null && currNode.right == null) {
        result += currentNumber;
        continue;
      }
      queue.offer(new Object[] {currNode.left, currentNumber});
      queue.offer(new Object[] {currNode.right, currentNumber});

    }
    return result;
  }

}

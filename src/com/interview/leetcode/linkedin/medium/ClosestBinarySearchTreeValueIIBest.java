package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks

Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
===========================================================Solution Approach===========================================================
1) Do In-Order Traversal.
2) Eagerly add k elements to result.
3) Once k elements is added. Start Sliding Window.
4) If (target-firstResult > currentNodeValue-target). Then remove firstResult and add currentNodeValue.
5) Else Sliding Window completed. No further processing needed. return result.
===========================================================Data Flow Diagram===========================================================
Ex1: [100,80,120,70,90,110,130], target = 95, k = 3 Ans: [80,90,100]
						100
					  /	   \
					80		120
				  /  \      /  \
				70    90  110  130

Sorted Value or InOrder Traversal will give : [70,80,90,100,110,120,130]
Initial Result - [70,80,90]
Result Updated to - [80,90,100] --> Because -->  target-firstResult > currentNodeValue-target --> 95-70 > 100-95
When 110 is processed. Sliding Window is terminated. So after 110 no more further processing needed return result.

Ex2: Above input with target = 95 k = 1 Ans: [70]
Sorted Value or InOrder Traversal will give : [70,80,90,100,110,120,130]
Initial Result - [70]
Result Updated to - [80] --> Because -->  target-firstResult > currentNodeValue-target --> 95-70 > 80-95
Result Updated to - [90] --> Because -->  target-firstResult > currentNodeValue-target --> 95-80 > 90-95
When processing 100.... 90 and 100 has same priority over 95. Since requirement says this case cannot come or
input is unique such that 2 same results cannot come, choosing 90 still works.
*/
public class ClosestBinarySearchTreeValueIIBest {

  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    return closest(root, target, k, new LinkedList<>());
  }

  private LinkedList<Integer> closest(
      TreeNode node, double target, int k, LinkedList<Integer> result) {
    if (node == null) return result;
    closest(node.left, target, k, result);

    if (result.size() < k) result.add(node.val);
    else {
      if (target - result.getFirst() > node.val - target) {
        result.removeFirst();
        result.add(node.val);
      } else return result;
    }

    return closest(node.right, target, k, result);
  }
}

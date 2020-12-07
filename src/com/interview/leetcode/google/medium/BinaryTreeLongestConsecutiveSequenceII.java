package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;
import java.util.stream.IntStream;

/*

https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii/

Similar to BinaryTreeMaximumPathSum

 */
public class BinaryTreeLongestConsecutiveSequenceII {
  public int longestConsecutive(TreeNode root) {
    recur(root);
    return maxLongestSequence;
  }

  int maxLongestSequence = 0;

  public int[] recur(TreeNode root) {
    if (root == null) return new int[] {0, 0};

    int[] left = recur(root.left), right = recur(root.right);

    int leftIncrMax = (root.left != null && root.val == root.left.val + 1) ? left[0] + 1 : 1;
    int leftDecrMax = (root.left != null && root.val == root.left.val - 1) ? left[1] + 1 : 1;
    int rightIncrMax = (root.right != null && root.val == root.right.val + 1) ? right[0] + 1 : 1;
    int rightDecrMax = (root.right != null && root.val == root.right.val - 1) ? right[1] + 1 : 1;

    int leftIncrOrDecrMax = Math.max(leftIncrMax, rightIncrMax);
    int rightIncrOrDecrMax = Math.max(leftDecrMax, rightDecrMax);
    int maxIncludingParent = leftIncrOrDecrMax + rightIncrOrDecrMax - 1;
    
    maxLongestSequence =
        IntStream.of(leftIncrOrDecrMax, rightIncrOrDecrMax, maxIncludingParent, maxLongestSequence)
            .max()
            .getAsInt();

    return new int[] {leftIncrOrDecrMax, rightIncrOrDecrMax};
  }
}

package com.interview.leetcode.google.easy;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/find-mode-in-binary-search-tree/
*
* Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
*
* What is mode? In sequence of number maximum number of occurrence of a number is mode.
* Ex: [1,2,2,3] Ans: 2
* Ex: [1,2,2,3,3] Ans: 2,3
* Ex: [1,2,3] Ans: 1,2,3

=======================Solution====================
1) If I traverse BST in In-Order then I will get sorted number.
2) Now the problem is as simple as finding mode in sorted number.
3) If previous number is same as current number, then increment currentDup.
4) Compare currentDup and maxDup.
5) If maxDupCount==currentDupCount (Ex: [1,2,2,3,3]) Then second answer found.
6) If currentDupCount>maxDupCount then new answer found.

*/
public class FindModeInBinarySearchTree {
  List<Integer> mode = new ArrayList<>();
  int currentDupCount = 1;
  int maxDupCount = 1;
  long prev = Long.MAX_VALUE;

  public int[] findMode(TreeNode root) {
    recur(root);
    int result[] = new int[mode.size()];
    for (int i = 0; i < mode.size(); i++) result[i] = mode.get(i);
    return result;
  }

  private void recur(TreeNode root) {
    if (root == null) return;
    recur(root.left);
    if (prev == Long.MAX_VALUE) {
      prev = root.val;
      mode.add(root.val);
    } else {
      if (prev == root.val) {
        currentDupCount++;
        if (currentDupCount > maxDupCount) {
          maxDupCount = currentDupCount;
          mode.clear();
          mode.add(root.val);
        } else if (currentDupCount == maxDupCount) mode.add(root.val);
      } else if (maxDupCount == 1) mode.add(root.val);
      else currentDupCount = 1;

      prev = root.val;
    }
    recur(root.right);
  }
}

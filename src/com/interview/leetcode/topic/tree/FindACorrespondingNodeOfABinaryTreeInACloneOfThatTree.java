package com.interview.leetcode.topic.tree;

import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
===========================================================Requirement===========================================================
1) Given a original and cloned node. Given "targetNode in original", return "clonedNode in cloned".
2) "targetNode in original always exist"
========================================================Solution Approach========================================================
1) We can completely ignore original node. Because we compare by value and not reference.
2) So traverse clonedNode in recursion. If targetNode.val == clonedNode.val return clonedNode.

 */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public final TreeNode getTargetCopyBest(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return findCopy(cloned, target);
    }

    // Below code Traverse till the result is found.
    // Ex: if result is at extreme left then Time Complexity is O(h) atmost.
    private TreeNode findCopy(final TreeNode cloned, final TreeNode target) {
        if (cloned == null) return null;
        if (cloned.val == target.val) return cloned;
        TreeNode left = findCopy(cloned.left, target);
        if (left != null) return left;
        TreeNode right = findCopy(cloned.right, target);
        return right;
    }

    // Below code Traverse the entire tree
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) return null;
        if (original.val == target.val) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left != null ? left : right;
    }
}

package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees,
you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure(left and right) with same node values.
==========================================================Solution Approach====================================================
Based on Solution "SerializeAndDeserializeBinaryTreeRecursionBest"
1) Serialize the node from Bottom-Up or from leaf node.
In case of "SerializeAndDeserializeBinaryTreeRecursionBest", serialization happens from Top To Bottom Pre-Order.
2) Create a "prefixSerializedValue" from leaf and save it in map.
3) If the prefixSerializedValue count == 2 then there is a duplicate occured at second time.
4) To skip duplication which occurs more than 3rd time,4th time ++++times --> do "prefixSerializedValue count == 2".
So that only during second time node will be saved and rest of time ignored.
===============================================Data Flow Analysis==============================================================
								4
							   / \
							  n   n
Current Serial Value for the leaf: 4,#,#. Map Updated to: {4,#,#=1}
========================================================================================================
								  2
								 /
								4
							   / \
							  n   n
Current Serial Value for the leaf: 2,4,#,#,#. Map Updated to: {4,#,#=1, 2,4,#,#,#=1}
========================================================================================================
								4
							   / \
  							  n   n
Current Serial Value for the leaf: 4,#,#. Map Updated to: {4,#,#=2, 2,4,#,#,#=1}
Found Duplicate for the Current Serial Value: 4,#,#
========================================================================================================
								  2
								 /
								4
							   / \
							  n   n
Current Serial Value for the leaf: 2,4,#,#,#. Map Updated to: {4,#,#=2, 2,4,#,#,#=2}
Found Duplicate for the Current Serial Value: 2,4,#,#,#
========================================================================================================
								4
							   / \
							  n   n
Current Serial Value for the leaf: 4,#,#. Map Updated to: {4,#,#=3, 2,4,#,#,#=2}
Not a duplicate because count reached more than 2 or this duplicate is already saved in result.
========================================================================================================
						         3
						        / \
						       2   4
						      /
						     4
Current Serial Value for the leaf: 3,2,4,#,#,#,4,#,#. Map Updated to: {4,#,#=3, 2,4,#,#,#=2, 3,2,4,#,#,#,4,#,#=1}
========================================================================================================
Current Serial Value for the leaf: 1,2,4,#,#,#,3,2,4,#,#,#,4,#,#.
Map Updated to: {1,2,4,#,#,#,3,2,4,#,#,#,4,#,#=1, 4,#,#=3, 2,4,#,#,#=2, 3,2,4,#,#,#,4,#,#=1}

================================================================================================================================
Example 1:

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
The following are two duplicate subtrees:

      2
     /
    4
and

    4
Therefore, you need to return above trees' root in the form of a list.
 */
public class FindDuplicateSubtrees {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    serialize(root, result, new HashMap<>());
    return result;
  }

  private String serialize(
      TreeNode root, List<TreeNode> result, Map<String, Integer> prefixSerialMap) {
    if (root == null) return "#";
    String leftSerial = serialize(root.left, result, prefixSerialMap);
    String rightSerial = serialize(root.right, result, prefixSerialMap);
    String prefixSerial = root.val + "," + leftSerial + "," + rightSerial;
    prefixSerialMap.put(prefixSerial, prefixSerialMap.getOrDefault(prefixSerial, 0) + 1);
    if (prefixSerialMap.get(prefixSerial) == 2) result.add(root);
    return prefixSerial;
  }
}

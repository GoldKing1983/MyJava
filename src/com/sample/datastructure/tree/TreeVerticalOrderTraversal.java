package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

Condition1) index data has higher precedence. So TreeMap sorts by index.
Condition2) if multiple data found in same index, then go by level. If there are multiple values in same level. Then sort by lowest


Note: In below 1 and 5 and 6 are purposely changed. From the below tree keep only 1,5,6 in mind.
	  Recursion picks 5 first with index=0 and level=0
	  Then 6 with index=0 and level=2. 5 also with index=0 and level=2.
	  So now 1 and 5 and 6 all indexes are 0.
	  Now output picks 5 as first because it got lowest level of 0.
	  6 and 1 falls under same level of 2. As per Condition2 sort them and add it to result.

 						5
 					  /   \
 			  		2	    3
 			  	  /  \	   /  \
 				 4	  6	  1    7
====================level ============================================
 						0
 					  /   \
 			  		1	    1
 			  	  /  \	   /  \
 				 2	  2	  2    2
=====================Index================================================
 						0
 					  /   \
 			  	   -1	    1
 			  	  /  \	   /  \
 				-2	  0	  0     2
==================================================================
 		So 5 and 6 are falling in same group.
 		So the node value of 5 comes first and then 6.
 		Output: [[4],[2],[5,1,6],[3],[7]]
 */
public class TreeVerticalOrderTraversal {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
    dfs(root, 0, 0, map);
    List<List<Integer>> result = new ArrayList<>();
    int resultIndex = 0;
    for (TreeMap<Integer, List<Integer>> treeMap : map.values()) {
      result.add(new ArrayList<>()); // will be added at last. So increment resultIndex.
      for (List<Integer> nodes : treeMap.values()) {
        Collections.sort(nodes);
        result.get(resultIndex).addAll(nodes);
      }
      resultIndex++;
    }
    return result;
  }

  private void dfs(TreeNode root, int index, int level,
      TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
    if (root == null) return;
    map.computeIfAbsent(index, k -> new TreeMap<>()).computeIfAbsent(level, k -> new ArrayList<>())
        .add(root.val);
    dfs(root.left, index - 1, level + 1, map);
    dfs(root.right, index + 1, level + 1, map);
  }
}

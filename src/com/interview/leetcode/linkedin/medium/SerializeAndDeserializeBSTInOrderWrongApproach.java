package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.interview.leetcode.TreeNode;

/*

https://leetcode.com/problems/serialize-and-deserialize-bst

1) Based on solution ConvertSortedArrayToBinarySearchTree. But not expected as per requirement.
2) ConvertSortedArrayToBinarySearchTree builds BST, but order can be any.

=======================================================Case1==================================

1) Append "," as delimiter between nodes. 

                  10
                 /  \
                5    20

Serialized String =   5, 10, 20

For above case below solution will work... 
=======================================================Case2==================================
de-serialize fail for below case.

                  20
                 /  
               10    
Serialized String =  10,20

                10
               /  \
              n   20

de-serialized result will be not same as input. But still valid BST.

 */
public class SerializeAndDeserializeBSTInOrderWrongApproach {

  public String serialize(TreeNode root) {
    if (root == null) return null;


    List<Integer> sortedList = new ArrayList<>();
    serializeBST(root, sortedList);

    return sortedList.stream().map(String::valueOf).collect(Collectors.joining(","));

  }

  private void serializeBST(TreeNode root, List<Integer> sortedList) {
    if (root == null) return;

    serializeBST(root.left, sortedList);
    sortedList.add(root.val);
    serializeBST(root.right, sortedList);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    if (data == null || data.length() == 0) return null;

    String[] nodes = data.split(",");

    return deserializeBST(nodes, 0, nodes.length - 1);
  }

  private TreeNode deserializeBST(String[] nodes, int low, int high) {
    if (low > high) return null;

    int cutPoint = low + (high - low) / 2;
    TreeNode root = new TreeNode(Integer.valueOf(cutPoint));
    root.left = deserializeBST(nodes, low, cutPoint - 1);
    root.right = deserializeBST(nodes, cutPoint + 1, high);
    return root;
  }
}

package com.sample.datastructure.tree;

import com.interview.leetcode.TreeNode;

/*

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
                          5
                        /   \
                       1     4
                           /   \
                          3     6 
                          
1) Keep propagate minimum/maximum/trueOrFalse from bottomToTop.
2) 0thColumn is min... 1stColumn is max... 2ndColumn is 0-false... 1-true                          
                            
For 1 result [1, 1, 1]
For 3 result [3, 3, 1]
For 6 result [6, 6, 1]
For 4 result [3, 6, 1]

5's Left  [1, 1, 1]
5's right [3, 6, 1]

Validation Failed For Node 5 with right [3, 6, 1] because of condition 5 >= 3



 */
public class ValidateBinarySearchTreeOrValidBSTPostOrderApproach {


  public boolean isValidBST(TreeNode root) {
    return divideAndConquer(root)[2] == 1;

  }

  private long[] divideAndConquer(TreeNode root) {
    // (min, max,trueOrFalse)
    if (root == null) return new long[] {Long.MAX_VALUE, Long.MIN_VALUE, 1};

    // divide
    long[] left = divideAndConquer(root.left);
    long[] right = divideAndConquer(root.right);

    //
    if (left[2] == 0 || right[2] == 0 || root.val <= left[1] || root.val >= right[0]) {
      return new long[] {Long.MAX_VALUE, Long.MIN_VALUE, 0}; // return false...
    }

    return new long[] {Math.min(root.val, left[0]), Math.max(root.val, right[1]), 1};
  }
}

package com.interview.leetcode.google.medium;

import com.interview.leetcode.TreeNode;
/*


https://leetcode.com/problems/split-bst/
Look into image "SplitBST.HEIC"

1) Given a Binary Search Tree (BST) with root node, and a target value, split the tree into two subtrees.
2) result[0] should contain all smaller or equal to the target value.
3) result[1] should contain all nodes that are greater than the target value.
4) target may or may present in tree. Still gather all value "<=target" to oneSide and ">target" to anotherSide.
5) result[0] and result[1] can interchange.

Input: root = [4,2,6,1,3,5,7], target = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation: Note that root, output[0], and output[1] are TreeNode objects, not arrays.

The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

							          40
							        /   \
							      20     60
							     / \     / \
							    10  30  50  70

			target = 20 or 25. Both return same result

						20	          40
					  /		        /   \
					10		      30     60
							            / \
							           50  70
===================================================Data Flow Analysis===================================================
						==============Input : [20,10,30]=============
									20
								  /	  \
								10     30
						========Target = 25 or 20=======
						==============Output : [20,30]=============
								   20        30
								  /
								10

							10.left  returns ==> [] ---- Base Case
							10.right returns ==> [] ---- Base Case
							10.left  assigned null from split1.
							10.right assigned null from split0.

     						10 returns [null,10]

							30.left  returns ==> [] ---- Base Case
							30.right returns ==> [] ---- Base Case
							30.left  assigned null from split1.
							30.right assigned null from split0.

							30 returns [30,null]

							20.left  assigned 10  ==> from [null, 10] returned by 10
							20.right assigned null==> from [30, null] return by 30

							20 returns [20,30]

===============================================Solution Approach - Time Complexity O(h)===============================================
1) Lets say we want to fix, split0 is "<=target" to be placed in resultIndex0, and split1 is ">target" to be placed in resultIndex1
2) if root.val > target then 3 things are happening
 		2a) all of "roots right" can be skipped. We can traverse towards left.
		2b) for sure right will be in split2, left will be in split1.
2) Likewise if root.val <= target then for sure Left comes in split1.
split will be in right.

 */
public class SplitBST {

  public TreeNode[] splitBSTStep1(TreeNode root, int target) {
    if (root == null) return new TreeNode[2];
    if (root.val > target) {
      TreeNode[] splitNode = splitBST(root.left, target);
    }
    TreeNode[] splitNode = splitBST(root.right, target);

    return null;
  }

  public TreeNode[] splitBSTStep2(TreeNode root, int target) {
    if (root == null) return new TreeNode[2];
    if (root.val > target) {
      TreeNode[] splitNode = splitBST(root.left, target);
      root.left = splitNode[1];
    }
    TreeNode[] splitNode = splitBST(root.right, target);
    root.right = splitNode[0];

    return null;
  }

  public TreeNode[] splitBST(TreeNode root, int target) {
    if (root == null) return new TreeNode[2];
    if (root.val > target) {
      TreeNode[] splitNode = splitBST(root.left, target);
      root.left = splitNode[1];
      return new TreeNode[] {splitNode[0], root};
    }
    TreeNode[] splitNode = splitBST(root.right, target);
    root.right = splitNode[0];
    return new TreeNode[] {root, splitNode[1]};
  }
}

package com.interview.leetcode.topic.tree;
/*
https://leetcode.com/problems/range-sum-query-mutable/

See Image "SegmentTree.png"

1) See RangeSumQueryImmutable, that is the base for this problem.
In RangeSumQueryImmutable, after forming dp, if we update element, it takes O(n) to update dp matrix, which is costly.
So 

2) Create Tree like below

Ex: [2,4,5,7]
In RangeSumQueryImmutable we split by index 0,1 -- 0,1,2 -- 0,1,2,3

Here we split by half... like below

                      18 (0-3)
                    /    \
              (0-1)6      12 (2-3)
                  /\      /\
                 2  4    5  7
======Tree Creation======Time Complexity O(n)====== 
1) Similar to standard tree logic.
2) range(start,end) is updated from topToBottom.
3) levelSum updated from bottomUp. 
a) for the above tree. recursion goes all the way, leaf with sum created and node2 and node4 returned .
b) at 6, we update sum from left.sum and right.sum, then we return node6
======Tree Search and return sum======Time Complexity O(log(n))====== 
1) If start and end is found at root return the sum.
2) Go by property of BST
   a) If start and end can fall in leftSide. Ex: [0,1]
   b) If start and end can fall in rightSide.Ex: [2,3]
   c) If start and end can fall in bothSide. Ex: [1,2]
======Tree Update======Time Complexity O(log(n))======Perfect Post order traversal.
Ex: update 5 with 10
1) Similar logic to Tree Creation. But here we update only levelSum and only specific path is updated.
2) levelSum updated from bottomUp. 
3) the indexToUpdate can exists either right or left only. 
  So based on indexToUpdate, recursion goes left or right from topToBottome. 
  When it comes from bottomToTop rootSum = leftSum + rightSum. 
  
  Update input array = [2,4,10,7] --> only 10 is updated at index2.
  
                      23 (0-3)
                    /    \
              (0-1)6      17 (2-3)
                  /\      /\
                 2  4    10 7

==================Note============
1) This approach is best only when there are more update operation than search operation.            
 */

public class RangeSumQueryMutable {
  class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    int sum;

    public SegmentTreeNode(int start, int end) {
      this.start = start;
      this.end = end;
      this.left = null;
      this.right = null;
      this.sum = 0;
    }
  }

  SegmentTreeNode root = null;

  public RangeSumQueryMutable(int[] nums) {
    root = buildTree(nums, 0, nums.length - 1);
  }

  private SegmentTreeNode buildTree(int[] nums, int start, int end) {
    SegmentTreeNode current = new SegmentTreeNode(start, end);

    if (start == end) { // reached end... No need to calculate left and right
      current.sum = nums[start];
      return current;
    }

    int mid = start + (end - start) / 2;
    current.left = buildTree(nums, start, mid);
    current.right = buildTree(nums, mid + 1, end);
    current.sum = current.left.sum + current.right.sum;
    return current;


  }

  public int sumRange(SegmentTreeNode root, int start, int end) {
    // Ex: query = [0,3].. we found result at root.
    if (root.end == end && root.start == start) {
      return root.sum;
    } else {
      int mid = root.start + (root.end - root.start) / 2;
      if (end <= mid) {
        return sumRange(root.left, start, end);
      } else if (start >= mid + 1) {
        return sumRange(root.right, start, end);
      } else {
        return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
      }
    }
  }

  void update(int i, int val) {
    update(root, i, val);
  }

  void update(SegmentTreeNode root, int indexToUpdate, int valueToUpdate) {
    if (root.start == root.end) {
      root.sum = valueToUpdate;
    } else {
      int mid = root.start + (root.end - root.start) / 2;
      if (indexToUpdate <= mid) {
        update(root.left, indexToUpdate, valueToUpdate);
      } else {
        update(root.right, indexToUpdate, valueToUpdate);
      }
      root.sum = root.left.sum + root.right.sum;
    }
  }

  public int sumRange(int i, int j) {
    return sumRange(root, i, j);
  }

}

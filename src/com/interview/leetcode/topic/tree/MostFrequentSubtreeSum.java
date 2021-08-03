package com.interview.leetcode.topic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.interview.leetcode.TreeNode;

/*
https://leetcode.com/problems/most-frequent-subtree-sum/
===========================================================Requirement===========================================================
1) Calculate nodeSum and countOfNodeSum for eachNode from bottomUp.
2) Return all the values with maximumCount

============================================================Example1=============================================================
Input: root = [5,2,-3]
Output: [2,-3,4]
                       5
                      / \
                     2   -3
                     sum at 2 is      =  2 with a count of 1
                     sum at -3 is     = -3 with a count of 1
                     sum at 5 is 2+5-3=  4 with a count of 1
So all will go to result                     
============================================================Example2=============================================================                     
Input: root = [5,10,-5]
Output: [10]           

                       5
                      / \
                     10  -5
                     sum at 10 is      =  10 with a count of 1
                     sum at -5 is      = -5  with a count of 1
                     sum at 5 is 10+5-5 = 10 with a count of 2

The biggestCount is 2 with the value of 10. So answer is 10                     
                     

 */
public class MostFrequentSubtreeSum {

  public int[] findFrequentTreeSum(TreeNode root) {
    // Now the pick the maximum count of result.
    Map<Integer, Integer> result = new HashMap<>();
    recur(root, result);
    int maxCount = 0;

    // find the maximum countOfNodeSum
    for (Integer v : result.values()) {
      maxCount = Math.max(maxCount, v);
    }

    // We don't know the number of entries with maxCount. So use dynamicArray 
    List<Integer> resultList = new ArrayList<>();
    for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
      if (entry.getValue() == maxCount) resultList.add(entry.getKey());
    }

    int[] resultArr = new int[resultList.size()];
    // Convert the dynamicArray to staticArray
    for (int i = 0; i < resultList.size(); i++) resultArr[i] = resultList.get(i);

    return resultArr;

  }

  private int recur(TreeNode root, Map<Integer, Integer> result) {
    if (root == null) return 0;

    int left = recur(root.left, result);
    int right = recur(root.right, result);

    int nodeSum = left + right + root.val;
    int countOfNodeSum = result.getOrDefault(nodeSum, 0) + 1;

    result.put(nodeSum, countOfNodeSum);

    return nodeSum;

  }
}

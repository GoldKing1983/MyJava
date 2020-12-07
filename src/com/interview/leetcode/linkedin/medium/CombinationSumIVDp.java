package com.interview.leetcode.linkedin.medium;

/*
 *
 * https://leetcode.com/problems/combination-sum-iv
 *

This dp table is little bit different. For each of dp column we compare on all nums.

Generally we fill all columns in a row for a dp.
But here we fill all rows for a column.

			 0  1  2  3  4
			===============
		{1}	[0, 1, 0, 0, 0]
	  {1,2}	[0, 1, 0, 0, 0]
	{1,2,3}	[0, 1, 0, 0, 0]
			Filling Completed for dp column:1 i.e number1
		{1}	[0, 1, 1, 0, 0]
	  {1,2}	[0, 1, 2, 0, 0]
	{1,2,3}	[0, 1, 2, 0, 0]
			Filling Completed for dp column:2 i.e number2
		{1}	[0, 1, 2, 2, 0]
	  {1,2}	[0, 1, 2, 3, 0]
	{1,2,3}	[0, 1, 2, 4, 0]
			Filling Completed for dp column:3 i.e number3
		{1}	[0, 1, 2, 4, 4]
	  {1,2}	[0, 1, 2, 4, 6]
	{1,2,3}	[0, 1, 2, 4, 7]
			Filling Completed for dp column:4 i.e number4
			[0, 1, 2, 4, 7]


 */
public class CombinationSumIVDp {

  public int combinationSum4(int[] nums, int target) {
    int[] res = new int[target + 1];
    for (int i = 1; i < res.length; i++) {
      for (int num : nums) {
        if (num == i) res[i] += 1;
        else if (num > i) ; // don't do anything
        else res[i] += res[i - num];
      }
    }
    return res[target];
  }
}

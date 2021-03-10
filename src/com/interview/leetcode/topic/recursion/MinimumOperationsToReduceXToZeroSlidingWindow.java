package com.interview.leetcode.topic.recursion;

/*

https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/

1) 
 */
public class MinimumOperationsToReduceXToZeroSlidingWindow {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;
        int target = total - x;

        int start = 0;
        int end = 0;
        int sum = 0;
        int len = -1;
        while (end < nums.length) {
            sum += nums[end++];
            while (start < nums.length && sum > target)
                sum -= nums[start++];
            if (sum == target)
                len = Math.max(len, end - start);
        }
        return len == -1 ? -1 : (nums.length - len);
    }
}

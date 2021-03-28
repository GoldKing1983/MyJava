package com.interview.leetcode.topic.prefixsum;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/consecutive-numbers-sum/
Given a positive integer N, how many ways can we write it as a sum of consecutive positive integers?

Example 1:

Input: 5
Output: 2
Explanation: 5 = 5 = 2 + 3
Example 2:

Input: 9
Output: 3
Explanation: 9 = 9 = 4 + 5 = 2 + 3 + 4
Example 3:

Input: 15
Output: 4
Explanation: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
========================================================Solution Approach========================================================
1) We see that previousResultCount can be re-used for currentNumber.
2) Standard prefixSum problem.
3) Optionally we can also implement similar to "LongestCommonSubString"
4) The solution throws TLE for big numbers, right approach is Mathematical deriviation.
=======================================================Data Flow Analysis========================================================
N = 5
i : 0. currSum : 0. diff : -5. preSum : {0=1}. resultCount : 0
i : 1. currSum : 1. diff : -4. preSum : {0=1, 1=1}. resultCount : 0
i : 2. currSum : 3. diff : -2. preSum : {0=1, 1=1, 3=1}. resultCount : 0
i : 3. currSum : 6. diff : 1. preSum : {0=1, 1=1, 3=1, 6=1}. resultCount : 1
i : 4. currSum : 10. diff : 5. preSum : {0=1, 1=1, 3=1, 6=1, 10=1}. resultCount : 1
i : 5. currSum : 15. diff : 10. preSum : {0=1, 1=1, 3=1, 6=1, 10=1, 15=1}. resultCount : 2
=======================================================Data Flow Analysis========================================================
N = 9
i : 0. currSum : 0. diff : -9.  preSum : {0=1}. resultCount : 0
i : 1. currSum : 1. diff : -8.  preSum : {0=1, 1=1}. resultCount : 0
i : 2. currSum : 3. diff : -6.  preSum : {0=1, 1=1, 3=1}. resultCount : 0
i : 3. currSum : 6. diff : -3.  preSum : {0=1, 1=1, 3=1, 6=1}. resultCount : 0
i : 4. currSum : 10. diff : 1.  preSum : {0=1, 1=1, 3=1, 6=1, 10=1}. resultCount : 1
i : 5. currSum : 15. diff : 6.  preSum : {0=1, 1=1, 3=1, 6=1, 10=1, 15=1}. resultCount : 2
i : 6. currSum : 21. diff : 12. preSum : {0=1, 1=1, 3=1, 21=1, 6=1, 10=1, 15=1}. resultCount : 2
i : 7. currSum : 28. diff : 19. preSum : {0=1, 1=1, 3=1, 21=1, 6=1, 10=1, 28=1, 15=1}. resultCount : 2
i : 8. currSum : 36. diff : 27. preSum : {0=1, 1=1, 3=1, 36=1, 21=1, 6=1, 10=1, 28=1, 15=1}. resultCount : 2
i : 9. currSum : 45. diff : 36. preSum : {0=1, 1=1, 3=1, 36=1, 21=1, 6=1, 10=1, 28=1, 45=1, 15=1}. resultCount : 3


 */
public class ConsecutiveNumbersSum {
    public int consecutiveNumbersSum(int N) {
        Map<Long, Long> preSum = new HashMap<>();
        long currSum = 0;
        int resultCount = 0;
        for(long i=0; i<=N; i++) {
            currSum = currSum + i;
            long diff = currSum-N;
            if(preSum.containsKey(diff)) {
                resultCount += preSum.get(diff);
            }
            preSum.put(currSum, preSum.getOrDefault(currSum, 0l)+1);
        }
        return resultCount;
    }
}

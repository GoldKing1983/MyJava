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
1) Tricky.... Try understand
https://leetcode.com/problems/consecutive-numbers-sum/discuss/809348/(With-explanation)-Simple-solution-beats-98-in-Java
LeoEnriqueWu has updated the logic...

=======================================================Data Flow Analysis========================================================
N = 5

i : 1. currSum : 1. diff : 4. resultCount : 2
i : 2. currSum : 3. diff : 2. resultCount : 2
=======================================================Data Flow Analysis========================================================
N = 9

i : 1. currSum : 1. diff : 8. resultCount : 2
i : 2. currSum : 3. diff : 6. resultCount : 3
i : 3. currSum : 6. diff : 3. resultCount : 3

=======================================================Data Flow Analysis========================================================
N = 15

i : 1. currSum : 1. diff : 14. resultCount : 2
i : 2. currSum : 3. diff : 12. resultCount : 3
i : 3. currSum : 6. diff : 9. resultCount : 3
i : 4. currSum : 10. diff : 5. resultCount : 4


 */
public class ConsecutiveNumbersSumWithoutDP {
    public int consecutiveNumbersSum(int N) {
        int resultCount = 1;
        int currSum = 0;

        for(int i=1; currSum<N; i++){
            currSum += i ;
            int diff = N - currSum;
            if (diff <= 0) continue;

            if(diff % (i+1) == 0) resultCount++;

        }

        return resultCount;
    }
}

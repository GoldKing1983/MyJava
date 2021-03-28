package com.interview.leetcode.topic.greedy;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-units-on-a-truck/

1) Given a truck with "n" number of boxes it can carry.
2) Fill "n" number of boxes which can profit maxValue.

Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], n = 10
Explanation: 5 boxes with value 10.
             2 boxes with value 5
             4 boxes with value 7
             3 boxes with value 9
Output: 91

5 * 10 = 50
3 * 9  = 27
2 * 7  = 14
==
10
==

1) sort the boxes by its values in descending order.
2) greedily pick n boxes and sum its value.

 */
public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int maxUnixTruckCanCarry = 0;
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        for(int[] boxType : boxTypes) {
            int boxCount = boxType[0];
            int boxValue = boxType[1];
            // Below step can be optimized, instead of looping
            while(boxCount -- > 0) {
                if(truckSize-- == 0) return maxUnixTruckCanCarry;
                maxUnixTruckCanCarry += boxValue;
            }
        }
        return maxUnixTruckCanCarry;
    }
}

package com.interview.leetcode.topic.prefixsum;

/*
https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
===========================================================Requirement===========================================================
1) Given na array of input, return number of combination of pair that are divisible by 60.
============================================================Example1=============================================================
Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
============================================================Example2=============================================================
Input: time = [60]
Output: 0
============================================================Example3=============================================================
Input: time = [60,60]
Output: 2
============================================================Example4=============================================================
Input: time = [60,60,60]
Output: 3
============================================================Example5=============================================================
Input: time = [20,20,20]
Output: 0
============================================================Example6=============================================================
Input: time = [30,30,60]
Output: 1

 */

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60BruteForce(int[] time) {
        int pairCount = 0, n = time.length;
        for (int i = 0; i < n; i++) {
            // j starts with i+1 so that i is always to the left of j to avoid repetitive counting
            for (int j = i + 1; j < n; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    pairCount++;
                }
            }
        }
        return pairCount;
    }

    /*
    Ex1: [35,25]
    map = {35=1}
    map = {35=1, 25=1}

    Ex2: [20,100,40]
    map = {20=1}
    map = {20=1, 40=1}
    map = {20=1, 40=2}

     */
    public int numPairsDivisibleBy60(int[] arr) {
        int pairCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            if(a%60==0) {
                pairCount += map.getOrDefault(0 , 0);
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                // Ex: for [90,150,30].. Ans:3
                // for 90.. [30,1]...pairCount=0
                // for 150..[30,2]...pairCount=0+1=1
                // for 30..[30,3]...pairCount=1+2=3
                int rem = a % 60;
                pairCount += map.getOrDefault((60 - rem) , 0);
                map.put(rem, map.getOrDefault(rem, 0) + 1);
            }

            //System.out.println(map);
        }
        return pairCount;
    }
}

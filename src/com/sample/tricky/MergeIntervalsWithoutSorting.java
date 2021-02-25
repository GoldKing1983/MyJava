package com.sample.tricky;

import java.util.Arrays;

/*

=== Merge Intervals Without Sorting===(O(N))
It is like a bucketing algorithm.  But it takes lot of space O(N) and space complexity O(N)

 */
public class MergeIntervalsWithoutSorting {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];
        int min = Arrays.stream(intervals).min((a, b) -> a[0] - b[0]).get()[0];
        int max = Arrays.stream(intervals).max((a, b) -> a[1] - b[1]).get()[1];

        int range = max - min + 1;
        int[] intrv = new int[range];
        boolean[] same = new boolean[range];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != intervals[i][1]) {
                intrv[intervals[i][0] - min]++;
                intrv[intervals[i][1] - min]--;
            } else {
                same[intervals[i][0] - min] = true;
            }
        }

        System.out.println(Arrays.toString(intrv));
        System.out.println(Arrays.toString(same));

        int[][] results = new int[intervals.length][2];
        int counter = 0;
        int currentSum = 0;
        int start = 0;
        for (int i = 0; i < range; i++) {
            if (intrv[i] > 0) {
                if (currentSum == 0) {
                    start = i;
                }
            }
            currentSum += intrv[i];
            if (intrv[i] < 0 && currentSum == 0) {
                results[counter++] = new int[]{start + min, i + min};
            }
            if (intrv[i] == 0 && same[i] && currentSum == 0) {
                results[counter++] = new int[]{i + min, i + min};
            }
        }
        return Arrays.copyOfRange(results, 0, counter);
    }
}

import java.util.*;

/*
com.interview.leetcode.topic.

===========================================================Requirement===========================================================
=========================================================Initial Thought=========================================================
===========================================================BruteForce============================================================
============================================================Example1=============================================================
========================================================Solution Approach========================================================
=======================================================Data Flow Analysis========================================================
========================================================Logical Thinking=========================================================
=========================================================Time Complexity=========================================================
=================================================================================================================================
 */
public class Sample {

  /*
   * 10,20,5 = 
   * 10,20,2
   * 
   */

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        /*
        1 -- 4
             4 -- 5

        1--------------4
            2------3

        1 -- 4
                5 -- 6


        */
    int n = intervals.length;
    int[][] result = new int[n][2];
    int resultIndex = 0;
    int previousStartTime = intervals[0][0];
    int previousEndTime = intervals[0][1];
    for(int i=1; i<n; i++) {
      int currentStartTime = intervals[i][0];
      int currentEndTime = intervals[i][1];
      if(currentStartTime <= previousEndTime) { // merge
        previousEndTime = Math.max(currentEndTime,previousEndTime);
      } else {
        result[resultIndex][0] = previousStartTime;
        result[resultIndex++][1] = previousEndTime;
      }
    }
    result[resultIndex][0] = previousStartTime;
    result[resultIndex][1] = previousEndTime;

    return Arrays.copyOfRange(intervals,0,resultIndex);
  }
}

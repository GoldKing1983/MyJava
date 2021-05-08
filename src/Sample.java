import java.util.Arrays;

/*
com.interview.leetcode.topic.

===========================================================Requirement===========================================================
=========================================================Initial Thought=========================================================
=================================================Initial Thought - Wrong Approach================================================
=================================================Initial Thought - Right Approach================================================
===========================================================BruteForce============================================================
============================================================Example1=============================================================
========================================================Solution Approach========================================================
=======================================================Data Flow Analysis========================================================
========================================================Logical Thinking=========================================================
=========================================================Time Complexity=========================================================
========================================================Space Complexity=========================================================
===========================================================Corner Case===========================================================
==========================================================Deep Thinking==========================================================
=================================================================================================================================
 */
public class Sample {

  public int maximumWealth(int[][] accounts) {
    int max = Integer.MIN_VALUE;

    for (int[] account : accounts) {
      max = Math.max(max, Arrays.stream(account).sum());
    }

    return max;
  }
}

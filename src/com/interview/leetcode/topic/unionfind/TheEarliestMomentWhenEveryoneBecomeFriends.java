package com.interview.leetcode.topic.unionfind;

import java.util.Arrays;

/*
https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/

1) Initially there are 1 friendsInAGroup.
2) When any 2 joins a group then increment friendsInAGroup. 
3) If n==friendsInAGroup return the logTime.  

=======================================================Data Flow Analysis========================================================
input:             
[20190101,0,1],
[20190104,3,4],
[20190107,2,3],
[20190211,1,5],
[20190224,2,4],
[20190301,0,3], --> at this point 0 to 5 are friends
[20190312,1,2],
[20190322,4,5]],

output: 20190301

  5 <-> 1 <-> 0    
  |     |     |
  |     2 <-> 3 
  |     |     |
  |-----4-----

root = [0,1,2,3,4,5]
       [0,0,2,3,4,5] 0,1
       [0,0,2,3,3,5] 3,4
       [0,0,2,2,3,5] 2,3 
       [0,0,2,2,3,0] 1,5 
       [0,0,2,2,3,0] 2,4 -- no change
       [0,0,0,2,3,0] 0,3 -- at this point friendsInAGroup==n. So return timestamp of 0,3
 */
public class TheEarliestMomentWhenEveryoneBecomeFriends {

  public int earliestAcq(int[][] logs, int n) {
    int[] root = new int[n];

    for (int i = 0; i < n; i++) root[i] = i;

    Arrays.sort(logs, (a, b) -> a[0] - b[0]);

    int friendsInAGroup = 1;
    for (int[] log : logs) {
      int sourceNodeGroup = findRoot(root, log[1]);
      int targetNodeGroup = findRoot(root, log[2]);
      if (sourceNodeGroup != targetNodeGroup) {
        root[targetNodeGroup] = sourceNodeGroup;
        friendsInAGroup++;
        if (friendsInAGroup == n) return log[0];
      }
    }
    return -1;
  }

  public int findRoot(int[] root, int id) {
    while (true) {
      if (root[id] == id) return id;
      //roots[id] = roots[roots[id]]; //performance...
      id = root[id];
    }
  }
}

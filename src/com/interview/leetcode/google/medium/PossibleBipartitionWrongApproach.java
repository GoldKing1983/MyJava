package com.interview.leetcode.google.medium;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/possible-bipartition/

1) Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
2) Each person may dislike some other people, and they should not go into the same group.
3) Ex: dislikes[i] = [a, b] means it is not allowed to put the people numbered a and b into the same group.
4) Return true if and only if it is possible to split everyone into two groups in this way.

============================================Solution Approach============================================
1) Keep 2 groups. Eagerly put member1 into groupA or groupB then do the reverse for member2. This fails in below test case

5
[[1,2],[2,3],[4,5],[3,4]]
Output: True

Iteration1 : groupA [1]. groupB [2]
Iteration2 : groupA [1, 3]. groupB [2]
Iteration3 : groupA [1, 3, 4]. groupB [2, 5]
Iteration4 : 3 and 4 cannot be placed in sameGroup. But already they are in groupA. So false.

Above could be avoided if we do... Kind of backTracking...
Iteration3 : groupA [1, 3, 5]. groupB [2, 4]
Iteration4 : groupA [1, 3, 5]. groupB [2, 4]... No change because 3 is already in groupA and 4 is already in groupB.


 */
public class PossibleBipartitionWrongApproach {
  public boolean possibleBipartition(int N, int[][] dislikes) {

    Set<Integer> groupA = new HashSet<>();
    Set<Integer> groupB = new HashSet<>();
    for (int[] dislike : dislikes) {
      Integer member1 = dislike[0];
      Integer member2 = dislike[1];
      if (groupA.contains(member1) && groupA.contains(member2)) return false;
      if (groupB.contains(member1) && groupB.contains(member2)) return false;
      if (groupA.contains(member1)) {
        groupB.add(member2);
      } else if (groupB.contains(member1)) {
        groupA.add(member2);
      } else {
        groupA.add(member1);
        groupB.add(member2);
      }
      System.out.println(groupA);
      System.out.println(groupB);
    }
    return true;
  }
}

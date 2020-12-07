package com.interview.leetcode.linkedin.medium;

import java.util.HashSet;
import java.util.Set;

/*

Input : [3,0,2,1,2]
output: 2

1) Memoization needed for 2 purpose.
a) For a particular point Lets say "A" if it true or false to be noted.
Because like fibonacci, other points "B" may lead to this point "A". So we don't need to recur again for "A".
b)For isVisited purpose. "A" point can come back to same "A" again. For Below input  at index 2, "recur goes for ever".
		Input : [3,0,2,1,2]
		output: 2

If we think visually, isVisited (set) solves the purpose of "point a". So map is not needed set is enough.
Because in Fibonacci, we need to propagate "number" from point "A" which will be used in point "B".
But here it is true or false state. Same state is reused in point "B".
 */
public class JumpGameIII {

  private Set<Integer> isVisited = new HashSet<>();

  public boolean canReach(int[] a, int start) {
    if (start < 0 || start >= a.length) return false;
    if (a[start] == 0) return true;
    if (!isVisited.contains(start)) {
      isVisited.add(start);
      boolean towardsRight = canReach(a, start + a[start]);
      boolean towardsLeft = canReach(a, start - a[start]);
      return towardsRight || towardsLeft;
    }
    return false;
  }
}

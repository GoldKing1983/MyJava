package com.interview.leetcode.google.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/bulls-and-cows/
 *
 * See how the game works on below URL. Just code for the video. This is not the best solution
 * https://www.youtube.com/watch?v=r_dw8iV_52g
 *
 */
public class BullsAndCowsBruteForce {
  public String getHint(String secret, String guess) {
    int noOfBulls = 0;
    int noOfCows = 0;
    Map<Character, Set<Integer>> map = new HashMap<>();
    boolean[] isVisited = new boolean[secret.length()];
    int i = 0;
    for (Character s : secret.toCharArray()) {
      Set<Integer> set = map.getOrDefault(s, new HashSet<>());
      set.add(i++);
      map.put(s, set);
    }
    i = 0;
    for (Character g : guess.toCharArray()) {
      if (map.containsKey(g)) {
        Set<Integer> index = map.get(g);
        if (index.contains(i)) {
          index.remove(i);
          if (index.isEmpty()) map.remove(g);
          noOfBulls++;
          isVisited[i] = true;
        }
      }
      i++;
    }
    i = 0;
    for (Character g : guess.toCharArray()) {
      if (!isVisited[i] && map.containsKey(g)) {
        Set<Integer> index = map.get(g);
        index.remove(index.iterator().next());
        if (index.isEmpty()) map.remove(g);
        noOfCows++;
      }
      i++;
    }
    return noOfBulls + "A" + noOfCows + "B";
  }
}

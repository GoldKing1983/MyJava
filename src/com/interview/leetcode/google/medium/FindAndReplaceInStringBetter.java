package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInStringBetter {
  public String findReplaceString(
      String inputStr, int[] indexes, String[] sources, String[] targets) {
    Map<Integer, String[]> map = new HashMap<>();
    for (int i = 0; i < indexes.length; i++) {
      map.put(indexes[i], new String[] {sources[i], targets[i]});
    }

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < inputStr.length(); i++) {
      if (map.containsKey(i)) {
        String[] sourceAndTarget = map.get(i);
        String source = sourceAndTarget[0];
        String target = sourceAndTarget[1];
        if (inputStr.substring(i).startsWith(source)) {
          result.append(target);
          i += source.length() - 1;
        } else {
          result.append(inputStr.charAt(i));
        }
      } else {
        result.append(inputStr.charAt(i));
      }
    }
    return result.toString();
  }
}

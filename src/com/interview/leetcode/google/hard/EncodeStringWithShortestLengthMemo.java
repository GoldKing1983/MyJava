package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.Map;

public class EncodeStringWithShortestLengthMemo {

  Map<String, String> memo = new HashMap<>();

  public String encode(String s) {
    if (s == null) return "";
    if (memo.containsKey(s)) return memo.get(s);

    StringBuilder prefix = new StringBuilder();
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      prefix.append(s.charAt(i));
      int count = prefixCount(s.substring(i + 1), prefix.toString()) + 1;
      String prefixEncodedString = count == 1 ? prefix.toString() : encode(prefix.toString());

      for (int countTemp = 1; countTemp <= count; countTemp++) {
        String tempString = "";
        if (countTemp == 1) tempString = prefixEncodedString + "" + encode(s.substring(i + 1));
        else {
          tempString =
              Integer.toString(countTemp)
                  + "["
                  + prefixEncodedString
                  + "]"
                  + encode(s.substring(i + (countTemp - 1) * prefix.length() + 1));
        }
        result = result != "" && result.length() < tempString.length() ? result : tempString;
      }
    }
    memo.put(s, result);
    return result;
  }

  public int prefixCount(String S, String prefix) {
    if (S != null && S.startsWith(prefix)) {
      return prefixCount(S.substring(prefix.length()), prefix) + 1;
    }
    return 0;
  }
}

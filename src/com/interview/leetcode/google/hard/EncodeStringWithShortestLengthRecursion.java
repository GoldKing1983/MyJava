package com.interview.leetcode.google.hard;

public class EncodeStringWithShortestLengthRecursion {

  public String encode(String s) {
    if (s == null) return "";

    StringBuilder prefix = new StringBuilder();
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      prefix.append(s.charAt(i));
      int count = prefixCount(s.substring(i + 1), prefix.toString()) + 1;
      String prefixEncodedString = count == 1 ? prefix.toString() : encode(prefix.toString());

      for (int countTemp = 1; countTemp <= count; countTemp++) {
        String encodedString = "";
        if (countTemp == 1) encodedString = prefixEncodedString + "" + encode(s.substring(i + 1));
        else {
          encodedString =
              Integer.toString(countTemp)
                  + "["
                  + prefixEncodedString
                  + "]"
                  + encode(s.substring(i + (countTemp - 1) * prefix.length() + 1));
        }
        result = result != "" && result.length() < encodedString.length() ? result : encodedString;
      }
    }
    return result;
  }

  public int prefixCount(String S, String prefix) {
    if (S != null && S.startsWith(prefix)) {
      return prefixCount(S.substring(prefix.length()), prefix) + 1;
    }
    return 0;
  }
}

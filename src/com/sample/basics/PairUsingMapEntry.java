package com.sample.basics;

import java.util.AbstractMap;
import java.util.Map;

/*
Available on Java8. So safe to use in leetcode.
But do "import java.util.*;"
 */
public class PairUsingMapEntry {
  public static void main(String[] args) {
      Map.Entry<Integer, String> entry
              = new AbstractMap.SimpleEntry<>(1, "one");
      Integer key = entry.getKey();
      String value = entry.getValue();
  }
}

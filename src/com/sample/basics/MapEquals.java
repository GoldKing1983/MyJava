package com.sample.basics;

import java.util.HashMap;
import java.util.Map;

public class MapEquals {
  public static void main(String[] args) {

    Map<Character, Integer> map1 = new HashMap<>();
    map1.put('a', 2);

    Map<Character, Integer> map2 = new HashMap<>();
    map2.put('a', 2);
    map2.put('b', 2);

    System.out.println(map1.equals(map2));

  }
}

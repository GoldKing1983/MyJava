package com.sample.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Make sure value is unique. If value is not unique. Then data will be overwritten

public class MapSortByValue {

  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("aa", 75);
    map.put("a", 25);
    map.put("b", 50);

    System.out.println("==========Initial Key Value===========");
    System.out.println("Map UnSorted: " + map);

    System.out.println("==========Sort By Key===========");
    TreeMap<String, Integer> mapSortedByKey = new TreeMap<>(map);
    System.out.println("Map Sorted By Key: " + mapSortedByKey);


    System.out.println("==========Sort By Value===========");
    TreeMap<String, Integer> mapSortedByValue =
        new TreeMap<>((a, b) -> mapSortedByKey.get(a).compareTo(mapSortedByKey.get(b)));
    mapSortedByValue.putAll(map);
    System.out.println("Map Sorted By Value: " + mapSortedByValue);

    // System.out.println("==========Sort By Value Error===========");
    // sorted.put("e", 10); put will fail
    // System.out.println("Sorted Map: " + Arrays.toString(sorted.entrySet().toArray()));
  }
}


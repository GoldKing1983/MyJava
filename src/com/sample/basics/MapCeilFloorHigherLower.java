package com.sample.basics;

import java.util.TreeMap;
// The ceilingKey() returns a number greaterThanOrEqualTo keys passed. If nothing found returns null.
// The higherKey() returns a number greaterThan the keys passed. . If nothing found returns null.
// The ceilingKey() returns a number greaterThanOrEqualTo keys passed. If nothing found returns null.
// The higherKey() returns a number greaterThan the keys passed. . If nothing found returns null.

public class MapCeilFloorHigherLower {
  public static void main(String[] args) {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    treeMap.put(1, 11);
    treeMap.put(10, 101);
    treeMap.put(5, 55);
    System.out.println(treeMap.ceilingKey(5));//5
    System.out.println(treeMap.higherKey(5));//10
    
    System.out.println(treeMap.floorKey(5));//5
    System.out.println(treeMap.lowerKey(5));//1
    
  }
}

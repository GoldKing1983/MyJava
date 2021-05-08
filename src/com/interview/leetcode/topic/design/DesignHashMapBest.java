package com.interview.leetcode.topic.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/design-hashmap


    Visualization. 
    
    Create a list of array of sizeX.
    
    Each array index is selected based on key.
    
    Each Array value is bucket, which is a linkedlist. Store key value like a train...

1) Key to the solution is we create x number of buckets initially. 

 */
public class DesignHashMapBest {
  private List<Bucket> myMap;

  public DesignHashMapBest() {
    myMap = new ArrayList<>();
    for (int i = 0; i < 2069; ++i) myMap.add(new Bucket());
  }

  public void put(int key, int value) {
    int hashKey = key % 2069;
    myMap.get(hashKey).update(key, value);
  }

  public int get(int key) {
    int hashKey = key % 2069;
    return myMap.get(hashKey).get(key);
  }

  public void remove(int key) {
    int hashKey = key % 2069;
    myMap.get(hashKey).remove(key);
  }

  class Pair {
    private int key;
    private int value;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }


  class Bucket {
    private List<Pair> bucket = new LinkedList<>();

    public Integer get(Integer key) {
      for (Pair pair : bucket) {
        if (pair.key == key) return pair.value;
      }
      return -1;
    }

    // If found update else create 
    public void update(Integer key, Integer value) {
      boolean found = false;
      for (Pair pair : bucket) {
        if (pair.key == key) {
          pair.value = value;
          found = true;
        }
      }
      if (!found) bucket.add(new Pair(key, value));
    }

    public void remove(Integer key) {
      for (Pair pair : bucket) {
        if (pair.key == key) {
          bucket.remove(pair);
          break;
        }
      }
    }
  }
}

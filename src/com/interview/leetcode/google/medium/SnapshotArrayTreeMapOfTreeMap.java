package com.interview.leetcode.google.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*

See SnapshotArrayTreeMap for detailed analysis. Here instead of array another map is used. 
*/
public class SnapshotArrayTreeMapOfTreeMap {
  Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();
  int snapId = 0;

  public SnapshotArrayTreeMapOfTreeMap(int length) {
    for (int i = 0; i < length; i++) {
      map.put(i, new TreeMap<>());
    }
  }

  public void set(int index, int val) {
    map.get(index).put(snapId, val);
  }

  public int snap() {
    return snapId++;

  }

  public int get(int index, int snap_id) {
    if (map.get(index).floorEntry(snap_id) == null) return 0;
    return map.get(index).floorEntry(snap_id).getValue();
  }
}

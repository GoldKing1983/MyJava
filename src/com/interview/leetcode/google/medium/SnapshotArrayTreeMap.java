package com.interview.leetcode.google.medium;

import java.util.TreeMap;

/*
=============================================================Requirement=========================================================
Implement a SnapshotArray that supports the following interface:

1) SnapshotArray(int length) initializes an array-like data structure with the given length.  
2) Initially, each element equals 0.
3) void set(index, val) sets the element at the given index to be equal to value.
4) int snap() takes a snapshot of the array and returns the snap_id: 
5) the total number of times we called snap() minus 1.
6) int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
===============================================================Example1==========================================================
Input: ["SnapshotArray","set","snap","set","get"]
[[3],[0,5],[],[0,6],[0,0]]
Output: [null,null,0,null,5]
Explanation: 
SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
snapshotArr.set(0,5);  // Set array[0] = 5
snapshotArr.snap();  // Take a snapshot, return snap_id = 0
snapshotArr.set(0,6);
snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
===============================================================Solution Approach=================================================
1) Don't think requirement as snapshot. Think of it as versioning.
2) If the length of data is 10. There can be only 10 data, but million snaps are possible.
Another point is, if we "index by snapShot" which is unknown... we don't the limit of array.

      indexId -> [snapshotId,data]

3) So create an array of map as the length of data.
4) mapKey holds snapId and mapValue is valueOfData itself.
5) Initial currentSnapId is 0. When the  
===============================================================Data Flow Analysis================================================
Input: ["SnapshotArray","set","set","snap","set","snap","set","snap","get"]
[[3],[0,5],[1,10],[],[0,6],[],[0,7],[],[0,1],[1,1], 6]]

1) An array of map with size 3 is created.
2) currentSnapId is 0
3) [0,5] - set ----> place data in 0thIndex,0thSnap with value 5.    

          0---->[0,5]
3) [0,10] - set ----> place data in 0thIndex,0thSnap with value 5.    

          0---->[0,5]
          1---->[0,10]
                    
4) snap. currentSnapId incremented to 1.
5) [0,6] - set ----> place data in 0thIndex,1stSnap with value 6.
                ---->[0,5]
         0---->|
                ---->[1,6]
         1---->[0,10]

6) snap. currentSnapId incremented to 2.
7) [0,7] - set ----> place data in 0thIndex,1stSnap with value 6.
                ---->[0,5]
               |
         0----> ---->[1,6]
               | 
                ---->[2,7]
         1---->[0,10]

8) [0,1] - get ----> get 0thIndex data from snap1
        Pick 0th array. Pick floorOf1 which will pick 1 as Key and return 6.

9) [1,1] - get ----> get 1stIndex data from snap1
        Pick 1st array. Pick floorOf1 which will pick 0 as Key and return 10.   
*/
public class SnapshotArrayTreeMap {
  // each array holds 1 index data. Ex: if length is 10. array size is 10.
  // mapKey holds snapId and mapValue is valueOfData itself.
  TreeMap<Integer, Integer>[] map;
  int currentSnapId = 0; // totalSnap is snapId+1, like array start from 0 snapId start from 0.

  public SnapshotArrayTreeMap(int length) {
    map = new TreeMap[length];
    for (int i = 0; i < length; i++) {
      map[i] = new TreeMap<>();
    }
  }

  public void set(int index, int val) {
    map[index].put(currentSnapId, val);
  }

  public int snap() {
    return currentSnapId++;
  }

  public int get(int index, int snapId) {
    if (map[index].floorEntry(snapId) == null) return 0; // corner case, return 0, if nothing found
    return map[index].floorEntry(snapId).getValue();
  }
}

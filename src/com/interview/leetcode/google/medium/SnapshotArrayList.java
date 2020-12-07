package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

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
===============================================================Example1==========================================================

1) If index is not set with value, return 0.
2) Get can happen only from snap. So without snapping if I call get, then error. Also If I call value from invalid SnapId, 
   that is also error.

================================
Example with n=3

	  1 2 3
	    4
	  5 6
	    8 9
	  1   5

0 1 - set
1 2 - set
2 3 - set
snap - 0 - 3
1 4 - set
snap - 1 - 4
0 5 
1 6
snap - 2 - 6
1 8
2 9
snap - 3 - 8
0 1
2 5
snap - 4 - 10

get (1, 1)
snaps.get(1) - return 4. So answer lies between 0 and 4



 */
public class SnapshotArrayList {
  List<int[]> records;
  List<Integer> snaps;
  
  int totalSnap = 0;
  int currentSnapId = 0;

  public SnapshotArrayList(int length) {
    records = new ArrayList<>();
    snaps = new ArrayList<>();
  }

  public void set(int index, int val) {
    records.add(new int[] {index, val});
  }

  public int snap() {
    snaps.add(records.size() - 1);
    return snaps.size() - 1;
  }

  public int get(int index, int snapId) {
    for (int i = snaps.get(snapId); i >= 0; i--) {
      int[] record = records.get(i);
      if (record[0] == index) {
        return record[1];
      }
    }
    return 0;
  }
}

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
1) If index is not set with value return 0.
2) Get can happen only from snap. So without snapping if I call get, then error.
     Also If I call value from invalid SnapId, that is also error.
Ex: We take backup everyday's currentData. But if we look for data, fetch only from backup. 
======================Problem with Below Approach==========
1) Every time I save a snap, I am saving all data which is not updated also. This makes a lot of memory.
Ex: For 1000 records, snap1 all updated. 
Lets say only 1 value updated after that and if a snap called. Still below code saves another 1000 entry.
2) So the right approach is save only the updated value. If an entry is not there pick from previous snap.
3) Step2 point now explains to use TreeMap. FloorEntry...

 */
public class SnapshotArrayStep1Approach {
  List<int[]> list = new ArrayList<>();
  int length = 0;
  int[] currentSnap;

  public SnapshotArrayStep1Approach(int length) {
    this.length = length;
    initSnap();
  }

  private void initSnap() {
    currentSnap = new int[length];
  }

  public void set(int index, int val) {
    currentSnap[index] = val;
  }

  public int snap() {
    int[] snapToTake = new int[length];
    for (int i = 0; i < length; i++) snapToTake[i] = currentSnap[i];
    list.add(snapToTake);
    return list.size() - 1;
  }

  public int get(int index, int snap_id) {
    if (list.size() > snap_id) {
      return list.get(snap_id)[index];
    }
    return currentSnap[index];
  }
}

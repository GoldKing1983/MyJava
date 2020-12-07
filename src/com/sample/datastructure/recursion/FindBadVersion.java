package com.sample.datastructure.recursion;

/*
https://leetcode.com/problems/first-bad-version/description/

1) if n=9, then values are from 1 to 9. 0 not included
2) If 5 is badVersion. Then isBadVersion with 5 and above returns true.
3) Requirement: Minimize the call to isBadVersion.
==================================================================================================================
Given n = 9, and version = 7 is the first bad version.

call isBadVersion(5) -> false
call isBadVersion(8) -> true
call isBadVersion(9) -> true


 isBadVersion(mid) => false ==> Go Right

 1 2 3 4 5 6 7 8 9
 G G G G G G B B B       G = Good, B = Bad
 |       |       |
left    mid    right

==================================================================================================================
Given n = 9, and version = 4 is the first bad version.

isBadVersion(mid) => true  ==> Go Left

 1 2 3 4 5 6 7 8 9
 G G G B B B B B B       G = Good, B = Bad
 |       |       |
left    mid    right
==================================================================================================================


*/
public class FindBadVersion {

  public int firstBadVersion(int n) {
    return binSearch(1, n);
  }

  private int binSearch(int low, int high) {
    if (low > high) return low;
    int mid = low + (high - low) / 2;
    boolean bad = isBadVersion(mid);
    if (bad) {
      return binSearch(low, mid - 1);
    }
    return binSearch(mid + 1, high);
  }

  public boolean isBadVersion(int version) {
    return false;
  }
}

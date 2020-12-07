package com.interview.leetcode.linkedin.easy;

public class RotateString {

  public boolean rotateString(String A, String B) {
    if (A.length() > B.length()) {
      return false;
    }
    // Ex: "cap".... will turn into "capcap"
    String bigger = A + A;
    if (bigger.contains(B)) { // "pca" or "apc"
      return true;
    }
    return false;
  }

}

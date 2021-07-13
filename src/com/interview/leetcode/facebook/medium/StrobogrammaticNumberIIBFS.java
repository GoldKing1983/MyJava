package com.interview.leetcode.facebook.medium;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/strobogrammatic-number-ii/
===========================================================Requirement===========================================================
1) Given a number. return all combination of strobogrammatic number.
2) A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
========================================================Logical Thinking=========================================================
1) This problem is mostly about data analysis.
2) There are 2 set of flows. Odd Flow and Even Flow
3) For Odd Flow,  the initial feedData is [0,1,8]
4) For Even Flow, the initial feedData is [] empty
5) The loop runs n/2 times. 
6) Append [1 1] [6 9] [8 8] [9 6] [0 0] to the feedData. 
[0 0] is applicable for feedData except last loop. Because no number can start 0. 
 
=======================================================Example1 - Odd Flow=======================================================
n=1
[0, 1, 8]
===totalLoopToRun:0===
=======================================================Example2 - Odd Flow=======================================================
n=3
[0, 1, 8]
===totalLoopToRun:1===
===running 1stLoop===
[101, 609, 808, 906, 
 111, 619, 818, 916, 
 181, 689, 888, 986]
=======================================================Example3 - Odd Flow=======================================================
n=5
[0, 1, 8]
===totalLoopToRun:2===
===running 1stLoop=== 0 at beginning and end will be included
[101, 609, 808, 906, 000, 
 111, 619, 818, 916, 010, 
 181, 689, 888, 986, 080]
===running 2ndLoop===
[11011, 61019, 81018, 91016, 
 16091, 66099, 86098, 96096, 
 18081, 68089, 88088, 98086, 
 19061, 69069, 89068, 99066, 
 10001, 60009, 80008, 90006, 
 
 11111, 61119, 81118, 91116, 
 16191, 66199, 86198, 96196, 
 18181, 68189, 88188, 98186, 
 19161, 69169, 89168, 99166, 
 10101, 60109, 80108, 90106, 
 
 11811, 61819, 81818, 91816, 
 16891, 66899, 86898, 96896, 
 18881, 68889, 88888, 98886, 
 19861, 69869, 89868, 99866, 
 10801, 60809, 80808, 90806]
=======================================================Example2 - Even Flow======================================================
n=2
[]
===totalLoopToRun:1===
===running 1stLoop===
[11, 69, 88, 96]
=======================================================Example1 - Even Flow======================================================
n=4
[]
===totalLoopToRun:2===
===running 1stLoop=== 0 at beginning and end will be included
[11, 69, 88, 96, 00]
===running 2ndLoop===
[1111, 6119, 8118, 9116, 
 1691, 6699, 8698, 9696, 
 1881, 6889, 8888, 9886, 
 1961, 6969, 8968, 9966, 
 1001, 6009, 8008, 9006]
=================================================Initial Thought - Wrong Approach================================================
1) 0,1,6,8,9
2) If n=4 from 1000 to 9999 -> Generate number. do palindrome string comparism.
3) This goes timeout error. Due to too many number generation.
======Solution based on Data Analysis=========
    LetterCombinationOfPhoneNumber.png


Loop runs n/2 times only. Because we are appending 2 character each time.
===============


 *
 */
public class StrobogrammaticNumberIIBFS {

  public List<String> findStrobogrammatic(int n) {

    LinkedList<String> q = new LinkedList<>();
    if (n % 2 == 1) {
      q.offer("0");
      q.offer("1");
      q.offer("8");
    } else {
      q.offer("");
    }
    int totalLoopToRun = n / 2;
    for (int i = 1; i <= totalLoopToRun; ++i) {
      int size = q.size();
      for (int j = 0; j < size; j++) {
        String currNumber = q.poll();

        q.offer("1" + currNumber + "1");
        q.offer("6" + currNumber + "9");
        q.offer("8" + currNumber + "8");
        q.offer("9" + currNumber + "6");

        // Skip inserting 00 for last iteration of loop.
        if (i != totalLoopToRun) q.offer("0" + currNumber + "0");
      }
    }
    return q;
  }
}

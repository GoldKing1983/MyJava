package com.interview.leetcode.google.medium;

import java.util.TreeMap;

/*
https://leetcode.com/problems/my-calendar-ii/

Requirement: Double Booking is allowed. Whereas Triple Booking is not allowed.

[10,20],[10,40],[25,55],[21,22]
Output: True, True, True, True
==================================================Execution Flow==================================================
[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]
true,true,true,false,true,true]
	==========Step1 Insertion of [10,20]==========
Insertion
10    0+1 =  1
20    0-1 = -1
MapValues	Sum
[10,1]  	 1
[20,-1]  	 0
	==========Step2 Insertion of [50,60]==========
Insertion
50    0+1 =  1
60    0-1 = -1
MapValues	Sum
[10,1] 		 1
[20,-1] 	 0
[50,1] 		 1
[60,-1] 	 0
	==========Step3 Insertion of [10,40]==========
Insertion
10    1+1 =  2
40    0-1 = -1
MapValues	Sum
[10,2] 		 2
[20,-1] 	 1
[40,-1] 	 0
[50,1] 		 1
[60,-1] 	 0
	==========Step4 Insertion of [5,15]==========
Insertion
5     0+1 =  1
15    0-1 = -1
MapValues	Sum
[5,1]		 1
[10 2]		 3
----->greater than 2. Revert the current entry [5,15] +1 to -1 and -1 to +1. So Map look like in Step3
	==========Step5 Insertion of [5,10]==========
Insertion
5      0+1 = 1
10     2-1 = 1
MapValues	Sum
[5,1] 		 1
[10,1] 		 2
[20,-1] 	 1
[40,-1] 	 0
[50,1] 		 1
[60,-1] 	 0
	==========Step5 Insertion of [25,55]==========
Insertion
25     0+1 = 1
55     0-1 =-1
MapValues	Sum
[5,1] 		 1
[10,1] 		 2
[20,-1] 	 1
[25,1] 		 2
[40,-1] 	 1
[50,1] 		 2
[55,-1] 	 1
[60,-1] 	 0

 */
public class MyCalendarII {
  TreeMap<Integer, Integer> map;

  public MyCalendarII() {
    map = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    map.put(start, map.getOrDefault(start, 0) + 1);
    map.put(end, map.getOrDefault(end, 0) - 1);
    int runningCount = 0;
    for (Integer l : map.values()) {
      runningCount += l;
      if (runningCount > 2) { // revert back and return false
        map.put(start, map.get(start) - 1);
        map.put(end, map.get(end) + 1);
        return false;
      }
    }
    return true;
  }
}

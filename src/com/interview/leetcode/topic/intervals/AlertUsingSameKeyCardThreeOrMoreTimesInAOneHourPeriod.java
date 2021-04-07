package com.interview.leetcode.topic.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

1) Given a list of names and list of times. 
2) Return true, if three consecutive times makes less than or equal to 1 hour.
3) We don't need to consider days. Ex: "23:50", "23:55", "00:05" all 3 happens in same days. 
So if I sort  "00:05","23:50", "23:55" there is no consecutive events of 3 times of 1 hour occurred.

============================================================Example1=============================================================
Input: keyName = ["daniel","daniel","daniel","luis","luis","luis","luis"], 
       keyTime = ["10:00","10:40","11:00","09:00","11:00","13:00","15:00"]
Output: ["daniel"]
Explanation: "daniel" has 3 consecutive time start from 10:00  which lies in 1 hour
             "luis" has atmost only 2 consecutive time which is within 1hour
============================================================Example2=============================================================
Input: keyName = ["alice","alice","alice","bob","bob","bob","bob"], 
       keyTime = ["12:01","12:00","18:00","21:00","21:20","21:30","23:00"]
Output: ["bob"]
Explanation: "bob" used the keycard 3 times in a one-hour period ("21:00","21:20", "21:30").
============================================================Example3=============================================================
Input: keyName = ["john","john","john"]
       keyTime = ["23:50","23:55","00:05"]
Output: []       
Explanation: As per requirement, if I sort then third event("00:01") happens very beginning. 
             So there is no consecutive events happened in 1 hour.  
========================================================Solution Approach========================================================
1) Key to the problem is converting the time to minutes and sort it. 
  Ex: 11:05 will be converted into 11*60+5 = 660+5=665.
  Ex: 11:06 will be converted into 11*60+5 = 660+6=666.

2) Sort. 
  Ex: ["23:50","23:55","00:05"]
  Sorted time : [5, 1430, 1435]

3) Compare 1st and 3rd time. If the difference is <= 60. Then result found.    
  
  

 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    Map<String, List<Integer>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    for (int i = 0; i < keyName.length; i++) { // cache all visits for same person.
      String k = keyName[i];
      map.computeIfAbsent(k, g -> new ArrayList<>()).add(getTime(keyTime[i]));
    }
    for (String k : map.keySet()) {
      List<Integer> l = map.get(k);
      Collections.sort(l); // sort to find the connective events

      for (int i = 0; i < l.size() - 2; i++) {
        int firstTimeInMin = l.get(i);
        int thirdTimeInMin = l.get(i + 2);
        if (thirdTimeInMin - firstTimeInMin <= 60) { // connective 3 within 60 mins.
          res.add(k);
          break;
        }
      }
    }

    Collections.sort(res);
    return res;
  }

  private int getTime(String t) { // Convert the time to minutes
    String[] ss = t.split(":");
    return Integer.parseInt(ss[1]) + 60 * Integer.parseInt(ss[0]);
  }

}

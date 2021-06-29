package com.interview.leetcode.topic.intervals;

import java.util.Arrays;

/*

https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/

1) Given an array of startDay,endDay of events.
2) Return the numberOfEvents person can attend.
3) Person don't need to attend the event fully. 
Ex: If event happens for 2 day, he can attend any one day.


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Event1 happens on day1 and day2. Attend the event1 on day 1.
Event2 happens on day2 and day3. Attend the event1 on day 2.
Event2 happens on day3 and day4. Attend the event1 on day 3 or day4.

 
1) Sort by endDate
2) Traverse each event from startDay to endDay. 
3) Greedily choose the first availableDay to attend event.
 */
public class MaximumNumberOfEventsThatCanBeAttended {

  public int maxEvents(int[][] events) {
    Arrays.sort(events, (a, b) -> a[1] - b[1]);

    boolean[] day = new boolean[100001];

    for (int i = 0; i < events.length; ++i) {
      for (int j = events[i][0]; j <= events[i][1]; j++) {
        if (!day[j]) {
          day[j] = true;
          break;
        }
      }
    }

    int sum = 0;
    for (boolean k : day) if (k) sum++;

    return sum;
  }
}

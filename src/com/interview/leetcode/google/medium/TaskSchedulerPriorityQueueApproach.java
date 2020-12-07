package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/task-scheduler/description/
Similar to ReorganizeString

between two same tasks, there must be at least n intervals of "different tasks" or "idle".
======================================================================================================================
["A","A","A","B","B","B"] n=0
Output:6
======================================================================================================================
["A","A","A","B","B","B"] n=1
Output:6
======================================================================================================================
["A","A","A","B","B","B"] n=2
Output:6
===================================Initial Thought about arranging===================================
1) Round Robin approach will not work...
	Ex: [A,A,A,A,A,B,C,D,E], n=2 -->Round-Robin will take 15 intervals. But can be done in 13

	pQ Approach : AB CA DE Ai iA ii A      =======> 13
	Round Robin : AB CD EA ii Ai iA ii A   =======> 15
===============================Solution Approach=========================================================================
1) Idea is to add "countsOfEachTasks" to a priority Q and sort based on the highest frequency.
2) Pick the task in each round of 'n' with highest frequency.
3) As you pick the task, decrease the frequency, save in pendingTask, and put them back to queue after "Each Round".
 */
public class TaskSchedulerPriorityQueueApproach {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
    PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    pQ.addAll(map.values());
    int count = 0;
    while (true) {
      int interval = n; // If n=2, loop runs 3 times or till pQ exhaust
      List<Integer> pendingTasks = new ArrayList<>();
      while (interval >= 0 && !pQ.isEmpty()) {
        Integer top = pQ.poll(); // most frequency task
        pendingTasks.add(top - 1); // collect task to add back to queue
        interval--;
        count++; // successfully executed task
      }
      // add valid remaining tasks
      for (Integer pendingTask : pendingTasks) if (pendingTask > 0) pQ.add(pendingTask);

      if (pQ.isEmpty()) break;
      count = count + interval + 1; // add "remaining or idle" and +1 for next round.
    }
    return count;
  }
}

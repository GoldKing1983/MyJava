package com.sample.datastructure;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/implement-stack-using-queues/discuss/62516/Concise-1-Queue-Java-C++-Python
===========================================================Requirement===========================================================
1) Can be done with single queue instead of 2 queues.
2) Think of people waiting in line. Make the currentPerson stand in line. 
3) Move n-1 to go and stand behind currentPersion. Just loop is enough. 
=======================================================Data Flow Analysis========================================================
Ex: 1,2,3

  1
  
  
  1,2 --> Add 2 to queue. 
  2,1 --> circle 1 back
  
  
  2,1,3 --> Add 3 to queue. 
  1,3,2 --> circle 2 back.
  3,2,1 --> circle 1 back.
  
 */
public class StackUsingQueue {
	Queue<Integer> q;

	public StackUsingQueue() {
		q = new LinkedList<>();
	}

	public void push(int x) {
		q.offer(x);
		int length = q.size() - 1;
		for (int i = 0; i < length; i++) {
			q.offer(q.poll());
		}
	}

	public int pop() {
		return q.poll();
	}

	public int top() {
		return q.peek();
	}

	public boolean empty() {
		return q.isEmpty();
	}

}

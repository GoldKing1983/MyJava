package com.interview.leetcode.topic.linkedlist;

import java.util.Random;

import com.interview.leetcode.ListNode;

/*
https://leetcode.com/problems/linked-list-random-node/description/
http://blog.jobbole.com/42550/
===========================================================Requirement===========================================================
1) Given a singly linked list, return a random node's value from the linked list. 
2) Each node must have the "same probability of being chosen".
3) You cannot parse all the data and decide. Because assume you cannot use any additional memory.
4) You can read or have only one data at a time and only one result(it could be current or previous) at a time 
5) "Do it in 1 pass" and "without extra-memory"
================================================Initial Thought - With Extra Space===============================================
1) Parse the ListNode and add all numbers to list.
2) generate a number between 0 and list.size() and send that number.
3) This approach is completely right. But how can we do it without extra space. 
=====================================================Initial Thought - 2Pass====================================================
1) Get the count of all data.
2) generate a number between 0 and count. Parse ListNode again till randomNumber and return the data.
3) This approach is completely right. But now we are passing the input 2 times which is costly. 
4) See the solution LinkedListRandomNode2Pass
=================================================Initial Thought - Wrong Approach================================================
1) FirstNumber add directly to result.
2) For second number generate number between 0 and 1. Then choose/delete anyone based on that,
    That will make the probability as
    1/2, 1/2, 1/2, 1/2 every time, which is wrong.

3) Above is 100% wrong,. Ex: for a 50 data in list. 
50th data has the probability of winning 50%, whereas 1st data has to survive a lot or 0% to survive and cannot till end.

4) The property "same probability of being chosen" is gone.
=================================================Initial Thought - Right Approach================================================
1) The Random should works like the probability 1, 1/2, 1/3, 1/4, 1/5, 1/6..
2) Lets say list has 5 numbers.
  During the iteration of 1st number, the probability of picking 1st number is 1.
  During the iteration of 2nd number , the probability of picking 1st number and 2nd number is 1/2.
  During the iteration of 3rd number , the probability of picking 1st number,2nd number or 3rd number is 1/3.
========================================================Solution Approach========================================================
1) Initially count is 1.
2) generate random number between 0 and count(firstTime random can generate only 0).
3) If that number is 0. Then update result to currentNumber.
4) Increment count.
5) Continue step2 Till all data is exhausted.



See also "RandomPickIndex"
This is also called "Reservoir Sampling solution"
 */
public class LinkedListRandomNode {

  ListNode tempHead;
  Random random;

  public LinkedListRandomNode(ListNode h) {
    tempHead = h;
    random = new Random();
  }

  // Picking 0 as Sample
  public int getRandom() {
    ListNode head = tempHead;
    int count = 1;
    int result = -1;
    while (head != null) {
      if (random.nextInt(count++) == 0) {
        result = head.val;
      }
      head = head.next;
    }
    return result;
  }

  // Picking current list size as Sample
  public int getRandomSolution2() {
    ListNode head = tempHead;
    int count = 0;
    int result = -1;
    while (head != null) {
      int randomPick = random.nextInt(++count) + 1;
      if (count == randomPick) {
        result = head.val;
      }
      head = head.next;
    }
    return result;
  }

  public int getRandomWrongVersion() {
    ListNode head = tempHead;
    int prevVal = head.val;
    while (head.next != null) {
      head = head.next;
      // Generate 0 or 1. if 1 replace prveValue else keep prevValue. But this is wrong and not passing all test cases.
      if (random.nextInt(2) == 1) {
        prevVal = head.val;
      }
    }

    return prevVal;
  }

}

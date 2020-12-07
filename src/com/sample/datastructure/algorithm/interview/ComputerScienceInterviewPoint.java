package com.sample.datastructure.algorithm.interview;

import java.util.Deque;
import java.util.LinkedList;

/*

1) We can get Binary number from leftToRight and rightToLeft using >> and <<.
   Example: BinaryGapLeftShift, BinaryGapRightShift
   But Getting Decimal number from leftToRight is complex. Only use builtIn method. 
   Example: StringCompression
   But Getting Decimal number from rightToLeft is easy. Just divide by 10.
   
2) Use LinkedList for plain stack and queue operation. Because operation is O(1).
   
   Use ArrayDeque if there is a need for search by index too like multi-purpose usage. 
   
3) Convert binary to integer - SumOfRootToLeafBinaryNumbersDFS
               =====101 ==> 5
               0*2 + 1 = 1
               1*2 + 0 = 2
               2*2 + 1 = 5
  */
public class ComputerScienceInterviewPoint {
  public static void main(String[] args) {
    Deque<Integer> stack = new LinkedList<>();
    stack.push(1);
    stack.pop();

    Deque<Integer> queue = new LinkedList<>();
    queue.offer(1);
    queue.poll();
  }
}

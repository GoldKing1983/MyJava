package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogramStackApproachPrintAnalysis {
  public int largestRectangleArea(int[] height) {

    int max = 0;
    int leftIndex = 0;
    Deque<Integer> stack = new ArrayDeque<>();

    while (leftIndex < height.length) {
      System.out.println("        ====================        ");
      System.out.println("Starting Process at Index: " + leftIndex);
      if (stack.isEmpty() || height[leftIndex] > height[stack.peek()]) {
        Integer prev = stack.isEmpty() ? null : height[stack.peek()];
        System.out.println(
            "Current Value "
                + height[leftIndex]
                + " is > than "
                + prev
                + " Previous Value, so pushing current to stack");
        stack.push(leftIndex);
        leftIndex++;
      } else {
        int topIndex = stack.pop();
        int topValue = height[topIndex];

        Integer previousIndex = stack.isEmpty() ? null : stack.peek();

        int currentArea = 0;
        if (previousIndex == null) currentArea = topValue * leftIndex;
        else {
          System.out.println(
              "Current Value "
                  + height[leftIndex]
                  + " "
                  + "is <= to Previous Value "
                  + topValue
                  + ", so calculating area between index "
                  + (leftIndex - 1)
                  + " and "
                  + (stack.peek() + 1));
          currentArea = topValue * (leftIndex - stack.peek() - 1);
        }

        max = Math.max(currentArea, max);
        System.out.println(
            "Area between index "
                + (leftIndex - 1)
                + " and "
                + (stack.peek() + 1)
                + " is: "
                + currentArea
                + ". MaxArea is: "
                + max);
        System.out.println(
            "      ===Note: LeftIndex is Not Incremented. So next process will happen at same leftIndex=== ");
      }
    }

    while (!stack.isEmpty()) {
      int topIndex = stack.pop();
      int topValue = height[topIndex];
      int top2IndexWidth = stack.isEmpty() ? leftIndex : leftIndex - stack.peek() - 1;
      max = Math.max(topValue * top2IndexWidth, max);
    }

    return max;
  }
}

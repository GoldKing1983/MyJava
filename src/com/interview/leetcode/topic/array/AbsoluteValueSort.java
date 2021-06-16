package com.interview.leetcode.topic.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AbsoluteValueSort {

  static int[] absSortUsingSort(int[] arr) {
    // Note: Arrays.sort comparator cannot work on int
    //Arrays.sort(arr, (int a, int b) -> a - b);

    return null;

  }

  static int[] absSort(int[] arr) {
    // Case both are same...
    // [-5,5]... -5 first
    // [5,-5]... -5 first

    // Case both are different...
    // [-5,4]... 4 first
    // [4,-5]... 4 first

    // If both are same then sort by a-b..
    // Else sort by Math.abs(a)-Math.abs(b)..
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a, b) -> Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b));
    for (int a : arr) pq.offer(a);

    int[] result = new int[arr.length];
    int resultIndex = 0;
    while (!pq.isEmpty()) result[resultIndex++] = pq.poll();
    return result;
  }



  public static void main(String[] args) {
    int[] arr = new int[] {2, -7, -2, -2, 0}; // output: [0, -2, -2, 2, -7]
    System.out.println(Arrays.toString(absSort(arr)));
  }

}

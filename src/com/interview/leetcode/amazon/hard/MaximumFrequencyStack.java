package com.interview.leetcode.amazon.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*

https://leetcode.com/problems/maximum-frequency-stack/
========================Logic=================================================
1) Create Data Structure like Matrix.
1st row will have element with count1.
2nd row will have element with count1 and count2.
3rd row will have element with count1 and count2 and count3.
Ex: For Input:[5],[7],[5],[7],[4],[5]
	Below is the matrix created.
	[5,7,4]
	[5,7]
	[5]
2) Remove operation will happen from "last row" "last data".
For above operation 3rd row 1st data will be removed.

========================PUSH Operation========================================
When adding element, group the element "by their count" and "by their order".
This is achieved by map and LinkedList<LinkdeList> list data structure.
So for the first 3(5,7,5) element with 1 duplicate below is the sequence

{5=1}
[[5]] -> add 5 to gropu1

{5=1, 7=1}
[[5, 7]] -> add 7 to gropu1

{5=2, 7=1}
[[5, 7], [5]] -> add 5 to gropu2

========================POP Operation========================================
Remove from "top of list" with "top value".
Ex: 3rd row 3rd Element.
After  removing if size of row is 0. remove that entry.
Reduce the map "count of that value" by 1.(Removing the value from map is not necessary if count==0.)
===================================================================
[[],[5],[7],[5],[7],[4],[5],[3],[],[],[],[]]

{5=1}
[[5]]

{5=1, 7=1}
[[5, 7]]

{5=2, 7=1}
[[5, 7], [5]]

{5=2, 7=2}
[[5, 7], [5, 7]]

{4=1, 5=2, 7=2}
[[5, 7, 4], [5, 7]]

{4=1, 5=3, 7=2}
[[5, 7, 4], [5, 7], [5]]

{3=1, 4=1, 5=3, 7=2}
[[5, 7, 4, 3], [5, 7], [5]]


 */
public class MaximumFrequencyStack {
  private LinkedList<LinkedList<Integer>> list;
  private Map<Integer, Integer> map;

  public MaximumFrequencyStack() {
    list = new LinkedList<>();
    map = new HashMap<>();
  }

  public void push(int x) {
    map.put(x, 1 + map.getOrDefault(x, 0));
    int freq = map.get(x);
    if (list.size() < freq) list.add(new LinkedList<>());
    list.get(freq - 1).add(x);
  }

  public int pop() {
    int val = list.getLast().removeLast();
    if (list.getLast().isEmpty()) list.removeLast();
    map.put(val, map.get(val) - 1);
    return val;
  }
}

package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/add-bold-tag-in-string/

Ex1:
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

====================================Solution Approach========================================================================
1) Find all the start index and end index of dictionary word found in input string.
2) For Ex1: below is the start/end list. Note we add 1 at end for merging.
	[[0, 3], [1, 4], [4, 6]]
     aaa     aab      bc
3) Use MergeInterval and combine all over-lapping. Merged interval is 0-6
4) insert bold tag in start and end index.
==============================================================================================================================
 */
public class AddBoldTagInString {
  public void merge(List<Integer> startT, List<Integer> endT, List<int[]> mergedList) {
    int start = 0;
    for (int i = 1; i < startT.size(); i++) {
      if (startT.get(i) <= endT.get(i - 1)) {
        continue; // merge Needed. So continue
      }
      // distinct interval. No merge Needed. So add it to result.
      mergedList.add(new int[] {startT.get(start), endT.get(i - 1)});
      start = i;
    }
    mergedList.add(new int[] {startT.get(start), endT.get(startT.size() - 1)});
  }

  public String addBoldTag(String s, String[] dict) {
    if (dict.length == 0) return s;
    List<Integer> startT = new ArrayList<>();
    List<Integer> endT = new ArrayList<>();
    for (String str : dict) {
      int index = -1;
      // For each of dictionary of "word", search till nothing(-1) exists.
      while (true) {
        index = s.indexOf(str, index);
        if (index == -1) break;
        startT.add(index);
        endT.add(index + str.length());
        index += 1; // cannot be index+=str.length();
      }
    }
    if (startT.isEmpty()) return s;
    Collections.sort(startT);
    Collections.sort(endT);
    List<int[]> mergedList = new ArrayList<>();

    merge(startT, endT, mergedList);

    for (int[] interv : mergedList)
      System.out.println("Interval To Add " + Arrays.toString(interv));

    StringBuilder sb = new StringBuilder(s);
    int adjustment = 0;
    for (int[] interval : mergedList) {
      int boldStart = interval[0];
      int boldEnd = interval[1];
      sb.insert(boldStart + adjustment, "<b>");
      adjustment += 3;
      sb.insert(boldEnd + adjustment, "</b>");
      adjustment += 4;
    }
    return sb.toString();
  }
}

package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  https://leetcode.com/problems/sort-characters-by-frequency/description/

1) To avoid sorting, take "maximumFrequency" as "maximumBucketSize".
2) Ex: Tree
maximumBucketSize = 2... Bucket created with index0 and index1 and index2
index0 is leftout for easier iteration.
index1 is filled with all size 1 characters.  (T,r)
index2 is filled with all size 2 characters. (e)

3) Ex: Treee
maximumBucketSize = 3... Bucket created with index0 and index1 and index2 and index3
index0 is leftout for easier iteration.
index1 is filled with all size 1 characters.(T,r)
index2 is empty. Because there nothing with size2.
index3 is filled with all size 3 characters.(e)

*/
public class SortCharactersByFrequencyBucketApproach {
  public String frequencySort(String s) {

    if (s == null || s.isEmpty()) return s;

    // Count up the occurances.
    Map<Character, Integer> counts = new HashMap<>();
    for (char c : s.toCharArray()) counts.put(c, counts.getOrDefault(c, 0) + 1);

    int maximumFrequency = Collections.max(counts.values());

    // Make the list of buckets and apply bucket sort.
    List<List<Character>> buckets = new ArrayList<>();
    for (int i = 0; i <= maximumFrequency; i++) buckets.add(new ArrayList<Character>());

    for (Character key : counts.keySet()) {
      int freq = counts.get(key);
      buckets.get(freq).add(key);
    }

    // Build up the string.
    StringBuilder sb = new StringBuilder();
    for (int i = buckets.size() - 1; i >= 1; i--) {
      for (Character c : buckets.get(i)) {
        for (int j = 0; j < i; j++) {
          sb.append(c);
        }
      }
    }
    return sb.toString();
  }
}

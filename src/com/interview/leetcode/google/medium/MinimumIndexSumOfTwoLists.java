package com.interview.leetcode.google.medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*
Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite
restaurants represented by strings.

You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers,
output all of them with no order requirement. You could assume there always exists an answer.

Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+

================Code for Requirement================================
 */

public class MinimumIndexSumOfTwoLists {
  public String[] findRestaurant(String[] list1, String[] list2) {
    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();
    for (int i = 0; i < list1.length; i++) map1.put(list1[i], i);
    // Add string which present in both list with their sum of index.
    for (int i = 0; i < list2.length; i++) {
      String currRest = list2[i];
      if (map1.containsKey(currRest)) {
        map2.put(currRest, i + map1.get(currRest));
      }
    }

    // Get the smallest index
    Collection<Integer> indexSum = map2.values();
    Integer min = Integer.MAX_VALUE;
    for (Integer i : indexSum) min = Math.min(i, min);

    // Find the number of occurrence of min
    int count = 0;
    for (Integer i : indexSum) if (i.equals(min)) count++;

    String result[] = new String[count];
    if (count == 0) return result;
    int i = 0;
    for (Map.Entry<String, Integer> entry : map2.entrySet()) {
      if (entry.getValue().equals(min)) result[i++] = entry.getKey();
    }
    return result;
  }
}

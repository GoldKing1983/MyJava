package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/map-sum-pairs/

1) insert : Sum and Insert at first time. Bit Tricky
2) sum : Simply get from map.

Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5(2+3)
Input: insert("appa", 6), Output: Null
Input: sum("ap"), Output: 11(2+6+3)
Input: sum("app"), Output: 11(2+6+3)
Input: sum("a"), Output: 11(2+6+3)
						 a
						/
					   p
					  /
					 p(2)
   					/ \
   				   l   a(6)
   				  /
   				 e(3)
==================================Solution Approach - save the sum in beginning=============================
input: "apple,3" then "app,2"
		=====================Case1... Big first inserted=============
When inserting apple with 3.
	a -> 3
	ap -> 3
	app -> 3
	appl -> 3
	apple -> 3

When inserting app with 2.
	a -> 5
	ap -> 5
	app -> 5
		=====================Case2... Small first inserted=============
input: "app,2" then "apple,3"

When inserting app with 2.
	a -> 2
	ap -> 2
	app -> 2

When inserting apple with 3.
	a -> 5
	ap -> 5
	app -> 5
	appl -> 3
	apple -> 3

		==================Case3... Small first inserted. Duplicate comes with different value=============
input: "app,2" then "apple,3" then "app,1"

When inserting app with 2.
	a -> 2
	ap -> 2
	app -> 2

When inserting apple with 3.
	a -> 5
	ap -> 5
	app -> 5
	appl -> 3
	apple -> 3

When inserting app with 1.
	a -> 4
	ap -> 4
	app -> 4
	appl -> 3
	apple -> 3

==================================2nd HashMap is needed for Case3==================================
["MapSum", "insert", "sum", "insert", "sum"]
[      [], ["aa",3], ["a"], ["aa",2], ["a"]]

Output  : [null,null,3,null,5]
Expected: [null,null,3,null,2]
==================================Time Complexity====================================================================
because of s += c. This operation is not O(1), it's O(String::length), which makes for loop to be k^2.
And this will break when string is long.

insert: O(n^2)
sum : O(1)
======================================================================================================
 */
public class MapSumPairsHackUsingTwoMap {
  Map<String, Integer> prefixSum = new HashMap<>();;
  Map<String, Integer> source = new HashMap<>();

  public void insert(String key, int val) {
    val -= source.getOrDefault(key, 0); // calculate the diff to be added to prefixes
    String s = "";
    for (char c : key.toCharArray()) {
      s += c; // creating all prefixes
      prefixSum.put(s, prefixSum.getOrDefault(s, 0) + val);
    }
    source.put(key, source.getOrDefault(key, 0) + val);
  }

  public int sum(String prefix) {
    return prefixSum.getOrDefault(prefix, 0);
  }
}

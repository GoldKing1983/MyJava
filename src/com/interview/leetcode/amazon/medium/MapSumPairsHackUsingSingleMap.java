package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/map-sum-pairs/

1) Insert the way like trie...
2) For the method sum, you'll be given a string representing the prefix, and you need to
return the sum of all the pairs' value whose key starts with the prefix.

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
==================================Solution Approach=============================
input: "apple,3" then "app,2"
		=====================Case1... Big first inserted=============
When inserting apple with 3.
	a -> 3
	ap -> 3
	app -> 3
	appl -> 3
	apple -> 3

When inserting app with 2.
	a -> 2
	ap -> 2
	app -> 2
		=====================Case2... Small first inserted=============
input: "app,2" then "apple,3"

When inserting app with 2.
	a -> 2
	ap -> 2
	app -> 2

When inserting apple with 3.
	a -> 3
	ap -> 3
	app -> 3
	appl -> 3
	apple -> 3

		==================Case3... Small first inserted. Duplicate comes with different value=============
input: "app,2" then "apple,3" then "app,1"

When inserting app with 2.
	a -> 2
	ap -> 2
	app -> 2

When inserting apple with 3.
	a -> 3
	ap -> 3
	app -> 3
	appl -> 3
	apple -> 3

When inserting app with 1.
	a -> 1
	ap -> 1
	app -> 1
	appl -> 3
	apple -> 3

==================================2nd HashMap is needed for Case3==================================
["MapSum", "insert", "sum", "insert", "sum"]
[      [], ["aa",3], ["a"], ["aa",2], ["a"]]

Output  : [null,null,3,null,5]
Expected: [null,null,3,null,2]
==================================Time Complexity====================================================================
insert: O(1)
sum : O(n)
======================================================================================================
 */
public class MapSumPairsHackUsingSingleMap {
  Map<String, Integer> prefixSum = new HashMap<>();

  public void insert(String key, int val) {
    prefixSum.put(key, val);
  }

  public int sum(String prefix) {
    int sum = 0;
    for (String s : prefixSum.keySet()) {
      if (s.startsWith(prefix)) {
        sum += prefixSum.get(s);
      }
    }
    return sum;
  }
}

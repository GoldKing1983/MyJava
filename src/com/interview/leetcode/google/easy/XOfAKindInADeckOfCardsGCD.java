package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/
In a deck of cards, each card has an integer written on it.
Return true if and only if you can choose "equal size" of "same number of cards"

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.

Input: deck = [1]
Output: false
Explanation: No possible partition.

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].
Example 5:
======================================Why GCD is needed=====================================================
Input: deck = [1,1,2,2,2,2,3,3,3,3,3,3]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2],[3,3],[3,3],[3,3].

Map will have
1 -> 2
2 -> 4
3 -> 6
==========
Input: deck = [1,1,1,2,2,2,2,2,2]
Output: true
Explanation: Possible partition [1,1,1][2,2,2][2,2,2]

Map will have
1 -> 3
2 -> 6

============================================================================================================
======Requirements Understanding======
1) Split the numbers into equal groups.
2) a group should have same number.
===============
========Solution=====
1) Put all the unique elements as "key" with its count "count" into map.
2) We can ignore key.
3) Take the values, which is count.
4) For GCD calculation. I can always calculate between current and previous number alone or I can 
save GCD and use that with next number. Both will work  
 */
public class XOfAKindInADeckOfCardsGCD {

  public boolean hasGroupsSizeX(int[] deck) {
    if (deck.length == 1) return false;
    Map<Integer, Integer> count = new HashMap<>();
    int gcd = 0;
    for (int i : deck) {
      count.put(i, count.getOrDefault(i, 0) + 1);
    }
    List<Integer> deckNumberCounts = new ArrayList<>(count.values());

    for (int i = 1; i < deckNumberCounts.size(); i++) {
      int currentNumberCount = deckNumberCounts.get(i);
      int previousNumberCount = deckNumberCounts.get(i - 1);
      gcd = gcd(currentNumberCount, previousNumberCount);

      if (gcd == 1) return false;
    }
    return true;
  }
  // GCD of [3,5] = 1...[3,6] = 2
  // Swap operation with %
  public int gcd(int a, int b) {
    if (a == 0) return b; // To avoid DivideByZero issue
    while (true) {
      int temp = a;
      a = b % a;
      b = temp;
      if (a == 0) break;
    }
    return b;
  }
}

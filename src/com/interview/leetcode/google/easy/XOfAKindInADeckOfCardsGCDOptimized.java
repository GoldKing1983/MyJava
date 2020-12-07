package com.interview.leetcode.google.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/description/

 */
public class XOfAKindInADeckOfCardsGCDOptimized {

  public boolean hasGroupsSizeX(int[] deck) {
    if (deck.length == 1) return false;
    Map<Integer, Integer> count = new HashMap<>();
    int gcd = 0;
    for (int i : deck) {
      count.put(i, count.getOrDefault(i, 0) + 1);
    }
    List<Integer> deckNumberCounts = new ArrayList<>(count.values());

    // Ex: Deck with [1,1]
    if (deckNumberCounts.size() == 1) return true;

    int currentNumberCount = deckNumberCounts.get(0);
    int previousNumberCount = deckNumberCounts.get(1);
    gcd = gcd(currentNumberCount, previousNumberCount);

    for (int i = 2; i < deckNumberCounts.size(); i++) {
      currentNumberCount = deckNumberCounts.get(i);
      if (currentNumberCount % gcd != 0) return false;
    }
    return true;
  }

  private int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}

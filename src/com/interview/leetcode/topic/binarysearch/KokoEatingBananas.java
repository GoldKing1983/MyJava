package com.interview.leetcode.topic.binarysearch;

/*

https://leetcode.com/problems/koko-eating-bananas/

1) Given a piles of banana. 
2) Task is to eat all banana in given hour
3) Condition is if koko eats k bananas, then remaining has to be finished without picking next.
  Ex:piles[10].. h=2
  each hour 5... So answer is 2
  
  Ex:piles[11].. h=3
  each hour 4... So answer is 3. 
  5 can also be answer. But best pick is 4.
  If I choose 3 then only 9 can be finished in 3 hour.

    Input: piles = [3,6,7,11], h = 8
Output: 4
    11 - 3h
    7 -  2h
    6 -  2h
    3 -  1h    
if koko eats 4 or more per hour it can finish eating all the bananas. We pick minimum    
    
    
 */
public class KokoEatingBananas {
  public int minEatingSpeed(int[] piles, int h) {
    return binSearch(piles, 0, 1000000000, h);
  }

  private int binSearch(int[] piles, int low, int high, int hour) {
    // l=1 h=8.. l=3 h=5..l=3 h=4.. l=4 h=4
    if (low >= high) return low;
    int mid = low + (high - low) / 2;
    if (canEatAll(piles, hour, mid)) {
      return binSearch(piles, low, mid, hour);
    }
    return binSearch(piles, mid + 1, high, hour);
  }

  private boolean canEatAll(int[] piles, int hour, int k) {
    if (k == 0) return false;
    int hourTakenToEat = 0;
    for (int pile : piles) {
      // ex1: pile=11, k=4 then hourTakenToEat=3
      // ex2: pile=8 , k=4 then hourTakenToEat=2
      hourTakenToEat += (pile / k) + (pile % k == 0 ? 0 : 1);
    }
    return hourTakenToEat <= hour;
  }
}

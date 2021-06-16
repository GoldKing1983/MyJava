package com.interview.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BlackRockInterviewQuestion2 {
  /*
  1) Use set to track unique numbers.
  2) Ex: [1,2,3,4,5,6]. Iterate each numbers. 
  3) If currentNumber-k exists in set then increment resultCount
  4) If currentNumber+k exists in set then increment resultCount
  5) Remove currentNumber from set. Because it cannot be used again for another pair.
  6) Corner case1: if k==0. Then resultCount=uniqueNumbers.size()
  7) Corner case2: For step3, if number-k >= 0 then only I need to proceed because negative numbers are not allowed.
  8) Corner case3: For step4, if number+k <= 1000000000 then only I need to proceed because max number range is 1000000000.
  9) Time Complexity : O(n)... I am running 2 loops. So O(n)+O(n) ~= O(n). Set operations(add/remove) are considered O(1). 
  10) Space Complexity : O(n)... due to the usage of set
  */
  public static int countPairs(List<Integer> numbers, int k) {
    Set<Integer> uniqueNumbers = new HashSet<>();
    for (Integer currentNumber : numbers) {
      uniqueNumbers.add(currentNumber);
    }
    if (k == 0) return uniqueNumbers.size();
    int resultCount = 0;
    // Iterators in Java are fail-safe. So I am allowed to remove(remove from iterator) element while iteration. 
    Iterator<Integer> uniqueNumbersIterator = uniqueNumbers.iterator();
    while (uniqueNumbersIterator.hasNext()) {
      int currentNumber = uniqueNumbersIterator.next();
      if (currentNumber - k >= 0 && uniqueNumbers.contains(currentNumber - k)) {
        resultCount++;
      }
      if (currentNumber + k <= 1000000000 && uniqueNumbers.contains(currentNumber + k)) {
        resultCount++;
      }
      uniqueNumbersIterator.remove();
    }
    return resultCount;

  }
}

package com.sample.tricky;

import java.util.HashMap;

/*
https://leetcode.com/problems/roman-to-integer/

=====================================================Solution Approach===========================================================
1) Parse from last-1 to first.
2) Initially assign lastNumber as result.
   Then in each iteration, compare "currentNumber" and "nextNumber".
 	"currentNumber" is added or subtracted to result based on condition.
3) If currentNumber is less than previousNumber. add "previousNumber" to result.
     										Else subtract "previousNumber" from result.
=====================================================Data Flow Analysis==========================================================
How to Solve this problem. Do data Analysis.
Ex1: 'X'.
	 I can directly return 10.

Ex2: 'IX'.
 	 No loop needed for X. 10 directly added to result.
 	 Loop Starts : Come from n-1.
	 Process I. Compare current and next. Loop runs 1 time.
	 If current is lesser, subtract current and result.

Ex3: 'XI'.
	 No loop needed for I. 10 directly added to result.
	 Loop Starts : Come from n-1.
	 Process X. Compare current and next. Loop runs 1 time.
	 If current is greater than next, add current and result.

Ex3: 'XX'.
	 No loop needed for X. 10 directly added to result.
	 Loop Starts : Come from n-1.
	 Process X. Compare current and next. Loop runs 1 time.
	 If current is equal to next, add current and result.

 */
public class RomanToInteger {

  private HashMap<Character, Integer> map = new HashMap<>();

  private void initMap() {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public int romanToInt(String s) {
    initMap();
    int n = s.length() - 1;
    Integer result = map.get(s.charAt(n));
    for (int i = n - 1; i >= 0; i--) {
      Integer currentNumber = map.get(s.charAt(i));
      Integer nextNumber = map.get(s.charAt(i + 1));
      if (currentNumber < nextNumber) result -= currentNumber;
      else result += currentNumber;
    }
    return result;
  }
}

package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
/*
 * https://leetcode.com/problems/confusing-number-ii/

// 1 6 8 9
// 0 1 6 8 9

//10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,
// 0 1 6 8 9


6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,
    100,106,108,109,
    110,116,118,119,
    160,161,166,168,169,180,186,188,189,190,191,196,198,199,


11 a combo, it is not a result. But it is needed for next permutation.

 */
public class ConfusingNumberIIMySolution {

  public int confusingNumberII(int N) {
    char[] comboSource = new char[] {'0', '1', '6', '8', '9'};
    Queue<StringBuilder> q = new ArrayDeque<>();
    q.offer(new StringBuilder("1"));
    q.offer(new StringBuilder("6"));
    q.offer(new StringBuilder("8"));
    q.offer(new StringBuilder("9"));
    if (N < 6) return 0;
    if (N < 9 && N > 5) return 1;
    if (N < 10) return 2;
    int count = 2;
    while (true) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        StringBuilder currCombo = q.poll();
        // System.out.println("Polled From Queue" + combo);
        for (int j = 0; j < comboSource.length; j++) {
          StringBuilder newCombo = new StringBuilder(currCombo);
          newCombo.append(comboSource[j]);
          if (Integer.parseInt(newCombo.toString()) > N) return count;
          if (confusingNumber(newCombo)) count++;
          q.offer(newCombo);
        }
      }
    }
  }

  private Map<Character, Character> map = new HashMap<>();

  {
    map.put('6', '9');
    map.put('9', '6');
    map.put('0', '0');
    map.put('1', '1');
    map.put('8', '8');
  }

  public boolean confusingNumber(StringBuilder s) {
    int len = s.length();
    StringBuilder reversedString = new StringBuilder(s);
    for (int i = 0; i < len; i++) {
      if (!map.containsKey(map.get(s.charAt(i)))) return false;
      reversedString.setCharAt(i, map.get(s.charAt(i)));
    }
    reversedString.reverse();
    return !s.toString().equals(reversedString.toString());
  }
}

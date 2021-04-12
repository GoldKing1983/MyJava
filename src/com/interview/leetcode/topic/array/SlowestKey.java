package com.interview.leetcode.topic.array;

/*
1) Given an array of times where each entry represents seconds and corresponding keysReleased at that time.
2) Return longestTime which key was pressed.
3) If there was a tie, return the biggest character.
4) Ex: [1,2,3,4][a b c d].. Ans:d (a,b,c,d all can be answer. But as per tie logic 'd' is the answer)
                           from 0To1 a was pressed.
                           from 1To2 b was pressed.
                           from 2To3 c was pressed.
                           from 3To4 c was pressed.

 */
public class SlowestKey {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    // If there is only 1 key pressed then answer is firstKey pressed time
    int maxLongestTime = releaseTimes[0];
    char longestTimePressedKey = keysPressed.charAt(0);

    // from 2ndKey pressedTime, compare current and longestTimePressedKey.
    for (int i = 1; i < keysPressed.length(); i++) {
      char currentPressedKey = keysPressed.charAt(i);
      int currentLongestTime = releaseTimes[i] - releaseTimes[i - 1];

      if (currentLongestTime == maxLongestTime) {
        // tie happened. Pick the biggest character just by below comparing..
        // Ex: a,b... b's integer value greater than a's integer value
        if (currentPressedKey > longestTimePressedKey) {
          longestTimePressedKey = currentPressedKey;
        }
      } else if (currentLongestTime > maxLongestTime) {
        maxLongestTime = currentLongestTime;
        longestTimePressedKey = currentPressedKey;
      }
    }
    return longestTimePressedKey;

  }
}

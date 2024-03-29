package com.interview.leetcode.topic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.
Input can contain "English letters, digits, symbols and spaces". So using array to track count is difficult.

"abcad" output:4 ("bcad")
"abcbad" output:4 ("cbad")
======================================================Solution Approach======================================================
1) In the actual sliding window, when a duplicate found. I will slide from left to index of duplicate character.
during the move I will delete all character in set.
2) delete and move is costlier operation.
3) In this optimized solution, save the index of each character.
4) When a duplicate found, move left to duplicateIndex+1.
4a) If duplicateIndex is less than left, then left is not updated... that means those duplicateIndex data should have already deleted.
Ex: abba. When index at 3. for "a" duplicate is found but left should not be updated.
5) Finally map will not be cleaned up, so it will have redundant data.

    input : abccbad
    left           dulplicate        dulplicate
    					             Index             maxSize
    =============================================================================
    0               No                      			0
    0               No                      			1
    0               No                      			2
    3               Yes     		2               	3 ---> left updated
    3               Yes     		1               	3 ---> left not updated
    3               Yes     		0               	3 ---> left not updated
    3               No                      			3 ---> left not updated

    input : abcabcab
    left   		dulplicate		dulplicate
    							Index 				  maxSize
    =============================================================================
    0           No                        			   0
    0           No                       			   1
    0           No                     			       2
    1           Yes         	0          			   3 ---> left updated
    2           Yes         	1          			   3 ---> left updated
    3           Yes         	2           		   3 ---> left updated
    4           Yes         	4          			   3 ---> left updated
    5           Yes         	6          			   3 ---> left updated
	=============================================================================
*/

public class LongestSubstringWithoutRepeatingCharactersOptimized {

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0, right = 0, maxWindow = 0;
    for (Character c : s.toCharArray()) {

      if (map.containsKey(c)) { // Ex: "aa"
        int prevIndex = map.get(c); // 0
        if (prevIndex < left) {
          // do nothing
        } else {
          left = prevIndex + 1;
        }
      }
      map.put(c, right);
      int currentWindow = right - left + 1;
      maxWindow = Math.max(currentWindow, maxWindow);
      right++;
    }
    return maxWindow;
  }
}

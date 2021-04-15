package com.interview.leetcode.topic.string;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

This question was asked by Amazon Onsite for me in 2019

1) Assume if it is a stream. Then you cannot parse input 2 times. Also you need result at each point.
2) Use sliding window. left always stands on firstUniqueCharacter.
3) Cache the countOfCharacter in map. 
4) If the currentCharacterCount>1 then it cannot be unique. 
5) At each iteration, if currentCharacterCount > 1 then shrink the window. It has to be in loop.
        Ex: abcbda
        a) on seeing b at index3. left still stands on a. 
        b) on seeing a at index5. left moves to c.
        
*/
public class FirstUniqueCharacterInAStringAssumeinputIsStream {
  public int firstUniqChar(String s) {

    Map<Character, Integer> map = new HashMap<>();
    int left = 0, right = 0, n = s.length();
    while (right < n) {
      char leftChar = s.charAt(left);
      char rightChar = s.charAt(right);
      map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

      int leftCharCount = map.get(leftChar);
      while (leftCharCount > 1 && ++left < n) {// Shrink till left goes to unique character.
        leftChar = s.charAt(left);
        leftCharCount = map.getOrDefault(leftChar, 0);
      }
      right++;

      // Ex: "aadadaad".. left goes all the way to end when right=4. 
      if (left > right) right = left;
    }
    return left == n ? -1 : left; // ex: aabb. left=3
  }

}

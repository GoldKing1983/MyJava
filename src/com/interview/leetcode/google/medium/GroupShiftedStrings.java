package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/group-shifted-strings


=================================================Solution Approach=================================================
Form unique key for each word to group them.

EX:["abc","bcd","a","z", "az","ba"]

Original String 'abc'. Converted String 'abc'
Original String 'bcd'. Converted String 'abc'
Original String 'a'. Converted String 'a'
Original String 'z'. Converted String 'a'
Original String 'az'. Converted String 'az'
Original String 'ba'. Converted String 'az'

Output : [["a","z"],["abc","bcd"],["az","ba"]]

 */
public class GroupShiftedStrings {
  public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String string : strings) {
      String hashedString = getHashedString(string);
      map.computeIfAbsent(hashedString, k -> new ArrayList<>()).add(string);
    }
    for (List<String> res : map.values()) result.add(res);
    return result;
  }

  private String getHashedString(String string) {
    StringBuilder hashedString = new StringBuilder();
    char firstChar = string.charAt(0);
    int shiftRequiredFromLeftToRight = firstChar - 'a'; // for a=0, for b=1
    for (char currentChar : string.toCharArray()) {
      int currentCharIndex = currentChar - 'a';
      // Ex: string="b". shiftRequiredFromLeftToRight=1. updatedCurrentCharIndex=0
      int shiftRequiredFromLeftToRightForCurrentChar =
          currentCharIndex - shiftRequiredFromLeftToRight;
      /*
      Ex: string="ba". shiftRequiredFromLeftToRight=1. For "a". shiftRequiredFromLeftToRightForCurrentChar=-1
      It should be 25. So adding 26 to -1, to make it 25.
      hashedString = "az"
      */
      shiftRequiredFromLeftToRightForCurrentChar =
          shiftRequiredFromLeftToRightForCurrentChar >= 0
              ? shiftRequiredFromLeftToRightForCurrentChar
              : 26 + shiftRequiredFromLeftToRightForCurrentChar;

      int updatedCurrentCharIndex = 'a' + shiftRequiredFromLeftToRightForCurrentChar;
      hashedString.append((char) updatedCurrentCharIndex);
    }
    return hashedString.toString();
  }
}

package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/group-shifted-strings
===========================================================Requirement===========================================================
1) Given a list of inputString.
2) Group them into similar string.
3) What is "similar string". If I keep rotate a string by 1char... then if it matches another string... then they both form a group.
Ex: "abc" -> "bcd" -> ... -> "xyz" all form 1 group
    "a" -> "b" ->"c" ... -> "z" all form 1 group
    "az" -> "ba" ....za--> all form 1 group
 
============================================================Example1=============================================================
Input: strings = ["abc","bcd","xyz","acef","az","ba","a","z"]
Output: [["abc","bcd","xyz"],["acef"],["a","z"], ["az","ba"]]
         
         "abc","bcd","xyz" -> forms a group because each differ by 1 char difference
         "acef" -> don't match with any. so it is alone in a group.  
         "a","z" -> forms a group
         "az","ba" -> forms a group


========================================================Solution Approach========================================================
1) Form unique key for each word to group them.
2) The unique key must start with "a", so that all can be grouped. 

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
    char[] hashedString = new char[string.length()];

    char firstChar = string.charAt(0);

    int shiftRequiredFromRightToLeft = firstChar - 'a'; // for a=0, for b=1
    int i = 0;
    for (char currentChar : string.toCharArray()) {
      int currentCharIndex = currentChar - 'a';

      //Ex: string="bc". hashedString = "ab"
      int shiftRequiredForCurrentChar = currentCharIndex - shiftRequiredFromRightToLeft;

      //Ex: string="ba". hashedString = "az". shiftRequiredFromRightToLeft=1. 
      // For "a". shiftRequiredFromRightToLeftForCurrentChar=-1. It should be 25. 
      // So adding 26 to 0, to make it 26. 26-1= 25 
      if (shiftRequiredForCurrentChar < 0) shiftRequiredForCurrentChar += 26;

      char updatedCurrentChar = (char) ('a' + shiftRequiredForCurrentChar);
      hashedString[i++] = updatedCurrentChar;
    }
    return String.valueOf(hashedString);
  }
}

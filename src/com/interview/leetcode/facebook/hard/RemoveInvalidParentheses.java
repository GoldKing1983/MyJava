package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/remove-invalid-parentheses/

 
1) At each point on seeing currentChar from inputStr. 
    1a) if currentChar is "(". include "(" in currentResult. increment openParenthesesCount. do recur
                               exclude "(" in currentResult. do recur

    1b) if currentChar is ")". include/exclude based on comparing openParenthesesCount and  closeParenthesesCount                            
    Ex: "()())" or "(()))" . If currentChar is ")" is Here 5th character can be ignored.

2) Recursion goes from leftToRight. So the firstResult will have maxResultSize. 
Avoid adding un-necessary combinations by comparing with firstResult maxResultSize.
Ex: input: "()())()"
     The entire sequence is  ["()()()","()()","()","(())()","(())",""]
     So I can avoid remaining 4 combinations with maxResultSize.

================Note==============
Time Complexity : 2^N. As it tries all combination.
The solution is not efficient and it contains duplicate. Duplicate will be removed by list.contains.


*
*/
public class RemoveInvalidParentheses {

  ArrayList<String> result = new ArrayList<>();
  Integer maxResultSize = 0;

  public List<String> removeInvalidParentheses(String s) {
    if (s == null) return result;
    dfs(s, "", 0, 0);
    if (result.isEmpty()) result.add("");

    return result;
  }

  public void dfs(String inputStr, String currResult, int openParenthesesCount,
      int closeParenthesesCount) {
    if (inputStr.length() == 0) { // Reached end of string
      if (openParenthesesCount == closeParenthesesCount) {
        if (maxResultSize == null) maxResultSize = openParenthesesCount + closeParenthesesCount;
        if (openParenthesesCount + closeParenthesesCount >= maxResultSize) { // we want multiple result with same size. So >=
          if (!result.contains(currResult)) result.add(currResult);
        }
      }
      return;
    }

    if (inputStr.charAt(0) == '(') {
      dfs(inputStr.substring(1), currResult + "(", openParenthesesCount + 1, closeParenthesesCount); // keep (
      dfs(inputStr.substring(1), currResult, openParenthesesCount, closeParenthesesCount); // drop (
    } else if (inputStr.charAt(0) == ')') {
      if (closeParenthesesCount >= openParenthesesCount) { //  "()())" --> skip for this case.
        dfs(inputStr.substring(1), currResult, openParenthesesCount, closeParenthesesCount);
      } else {
        dfs(inputStr.substring(1), currResult + ")", openParenthesesCount,
            closeParenthesesCount + 1);
        dfs(inputStr.substring(1), currResult, openParenthesesCount, closeParenthesesCount);
      }

    } else { // if(Character.isAlphabetic(prefix.charAt(0))){
      dfs(inputStr.substring(1), currResult + String.valueOf(inputStr.charAt(0)),
          openParenthesesCount, closeParenthesesCount);
    }
  }
}

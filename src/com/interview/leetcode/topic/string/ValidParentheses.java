package com.interview.leetcode.topic.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/valid-parentheses/description/

*/
public class ValidParentheses {

  // Push the "closeElement" instead of "openElement" and compare. So no need for HashMap
  public boolean isValidEfficient(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (Character c : s.toCharArray()) {
      switch (c) {
        case '(':
          stack.push(')');
          break;
        case '{':
          stack.push('}');
          break;
        case '[':
          stack.push(']');
          break;
        default:
          // all 3close "})]" parentheses will come here. No need to write code for individual close parentheses.
          if (stack.isEmpty() || !c.equals(stack.pop())) {
            return false;
          }
      }
    }
    return stack.isEmpty();
  }

  public boolean isValid(String s) {
    Map<Character, Character> map = new HashMap<>();
    map.put('(', ')');
    map.put('{', '}');
    map.put('[', ']');

    Deque<Character> stack = new ArrayDeque<>();
    for (Character c : s.toCharArray()) {
      if (map.containsKey(c)) stack.push(c);
      else {
        if (stack.isEmpty()) return false; // Ex: ")"
        Character topChar = stack.pop();
        if (!map.get(topChar).equals(c)) return false;
      }
    }
    return stack.isEmpty();
  }
}

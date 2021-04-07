package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * Copied from BasicCalculatorIIIInfixToPostFixScalable
 */

public class BasicCalculatorInfixtoPostFixScalable {
  public int calculate(String str) {
    // deal with the negative numbers
    if (str.charAt(0) == '-') str = "0" + str; // Ex: -1+1 
    str = str.replace("(-", "(0-"); // Ex: 1-(-1+1)
    str = str.replace("(+", "(0+"); // Ex: 1-(+1+1)

    return evaluatePostFix(convertInFixToPostFix(str));
  }

  private Queue<String> convertInFixToPostFix(String infix) {
    // queue is better. If it is StringBuilder "," needs to be added to separate operator/operand 
    Queue<String> postFix = new LinkedList<>();
    Deque<Character> operatorStack = new ArrayDeque<>();

    for (int i = 0; i < infix.length(); i++) {
      char currentChar = infix.charAt(i);
      if (Character.isDigit(currentChar)) {// c is a number. Collect all consecutive number
        int number = currentChar - '0';
        while (i + 1 < infix.length() && Character.isDigit(infix.charAt(i + 1))) {
          i++;
          number = number * 10 + infix.charAt(i) - '0';
        }
        postFix.offer(String.valueOf(number));
      } else if (operators.containsKey(currentChar)) { // process from operatorStack
        // ============operator case3 : no-process, just add it to "operatorStack".============
        if (currentChar == '(') {
          operatorStack.push(currentChar);
          continue;
        }
        // ============operator case1 : process from operatorStack============
        if (currentChar == ')') {
          while (true) {
            char operator = operatorStack.pop();
            if (operator == '(') break;
            postFix.offer(String.valueOf(operator));
          }
          continue;
        }
        // ============operator case2 : process from operatorStack============
        int currOperatorPrecedence = operators.get(currentChar);
        while (!operatorStack.isEmpty()) {
          int prevOperatorPrecedence = operators.get(operatorStack.peek());
          if (currOperatorPrecedence <= prevOperatorPrecedence) {
            postFix.offer(String.valueOf(operatorStack.pop()));
          } else {
            // Ex: 5+2*1. currOperatorPrecedence > prevOperatorPrecedence. So break
            break;
          }
        }
        operatorStack.push(currentChar);
      } else {
        // currentChar is ' ' don't do anything for space.
      }
    }

    // Ex: 5+2*1.... postFix=[5,2,1] operatorStack=[+,*]. Add everything from "operatorStack" to "postFix" result.
    while (!operatorStack.isEmpty()) {
      postFix.offer(String.valueOf(operatorStack.pop()));
    }
    return postFix;
  }

  private int evaluatePostFix(Queue<String> tokens) {
    Deque<Integer> numberStack = new ArrayDeque<>();
    while (!tokens.isEmpty()) {
      String token = tokens.poll();
      switch (token) {
        case "+":
          int num1 = numberStack.pop();
          int num2 = numberStack.pop();
          numberStack.push(num1 + num2);
          break;
        case "-":
          num1 = numberStack.pop();
          num2 = numberStack.pop();
          numberStack.push(num2 - num1);
          break;
        case "*":
          num1 = numberStack.pop();
          num2 = numberStack.pop();
          numberStack.push(num1 * num2);
          break;
        case "/":
          num1 = numberStack.pop();
          num2 = numberStack.pop();
          numberStack.push(num2 / num1);
          break;
        default:
          numberStack.push(Integer.parseInt(token));
      }
    }
    return numberStack.pop();
  }

  Map<Character, Integer> operators = new HashMap<>();
  {
    operators.put('+', 1);
    operators.put('-', 1);
    operators.put('*', 2);
    operators.put('/', 2);
    operators.put('(', 0);
    operators.put(')', 0);
  }


}

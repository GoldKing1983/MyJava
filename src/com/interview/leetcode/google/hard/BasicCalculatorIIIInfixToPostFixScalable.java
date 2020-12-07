package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
https://leetcode.com/problems/basic-calculator-iii/
https://www.youtube.com/watch?v=vq-nUF0G4fI
===========================================================Requirement===========================================================
Input may Contain
1) operators ====> + - * / ( )
2) Numbers (Only positive, no negative number)
3) Empty
========================================================Solution Approach========================================================
                                    =====================Infix To PostFix=====================
1) When we analyze "inFixInput" to "postFixOutput", order of operands(numbers) will never change. 
So if "currentChar" is number, we can add it to "postFix" result directly.

2) if currentChar is operator, 2 cases(case1 and case2) where we need to popOperator from "operatorStack" and 
add it to "postFix" result or we can say process

operator process case1: If "currentChar" is ")". Till "(", poll everything from "operatorStack" and add it to "postFix" result.
Basic idea on above case: Anything inside "()" we can treat it as isolated. Ex: (a+b)*c. So when ")" comes Evaluate till "(". 

operator process case2: Compare "currentOperator" and "previousOperator".  
     Ex1: 5*4+2 --> If "currentOperatorPrecedence(+)" is <= "previousOperatorPrecedence". Add "previousOperator" to "postFix" result.
     Ex2: 5+4*2 --> Else add "currentOperator" to operatorStack.

operator no-process case3: If "currentChar" is "(". Just add it to "operatorStack".  
                                  =====================Evaluate PostFix======================
1) If currentToken is "number" push it to "numberStack".
2) If currentToken is "operator". Pop top2 number from "numberStack". Evaluate and push it to "numberStack".
3) Result is carried in "numberStack". Return top from "numberStack".                            
=====================================================Data Flow Analysis==========================================================

Ex: "2*(5+5*2)/3+(6/2+8)"

Converted PostFix: [2, 5, 5, 2, *, +, *, 3, /, 6, 2, /, 8, +, +]

=====Evaluating the PostFix=======
[2, 5, 5, 2, *, +, *, 3, /, 6, 2, /, 8, +, +]

[2, 5,  10    , +, *, 3, /, 6, 2, /, 8, +, +]

[2,     15       , *, 3, /, 6, 2, /, 8, +, +]

[       30          , 3, /, 6, 2, /, 8, +, +]

[          10             , 6, 2, /, 8, +, +]

[          10             ,    3   , 8, +, +]

[          10             ,     11       , +]

[                         21                ]

 */
public class BasicCalculatorIIIInfixToPostFixScalable {
  public int calculate(String s) {
    return evaluatePostFix(convertInFixToPostFix(s));
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

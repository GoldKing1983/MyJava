package com.interview.leetcode.intuit.all;

import java.util.Deque;
import java.util.LinkedList;

/*
https://leetcode.com/problems/basic-calculator-ii
======================================================Requirement================================================================
Implement a basic calculator to evaluate a simple expression string.

Input may Contain
1) operators ====> + - * /
2) Numbers
3) Empty
======================================================Example1===================================================================
Input: "3+2*2"
Output: 7
======================================================Example2===================================================================
Input: " 3/2 "
Output: 1
======================================================Example3===================================================================
Input: " 3+5 / 2 "
Output: 5
==================================================Solution Approach==============================================================
1) Iterate the String of Characters.
2) If currentChar is ' '. continue.
3) If currentChar is number. update the number.
4) Else currentChar is operator. We might or might not process.
   Case1   :  5*10/2
         when we see "*".... No-Process. Because no sufficient numbers available in numberStack.  
         when we see "/".... Process   . Because previousOperator is equal. 5 and 10 can be processed.
   Case2   :  5+10*2
        when we see "+".... No-Process. Because no sufficient numbers available in numberStack. 
        when we see "*".... No-Process. Because previousOperator is smaller
 
==================================================Data Flow Analysis=============================================================
"5*2-10*2+10/2"
10-20+5 = -10+5 = -5


[2, 10, 20, 10]
    [/, +, -]

10-20+10/2
-10+10/2

 *
 */
public class BasicCalculatorII {
  public int calculate(String str) {
    Deque<Character> operatorStack = new LinkedList<>();
    Deque<Integer> numberStack = new LinkedList<>();
    int number = 0;
    for (Character c : str.toCharArray()) {
      if (c == ' ') {
        // don't do anything for ' '
      } else if (Character.isDigit(c)) {
        number = (number * 10) + c - '0';// update the number
      } else {
        numberStack.push(number);
        number = 0;
        // Below while is very important. If an operation is evaluated. Then all previous needs to
        // evaluated. Ex: "5*2-10*2+10/2"
        while (numberStack.size() > 1) {
          if (isPreviousOperatorHasEqualOrHigherPrecedence(operatorStack.peek(), c)) {
            int data1 = numberStack.pop();
            int data2 = numberStack.pop();
            numberStack.push(doOperation(data1, data2, operatorStack.pop()));
          } else break;
        }
        operatorStack.push(c);
      }
    }

    numberStack.push(number);// Push the last number

    while (numberStack.size() > 1) {
      numberStack.push(doOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop()));
    }
    return numberStack.pop();
  }

  private int doOperation(final int data1, final int data2, final Character operator) {
    switch (operator) {
      case '*':
        return data2 * data1;
      case '/':
        if (data1 == 0) return 0;
        return data2 / data1;
      case '+':
        return data2 + data1;
      case '-':
        return data2 - data1;
    }
    return 0;
  }

  private boolean isPreviousOperatorHasEqualOrHigherPrecedence(final Character c1,
      final Character c2) {
    int c1Precedence = c1 == '*' || c1 == '/' ? 1 : 0;
    int c2Precedence = c2 == '*' || c2 == '/' ? 1 : 0;
    return c1Precedence >= c2Precedence;
  }
}

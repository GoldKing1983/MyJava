package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.com/problems/basic-calculator/description/
======================================================Requirement================================================================
Input may Contain
1) operators ====> + - ( )
2) Numbers
3) Empty
4) Input may contain negative numbers. Ex: -1+2

1) Key point is doing evaluation from left to right.
2) Evaluate when a "operator "+" or "-" is found" or when ")" is found.
3) Always push/pop data to/from "operatorStack" and "numberStack" to evaluate. There are so many cases.
=======================================================Initial Thinking==========================================================
Ex: 1+2
1) On Seeing Input, We might think on seeing number after operator, we might evaluate. But that will not
work. Because "number length" we don't know. Apart from "number length" all are fixed.
2) For "1+2". "3". After "for loop" evaluation happens.
3) Evaluate when a "operator "+" or "-" is found" or when ")" is found.
==================================================================================================================================
"1+1"
==================================================================================================================================
"3"
==================================================================================================================================
"(3)"
========================================================When to do evaluation=====================================================
1) If operator is received and there is "+ or -" on top of "operator stack", we can evaluate.
Ex: 1+2+4
On Getting second "+". Evaluate 1+2... Push 3 to stack, Push + to stack.
Ex: 2-(1+1)
On Getting "+", evaluation will not happen because "operator stack" contains "(" at top

2)
2a) If ")" is received and "+ or -" is on top of "operator stack", we can evaluate. Ex: (2+3)
2b) We cannot evaluate, if ")" is received and "(" is on top of "operator stack".
But Just pop, stating "(" is not useful anymore Ex: (3)

3) Don't think number must come before ")". Below is valid case.
"(1-(3-4))"
=================================================================================================================================
This solution is not scalable, when the requirements changes asks you to add more operators. Adding priorities,
will complicate the code.
 *
 */
public class BasicCalculator {
  public int calculate(String str) {
    Deque<Character> operatorStack = new ArrayDeque<>();
    Deque<Integer> numberStack = new ArrayDeque<>();

    // deal with the negative numbers
    if (str.charAt(0) == '-') str = "0" + str; // Ex: -1+1 
    str = str.replace("(-", "(0-"); // Ex: 1-(-1+1)
    str = str.replace("(+", "(0+"); // Ex: 1-(+1+1)

    Integer number = null;
    for (Character c : str.toCharArray()) {
      switch (c) {
        case '+':
        case '-':
          if (number != null) { // Number can null Ex: (5)+3
            numberStack.push(number);
            number = null;
          }
          // Ex: "5+2" and (5+2) no evaluation on "+". Ex: 5+2-1, evaluation for "+" happens on "-"
          if (!operatorStack.isEmpty() && isOperator(operatorStack.peek())) {
            numberStack
                .push(doOperation(numberStack.pop(), numberStack.pop(), operatorStack.poll()));
          }
          operatorStack.push(c);
          break;
        case ')':
          if (number != null) { // Number can null for (1-(3-4))
            numberStack.push(number);
            number = null;
          }
          if (operatorStack.peek() == '(') operatorStack.pop(); // Ex: (3)
          else {
            numberStack
                .push(doOperation(numberStack.pop(), numberStack.pop(), operatorStack.poll()));
            if (operatorStack.peek() == '(') operatorStack.pop(); // Cleanup after evaluation Ex:(5+3)
          }
          break;
        case '(':
          operatorStack.push('(');
          break;
        case ' ':
          break;
        default: // character is number
          if (number == null) number = c - '0';
          else number = (number * 10) + c - '0';
      }
    }

    if (number != null) numberStack.push(number); // Ex: 3
    // Ex: 1+1
    if (!operatorStack.isEmpty())
      numberStack.push(doOperation(numberStack.pop(), numberStack.pop(), operatorStack.pop()));

    return numberStack.pop();
  }

  private boolean isOperator(final Character c) {
    return c == '+' || c == '-';
  }

  private Integer doOperation(final Integer data1, final Integer data2, final Character operator) {
    return operator == '+' ? data2 + data1 : data2 - data1;
  }
}

package com.sample.basics;

/*

boolean a, b;

short-circuiting     ==> if left fails  operands, right side not evaluated
not short-circuiting ==> verifies both operands

Operation     Meaning                       Note
---------     -------                       ----
   a && b     logical AND                    short-circuiting
   a || b     logical OR                     short-circuiting
   a &  b     boolean logical AND            not short-circuiting
   a |  b     boolean logical OR             not short-circuiting
   a ^  b     boolean logical exclusive OR
  !a          logical NOT

short-circuiting        (x != 0) && (1/x > 1)   SAFE
not short-circuiting    (x != 0) &  (1/x > 1)   NOT SAFE


 */
public class BitwiseAnd {
  public static void main(String[] args) {
    int a = 4;
    int b = 7;
    System.out.println(a & b);

    boolean c = false;
    boolean d = true;
    System.out.println(c & d);
  }
}

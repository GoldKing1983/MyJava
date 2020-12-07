package com.leetcode.maths;

public class LCM {
  
  public static void main(String[] args) {
    LCM l = new LCM();
    System.out.println(l.lcm(1, 2));
    System.out.println(l.lcm(2, 8));
    System.out.println(l.lcm(3, 8));
    System.out.println(l.lcm(2, 4));
    System.out.println(l.lcm(2, 7));
    System.out.println(l.lcm(10, 20));
    System.out.println(l.lcm(9968, 9987));
  }
  public int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
  }

  public int gcd(int a, int b) {
    if (a == 0) return b; // To avoid DivideByZero issue
    while (true) {
      int temp = a;
      a = b % a;
      b = temp;
      if (a == 0) break;
    }
    //System.out.println("GCD of " + a + " " + b + " is " + b);
    return b;
  }

}

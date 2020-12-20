package com.interview.leetcode.topic.concurrency;

import java.util.function.IntConsumer;

/*
https://leetcode.com/problems/fizz-buzz-multithreaded/
============================================================Requirement==========================================================
1) Leetcode will create, an instance out of currentClass
2) Leetcode will create, 4 threads out of currentInstance.
3) 
   Leetcode will call fizz() method with t1 thread.
   Leetcode will call buzz() method with t2 thread.
   Leetcode will call fizzbuzz() method with t3 thread.
   Leetcode will call number() method with t4 thread.

4) Sequence the logic such that, 
      inside fizz() method,      if (currentNumber%3 == 0) call  printFizz.run();
      inside buzz() method,      if (currentNumber%5 == 0) call  printBuzz.run();
      inside fizzbuzz() method,  if (currentNumber%3 == 0 && currentNumber%5 == 0) call  printFizzBuzz.run();
      inside number() method,    if (currentNumber%3 != 0 && currentNumber%5 != 0) call  printNumber.accept(x);
==========================================================Solution Approach======================================================

 */
public class FizzBuzzObjectLock {
  private int n;
  private Integer currentNumber;
  private Object lock = new Object();

  public FizzBuzzObjectLock(int n) {
    this.n = n;
    currentNumber = 1;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    synchronized (lock) {
      while (currentNumber <= n) {
        while ((currentNumber % 3 != 0 || currentNumber % 5 == 0) && currentNumber <= n) {
          lock.wait();
        }
        if (currentNumber <= n) printFizz.run();
        currentNumber++;
        lock.notifyAll();
      }
    }

  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    synchronized (lock) {
      while (currentNumber <= n) {
        while ((currentNumber % 5 != 0 || currentNumber % 3 == 0) && currentNumber <= n) {
          lock.wait();
        }
        if (currentNumber <= n) printBuzz.run();
        currentNumber++;
        lock.notifyAll();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    synchronized (lock) {
      while (currentNumber <= n) {
        while ((currentNumber % 5 != 0 || currentNumber % 3 != 0) && currentNumber <= n) {
          lock.wait();
        }
        if (currentNumber <= n) printFizzBuzz.run();
        currentNumber++;
        lock.notifyAll();
      }
    }

  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    synchronized (lock) {
      while (currentNumber <= n) {
        while ((currentNumber % 5 == 0 || currentNumber % 3 == 0) && currentNumber <= n) {
          lock.wait();
        }
        if (currentNumber <= n) printNumber.accept(currentNumber);
        currentNumber++;
        lock.notifyAll();
      }
    }

  }
}

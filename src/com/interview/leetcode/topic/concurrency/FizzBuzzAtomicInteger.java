package com.interview.leetcode.topic.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
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
1) Create an Atomic Integer and initialize with 1. 
2) When 4 threads calls 4 methds. 
          number() will succeed for 1 and 2.
          fizz() will succeed for 3.
3) The problem with this approach is CPU is exhausted heavily. Because all 4 threads keep runs and no-one is waiting.  

Worst Case: If the system has only 1 CPU. then only 1 method will stuck in loop, other methods will not turn 
and may result in OutOfMemory.  So add sleep of 10 nanoseconds.              

 */
public class FizzBuzzAtomicInteger {
  private int n;
  AtomicInteger currentNumber = new AtomicInteger(1);

  public FizzBuzzAtomicInteger(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (true) {
      int x = currentNumber.get();
      if (x > n) return;
      if (x % 3 == 0 && x % 5 != 0) {
        printFizz.run();
        currentNumber.incrementAndGet();
      }
      //Thread.sleep(0,10);// 10 nanoseconds sleep
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (true) {
      int x = currentNumber.get();
      if (x > n) return;
      if (x % 3 != 0 && x % 5 == 0) {
        printBuzz.run();
        currentNumber.incrementAndGet();
      }
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (true) {
      int x = currentNumber.get();
      if (x > n) return;
      if (x % 3 == 0 && x % 5 == 0) {
        printFizzBuzz.run();
        currentNumber.incrementAndGet();
      }
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (true) {
      int x = currentNumber.get();
      if (x > n) return;
      if (x % 3 != 0 && x % 5 != 0) {
        printNumber.accept(x);
        currentNumber.incrementAndGet();
      }
    }
  }
}

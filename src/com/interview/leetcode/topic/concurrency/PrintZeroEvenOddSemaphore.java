package com.interview.leetcode.topic.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/*
https://leetcode.com/problems/print-zero-even-odd/
===========================================================Requirement===========================================================
1) One instance will be created for the class.
2) Three Threads are created for the instance. Ex: T1,T2,T3
3) Three threads are fired asynchronously.
4) One of them calls zero(), the other calls even(), and the last one calls odd().
5) We are not sure which method will be called first by which thread.
6) But result should be always like "0" "odd" "0" "even" "0"..........

if n=2, "0102" is the correct output.

Input: n = 5
Output: "0102030405"
========================================================Logical Thinking=========================================================
1) if even is fired first. Then it will wait at evenSemaphore.acquire. because it has 0 permits.
2) if odd is fired first. Then it will wait at oddSemaphore.acquire. because it has 0 permits.
3) if zero is fired first. It will print 0, then it will "add permit" for either odd or even semaphore
========================================================Solution Approach========================================================
 1) zero will be printed n number of times.
 2) even and odd will printed n/2 times.
 3) initialize zeroSemphore with 1. So that it can acquire permit first.
 4) initialize oddSemphore and evenSemaphore with 0. So that it can never acquire permit first.
 5) When a zero is printed. Release(add permit to) odd or even semaphore based on current i.

 */
class PrintZeroEvenOddSemaphore {
  private int n;
  private Semaphore zeroSemphore, oddSemaphore, evenSemaphore;

  public PrintZeroEvenOddSemaphore(int n) {
    this.n = n;
    zeroSemphore = new Semaphore(1);
    oddSemaphore = new Semaphore(0); // zeroSemaphore will add permit at runtime by calling release
    evenSemaphore = new Semaphore(0); // zeroSemaphore will add permit at runtime by calling release
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      zeroSemphore.acquire();
      printNumber.accept(0);
      if (i % 2 == 0) evenSemaphore.release();
      else oddSemaphore.release();
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      evenSemaphore.acquire();
      printNumber.accept(i);
      zeroSemphore.release();
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      oddSemaphore.acquire();
      printNumber.accept(i);
      zeroSemphore.release();
    }
  }
}

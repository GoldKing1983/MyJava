package com.interview.leetcode.topic.concurrency;

import java.util.function.IntConsumer;

/*
https://leetcode.com/problems/print-zero-even-odd/

See PrintZeroEvenOddSemaphore
 */
class PrintZeroEvenOddSynchronized {
  private int n;
  private boolean isZero =true;
  private boolean isOdd =true;
  private boolean isEven =false;

  private Object lock = new Object();

  public PrintZeroEvenOddSynchronized(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {

    for (int i = 0; i < n; i++) {
      synchronized (lock) {
        while(!isZero){
          lock.wait();
        }
        printNumber.accept(0);
        isZero =false;
        lock.notifyAll();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 2; i <= n; i += 2) {
      synchronized (lock) {
        while(isZero || !isEven){
          lock.wait();
        }
        printNumber.accept(i);
        isEven =false;
        isOdd =true;
        isZero =true;
        lock.notifyAll();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i += 2) {
      synchronized (lock) {
        while(isZero || !isOdd){
          lock.wait();
        }
        printNumber.accept(i);
        isEven =true;
        isOdd =false;
        isZero =true;
        lock.notifyAll();
      }
    }
  }
}

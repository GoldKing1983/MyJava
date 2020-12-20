package com.interview.leetcode.topic.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/*
https://leetcode.com/problems/print-zero-even-odd/


This approach prints "You called method from wrong thread. Exiting."


 */
class PrintZeroEvenOddWrongApproach {

  private int n;

  IntConsumer zeroConsumer;
  IntConsumer oddConsumer;
  IntConsumer evenConsumer;
  int currentNumber;

  public PrintZeroEvenOddWrongApproach(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    zeroConsumer = printNumber;
    currentNumber++;
    print();
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    oddConsumer = printNumber;
    currentNumber++;
    print();
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    evenConsumer = printNumber;
    currentNumber++;
    print();
  }

  private void print() {
    if(currentNumber!=3) return;
    for(int i=1; i<=n; i++) {
      if(i%2 == 0) {
        zeroConsumer.accept(0);
        evenConsumer.accept(i);
      } else {
        zeroConsumer.accept(0);
        oddConsumer.accept(i);
      }
    }
  }
}

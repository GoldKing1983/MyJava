package com.sample.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
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
public class FizzBuzzReEntrantLock {
  private int n;
  private int currentNumber;
  private Lock lock;
  private Condition condition;

  public FizzBuzzReEntrantLock(int n) {
    this.n = n;
    currentNumber = 1;
    lock = new ReentrantLock();
    condition = lock.newCondition();
  }


  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (true) {
      lock.lock();
      while (currentNumber % 15 == 0 || currentNumber % 3 != 0) {
        if (currentNumber > n) {
          condition.signalAll();
          lock.unlock();
          return;
        }
        condition.await();
      }
      if (currentNumber > n) {
        condition.signalAll();
        lock.unlock();
        return;
      }
      printFizz.run();
      currentNumber++;
      condition.signalAll();
      lock.unlock();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (true) {
      lock.lock();
      while (currentNumber % 15 == 0 || currentNumber % 5 != 0) {
        if (currentNumber > n) {
          condition.signalAll();

          lock.unlock();
          return;
        }
        condition.await();
      }
      if (currentNumber > n) {
        condition.signalAll();

        lock.unlock();
        return;
      }
      printBuzz.run();
      currentNumber++;
      condition.signalAll();

      lock.unlock();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (true) {
      lock.lock();
      while (currentNumber % 15 != 0) {
        if (currentNumber > n) {
          condition.signalAll();

          lock.unlock();
          return;
        }
        condition.await();
      }
      if (currentNumber > n) {
        condition.signalAll();

        lock.unlock();
        return;
      }
      printFizzBuzz.run();
      currentNumber++;
      condition.signalAll();

      lock.unlock();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (true) {
      lock.lock();
      while (currentNumber % 15 == 0 || currentNumber % 3 == 0 || currentNumber % 5 == 0) {
        if (currentNumber > n) {
          condition.signalAll();

          lock.unlock();
          return;
        }
        condition.await();
      }
      if (currentNumber > n) {
        condition.signalAll();

        lock.unlock();
        return;
      }
      printNumber.accept(currentNumber);
      currentNumber++;
      condition.signalAll();

      lock.unlock();
    }
  }
}

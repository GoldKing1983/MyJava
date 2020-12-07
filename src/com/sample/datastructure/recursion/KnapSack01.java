package com.sample.datastructure.recursion;

/*
 * It is similar to groupSum Problem with additional condition sackWeight
 * https://www.educative.io/courses/grokking-the-coding-interview/gkZNLjV2kBk
 * Look into picture "Knapsack01.svg"
 *
	Time complexity of algorithm is exponential O(2^n).
	For 4 weights recursion will take 31 combinations. i.e approximately equal to 2 power 4

====================================================================================================
    weightValues = new int[] {60, 100, 120};
    weights = new int[] {1, 2, 3};
    knapSackWeight = 3;
	output = 160
​​* 							0
* 					60				0
* 			160    		60      100       0
*        280   160   180  60  220 100  120  0
================================Solution Approach====================================================
If condition cannot be removed. Add currentProfit to profit only if current weight can be put it into sack.
 */

public class KnapSack01 {

  public static void main(String[] args) {

    int[] weightValues = new int[] {60, 100, 120, 80, 40, 200};
    int[] weights = new int[] {1, 2, 3, 6, 4, 5};
    int knapSackWeight = 11;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0, 0)); // 480

    weightValues = new int[] {60, 100, 120};
    weights = new int[] {1, 2, 3};
    knapSackWeight = 3;
    System.out.println(knapSack(weightValues, weights, knapSackWeight, 0, 0)); // 160
  }

  private static int knapSack(
      int[] profits, int weights[], int maxSackCapacity, int currentProfit, int index) {
    if (maxSackCapacity == 0 || index == weights.length) return currentProfit;

    int leftProfit = 0;
    if (weights[index] <= maxSackCapacity) {
      leftProfit =
          knapSack(
              profits,
              weights,
              maxSackCapacity - weights[index],
              currentProfit + profits[index],
              index + 1);
    }
    int rightProfit = knapSack(profits, weights, maxSackCapacity, currentProfit, index + 1);
    // System.out.println(left + " : " + right);
    return Math.max(leftProfit, rightProfit);
  }
}
